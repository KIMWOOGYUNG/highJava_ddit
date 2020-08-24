package basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 문제) 5명의 사람 이름을 Scanner로 입력받아 ArrayList에 저장하고,
 이 사람들 중에 '김'씨 성의 이름을 출력하는 프로그램을 작성하시오

 */

public class ArrayListTest2 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String input;
		ArrayList<String> nameList = new ArrayList<>();
		int number = 5;

		System.out.println(number + "명의 이름을 입력하세요. ");
		for (int i = 0; i < number; i++) {
			System.out.println(i + 1 + "번째 이름 : ");
			input = s.nextLine();
			nameList.add(input);

		}
		System.out.println();
		System.out.println("김씨 성을 가진 사람들 : ");
		for (int i = 0; i < nameList.size(); i++) {
			if (nameList.get(i).charAt(0) == '김'){
		    //if (nameList.get(i).substring(0, 1).equals("김")) {
		    //if (nameList.get(i).indexOf("김")==0) {
		    //if (nameList.get(i).startsWith("김")) {
				String name = nameList.get(i);
				System.out.println(name);
			}
		}

	}
}
