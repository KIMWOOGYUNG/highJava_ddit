package basic;

public class ThreadTest16 {
	//동기화를 사용하는 방법 : 결과를 받아서 순차적으로 작업해야 할때, 두가지 쓰레드가 동시에 작업하는것을 방지하기 위해

	public static void main(String[] args) {
		// 공통으로 사용할 객체 생성
		ShareObject sObj = new ShareObject();
		
		WorkerThread work1 = new WorkerThread("Test1",sObj);
		WorkerThread work2 = new WorkerThread("Test2",sObj);
		
		work1.start();
		work2.start();
		
	}

}

//작업용 쓰레드
class WorkerThread extends Thread{
	private ShareObject sObj;

	public WorkerThread(String name, ShareObject sObj) {
		super(name);	//쓰레드 이름 설정
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
	
	//동기화 처리하기
	//방법 1 (메서드 자체에 동기화 설정하기)
	//public synchronized void add(){	//값이 순서대로 나옴
	
	public void add(){	//값이 순서대로 나옴
		
		//방법2(동기화 블럭으로 설정하기)
		synchronized (this){
			int n = sum;
			
			n += 10;
			
			sum = n;
			System.out.println(Thread.currentThread().getName() + "합계 : " + sum);
		}
	}
	public int getSum(){
		return sum;
	}
}