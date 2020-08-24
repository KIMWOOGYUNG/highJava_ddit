package basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Lotto {
	
	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		lotto.start();
		
		

	}
	
	void start(){
		Scanner sc = new Scanner(System.in);
		int input;
		System.out.println("========================");
		System.out.println("      Lotto 프로그램      ");
		System.out.println("------------------------");
		System.out.println("1. Lotto 구입");
		System.out.println("2. 프로그램 종료");
		System.out.println("========================");
		System.out.println("메뉴선택 : ");
		input = Integer.parseInt(sc.nextLine());
		
		switch(input){
			case 1: buy();
				break;
			case 2: System.out.println("감사합니다");
				break;
		}
	}
	
	void buy(){
		Lotto lotto = new Lotto();
		
		Scanner sc = new Scanner(System.in);
		int price;
		int count = 0;
		
		System.out.println("Lotto 구입 시작");
		System.out.println();
		System.out.println("1000원에 로또번호 하나입니다.");
		System.out.println("금액 입력 : ");
		price = Integer.parseInt(sc.nextLine());
		if(price < 1000){
			System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!");
		}else if(price > 100000){
			System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!");
		}else{
			count += (price/1000);
		}
		
		HashSet<Integer> lottoNum = new HashSet<>();
		ArrayList<HashSet>lottoList = new ArrayList<>();
		int num;
		for(int i = 0; i < count; i++){
			while(lottoNum.size() < 6){
				num = (int)(Math.random()* 40 + 1);
				lottoNum.add(num);
			}
			lottoList.add(lottoNum);
			lottoNum = new HashSet<>();
		}
		
		System.out.println(lottoList);
		System.out.println("행운의 로또번호는 아래와 같습니다.");
		for(int i = 0; i < count; i++){
			System.out.println("로또번호" + (i + 1) + " : " + lottoList.get(i));
		}
		System.out.println("받은 금액은 " + price + "원이고 거스름돈은 " + (price - (1000 * count)) + "원 입니다.");
		lotto.start();
	}

}
