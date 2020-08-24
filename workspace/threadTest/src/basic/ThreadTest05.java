package basic;

import javax.swing.JOptionPane;

public class ThreadTest05 {

	public static void main(String[] args) {
		//싱글쓰레드라 입력 후에 카운트다운이 작동됨
		
		//창으로 입력받는 법
		String str = JOptionPane.showInputDialog("아무거나 입력하세요.");
		System.out.println("입력값 : " + str);
		
		//카운트다운
		for(int i = 10; i >= 1; i--){
			System.out.println(i);
			try {
				Thread.sleep(1000); //1000이 1초
			} catch (Exception e) {
			}
		}
	}

}
