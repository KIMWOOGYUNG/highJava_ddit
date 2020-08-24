package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.management.InstanceNotFoundException;

/*
 10������ ������ �����ϴ� �渶 ���α׷��� �ۼ��� ����.

 ���� Horse��� �̸��� Ŭ������ �����ϰ�
 �� Ŭ������ ���̸�(String), ���(int), ������ġ(int)�� ��������� ���´�.
 �׸��� �� Ŭ�������� ����� ������������ ó���� �� �ִ� ���� ���� ������ �ִ�.
 (Comparable �������̽� ����)

 ��� ������ 1~50�������� �Ǿ� �ִ�.

 ��Ⱑ �����ϴ� ���� ������ �ð� ���� ������ ���� ��ġ�� ����Ѵ�.(������ġ�� ǥ��)
 ��) 
 ���̸�1  ---->---------------------------------------------
 ���̸�2  ------>-------------------------------------------
 ���̸�3  ---------->---------------------------------------
 ...
 ���̸�10 --------->----------------------------------------

 ��Ⱑ ������ ��� ������ ����Ѵ�.

 */
public class ThreadTest12 {

	public static void main(String[] args) {
		Horse[] horses = new Horse[] { new Horse("1����"), new Horse("2����"),
				new Horse("3����"), new Horse("4����"), new Horse("5����"),
				new Horse("6����"), new Horse("7����"), new Horse("8����"),
				new Horse("9����"), new Horse("10����") };

		PlayState display = new PlayState(horses);

		// ��� ����
		System.out.println("��� ����...");

		for (Horse h : horses) {
			h.start();
		}

		display.start();

		for (Horse h : horses) {
			try {
				h.join();
			} catch (InterruptedException e) {
			}
		}

		try {
			display.join();
		} catch (InterruptedException e) {

		}

		// ��Ⱑ ������ �迭�� ��������� �����Ѵ�.
		Arrays.sort(horses); // �迭 �����ϴ� �Լ�

		System.out.println("��� ���");
		for (Horse h : horses) {
			System.out.println(h);
		}

	}

}

// ���ָ��� ��Ÿ���� Ŭ���� --> �� ������ ���ָ� �ؾ��ϱ� ������ �� Ŭ������ ������� �����.

class Horse extends Thread implements Comparable<Horse> {
	public static int currentRank = 0; // ���ְ� ���� ���� ����� �����ϱ� ���� ����

	private String horseName; // �� �̸�
	private int rank; // ���
	private int location; // ������ġ

	// ������
	public Horse(String name) {
		this.horseName = name;
	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "���ָ� " + horseName + "�� " + rank + "�� �Դϴ�.";
	}

	// ����� ������������ ������ �� �ִ� ���� ���� �����
	@Override
	public int compareTo(Horse h) { // Ŭ�������� ��ü
		return Integer.compare(rank, h.rank);
	}

	// �渶����
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			location = i; // ���� �޸��� �ִ� ������ ���� ���� ��ġ�� �ȴ�.
			try {
				Thread.sleep((int) (Math.random() * 400));
			} catch (InterruptedException e) {
			}
		}
		++currentRank; // ����� �����ϴ� ������ ������Ű��
		this.rank = currentRank;
	}

}

// ��� �� ������ ��Ȳ�� ����ϴ� ������
class PlayState extends Thread {
	private Horse[] horses; // ���ֿ� ������ ������ ������ �迭

	// ������ ����� ���ÿ� Horse�� �����
	PlayState(Horse[] horses) {
		this.horses = horses;
	};

	@Override
	public void run() {
		while (true) {
			if(Horse.currentRank == horses.length)
				break;
			
			for(int i = 0; i < 10; i++){
				System.out.println();
			}
			
			// ��⿡ ������ ���� ������ŭ �ݺ�
			for (int i = 0; i < horses.length; i++) {
				System.out.print(horses[i].getHorseName() + " : ");

				// 1~50������ ��Ÿ���� �ݺ���
				for (int j = 0; j < 50; j++) {
					if (horses[i].getLocation() == j) {
						System.out.print(">");
					}else{
					System.out.print("-");
					}
				} // for j
				System.out.println();
			} // for i

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}
