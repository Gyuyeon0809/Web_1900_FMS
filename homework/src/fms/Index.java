package fms;

import java.io.IOException;
import java.util.Scanner;

public class Index {
	public static void main(String[] args) {
		//FMS(lang.txt) day14 2;15;59(과제설명)2;27;34(세부설명)
		//1. 내용 추가
			//추가할 내용 : 
		
			//내용이 추가되었습니다.
		//2. 내용 수정
			//수정할 데이터 : !
			//새로운 데이터 : ?
		
				//1. 입력하신 내용은 없는 데이터입니다.
				//2. 기존의 ! 이(가) ? (으)로 수정되었습니다.
		//3. 내용 삭제
			//삭제할 내용 : ~~~ 
		
				//1. 입력하신 내용은 없는 데이터입니다.
				//2. 입력하신 ~~~가 정상적으로 삭제되었습니다.
		//4. 전체 목록
			//Java
			//HTML
			//Spring
			//...
		//5. 나가기
		Scanner sc = new Scanner(System.in);
		//Index.java파일에 로직을 다 작성하게 되면 파일이 너무 길어진다.
		//기능적인 구현만 따로 해주는 FileManager 클래스를 만들고
		//그 내부에 메소드로 기능만 관리한다.
		FileManager manager = new FileManager("lang.txt");
		while(true) {
			System.out.println("1. 내용 추가\n2. 내용 수정\n"
					+ "3. 내용 삭제\n4. 전체 목록\n5. 나가기");
			int choice = sc.nextInt();
			
			if(choice == 5) {
				System.out.println("안녕히가세요");
				break;
			}
			String data = null;
			String updateData = null;
			switch(choice) {
			case 1:
				//내용추가
				System.out.print("추가할 데이터 : ");
				data = sc.next();
				try {
					if(manager.insert(data)) {
						System.out.println(data+"이(가) 추가되었습니다.");
					}else {
						System.out.println("추가 실패 / 다시 시도하세요");
					}
				} catch (IOException e) {
				}
				break;
			case 2:
				//내용 수정
				System.out.print("수정할 데이터 : ");
				data = sc.next();
				System.out.print("새로운 데이터 : ");
				updateData = sc.next();
				try {
					if(manager.update(data, updateData)) {
						System.out.println(data+"이(가) " +updateData+"으(로) 수정되었습니다");
					}else {
						System.out.println("데이터 수정에 실패했습니다/입력하신 데이터와 일치하는 데이터가 없습니다.");
					}
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				break;
			case 3:
				//내용 삭제
				
				System.out.print("삭제할 데이터 : ");
				data = sc.next();
				try {
					if(manager.delete(data)) {
						System.out.println(data+"이(가) 삭제되었습니다");
					}else {
						System.out.println("데이터 삭제에 실패했습니다/입력하신 데이터와 일치하는 데이터가 없습니다.");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				break;
			case 4:
				//전체 목록
				try {
					manager.selectAll();
				} catch (IOException e) {
				}
			}
		}
	}
	
	
	
}






