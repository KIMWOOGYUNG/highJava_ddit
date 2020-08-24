package basic;

/*
 	�������� ����ϴ� ������� ���� �������� ����ϴ� �����尡 �ִ�.
 	
 	�������� �����ϴ� ��ü�� �����ؼ� �� �����忡�� �������� ����Ѵ�.
 	
 */

public class ThreadTest15 {

	public static void main(String[] args) {
		ShareData sd = new ShareData();	// �������� ����� ��ü ����
		
		CalcPIThread cal = new CalcPIThread(sd);
		PrintThread prn = new PrintThread(sd);
		
		cal.start();
		prn.start();

	}

}

//�������� ����ϴ� ������
class CalcPIThread extends Thread{
	private ShareData sd;
	public CalcPIThread(ShareData sd){
		this.sd = sd;
	}
	@Override
	public void run() {
		/*
		 	������ = (1/1 - 1/3 + 1/5 - 1/7 + 1/9 ....) * 4
		 			1 3 5 7 9 11...
		*/
		
		
		double sum = 0.0;
		/*���1
		 ( 2�� ���� ��: 0 1 2 3 4 5...) --2�� ���� ���� ¦������ Ȧ�������� ����	
		for(int i = 1; i <= 100000000; i+=2){
			
			if((i / 2) % 2 == 0){
				sum += 1.0/i;
			}else{
				sum += 1/-i;
			}
			
		}*/
		
		for(int i = 1; i <= 100000000; i+=2){
			if(i%4==1){
				sum += 1.0/i;
			}else{
				sum -= 1.0/i;
			}
		}
		
		sd.result = sum * 4;
		sd.isOk = true;
	}
	
}

//����� �Ϸ�Ǹ� ���� �������� ����ϴ� ������
class PrintThread extends Thread{
	private ShareData sd;

	public PrintThread(ShareData sd) {
		this.sd = sd;
	}
	@Override
	public void run() {
		while(!sd.isOk){
			Thread.yield();
		}
		System.out.println();
		System.out.println("��� : " + sd.result);
		System.out.println(" PI : " + Math.PI);
	}
	
}

//�������� �����ϴ� Ŭ���� (������ Ŭ����)
class ShareData{
	public double result;	//���� ����� ����� ����
	
	//volatile ==> �ش� ������ �ִ� ������ �����͸� ���� ������ϱ� ������ ����� ������ �ٷ� ������� �� �ִ�.
	public volatile boolean isOk = false;	//����� �Ϸ�Ǿ������� ��Ÿ���� ����
	
}