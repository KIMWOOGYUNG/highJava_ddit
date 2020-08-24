package basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


class Phone{
	
	private String name;
	private String addr;
	private String tel;
	
	public Phone(String name, String addr, String tel) {
		super();
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}



public class PhoneBookTest {
	/*
	 * 문제) 이름, 주소, 전화번호 속성을 갖는 Phone클래스를 만들고 이 Phone클래스를 이용하여 전화번호 정보를 관리하는
	 * 프로그램을 완성하시오. 이 프로그램에는 전화번호를 등록, 수정, 삭제, 검색, 전체출력하는 기능이 있다.
	 * 
	 * 전체 전화번호 정보는 Map을 이용하여 관리한다. (Key값은 '이름'으로 사용하고, value값으로는 Phone클래스의 인스턴스로
	 * 한다.)
	 * 
	 * 실행 예시) ================================= 전화번호 관리 프로그램
	 * ================================= 1. 전화번호 등록 2. 전화번호 수정 3. 전화번호 삭제 4.
	 * 전화번호 검색 5. 전화번호 전체출력 0. 프로그램 종료 -----------------------------------------
	 * 메뉴선택 >> 1
	 * 
	 * 새롭게 등록할 전화번호 정보를 입력하세요. 이름>> 김우경 전화번호>> 010-1111-2222 주소 >> 대전광역시
	 * 
	 * 김우경 전화번호 정보가 추가되었습니다.
	 * 
	 * 1. 전화번호 등록 2. 전화번호 수정 3. 전화번호 삭제 4. 전화번호 검색 5. 전화번호 전체출력 0. 프로그램 종료
	 * ----------------------------------------- 메뉴선택 >> 5
	 * 
	 * ========================================= 번호 이름 전화번호 주소
	 * ========================================= 1 김우경 010-1111-2222 대전광역시 :
	 * ========================================= 출력 완료... 1. 전화번호 등록 2. 전화번호 수정
	 * 3. 전화번호 삭제 4. 전화번호 검색 5. 전화번호 전체출력 0. 프로그램 종료
	 * ----------------------------------------- 메뉴선택 >> 0
	 * 
	 * 프로그램을 종료합니다.
	 */
	

	HashMap<String, Phone> map = new HashMap<>();
	Set<String> keys = map.keySet();
	String name = "";
	String tel = "";
	String addr = "";
	int num = 1;
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		PhoneBookTest pbt = new PhoneBookTest();
		pbt.start();

	}
	
	private void start() {
		Scanner sc = new Scanner(System.in);
		int input = 0;

		do {
			System.out.println("=================================");
			System.out.println("        전화번호 관리 프로그램                  ");
			System.out.println("=================================");
			System.out.println("	1. 전화번호 등록                                 ");
			System.out.println("	2. 전화번호 수정                                 ");
			System.out.println("	3. 전화번호 삭제                                 ");
			System.out.println("	4. 전화번호 검색                                 ");
			System.out.println("	5. 전화번호 전체출력                           ");
			System.out.println();
			System.out.println("	0. 전화번호 종료                                 ");
			System.out.println("---------------------------------");
			System.out.println("메뉴선택 >> ");
			input = Integer.parseInt(sc.nextLine());

			switch (input) {
			case 1:
				add();
				break;
			case 2:
				change();
				break;
			case 3:
				delete();
				break;
			case 4:
				search();
				break;
			case 5:
				showAll();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("다시 입력해주세요");
				return;
			}

		} while (input != 0);
		
	}


	private void showAll() {
		num = 1;
		System.out.println("==================================================");
		System.out.println("번호\t이름\t전화번호\t\t주소");
		System.out.println("==================================================");
		for(String val : keys){
			System.out.println(num + " " + "\t" + map.get(val).getName() + "\t" + map.get(val).getAddr() + "\t" + map.get(val).getTel());
			num++;
		}
		System.out.println("==================================================");
		System.out.println("출력 완료...");
		start();
	}

	private void search() {
		String nameSearch = "";
		System.out.println("검색하실 이름을 입력해주세요>>");
		nameSearch = sc.nextLine();
		System.out.println(map.get(nameSearch).getName() + " " + map.get(nameSearch).getAddr() + " " + map.get(nameSearch).getTel());
		
		start();
	}

	private void delete() {
		String nameDelete = "";
		num = 1;
		System.out.println("==================================================");
		System.out.println("번호\t이름\t전화번호\t\t주소");
		System.out.println("==================================================");
		for(String val : keys){
			System.out.println(num + " " + "\t" + map.get(val).getName() + "\t" + map.get(val).getAddr() + "\t" + map.get(val).getTel());
			num++;
		}
		System.out.println("삭제하실 이름을 입력해주세요>>");
		nameDelete = sc.nextLine();
		
		if(!map.containsKey(name)){
			System.out.println(nameDelete + "은 등록되지 않은 이름입니다");
		}
		else{
			map.remove(nameDelete);
			System.out.println("삭제가 완료되었습니다.");
		}
		System.out.println("==================================================");
		System.out.println("번호\t이름\t전화번호\t\t주소");
		System.out.println("==================================================");
		for(String val : keys){
			System.out.println(num + " " + "\t" + map.get(val).getName() + "\t" + map.get(val).getAddr() + "\t" + map.get(val).getTel());
			num++;
		}
		System.out.println("==================================================");
		start();
	}

	private void change() {

		int input = 0;
		num = 1;
		String telChange = "";
		String addrChange = "";
		System.out.println("==================================================");
		System.out.println("번호\t이름\t전화번호\t\t주소");
		System.out.println("==================================================");
		for(String val : keys){
			System.out.println(num + " " + "\t" + map.get(val).getName() + "\t" + map.get(val).getAddr() + "\t" + map.get(val).getTel());
			num++;
		}
		System.out.println("==================================================");
		System.out.println("수정하실 이름을 입력해주세요>>");
		name = sc.nextLine();
		
		System.out.println("1. 전화번호 수정 / 2. 주소 수정");
		input = Integer.parseInt(sc.nextLine());
		
		switch(input){
			case 1: 
				System.out.println();
				System.out.println("새 전화번호를 입력해주세요>>");
				telChange = sc.nextLine();
				map.put(name,new Phone(name,telChange,addr));
				System.out.println("수정이 완료되었습니다.");
				System.out.println(map.get(name).getName() + " " + map.get(name).getAddr() + " " + map.get(name).getTel());
				break;
			case 2: 
				System.out.println();
				System.out.println("새 주소를 입력해주세요>>");
				addrChange = sc.nextLine();
				map.put(name,new Phone(name,tel,addrChange));
				System.out.println("수정이 완료되었습니다.");
				System.out.println(map.get(name).getName() + " " + map.get(name).getAddr() + " " + map.get(name).getTel());
				break;
			default:
				System.out.println("다시 입력해주세요");
				return;
		}
		
		start();
	}

	private void add() {
		num = 1;
		
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.println("이름>>");
		name = sc.nextLine();
		System.out.println("전화번호>>");
		tel = sc.nextLine();
		System.out.println("주소>>");
		addr = sc.nextLine();
		
		
		map.put(name, new Phone(name, tel, addr));
		
		System.out.println(name + "님의 전화번호 정보가 추가되었습니다.");
		
		System.out.println("==================================================");
		System.out.println("번호\t이름\t전화번호\t\t주소");
		System.out.println("==================================================");
		for(String val : keys){
			System.out.println(num+ "\t" + map.get(val).getName()+ "\t" + map.get(val).getAddr()+ "\t" + map.get(val).getTel());
			num++;
		}
		System.out.println("------------------------------");
		start();
		
	}

}
