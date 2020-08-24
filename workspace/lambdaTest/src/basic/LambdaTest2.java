package basic;

public class LambdaTest2 {

	public static void main(String[] args) {
		// 람다식을 사용하지 않은 경우
		LambdaTestInterface t1 = new LambdaTestInterface() {
			
			@Override
			public void test() {
				System.out.println("람다식을 사용하지 않은 경우입니다.");
				
			}
		};
		t1.test();
		
		LambdaTestInterface t2 = 
				() -> {System.out.println("람다식을 사용한 경우입니다.(중괄호 있음)");};
		t2.test();
		
		LambdaTestInterface t3 = 
				() -> System.out.println("람다식을 사용한 경우입니다.(중괄호 없음)");
		t3.test();
		
		System.out.println("------------------------------------------");
		
		LambdaTestInterface2 t4 = (int s) -> {
			int result = s + 40;
			System.out.println(result);
		};
		t4.test(30);
		
		//변수 1개면 소괄호 생략
		LambdaTestInterface2 t5 = k -> {
			int result = k * 40;
			System.out.println(k + " * 40 = " + result);
		};
		t5.test(30);
		
		//실행문 1개면 중괄호 생략
		LambdaTestInterface2 t6 = k -> System.out.println(k + " - 10 = " + (k-10));
		t6.test(30);
	
		//매개변수2개 (일반)
		LambdaTestInterface3 t7 = (int a, int b) -> {
			int result = a + b;
			return result;
		};
		int k = t7.test(30, 30);
		System.out.println("k = " + k);
		
		//매개변수2개 (람다)
		LambdaTestInterface3 t8 = (a, b) -> {
			int result = a - b;
			return result;
		};
		int k2 = t8.test(10, 50);
		System.out.println("k2 = " + k2);
		
		//실행문1개 (실행문이 하나라도 리턴이면 중괄호 필요)
		LambdaTestInterface3 t9 = (x,y) -> {
			return x * y;
		};
		int k3 = t9.test(10, 10);
		System.out.println("k3 = " + k3);
		
		//실행문 1개, 리턴 없음 (중괄호 생략, return생략)
		LambdaTestInterface3 t10 = (x,y) -> x / y;
		int a = t10.test(20, 5);
		System.out.println("a = " + a);
		
	}

}
