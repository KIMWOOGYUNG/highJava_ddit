package basic;

public class ThreadTest01 {

	public static void main(String[] args) {
		//싱글 쓰레드 프로그램
		for(int i = 0; i < 200; i++){
			System.out.print("*");
		}
		System.out.println();
		
		for(int j = 0; j < 200; j++){
			System.out.print("$");
		}
		System.out.println();
	}

}
