package mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Mail {
	public static void main(String[] args) {

		  String host     = "smtp.naver.com";
		  final String user   = "jungjuhwan10@naver.com";
		  final String password  = "";

		  String to     = "jungjuhwan10@naver.com";

		  
		  // Get the session object
		  Properties props = new Properties();
		  props.put("mail.smtp.host", host); 
		  props.put("mail.smtp.auth", "true");

		  Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
		   protected PasswordAuthentication getPasswordAuthentication() {
		    return new PasswordAuthentication(user, password);
		   }
		  });

		  // Compose the message
		  try {
		   MimeMessage message = new MimeMessage(session);
		   message.setFrom(new InternetAddress(user));
		   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

		   // Subject
		   message.setSubject("자바다");
		   
		   // Text
		   message.setText("동구리동동");

		   // send the message
		   Transport.send(message);
		   System.out.println("message sent successfully...");

		  } catch (MessagingException e) {
		   e.printStackTrace();
		  }
//		SimpleEmail email = new SimpleEmail();
//	    email.setAuthentication("ID", "pass");
//		
//	    email.setCharset("euc-kr");    email.setHostName("smtp.naver.com");  // SMTP 서버를 지정
//	    try {
//			email.addTo("jungjuhwan10@naver.com", "주환이");
//			email.setFrom("jungjuhwan10@naver.com", "주환"); // 보내는 사람 지정
//		    email.setSubject("텍스트 테스트 메일입니다."); // 메일 제목
//		    email.setContent("테스트 메일의 내용입니다.", "text/plain; charset=euc-kr");
//		    email.send(); // 메일 발송
//		    System.out.println("발송성공");
//	    } catch (EmailException e) {
//	    	e.printStackTrace();
//	    } // 수신자를 추가
		
	    
	}
}
