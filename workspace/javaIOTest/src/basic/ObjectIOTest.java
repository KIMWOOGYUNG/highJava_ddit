package basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectIOTest {

	public static void main(String[] args) {
		Member mem1 = new Member("김우경", 26, "반석");
		Member mem2 = new Member("전다희", 25, "유온");
		Member mem3 = new Member("남아름", 25, "대전");
		Member mem4 = new Member("이제경", 29, "공주");

		File file = new File("d:/d_other/memObj.bin");

		try {
			// 객체를 파일에 저장하기

			// 출력용 스트림 객체 생성
			ObjectOutputStream oos = new ObjectOutputStream( // 또다른 보조스트림
					new BufferedOutputStream( // 보조스트림
							new FileOutputStream(file) // 기반이되는 스트림
					));

			// 쓰기 작업
			oos.writeObject(mem1);
			oos.writeObject(mem2);
			oos.writeObject(mem3);
			oos.writeObject(mem4);

			oos.close(); // 스트림 닫기
			System.out.println("쓰기 작업 완료...");

			// ------------------------------------------
			// 저장된 객체 읽어오기
			// 입력용 스트림 객체 생성
			ObjectInputStream ois = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(file)));

			Object obj = null; // 읽어온 객체를 저장할 변수

			while ((obj = ois.readObject()) != null) {
				if (obj instanceof Member) {
					Member mem = (Member) obj;
					System.out.println("이름 : " + mem.getName());
					System.out.println("나이 : " + mem.getAge());
					System.out.println("주소 : " + mem.getAddr());
					System.out.println("-------------------------");

				}
			}

		} catch (EOFException e) {
			// EOFException은 readObject() 메서드에서 더 이상 읽어올 자료가 없을 때 발생하는
			// exception이다.
			System.out.println("읽기작업 완료");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {	//읽기할때 필요함
			e.printStackTrace();
		}
	}

}

// 저장용 class 작성 ==> 직렬화가 가능하도록 Serializable인터페이스를 구현해야 한다.
class Member implements Serializable {
	private static final long serialVersionUID = 1432605378974552445L;
	
	//transient ==> 직렬화가 되지 않을 멤버변수에 지정한다.
	//				직렬화가 되지 않은 멤버변수는 기본값으로 초기화되어 저장된다.
	//				(기본값 => 참조변수 : null, 숫자형 변수 : 0, 논리형 변수 : false)
	private String name;
	private transient int age;
	private transient String addr;

	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}