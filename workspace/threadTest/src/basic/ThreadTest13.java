package basic;

//yield()�޼��� ������ ����

public class ThreadTest13 {

	public static void main(String[] args) {
		ThreadYield th1 = new ThreadYield("1�� ������");
		ThreadYield th2 = new ThreadYield("2�� ������");
		
		th1.start();
		th2.start();
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
		}
		System.out.println("===================11111111111111111111111111");
		th1.work=false;
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
		}
		System.out.println("===================22222222222222222222222222");
		th1.work=true;
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
		}
		th1.stop = true;
		th2.stop = true;
	}

}

//yield()�޼��� ������ ������
class ThreadYield extends Thread{
	public boolean stop = false;	//������ ��ü�� ���� �����
	public boolean work = true;	//������ �۵� �� �۾��� ���� ���� �����
	
	public ThreadYield(String name){
		super(name);	//�������� �̸� ����(Thread Ŭ������ name �Ӽ��� �ִµ� �� �Ӽ����� �������� �̸��� ����ȴ�.)
	}
	
	@Override
	public void run() {
		while(!stop){	//stop�� true�� �Ǹ� �ݺ��� ����
			if(work){
				//getName()�޼��� ==> ���� �������� name�Ӽ����� ��ȯ�Ѵ�.
				System.out.println(getName() + "������ �۾� ��...");
			}else{
				Thread.yield();   //yield()�޼���� Thread�� ����(static) �޼���
			}
		}
		System.out.println(getName() + "����...");
	}
}