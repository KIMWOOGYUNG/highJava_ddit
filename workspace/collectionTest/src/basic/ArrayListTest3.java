package basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 문제1) 5명의 별명을 Scanner로 입력하여 ArrayList에 저장하고,
 이들  중 별명의 길이가 제일 긴 별명을 출력하시오.
 (단, 각 별명의 길이는 모두 다르게 입력한다.)

 문제2) 문제1번에서 별명을 입력할 때 별명의 길이가 같은 것이 허용될 경우를 처리하시오.


 */

public class ArrayListTest3 {

	public static void main(String[] args) {
		
//문제 1
/*		Scanner s = new Scanner(System.in);
		ArrayList<String> nicknameList = new ArrayList<>();

		System.out.println("5명의 별명을 입력해주세요. ");
		for (int i = 0; i < 5; i++) {
			System.out.println(i + 1 + "번째 별명 : ");
			String nickname = s.nextLine();
			nicknameList.add(nickname);

		}

		String longestName = "";
		int maxName = nicknameList.get(0)// 0번지정
		for (int i = 0; i < nicknameList.size(); i++) {
			if (maxName.length < nicknameList.get(i).length()) { // 더 큰 사이즈의 별명이 있으면
				maxName = nicknameList.get(i); // 가장 긴 이름에다 별명 넣기
			}
		}
		System.out.println("가장 긴 별명 : " + maxName);
	}
}*/


		// 문제 2

		Scanner s = new Scanner(System.in);
		String maxName = "";

		ArrayList<String> nicknameList = new ArrayList<>();
		System.out.println("서로 다른 길이의 별명 5명을 입력해주세요. ");
		for (int i = 0; i < 5; i++) {
			System.out.println(i + 1 + "번째 별명 : ");
			String nickname = s.nextLine();
			nicknameList.add(nickname);
		}

		ArrayList <String> longName = new ArrayList<>();
		maxName = nicknameList.get(0);
		//가장큰거 하나 담음
		for(int i = 0; i < nicknameList.size(); i++){
			if(maxName.length() < nicknameList.get(i).length()){
				maxName = nicknameList.get(i);
			}
		}
		//System.out.println("첫번째 가장긴이름 : " + maxName);
		longName.add(maxName);
		
		
		//다시 조회해서 길이가 같으면서 이름이 다른게 있으면 더 담기
		for(int i = 0; i < nicknameList.size(); i++){
			if((longName.get(0).length() == nicknameList.get(i).length()) && (longName.get(0) != nicknameList.get(i))){
				longName.add(nicknameList.get(i));
			}
		}
		
		//출력
		System.out.println();
		System.out.println("가장 긴 별명(들) : ");
		for(int i = 0; i < longName.size(); i++){
			System.out.println(longName.get(i));
		}
		
		/*
		 풀이2 = 가장 긴 길이 찾고 그 길이와 동일한 길이의 별명들 출력
		int maxLenth = aliasList.get(0).length();
		
		for(int i = 1; i < aliasList.size().length()){
		  if(maxLenth < aliasList.get(i).length(){
		    maxLenth = aliasList.get(i).length()
		  }
		}
		
		System.out.println("제일 긴 별명들...");
		for(int i = 0; i < aliasList.size(); i++){
		  if(maxLenth == aliasList.get(i).length()){
		    System.out.println(aliasList.get(i));
		  }
		}
		 */

		
	}
}
