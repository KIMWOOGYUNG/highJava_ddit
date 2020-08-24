package basic;

/*
 	wait(), notify()�� �̿��ؼ� �� �����尡 �����ư��� �ѹ��� ����Ǵ� ����
 
 */
public class ThreadTest20 {

	public static void main(String[] args) {
		WorkObject workObj = new WorkObject();
		
		ThreadA thA = new ThreadA(workObj);
		ThreadB thB = new ThreadB(workObj);
		
		thA.start();
		thB.start();

	}

}

//�������� ����� ��ü
class WorkObject{
	public synchronized void methodA(){
		System.out.println("methodA() �޼��� �۾� ��...");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}
	public synchronized void methodB(){
		System.out.println("methodB() �޼��� �۾� ��...");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}
}

//WorkObject�� methodA()�� ȣ���ϴ� ������
class ThreadA extends Thread{
	private WorkObject workObj;

	public ThreadA(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++){
			workObj.methodA();
		}
	}
	
}

//WorkObject�� methodB()�� ȣ���ϴ� ������
class ThreadB extends Thread{
	private WorkObject workObj;
	
	public ThreadB(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++){
			workObj.methodB();
		}
	}
	
}