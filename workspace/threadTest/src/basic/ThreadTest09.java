package basic;

//���� ������ ���� --> �ڵ� ���� ���
public class ThreadTest09 {

	public static void main(String[] args) {
		AutoSave auto = new AutoSave();
		
		auto.setDaemon(true); //���� ������� ����(start()�޼��带 ȣ���ϱ� ���� �����ؾ� �Ѵ�.)
		//���󾲷���� �����ϴ� ���ξ����� ���� �� ���̻� �������� x
		auto.start();
		
		try {
			for(int i = 1; i <= 20; i++){
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}

		System.out.println("���� ������ ����...");
		
	}

}

// �ڵ� �����ϴ� ������ ==> 3�ʿ� �ѹ��� �ڵ� �����ϴ� ������
class AutoSave extends Thread{
	public void save(){		//�������� �����ϴ� �޼���
		System.out.println("�۾� ������ �����մϴ�...");
	}
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(3 * 1000);
			} catch (InterruptedException e) {
				break;
			}
			save(); //�����ϴ� �޼��� ȣ��
		}
	}
}