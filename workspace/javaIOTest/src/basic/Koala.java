package basic;

/*
'd:/d_Other/Koala.jpg'파일을
'd:/d_Other/연습용'폴더에 
복사하는 프로그램을 작성하시오.*/

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Koala {

	public static void main(String[] args) throws IOException {
		/*File file = new File("d:/d_other/코알라.jpg");
		File file2 = new File("d:/d_other/연습용/코알라.jpg");
		

		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream(file2); 
		
		int data;
		while((data = fis.read()) != -1){
			fos.write(data);
		}
		
		fis.close();
		fos.close();*/
		
		File sourceFile = new File("d:/d_other/코알라.jpg");
		if(!sourceFile.exists()){
			System.out.println(sourceFile.getPath() + "는 없는 파일입니다. 작업 종료...");
			return;
		}
		
		File targetFile = new File("d:/d_other/연습용/" + sourceFile.getName());
		
		try {
		
			//복사할 입력용 파일 스트림 객체 생성
			FileInputStream fis = new FileInputStream(sourceFile);
			BufferedInputStream bin = new BufferedInputStream(fis);	//버퍼쓰면 더 빠름
			
			//복사될 출력용 파일 스트림 객체 생성
			FileOutputStream fos = new FileOutputStream(targetFile);
			BufferedOutputStream bout = new BufferedOutputStream(fos);
			
			int c;
			
			/*while((c=fis.read()) != -1){
				fos.write(c);
			}*/
			while((c=bin.read()) != -1){
				bout.write(c);
			}
			bout.flush();
			
			System.out.println("파일복사완료");
			
			/*fis.close();
			fos.close();*/	//버퍼쓰면 기반스트림은 안닫아도 됨
			bin.close();
			bout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
