package fms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
	String file;

	public FileManager(String file) {
		this.file = file;
	}

	boolean insert(String data) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
		bw.write(data + "\r\n");
		bw.close();
		return true;
	}

	boolean update(String oldData, String newData) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		// 텍스트 문서의 줄 수를 누적시킴
				int count = 0;
				//텍스트 줄 수 구하는 반복문
				while (true) {
					String line1 = br.readLine();
					
					if(line1 != null) {
						count++;
					} else {
						break;
					}
				}
				//처음 받은값이 null이라면 내용이 아예없는 경우이기 때문에 false리턴 
				if(count==0) {
					 System.out.println("현재 추가된 데이터가 없습니다/ 내용 추가 후 다시 시도해 주세요.");
					 return false;
				}

					//비교한 문자 중에 다른 문자를 카운트함 else 문에 들어가면 카운트
				int countNum = 0;
				String result = "";//result를 lang.txt에 넣어줘야함
				
				BufferedReader br1 = new BufferedReader(new FileReader(file));
					//라인 수만큼 반복하며 문자열 비교
				for (int i = 0; i < count; i++) {
					//현재 br.readLine()에있는 문자열을 line이라는 곳에 저장
					 String	line = br1.readLine(); 
					
					//매개변수로 받은 문자열이 line의 문자열과 같다면 삭제해야 할 데이터이므로 result에 수정할 데이터값을 누적
						if(oldData.equals(line)) { 
							result += newData+"\r\n";
						} else {
					/*line의 문자열과 매개변수로 받은 문자열이 서로 다르다면 countNum에 횟수 누적
					만약에 여기에서 그냥 result에 line을 누적한다면 새로운 문자가 추가 된다.
					따라서 텍스트가 몇 줄인지 구하고 텍스트의 줄 수 만큼 비교했지만 line의 문자열과 매개변수로 받은
					문자열의 값이 다르다면 없는 문자열을 입력한 것임*/
					//현재 검사하는 줄의 숫자와 텍스트문서의 줄 수가 같으면 false리턴
					//검사 한 줄 수를 countNum에 누적
							countNum++;
							if (countNum == count) {
								return false;
					//그게 아니라면 result에 누적
							} else {
								result += line+"\r\n";
							}
						}
					 
				}
				BufferedWriter bw = new BufferedWriter(new FileWriter(file));//이 위치일때는 정상작동(oldData)만 삭제
				bw.write(result);
				bw.close();
				return true;
		

	}

	boolean delete(String oldData) throws IOException { 	//데이터 삭제
		BufferedReader br = new BufferedReader(new FileReader(file));
		// 텍스트 문서의 줄 수를 누적시킴
		int count = 0;
		//텍스트 줄 수 구하는 반복문
		while (true) {
			String line1 = br.readLine();
			
			if(line1 != null) {
				count++;
			} else {
				break;
			}
		}
		//처음 받은값이 null이라면 내용이 아예없는 경우이기 때문에 false리턴 
		if(count==0) {
			 System.out.println("현재 추가된 데이터가 없습니다/ 내용 추가 후 다시 시도해 주세요.");
			 return false;
		}

			//비교한 문자 중에 다른 문자를 카운트함 else 문에 들어가면 카운트
		int countNum = 0;
		String result = "";//result를 lang.txt에 넣어줘야함
		
		BufferedReader br1 = new BufferedReader(new FileReader(file));
			//라인 수만큼 반복하며 문자열 비교
		for (int i = 0; i < count; i++) {
			//현재 br.readLine()에있는 문자열을 line이라는 곳에 저장
			 String	line = br1.readLine(); 
			
			//매개변수로 받은 문자열이 line의 문자열과 같다면 삭제해야 할 데이터이므로 무시
				if(oldData.equals(line)) { 
				} else {
			/*line1의 문자열과 매개변수로 받은 문자열이 서로 다르다면 countNum에 횟수 누적
			만약에 여기에서 그냥 result에 line을 누적한다면 새로운 문자가 추가 된다.
			따라서 텍스트가 몇 줄인지 구하고 텍스트의 줄 수 만큼 비교했지만 line의 문자열과 매개변수로 받은
			문자열의 값이 다르다면 없는 문자열을 입력한 것임*/
			//현재 검사하는 줄의 숫자와 텍스트문서의 줄 수가 같으면 false리턴
			//검사 한 줄 수를 countNum에 누적
					countNum++;
					if (countNum == count) {
						return false;
			//그게 아니라면 result에 누적
					} else {
						result += line+"\n";
					}
				}
			 
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));//이 위치일때는 정상작동(oldData)만 삭제
		bw.write(result);
		bw.close();
		return true;
	}

	void selectAll() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			System.out.println(line);
		}
	}
}
