package basic;

public class ThreadTest21 {

	public static void main(String[] args) {
		DataBox databox = new DataBox();
		
		ProducerThread pro = new ProducerThread(databox);
		ConsumerThread con = new ConsumerThread(databox);
		
		pro.start();
		con.start();


		
	}

}

//�����͸� �־��ִ� ���Ҹ� �ϴ� ������
class ProducerThread extends Thread{
	private DataBox databox;

	public ProducerThread(DataBox databox) {
		this.databox = databox;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 3; i++){
			String data = "DATA-" + i;
			databox.setData(data);
		}
	}
	
}

//�����͸� ������ ����ϴ� ���Ҹ� �ϴ� ������
class ConsumerThread extends Thread{
	private DataBox databox;
	public ConsumerThread(DataBox databox){
		this.databox = databox;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 3; i++){
			String temp = databox.getData();
		}
	}
}


//�����͸� �������� ����ϴ� Ŭ����
class DataBox{
	private String data;
	
	//data ������ ����� ���� ��ȯ�ϴ� �޼���
	//���� data ������ ����� ���� ������ ���� ä���� ������ ��ٸ���.
	//�׸��� ���� ä������ �� �� ���� ��ȯ�ϰ� �����͸� �ٽ� ����ش�.
	public synchronized String getData(){
		if(data == null){
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		
		String returnData = data;
		System.out.println("getData()�޼��尡 ���� ������ : " + returnData);
		data = null;
		notify();
		
		return returnData;
	}
	
	
	//������� data�� ���� �����ϴ� �޼���
	//������� data�� ���� ���� ������ ���� ����� ������ ��ٸ���.
	//���� ����ؼ�  ������� data�� ������� ���ο� ���� �����Ѵ�.
	public synchronized void setData(String data){
		if(this.data != null){
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		this.data = data;
		System.out.println("setData()�޼��忡�� ���� ������ ������ : " + data);
		notify();
	}
}