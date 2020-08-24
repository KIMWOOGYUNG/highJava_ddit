package basic;

/* 
	인터페이스가 함수적 인터페이스라는 것을 명시적으로 표시해 주는 어노테이션은 
	@FunctionalInterface이다.
*/
/*
 	자바파일에 인터페이스를 여러개 사용할 수 있다
 	그러나 public은 파일 이름과 동일한 인터페이스에만 사용할 수 있다.
 */

@FunctionalInterface
public interface LambdaTestInterface {
	//매개변수가 없고, 반환값도 없는 메서드
	public void test();
	//public void test2();
	
}
@FunctionalInterface
interface LambdaTestInterface2 {
	//반환값이 없고, 매개변수가 1개인 메서드
	public void test(int a);
}

@FunctionalInterface
interface LambdaTestInterface3 {
	//반환값이 있고, 매개변수도 있는 메서드ㄴ
	public int test(int a, int b);
}

