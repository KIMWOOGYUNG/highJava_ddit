package basic;

/*
 	Thread�� stop()�޼��带 ȣ���ϸ� �����尡 �ٷ� �����.
 	�� �� ����ϴ� �ڿ��� �������� ���ϰ� ���α׷��� ����Ǿ� ���߿� ����Ǵ� ���α׷��� ������ �� �� �ִ�.
 	�׷��� stop()�޼���� ����õ�Ǿ� �ִ�.
 
 */

public class ThreadTest14 {

	public static void main(String[] args) {
		
		/*ThreadStopEx1 th1 = new ThreadStopEx1();
		th1.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
		}
		//th1.stop(); //<--�� ����� ���� x (������ �������� ����)
		th1.setStop(true);*/
		
		//interrupt()�޼��带 �̿��� ������ ���߱�
		ThreadStopEx2 th2 = new ThreadStopEx2();
		th2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		th2.interrupt();
	}

}


class ThreadStopEx1 extends Thread{
	private boolean stop;
	
	 public void setStop(boolean stop){
		 this.stop = stop;
	 }
	 
	 @Override
	public void run() {
		while(!stop){
			System.out.println("������ ���� ��....");
		}
		
		System.out.println("�ڿ� ����...");
		System.out.println("���� ����...");
	}
}

//interrupt()�޼��带 �̿��Ͽ� �����带 ���߰� �ϴ� ��
class ThreadStopEx2 extends Thread{
	@Override
	public void run() {
		/*//���1
		while(true){
			System.out.println("���� ��...");
			try {
				Thread.sleep(1); //sleep()�� ���� �Ͻ����� ���¿��� interrupt() �޼��尡 ����Ǹ�
								 //InterruptedException�� �����Ѵ�.
			} catch (InterruptedException e) {
				break;
			}
		}*/
		
		//���2
		while(true){
			System.out.println("���� ��...");
			
			//interrupt()�޼��尡 ȣ��Ǿ������� �˻�
			
			/*//�˻� ���1
			//==> �ν��Ͻ� ��ü�� �޼��� isInterrupted()�� �̿��Ͽ� �˻��Ѵ�.
			if(this.isInterrupted()){
				break;
			}*/
			
			//�˻� ���2
			//==> Thread�� ���� �޼��� interrupted()�� �̿��Ͽ� �˻��Ѵ�.
			if(Thread.interrupted()){
				break;
			}
		}
		
		System.out.println("�ڿ� ����...");
		System.out.println("���� ����...");
	}	
	
}
