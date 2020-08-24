package basic;

import javax.swing.JOptionPane;

/*
	컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
	
	컴퓨터의 가위 바위 보는 난수를 이용해서 구하고,
	사용자의 입력 showInputDialog() 메서드를 이용해서 입력 받는다.
	
	입력시간은 5초로 제한하고 카운트 다운을 한다.
	5초안에 입력이 없으면 게임에서 진것으로 처리한다.
	
	5초안에 입력이 있으면 승패를 구해서 다음과 같이 출력한다.
	
	결과예시)
		-- 결 과 --
		컴퓨터 : 가위
		당   신 : 바위
		결   과 : 당신이 이겼습니다.
	
 */


public class ThreadTest07 {
	public static boolean inputChk;
	public static void main(String[] args) {
		RSP th1 = new RSP();
		Count th2 = new Count();
		
		th1.start();
		th2.start();

	}
	
}

/*
 String[] 배열 = {가위,바위,보}  
 int 인덱스 = 난수생성(0~1)
 String com = 배열[인덱스] 
 */


class RSP extends Thread{
	@Override
	public void run() {
		String user;
		do{
		user = JOptionPane.showInputDialog("가위 바위 보를 내주세요 (10초 경과시 패배)");
		}while(user == null || (!user.equals("가위") && !user.equals("바위") && !user.equals("보")));
		ThreadTest07.inputChk = true; //입력이 완료되어 값을 true로 변경한다.

		
		int ran = (int)(Math.random()*3) + 1;
		String com="";
		
		switch(ran){
			case 1: com = "가위";
			break;
			case 2: com = "바위";
			break;
			case 3: com = "보";
			break;
		}
		
		System.out.println("당   신 : " + user);
		System.out.println("컴퓨터 : " + com);
		System.out.println();
		
		//승패 판정하기
		if(user.equals(com)){
			System.out.println("비겼습니다.");
		}
		if(user.equals("가위")){
			if(com.equals("바위"))System.out.println("컴퓨터가 이겼습니다.");
			if(com.equals("보"))System.out.println("당신이 이겼습니다.");
		}else if(user.equals("바위")){
			if(com.equals("보"))System.out.println("컴퓨터가 이겼습니다.");
			if(com.equals("가위"))System.out.println("당신이 이겼습니다.");
		}else if(user.equals("보")){
			if(com.equals("가위"))System.out.println("컴퓨터가 이겼습니다.");
			if(com.equals("바위"))System.out.println("당신이 이겼습니다.");
		}
	}
}

//카운트다운 쓰레드
class Count extends Thread{
	@Override
	public void run() {
		for(int i = 10; i >= 1; i--){
			if(ThreadTest07.inputChk == true){
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
		System.out.println("10초가 지났습니다. 패배하였습니다.");
		System.exit(0);
	}
}