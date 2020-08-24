package basic;

// �������� ���¸� ����ϴ� ����

public class ThreadTest10 {

	public static void main(String[] args) {
		TargetThread target = new TargetThread(); //Ÿ�ٿ� ������ ��ü ����
		
		//Ÿ�ٿ� �����带 �������� �Ű������� �־ �������� ���¸� ����ϴ� ������ ��ü�� �����Ѵ�.
		StatePrintThread prn = new StatePrintThread(target);
		
		prn.start();  //�������� ���¸� ����ϴ� �����带 �۵� ��Ų��.
		

	}

}

//TargetThread�� ���¸� ����ϴ� ������ Ŭ����
class StatePrintThread extends Thread{
	private TargetThread target; //���¸� ����� ����̵Ǵ� �����尡 ����� ����
	
	//������
	public StatePrintThread(TargetThread target) {
		this.target = target;
	}
	
	@Override
	public void run() {
		while(true){
			//target�� �������� ���°� ���ϱ�
			Thread.State state = target.getState(); //�������� ���¸� ���� �����ϱ� ���� Thread.State�� ������ Ÿ�� ������ ��������.
			System.out.println("Ÿ�� �������� ���� ���°� : " + state);
			
			if(state == Thread.State.NEW){	//�������� ���°� NEW �������� �˻�
				target.start();		//������ �۵� ����
			}
			
			if(state == Thread.State.TERMINATED){	//�����尡 ����(TERMINATED)�������� �˻�
				break; //�����带 ����ϴ� ������� �������� �Ѵ�.
			}
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				
			}
			
		}
	}
	
	
}



// target�� ������ Ŭ���� �ۼ�
class TargetThread extends Thread{
	@Override
	public void run() {
		for(long i=1L; i <=2000000000L; i++){} //�ð� ������ //���� Ȥ�� ��������
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {}
		for(long i=1L; i <=2000000000L; i++){} //�ð� ������
	}
}