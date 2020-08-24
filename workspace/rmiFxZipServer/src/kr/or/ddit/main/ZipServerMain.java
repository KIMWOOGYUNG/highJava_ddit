package kr.or.ddit.main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import kr.or.ddit.zipcode.service.IzipcodeService;
import kr.or.ddit.zipcode.service.ZipcodeServiceImpl;

public class ZipServerMain {

   public static void main(String[] args) {
      try {
         IzipcodeService service = ZipcodeServiceImpl.getInstance();
         
         Registry reg = LocateRegistry.createRegistry(9999);
         reg.rebind("zipService", service);
         
         System.out.println("서버가 준비되었습니다.");
         
      } catch (Exception e) {
         e.printStackTrace();
      }

   }

}