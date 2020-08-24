package basic;

public class ThreadTest03 {

	public static void main(String[] args) {
		// �������� ���� �ð��� üũ�� ����
		Thread th = new Thread(new MyRunner());
		
		//1970�� 1�� 1�� 0�� 0�� 0��(ǥ�ؽð�)���� ����� �ð��� �и�������(1/1000��)������ ��ȯ�Ѵ�.
		long startTime = System.currentTimeMillis();
		
		th.start();
		try {
			th.join(); //���� �����忡�� th �����尡 ����� ������ ��ٷ���...
		} catch (Exception e) {

		}

		long endTime = System.currentTimeMillis();
		
		System.out.println("����ð� : " + (endTime - startTime));
	}

}

//1���� 10������� �հ踦 ���ϴ� ������
class MyRunner implements Runnable{
	@Override
	public void run() {
		long sum = 0L;
		for(long i = 1L; i <= 1_000_000_000L; i++){
			sum += i;
		}
		System.out.println("�հ�= " + sum);
	}
}
