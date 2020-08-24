package basic;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* 문제)
 	학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다.
 	이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서 처리한다.
 	
 	이 Student객체들은 List에 저장하여 관리한다.
 	
 	List에 저장된 데이터들을 학번의 오름차순으로 정렬하여 출력하는 부분(내부 정렬기준)과
 	총점의 역순으로 정렬하는 부분(외부 정렬기준)을 프로그램하시오.
 	(그리고, 총점이 같으면 이름의 내림차순으로 정렬되도록 한다.)
 	
 */

class Student implements Comparable <Student>{
	
	private int id;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private int rank;
	
	
	public Student(int id, String name, int kor, int eng, int math){
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = kor + eng + math;
		this.rank = 1;
	
	}
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}

	//학번 오름차순 정렬
	@Override
	public int compareTo(Student s) { //Student클래스의 제네릭
		if(this.id < s.id){
			return -1;
		}else if(this.id > s.id){
			return 1;
		}else{
			return 0;			
		}
		//return Integer.compare(this.getId(),s.getId());
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", kor=" + kor
				+ ", eng=" + eng + ", math=" + math + ", total=" + sum
				+ ", rank=" + rank + "]";
	}

}

//등수구하는 메서드
/*public void setRanking(List<Student> students){
	for(Student s : students){ //기준값을 찾기 위한 반복문
		int rank=1; //처음 등수는 1등으로 초기화
		for(Student s2 : students){ //비교 대상을 찾기 위한 반복문
			if(s.getSum()<s.getSum()){ //기준보다 큰 값이 있으면 rank를 증가시킨다.
				rank++;
			}
		} s.setRank(rank);
	}
}*/


public class StudentTest {
	
	public static void main(String[] args){
		ArrayList<Student> students = new ArrayList<>(); //링크드리스트도 가능
		
		students.add(new Student(101, "김우경", 90, 70, 100));
		students.add(new Student(104, "남아름", 70, 90, 100));
		students.add(new Student(102, "전다희", 85, 95, 95));
		students.add(new Student(105, "이제경", 80, 70, 100));
		students.add(new Student(103, "박정민", 100, 75, 85));
		students.add(new Student(108, "박기완", 60, 75, 90));
		students.add(new Student(107, "이혁진", 80, 75, 75));
		
		for(int i = 0; i < students.size(); i++){
			for(int j = 0; j < students.size(); j++){
				if(students.get(i).getSum() < students.get(j).getSum()){
					students.get(i).setRank(students.get(i).getRank() + 1);
				}
			}
		}
		
		
		
		//정렬 전
		System.out.println("정렬 전");
		System.out.println();
		for(Student s : students){
			System.out.println(s);
		}
		
		
		//학번순 (내부) 정렬 후
		System.out.println();
		System.out.println("학번순 정렬 후");
		System.out.println();
		Collections.sort(students);
		for(Student s : students){
			System.out.println(s);
		}
		
		//총점순 (외부) 정렬 후 (총점이 같으면 이름순 정렬)
		System.out.println();
		System.out.println("총점순 정렬 후");
		System.out.println();
		Collections.sort(students, new DescSort());
		for(Student s : students){
			System.out.println(s);
		}
		
		
	}
}

//외부 정렬 기준 클래스 작성 => 총점의 역순(총점이 같으면 이름의 내림차순)
class DescSort implements Comparator<Student>{
	@Override
	public int compare(Student s1, Student s2) {
		if(s1.getSum() < s2.getSum()){
			return 1;
		}else if(s1.getSum() == s2.getSum()){
			return s1.getName().compareTo(s2.getName())*-1; //이름 내림차순
			
		}else{
			return -1;
		}
		
	}
	
}
