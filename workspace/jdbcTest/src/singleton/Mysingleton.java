package singleton;
/*
 	singleton���� : �׻� �� ���� ��ü�� ��������� �ϴ� ���
 		==> �ܺο��� new ����� ������� ���ϰ� �ϰ�, ���ο��� �׻� ������ ��ü�� ��ȯ�ϵ��� ������� Ŭ����	
 */

//singleton Ŭ������ �����ϴ� ����
public class Mysingleton {
	//1. �ڱ� class�� �������� ���� ��������� private static �������� �����Ѵ�.
	private static Mysingleton single;
	
	//2. �����ڴ� private���� �����. ==> �ܺο��� new ����� ������� ���Ѵ�.
	private Mysingleton(){
		System.out.println("������ �Դϴ�.");
	}
	
	//3. �ڱ��ڽ� ��ü(instance)�� �����Ͽ� ��ȯ�ϴ� �޼��带 �ۼ��Ѵ�.
    //	  ==> �� �޼���� 'public static �ڱ��ڽ�Ŭ������ �޼����()' �������� �����.
	//		   �� �޼����� �̸��� ���� getInstance()�� �Ѵ�.
	//		   �׸��� �� �޼��忡�� �ڱ� �ڽ� ��ü�� ������ �� ��ü�� �����ϴ��� ���θ� �˻��ؼ�
	//		   �ش� ��ü�� �������� ������ ���Ӱ� ����� ��ȯ�ϰ� ������ ��ü�� �����ϸ� �� ��ü�� ��ȯ�Ѵ�.
	public static Mysingleton getInstance(){
		if(single == null) single = new Mysingleton();
		
		return single;
	}
	
	public void displayTest(){
		System.out.println("�̰��� �̱��� ��ü�� �޼��� �Դϴ�.");
	}
}
