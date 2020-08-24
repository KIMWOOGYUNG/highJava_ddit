package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//회원 정보를 저장할 수 있는 클래스 작성

/*
 	- 정렬과 관련된 interface는 Comparable과 Comparator 이렇게 두 가지가 있다.
 	
 	- 이 중에 사용자가 작성하는 객체 자체에 정렬 기준을 넣기 위해서는 Comparable 인터페이스를 구현하고, (내부정렬)
 	    정렬 기준을 외부에서 별도로 구현할 경우에는 Comparator 인터페이스를 구현하여 사용하면 된다.		(외부정렬)
 	
 	- Comparable 인터페이스는 compareTo()메서드를 재정의 해서 구현해야 하고, 
 	  Comparator 인터페이스는 compare()메서드를 재정의 해서 구현해야 한다.
 */

//회원 정보를 저장할 수 있는 클래스 작성 ==> 회원의 이름을 기준으로 오름차순 정렬이 될 수 있도록 구현한다.

class Member implements Comparable<Member>{
	private int num;		//회원번호
	private String name;	//회원이름
	private String tel;  	//전화번호
	
	//alt + shift + s 하면 게터세터, 생성자 만들 수 있음
	
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}
	//멤버변수가 private이므로 getter와 setter만들어서 접근가능하게 함
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}
	
	//이 메서드에서 회원의 이름을 기준으로 오름차순 정렬이 되도록 재정의한다.
	@Override
	public int compareTo(Member mem) { //Member 클래스형의 객체
		//스트링은 스트링함수로 비교하고
		//return this.getName().compareTo(mem.getName());
		
		//정수는 조건식으로 비교하기
		//회원번호의 오름차순일 경우
		if(this.getNum() > mem.getNum()){
			return 1;
		}else if(this.getNum() == mem.getNum()){
			return 0;
		}else{
			return -1;
		}
		
	}
	
}



public class ListSortTest2 {

	public static void main(String[] args) {
		ArrayList<Member> memList = new ArrayList<>();
		
		memList.add(new Member(1,"김우경","010-1111-1111"));
		memList.add(new Member(5,"남아름","010-2222-1111"));
		memList.add(new Member(9,"전다희","010-3333-1111"));
		memList.add(new Member(3,"이제경","010-4444-1111"));
		memList.add(new Member(6,"연지은","010-5555-1111"));
		memList.add(new Member(2,"박정민","010-6666-1111"));
		
		for(Member mem : memList){
			System.out.println(mem);
		}
		System.out.println("----------------------------------");
		
		Collections.sort(memList);
		
		System.out.println("회원이름의 오름차순 정렬후...");
		for(Member mem : memList){
			System.out.println(mem);
		}
		System.out.println("----------------------------------");
		
		Collections.sort(memList, new SortNumDesc());
		for(Member mem : memList){
			System.out.println(mem);
		}
		System.out.println("-----------------------------------");
	}	

}

//회원 번호를 기준으로 내림차순 정렬을 수행하는 외부 정렬 기준 class 작성
class SortNumDesc implements Comparator<Member>{

	@Override
	public int compare(Member mem1, Member mem2) {
		//내림차순은 앞이 더 커야함
		
		//조건식을 이용한 방법
		/*if(mem1.getNum() < mem2.getNum()){ //뒤가 더 크면
			return 1; //바꿔지도록 //양수를 반환하면 두 값의 순서가 바뀐다.
		}else if(mem1.getNum() > mem2.getNum()){ //앞이 더 크면
			return -1; //안바꿔지도록
		}else{
			return 0;
		}*/
		
		//수식을 이용한 방법
		//return mem2.getNum() - mem1.getNum(); //뒤에서 앞을 빼서 양수면 뒤가 크다는 뜻 =>반환값이 양수니까 순서바꿈
		
		//Wrapper클래스를 이용한 방법1 ==> 전역 메서드 compare() 이용하기
		//return Integer.compare(mem1.getNum(), mem2.getNum()) * -1;
		
		//Wrapper클래스를 이용한 방법2 ==> 멤버 메서드인 compareTo() 이용하기
		return new Integer(mem1.getNum()).compareTo(mem2.getNum()) * -1;
		
	}
	
}
