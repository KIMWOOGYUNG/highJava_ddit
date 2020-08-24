package basic;

public class ThreadTest08 {

	public static void main(String[] args) {
		Thread th1 = new UpperThread();
		Thread th2 = new LowerThread();
		
		//�켱���� ���� ==> start()�޼��� ȣ�� ���� �ؾ� �Ѵ�.
		th1.setPriority(9);
		th2.setPriority(3);
		
		//�켱 ���� ����ϱ�
		System.out.println("th1�� �켱 ���� : " + th1.getPriority());
		System.out.println("th2�� �켱 ���� : " + th2.getPriority());
		
		th1.start();
		th2.start();
		
	}

}

//�빮�ڸ� ����ϴ� ������
class UpperThread extends Thread{
	@Override
	public void run() {
		for(char ch='A'; ch<='Z'; ch++){
			System.out.println(ch);
			//�ð� ������ �ݺ���
			for(long i=1L; i<=1000000000L; i++){  }
		}
	}
}

//�ҹ��ڸ� ����ϴ� ������
class LowerThread extends Thread{
	@Override
	public void run() {
		for(char ch='a'; ch<='z'; ch++){
			System.out.println(ch);
			//�ð� ������ �ݺ���
			for(long i=1L; i<=1000000000L; i++){  }
		}
	}
}