package basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
	쓰레드의 동기화 처리 예제 => 은행의 입출금을 쓰레드로 처리하는 예제
	(lock객체를 이용한 동기화 처리)
*/

public class ThreadTest18 {
	
	private int balance;	//잔액이 저장될 변수
	private final Lock lock = new ReentrantLock();	//Lock객체 생성 (되도록이면 private final로 만든다.)
	
	//getter, setter
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//입금하는 메서드
	public void deposit(int money){
		//락 해제 (lock()) 메서드로 락을 설정한 곳에서는 반드시 unlock()메서드로 락을 해제해줘야 한다.
		
		lock.lock();	//락 설정
		
		balance += money;
		
		lock.unlock(); 
	}
	
	//출금하는 메서드 (출금성공 : true, 출금실패 : false)
	//동기화 염역에서 호출하는 메서드도 동기화처리를 해주어야 안전하다.
	
	//메서드 자체에 동기화 처리하기
	public boolean withdraw(int money){
		//try~catch 블럭이 사용되는 부분에서 unlock()메서드 호출을 finally 영역에서 하도록 한다.
		
		lock.lock();	//락 설정
		
		boolean chk = false;
		try{
		if(balance >= money){
			
			for(int i = 0; i < 1000000000; i++){}	//시간 때우기
			
			
			balance -= money;
			
			System.out.println("메서드 안에서 balance = " + getBalance());
			chk = true;
		}else{
			chk = false;
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{	//try catch를 쓰게되면 finally에 unlock을 넣어주면 된다.
			lock.unlock();	//락 해제 
		}
		
		return chk;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final ThreadTest18 account = new ThreadTest18();
		account.setBalance(10000);
		
		//익명 구현체를 이용한 쓰레드 구현
		Runnable accountTest = new Runnable(){
			@Override
			public void run() {
				boolean result = account.withdraw(6000);
				System.out.println("쓰레드에서 result = " + result + ", balance = " + account.getBalance());
			}
		};
		
		//-------------------------------------------------------------------------------------------------
		
		Thread th1 = new Thread(accountTest);
		Thread th2 = new Thread(accountTest);
		
		th1.start();
		th2.start();
		
	}

}
