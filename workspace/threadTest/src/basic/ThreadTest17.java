package basic;

/*
 	�������� ����ȭ ó�� ���� => ������ ������� ������� ó���ϴ� ����
 	(synchronized�� �̿��� ����ȭ ó��)
 */

public class ThreadTest17{
	private int balance;	//�ܾ��� ����� ����
	
	//getter, setter
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//�Ա��ϴ� �޼���
	public synchronized void deposit(int money){
		balance += money;
	}
	
	//����ϴ� �޼��� (��ݼ��� : true, ��ݽ��� : false)
	//����ȭ �������� ȣ���ϴ� �޼��嵵 ����ȭó���� ���־�� �����ϴ�.
	
	//�޼��� ��ü�� ����ȭ ó���ϱ�
	public synchronized boolean withdraw(int money){
		if(balance >= money){
			
			for(int i = 0; i < 1000000000; i++){}	//�ð� �����
			
			
			balance -= money;
			
			System.out.println("�޼��� �ȿ��� balance = " + getBalance());
			return true;
		}else{
			return false;
		}
	}
	
	/*//����ȭ ������ ó���ϱ�
		public boolean withdraw(int money){
			synchronized(this){ //����ȭ ��
				if(balance >= money){
					
					for(int i = 0; i < 1000000000; i++){}	//�ð� �����
					
					
					balance -= money;
					
					System.out.println("�޼��� �ȿ��� balance = " + getBalance());
					return true;
				}else{
					return false;
				}
			}
		}*/




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final ThreadTest17 account = new ThreadTest17();
		account.setBalance(10000);
		
		//�͸� ����ü�� �̿��� ������ ����
		Runnable accountTest = new Runnable(){
			@Override
			public void run() {
				boolean result = account.withdraw(6000);
				System.out.println("�����忡�� result = " + result + ", balance = " + account.getBalance());
			}
		};
		
		//-------------------------------------------------------------------------------------------------
		
		Thread th1 = new Thread(accountTest);
		Thread th2 = new Thread(accountTest);
		
		th1.start();
		th2.start();
		
	}

}
