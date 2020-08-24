package basic;

public class ThreadTest02 {

	public static void main(String[] args) {
		// ��Ƽ ������ ���α׷�

		// Thread�� ����ϴ� ���

		// ���1
		// ThreadŬ������ ����� class�� �ν��Ͻ��� ������ ��
		// �� �ν��Ͻ��� start()�޼��带 ȣ���Ѵ�.

		MyThread1 th1 = new MyThread1();
		th1.start();

		// ���2
		// Runnable �������̽��� ������ class�� �ν��Ͻ��� ������ ��
		// �� �ν��Ͻ��� Thread�� �ν��Ͻ��� ������ �� �������� �Ű����������� �Ѱ��ش�.
		// �� �� ������ Thread�� �ν��Ͻ��� start()�޼��带 ȣ���Ѵ�.
		MyThread2 r2 = new MyThread2();
		Thread th2 = new Thread(r2);
		th2.start();

		// ���3
		// Runnable�������̽��� �͸���ü�� ������ �� �� �͸���ü��
		// Thread�� �ν��Ͻ��� ������ �� �������� �Ű����������� �Ѱ��ش�.
		// �� �� ������ Thread�� �ν��Ͻ��� start()�޼��带 ȣ���Ѵ�.
		Thread th3 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 200; i++) {
					System.out.println("@");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {

					}
				}

			}
		});
		th3.start();
	}

}

// ThreadŬ������ ����� Ŭ���� �ۼ��ϱ�
class MyThread1 extends Thread {
	@Override
	public void run() {
		// �� run()�޼��� ������ �����尡 �� ���� �ڵ��ϸ� �ȴ�.
		for (int i = 0; i < 200; i++) {
			System.out.println("*");
			try {
				// Thread.sleep(�ð�); ==> �־��� �ð����� �۾��� ��� �����.
				// '�ð�'�� �и������� ������ ����Ѵ�. (��, 1�ʴ� 1000�� �ǹ��Ѵ�.)

				Thread.sleep(100);
			} catch (InterruptedException e) {

			}
		}
	}
}

// Runnable�������̽��� ������ Ŭ���� �ۼ��ϱ�
class MyThread2 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 200; i++) {
			System.out.println("$");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

			}
		}
	}
}