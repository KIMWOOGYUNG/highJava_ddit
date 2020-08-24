package basic;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class ThreadTest19 {

	public static void main(String[] args) {
		//Vector�� ���ο� ����ȭó�� �ڵ����� ���� / ArrayList�� ����ȭó���� ����
		//=> �����带 ���� Vector���°� ����
		/*
		 	Vector, Hashtable���� �������� �����ϴ� Collection���� ���ο� ����ȭ ó���� �Ǿ� �ִ�.
		 	�׷��� ���Ӱ� ������ Collenction���� �⺻������ ����ȭ ó���� �Ǿ����� �ʴ�.
		 	�׷���, ����ȭ�� �ʿ��� ���α׷����� �̷� Collection���� ����Ϸ��� ����ȭ ó���� �� �Ŀ� ����ؾ� �Ѵ�.
		 	
		 */
		
		final Vector<Integer> vec = new Vector<>();
		
		//����ȭ ���� ���� ���
		final ArrayList<Integer> list = new ArrayList<>();
		
		//����ȭ �ϴ� ���
		final List<Integer> list2 = Collections.synchronizedList(new ArrayList<Integer>());
		
		Runnable r = new Runnable(){
			@Override
			public void run() {
				for(int i = 0; i < 1000; i++){
					//vec.add(i);
					//list.add(i);
					list2.add(i);
				}
			}
		};
		
		Thread[] ths = new Thread[]{
			new Thread(r), new Thread(r), new Thread(r), 
			new Thread(r), new Thread(r)};
		
		for(Thread th : ths){
			th.start();
		}
		
		for(Thread th : ths){
			try {
				th.join();
			} catch (InterruptedException e) {
			}
		}
		//System.out.println("vec�� ���� : " + vec.size());
		//System.out.println("list�� ���� : " + list.size());
		System.out.println("list2�� ���� : " + list2.size());
	}
	
	

}
