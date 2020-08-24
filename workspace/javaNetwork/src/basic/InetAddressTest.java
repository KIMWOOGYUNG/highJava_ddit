package basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] args) throws UnknownHostException {
		//InetAddress클래스 ==> IP주소를 다루기 위한 클래스
		
		//Naver사이트의 IP주소 가져오기
		InetAddress naverIp = InetAddress.getByName("www.naver.com");
		System.out.println("HostName : " + naverIp.getHostName());
		System.out.println("HostAddress : " + naverIp.getHostAddress());	//아이피주소(주소창에 치면 사이트로 연결됨)
		System.out.println();
		
		//자신의 컴퓨터 Ip주소 가져오기
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("HostName : " + localIp.getHostName());
		System.out.println("HostAddress : " + localIp.getHostAddress());
		System.out.println();
		
		//IP주소가 여러개인 흐스트의 정보 가져오기
		InetAddress[] naverArrays = InetAddress.getAllByName("www.naver.net");	//큰 사이트는 보통 2개 이상 사용
		InetAddress[] daumArrays = InetAddress.getAllByName("www.daum.net");	
		InetAddress[] nateArrays = InetAddress.getAllByName("www.nate.net");
		InetAddress[] dditArrays = InetAddress.getAllByName("ddit.or.kr");
		for(InetAddress nIp : naverArrays) {
			System.out.println(nIp.toString());
		}
		
	}
}
