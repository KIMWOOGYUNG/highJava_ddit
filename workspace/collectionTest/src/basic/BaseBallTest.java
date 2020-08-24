package basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class BaseBallTest {
/*
 	숫자 야구 게임 프로그램 작성하기
 	
 	- Set을 이용하여 숫자 야구 게임 프로그램을 작성한다.
 	  컴퓨터의 숫자는 난수를 이용해서 구한다.
 	  (스트라이크는 S, 볼은 B로 출력한다.)
 	  
 	  예) 컴퓨터 난수 ==> 9 5 7
 	  
 	  실행 예시)
 	  	  숫자입력 : 3 5 6 
 	  	 3 5 6 ==> 1S 0B
 	  	 숫자입력 : 7 8 9
 	  	 7 8 9 ==> 0S 2B
 	  	 숫자입력 : 9 7 5
 	  	 9 7 5 ==> 1S 2B
 	  	 숫자입력 : 9 5 7
 	  	 9 5 7 ==> 3S 0B
 	  	 
 	  	 4번만에 맞췄습니다.
 */

	//ArrayList<Integer> lottoList = new ArrayList<>(lottoSet);
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> ranset = new HashSet<>();
		
		
		System.out.println("★BaseBall Game Start!!★");
		
		//컴퓨터 랜덤숫자 발생
		int random;
		
		while(ranset.size()<3){
			random = (int)(Math.random()*9 + 1);
			ranset.add(random);
		}
		System.out.println("랜덤숫자 : " + ranset);
		
		
		ArrayList<Integer> ranlist = new ArrayList<>(ranset);

		//숫자3개 입력받기
		ArrayList<Integer> set = new ArrayList<>();
		int s = 0;
		int b = 0;
		int count = 0;
		
		while(s != 3){
			s = 0; 
			b = 0;
			set.clear();
			System.out.println("숫자 3개를 입력해주세요>");
			for(int i = 0; i < 3; i++){
				int input = sc.nextInt();
				set.add(input);	
			}
			System.out.println("입력한 숫자 : " + set);
			
			for(int i = 0; i < ranlist.size(); i++){
				if(ranlist.get(i) == set.get(i)){
					s++;}
				for(int j = 0; j < set.size(); j++){
					if(ranlist.get(i) == set.get(j) && ranlist.get(i) != set.get(i)){
						b++;
					}
				}
			}
			System.out.println("S : " + s + " B : " + b);
			count++;
			if(s == 3){
				System.out.println("정답!! " + count + "번만에 맞췄습니다.");
			}
			
			
		}

	}

}
