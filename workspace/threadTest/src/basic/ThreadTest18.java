package basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
	�������� ����ȭ ó�� ���� => ������ ������� ������� ó���ϴ� ����
	(lock��ü�� �̿��� ����ȭ ó��)
*/

public class ThreadTest18 {
	
	private int balance;	//�ܾ��� ����� ����
	private final Lock lock = new ReentrantLock();	//Lock��ü ���� (�ǵ����̸� private final�� �����.)
	
	//getter, setter
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//�Ա��ϴ� �޼���
	public void deposit(int money){
		//�� ���� (lock()) �޼���� ���� ������ �������� �ݵ�� unlock()�޼���� ���� ��������� �Ѵ�.
		
		lock.lock();	//�� ����
		
		balance += money;
		
		lock.unlock(); 
	}
	
	//����ϴ� �޼��� (��ݼ��� : true, ��ݽ��� : false)
	//����ȭ �������� ȣ���ϴ� �޼��嵵 ����ȭó���� ���־�� �����ϴ�.
	
	//�޼��� ��ü�� ����ȭ ó���ϱ�
	public boolean withdraw(int money){
		//try~catch ���� ���Ǵ� �κп��� unlock()�޼��� ȣ���� finally �������� �ϵ��� �Ѵ�.
		
		lock.lock();	//�� ����
		
		boolean chk = false;
		try{
		if(balance >= money){
			
			for(int i = 0; i < 1000000000; i++){}	//�ð� �����
			
			
			balance -= money;
			
			System.out.println("�޼��� �ȿ��� balance = " + getBalance());
			chk = true;
		}else{
			chk = false;
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{	//try catch�� ���ԵǸ� finally�� unlock�� �־��ָ� �ȴ�.
			lock.unlock();	//�� ���� 
		}
		
		return chk;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final ThreadTest18 account = new ThreadTest18();
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
