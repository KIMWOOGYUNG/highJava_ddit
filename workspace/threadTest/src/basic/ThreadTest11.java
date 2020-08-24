package basic;

/*
	3���� �����尡 ���� ���ĺ� A~Z������ ����ϴµ�
	����� ���� ������� ����� ��Ÿ���� ���α׷� �ۼ��ϱ�
 */

public class ThreadTest11 {

	public static void main(String[] args) {
		//��ü ������ ��� ���� �迭�� ������ ����
		DisplayCharacter[] disChar = new DisplayCharacter[]{
				new DisplayCharacter("����"),
				new DisplayCharacter("���Ƹ�"),
				new DisplayCharacter("������")
		};
		
		for(DisplayCharacter dis : disChar){
			dis.start();
		}
		
		for(int i = 0; i < disChar.length; i++){
			try {
				disChar[i].join();
			} catch (InterruptedException e) {
			}
		}
		System.out.println();
		System.out.println("��� ���");
		System.out.println("���� : " + DisplayCharacter.strRank);
		
	}

}

//���ĺ� A~Z������ ����ϴ� ������ Ŭ����
class DisplayCharacter extends Thread{
	public static String strRank = "";		// ��⸦ ��ģ �������� name���� ������ ����
	
	private String name;	// ��� ������ �̸��� ����� ����

	//������
	public DisplayCharacter(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for(char ch = 'A'; ch <= 'Z'; ch++){
			System.out.println(name + "�� ��� ���� : " + ch);
			try {
				//sleep()�� ���� 201~500������ ������ �Ѵ�.
				Thread.sleep((int)(Math.random() * 300) + 201);
			} catch (InterruptedException e) {
			}
		}
		System.out.println(name + " ��� ��...");
		strRank += name + "  ";
	}
	
	
}










