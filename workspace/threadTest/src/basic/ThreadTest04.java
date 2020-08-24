package basic;

/*
 	1~20������� �հ踦 ���ϴµ� �ɸ� �ð��� üũ�غ���.
 	��ü �հ踦 ���ϴ� �۾��� �̱� �����尡 ó���� ����
 	��Ƽ������� �����ؼ� ó���� ���� �ð��� ���� ����.
 	
 */

public class ThreadTest04 {

	public static void main(String[] args) {
		SumThread smAll = new SumThread(1L, 2000000000L);
		
		SumThread[] sms = new SumThread[]{
			new SumThread(1L,		   500000000L),	
			new SumThread(500000000L,  1000000000L),	
			new SumThread(1000000000L, 1500000000L),	
			new SumThread(1500000000L, 2000000000L),	
		};
		
		//�ܵ����� ó���ϴ� ���
		long startTime = System.currentTimeMillis();
		smAll.start();
		try{
			smAll.join();
		} catch(InterruptedException e){
			
		}
		long endTime = System.currentTimeMillis();
		
		System.out.println("�ܵ����� ó���� ���� �ð� : " + (endTime - startTime));
		System.out.println();
		
		//-------------------------------------------------
		
		//�������� �����尡 �����ؼ� ó������ �� 
		startTime = System.currentTimeMillis();
		
		for(int i = 0; i < sms.length; i++){
			sms[i].start();
		}
		
		for(SumThread sm : sms){
			try {
				sm.join();
			} catch (Exception e) {
			}
		}
		endTime = System.currentTimeMillis();
		
		System.out.println("�����ؼ� ó������ �� �ð� : " + (endTime - startTime));
	}

}


class SumThread extends Thread{
	private long min, max;

	public SumThread(long min, long max) {
		this.min = min;
		this.max = max;
	}
	
	@Override
	public void run() {
		long sum = 0L;
		for(long i = min; i <= max; i++){
			sum += i;
		}
		System.out.println("�հ� : " + sum);
	}
}