package basic;

public class ThreadTest16 {
	//����ȭ�� ����ϴ� ��� : ����� �޾Ƽ� ���������� �۾��ؾ� �Ҷ�, �ΰ��� �����尡 ���ÿ� �۾��ϴ°��� �����ϱ� ����

	public static void main(String[] args) {
		// �������� ����� ��ü ����
		ShareObject sObj = new ShareObject();
		
		WorkerThread work1 = new WorkerThread("Test1",sObj);
		WorkerThread work2 = new WorkerThread("Test2",sObj);
		
		work1.start();
		work2.start();
		
	}

}

//�۾��� ������
class WorkerThread extends Thread{
	private ShareObject sObj;

	public WorkerThread(String name, ShareObject sObj) {
		super(name);	//������ �̸� ����
		this.sObj = sObj;
	}
	@Override
	public void run() {
		for(int i = 0; i < 10; i++){
			sObj.add();
		}
	}
	
}

class ShareObject{
	private int sum = 0;
	
	//����ȭ ó���ϱ�
	//��� 1 (�޼��� ��ü�� ����ȭ �����ϱ�)
	//public synchronized void add(){	//���� ������� ����
	
	public void add(){	//���� ������� ����
		
		//���2(����ȭ ������ �����ϱ�)
		synchronized (this){
			int n = sum;
			
			n += 10;
			
			sum = n;
			System.out.println(Thread.currentThread().getName() + "�հ� : " + sum);
		}
	}
	public int getSum(){
		return sum;
	}
}