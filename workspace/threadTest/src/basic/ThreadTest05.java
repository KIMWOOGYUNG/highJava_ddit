package basic;

import javax.swing.JOptionPane;

public class ThreadTest05 {

	public static void main(String[] args) {
		//�̱۾������ �Է� �Ŀ� ī��Ʈ�ٿ��� �۵���
		
		//â���� �Է¹޴� ��
		String str = JOptionPane.showInputDialog("�ƹ��ų� �Է��ϼ���.");
		System.out.println("�Է°� : " + str);
		
		//ī��Ʈ�ٿ�
		for(int i = 10; i >= 1; i--){
			System.out.println(i);
			try {
				Thread.sleep(1000); //1000�� 1��
			} catch (Exception e) {
			}
		}
	}

}
