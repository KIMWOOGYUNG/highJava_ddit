package basic;

import javax.swing.JOptionPane;

/*
	��ǻ�Ϳ� ���� ���� ���� �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	��ǻ���� ���� ���� ���� ������ �̿��ؼ� ���ϰ�,
	������� �Է� showInputDialog() �޼��带 �̿��ؼ� �Է� �޴´�.
	
	�Է½ð��� 5�ʷ� �����ϰ� ī��Ʈ �ٿ��� �Ѵ�.
	5�ʾȿ� �Է��� ������ ���ӿ��� �������� ó���Ѵ�.
	
	5�ʾȿ� �Է��� ������ ���и� ���ؼ� ������ ���� ����Ѵ�.
	
	�������)
		-- �� �� --
		��ǻ�� : ����
		��   �� : ����
		��   �� : ����� �̰���ϴ�.
	
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
 String[] �迭 = {����,����,��}  
 int �ε��� = ��������(0~1)
 String com = �迭[�ε���] 
 */


class RSP extends Thread{
	@Override
	public void run() {
		String user;
		do{
		user = JOptionPane.showInputDialog("���� ���� ���� ���ּ��� (10�� ����� �й�)");
		}while(user == null || (!user.equals("����") && !user.equals("����") && !user.equals("��")));
		ThreadTest07.inputChk = true; //�Է��� �Ϸ�Ǿ� ���� true�� �����Ѵ�.

		
		int ran = (int)(Math.random()*3) + 1;
		String com="";
		
		switch(ran){
			case 1: com = "����";
			break;
			case 2: com = "����";
			break;
			case 3: com = "��";
			break;
		}
		
		System.out.println("��   �� : " + user);
		System.out.println("��ǻ�� : " + com);
		System.out.println();
		
		//���� �����ϱ�
		if(user.equals(com)){
			System.out.println("�����ϴ�.");
		}
		if(user.equals("����")){
			if(com.equals("����"))System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
			if(com.equals("��"))System.out.println("����� �̰���ϴ�.");
		}else if(user.equals("����")){
			if(com.equals("��"))System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
			if(com.equals("����"))System.out.println("����� �̰���ϴ�.");
		}else if(user.equals("��")){
			if(com.equals("����"))System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
			if(com.equals("����"))System.out.println("����� �̰���ϴ�.");
		}
	}
}

//ī��Ʈ�ٿ� ������
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
		System.out.println("10�ʰ� �������ϴ�. �й��Ͽ����ϴ�.");
		System.exit(0);
	}
}