package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;


class Room{
	private int roomNum;
	private String roomKind;
	private String name;
	
	public Room(int roomNum, String roomKind) {
		super();
		this.roomNum = roomNum;
		this.roomKind = roomKind;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getRoomKind() {
		return roomKind;
	}

	public void setRoomKind(String roomKind) {
		this.roomKind = roomKind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}

public class Hotel {
	
	HashMap<Integer,Room> roomMap = new HashMap<>();
	Set<Integer> keys = roomMap.keySet();
	
	
	Scanner sc = new Scanner(System.in);
	int input;

	public static void main(String[] args) {
		Hotel hotel = new Hotel();
		hotel.roomAdd();
		hotel.start();

	}
	
	void roomAdd(){
		for(int i = 201; i <= 209; i++){
			roomMap.put(i, new Room(i,"싱글룸"));
		}
		for(int i = 301; i <= 309; i++){
			roomMap.put(i, new Room(i,"더블룸"));
		}
		for(int i = 401; i <= 409; i++){
			roomMap.put(i, new Room(i,"스위트룸"));
		}
	}
	
	void start(){
		System.out.println("*******************************");
		System.out.println("   호텔문을 열었습니다. 어서오십시요.  ");
		System.out.println("*******************************");
		
		System.out.println("---------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1. 체크인   2. 체크아웃   3. 객실상태   4. 업무종료");
		System.out.println("---------------------------------------");
		System.out.println("선택>> ");
		input = Integer.parseInt(sc.nextLine());
		System.out.println("---------------------------------------");
		
		switch(input){
			case 1: checkIn();
				break;
			case 2: checkOut();
				break;
			case 3: room();
				break;
			case 4: close();
				break;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			 	start();
		}
	}
	
	void checkIn(){
		System.out.println("---------------------------------------");
		System.out.println("               체크인 작업                                ");
		System.out.println("---------------------------------------");
		System.out.println(" * 201~209 : 싱글룸");
		System.out.println(" * 301~309 : 더블룸");
		System.out.println(" * 401~409 : 스위트룸");
		System.out.println("---------------------------------------");
		System.out.println("방 번호 입력>> ");
		int roomNum = Integer.parseInt(sc.nextLine());
		if(roomMap.containsKey(roomNum) == false){
			System.out.println(roomNum + "호 객실은 존재하지 않습니다.");
			start();
		}else if(roomMap.get(roomNum).getName() != null){
			System.out.println(roomNum + "호 객실은 이미 손님이 있습니다."); 
			
		}else{
			System.out.println("누구를 체크인 하시겠습니까?");
			System.out.println("이름 입력>> ");
			String name = sc.nextLine();
			Room room = roomMap.get(roomNum); //roomNum 키값에 있는 클래스 Room형태의 value를 가져온다.
			room.setName(name); //value(Room 클래스)의 이름을 Set한다.
			System.out.println("체크인이 완료되었습니다.");
			start();
		}
	}
	
	void checkOut(){
		System.out.println("체크아웃 할 방 번호를 입력하세요.");
		System.out.println("방 번호 입력>> ");
		int roomNum = Integer.parseInt(sc.nextLine());
		if(roomMap.containsKey(roomNum) == false){
			System.out.println(roomNum + "호 객실은 존재하지 않습니다.");
		}else if(roomMap.get(roomNum).getName() == null){
			System.out.println(roomNum + "호 객실에는 체크인 한 사람이 없습니다.");
		}else{
			System.out.println(roomNum + "호 객실의 " + roomMap.get(roomNum).getName() + "님 체크아웃을 완료하였습니다.");
			roomMap.get(roomNum).setName(null);;
		}
		start();
	}
	
	void room(){
		System.out.println("---------------------------------------");
		System.out.println("               현재 객실 상태                            ");
		System.out.println("---------------------------------------");
		System.out.println("방 번호      방 종류              투숙객 이름");
		
		ArrayList<Integer> roomList = new ArrayList<>();
		
		for(int val : keys){
			roomList.add(val);
		}  
		Collections.sort(roomList); //정렬
		
		for(int i = 0; i < roomList.size(); i++){
			System.out.println(roomMap.get(roomList.get(i)).getRoomNum() + "\t" +  roomMap.get(roomList.get(i)).getRoomKind() + "\t" + roomMap.get(roomList.get(i)).getName());
		}
		start();
	}
	
	void close(){
		System.out.println("***************************************");
		System.out.println("           호텔문을 닫았습니다.             ");
		System.out.println("***************************************");
		
		
	}
}
