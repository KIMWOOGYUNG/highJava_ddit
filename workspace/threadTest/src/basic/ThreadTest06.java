package basic;

import javax.swing.JOptionPane;

public class ThreadTest06 {
//��Ƽ������� �Էµ��ÿ� ī��Ʈ�ٿ� ����
	public static void main(String[] args) {
		Thread th1 = new DataInput();
		Thread th2 = new Countdown();
		
		th1.start();
		th2.start();

	}

}


//������ �Է��� ����ϴ� ������
class DataInput extends Thread{
	
	//�Է��� �Ϸ�Ǹ� true���� ����Ǿ� �Է��� �Ϸ�Ǿ����� ���θ� ��Ÿ���� ����
	public static boolean inputChk;
	@Override
	public void run() {
		String str;
		do{
		str = JOptionPane.showInputDialog("�ƹ��ų� �Է��ϼ���.");
		}while(str == null);
		inputChk = true; //�Է��� �Ϸ�Ǿ� ���� true�� �����Ѵ�.
		System.out.println("�Է� �� : " + str);
	}
}

//ī��Ʈ �ٿ��� ����ϴ� ������
class Countdown extends Thread{
	@Override
	public void run() {
		for(int i = 10; i >= 1; i--){
			//�Է� �Ϸ� ���� �˻�
			if(DataInput.inputChk == true){
				return; //�����ϸ� run �޼ҵ尡 ������
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
		System.out.println("10�ʰ� �������ϴ�. ���α׷��� �����մϴ�.");
		System.exit(0); //���α׷� �����ϴ� �޼���
	}
}