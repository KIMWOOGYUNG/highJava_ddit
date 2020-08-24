package kr.or.ddit.board.main;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

public class BoardInfoMain {

	private IBoardService service;
	
	private Scanner scan = new Scanner(System.in);
	
	public BoardInfoMain(){
		service = BoardServiceImpl.getInstance();
	}
	
	public static void main(String[] args) {
		new BoardInfoMain().boardStart();

	}
	
	public int displayMenu(){
		List<BoardVO> boardList = service.getAllBoard();		
		printBoard(boardList);
		System.out.println("------------------------------");
		System.out.println("*** 메뉴 *** \n1. 새글작성\n2. 게시글보기\n3. 검색\n\n0. 작업끝");
		System.out.println();
		System.out.println("작업선택 >> ");
		
		int num = scan.nextInt();
		return num;
	}
	
	public void boardStart(){
		while(true){
			int choice = displayMenu();
			
			switch(choice){
			case 1: 
				boardInsert();
				break;
			case 2:
				displayBoard();
				break;
			case 3:
				boardSearch();
				break;
			case 0:
				System.out.println("작업끝");
				return;
			default : 
				System.out.println("잘못 선택하셨습니다. 다시 입력해주세요.");
			}
		}
	}

	public void boardInsert(){
		System.out.println();
		System.out.println("새글 작성하기");	
		System.out.println("-----------------------------------");
		
		System.out.println("제 목 : ");
		String title = scan.next();
		
		System.out.println("작성자 : ");
		String writer = scan.next();
		
		System.out.println("내 용 : ");
		String content = scan.next();
		System.out.println();
		BoardVO boardVo = new BoardVO();
		
		boardVo.setBoard_title(title);
		boardVo.setBoard_writer(writer);
		boardVo.setBoard_content(content);
		
		int cnt = service.insertBoard(boardVo);
		
		if(cnt > 0){
			System.out.println("*** 새글이 추가되었습니다. ***");			
		}else {
			System.out.println("작업 실패");
		}
	}
	
	public void displayBoard(){
		System.out.println("보기를 원하는 게시물 번호 입력 >> ");
		int boardNum = scan.nextInt();
		
		//조회수 증가하기
		int cnt = service.setCountIncrement(boardNum);
		if(cnt == 0){
			System.out.println(boardNum + "번의 게시글은 존재하지 않습니다.");
			return;
		}
		
		BoardVO boardVo = service.getShowBoard(boardNum);
		System.out.println("---------------------------------------------");
		System.out.println("제   목 : " + boardVo.getBoard_title());
		System.out.println("작성자 : " + boardVo.getBoard_writer());
		System.out.println("내   용 : " + boardVo.getBoard_content());
		System.out.println("작성일 : " + boardVo.getBoard_date());
		System.out.println("조회수 : " + boardVo.getBoard_cnt());
		System.out.println("---------------------------------------------");
		
		System.out.println("*** 메뉴 ***");
		System.out.println("1. 수정\n2. 삭제\n3. 리스트로 가기\n4. 초기화면으로 가기");
		System.out.println("메뉴 선택 >>");
		int menuNum = scan.nextInt();
		System.out.println();
		switch(menuNum){
		case 1: 
			updateBoard(boardNum);
			break;
		case 2: 
			deleteBoard(boardNum);
			break;
		case 3:
			displayBoard();
			break;
		case 4:
			boardStart();
			break;
		default :
			System.out.println("잘못 선택하셨습니다. 다시 입력해주세요.");
		
		}
		
		
	}
	
	public void updateBoard(int boardNo){
		System.out.println("*** 수정 작업하기 ***");
		System.out.println("---------------------------------------------");
		System.out.print("제   목 : ");
		String title = scan.next();
		System.out.print("내    용 : ");
		String content = scan.next();
		System.out.println();	//버퍼비우기
		
		BoardVO boardVo = new BoardVO();
		boardVo.setBoard_title(title);
		boardVo.setBoard_content(content);
		boardVo.setBoard_no(boardNo);	//몇번째 게시물인지 넘겨줘야 쿼리문 작성가능
		
		int cnt = service.updateBoard(boardVo);
		if(cnt > 0){
			System.out.println(boardNo + "번글이 수정되었습니다.");
		}else{
			System.out.println("수정 작업 실패");
		}
		System.out.println();
	}
	
	public void deleteBoard(int boardNo){
		int cnt = service.deleteBoard(boardNo);
		if(cnt > 0){
			System.out.println(boardNo + "번글이 삭제되었습니다.");
		}else{
			System.out.println("삭제 작업 실패");
		}
	}
	
	public void boardSearch(){
		System.out.println("*** 검색 작업 ***");
		System.out.println("---------------------------------------------");
		System.out.println("검색할 제목 입력 >> ");
		String searchTitle = scan.next();
		
		BoardVO boardVo = new BoardVO();
		boardVo.setBoard_title(searchTitle);
		
		List<BoardVO> boardList = service.getSearchBoard(searchTitle);
		printBoard(boardList);
		System.out.println();
		System.out.println("검색완료!!");
		System.out.println();
		
	}
	
	public void printBoard(List<BoardVO> boardList){
		System.out.println("---------------------------------------------");
		System.out.println("  No\t제목\t작성자\t조회수");
		System.out.println("---------------------------------------------");
		if(boardList == null || boardList.size() == 0){
			System.out.println("  출력할 데이터가 없습니다.");
		}else{
			for(BoardVO boardVo : boardList){
				int board_no = boardVo.getBoard_no();
				String board_title = boardVo.getBoard_title();
				String board_writer = boardVo.getBoard_writer();
				int board_cnt = boardVo.getBoard_cnt();
				
				System.out.println("  " + board_no + "\t" + board_title + 
									"\t" + board_writer + "\t" + board_cnt);
			}
		}
	}
}
