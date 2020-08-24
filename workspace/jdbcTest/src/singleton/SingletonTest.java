package singleton;

public class SingletonTest {

	public static void main(String[] args) {
		//Mysinlgeton single1 = new Mysingleton();	
		//�̱��� ��ü�� �ܺο��� new�� ��ü�� ������ �� ����.
		//�����ڰ� private�̱⶧���� ���ٺҰ�
		
		//�̱��� ��ü�� �����Ϸ��� �ش� ��ü�� �����ؼ� ��ȯ�ϴ� �޼��带 ȣ���ؾ� �Ѵ�.
		//(�� ���������� getInstance()�޼��带 ȣ���Ѵ�.)
		Mysingleton single2 = Mysingleton.getInstance();
		
		Mysingleton single3 = Mysingleton.getInstance();
		
		System.out.println("single2 = " + single2);
		System.out.println("single3 = " + single3);
		
		System.out.println("equals ==> " + single2.equals(single3));
		System.out.println(" == : " + (single2 == single3));
		
		single2.displayTest();	//��ü���� ������� �޼��� ȣ��

	}

}
