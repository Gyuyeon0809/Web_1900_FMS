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
		// �ؽ�Ʈ ������ �� ���� ������Ŵ
				int count = 0;
				//�ؽ�Ʈ �� �� ���ϴ� �ݺ���
				while (true) {
					String line1 = br.readLine();
					
					if(line1 != null) {
						count++;
					} else {
						break;
					}
				}
				//ó�� �������� null�̶�� ������ �ƿ����� ����̱� ������ false���� 
				if(count==0) {
					 System.out.println("���� �߰��� �����Ͱ� �����ϴ�/ ���� �߰� �� �ٽ� �õ��� �ּ���.");
					 return false;
				}

					//���� ���� �߿� �ٸ� ���ڸ� ī��Ʈ�� else ���� ���� ī��Ʈ
				int countNum = 0;
				String result = "";//result�� lang.txt�� �־������
				
				BufferedReader br1 = new BufferedReader(new FileReader(file));
					//���� ����ŭ �ݺ��ϸ� ���ڿ� ��
				for (int i = 0; i < count; i++) {
					//���� br.readLine()���ִ� ���ڿ��� line�̶�� ���� ����
					 String	line = br1.readLine(); 
					
					//�Ű������� ���� ���ڿ��� line�� ���ڿ��� ���ٸ� �����ؾ� �� �������̹Ƿ� result�� ������ �����Ͱ��� ����
						if(oldData.equals(line)) { 
							result += newData+"\r\n";
						} else {
					/*line�� ���ڿ��� �Ű������� ���� ���ڿ��� ���� �ٸ��ٸ� countNum�� Ƚ�� ����
					���࿡ ���⿡�� �׳� result�� line�� �����Ѵٸ� ���ο� ���ڰ� �߰� �ȴ�.
					���� �ؽ�Ʈ�� �� ������ ���ϰ� �ؽ�Ʈ�� �� �� ��ŭ �������� line�� ���ڿ��� �Ű������� ����
					���ڿ��� ���� �ٸ��ٸ� ���� ���ڿ��� �Է��� ����*/
					//���� �˻��ϴ� ���� ���ڿ� �ؽ�Ʈ������ �� ���� ������ false����
					//�˻� �� �� ���� countNum�� ����
							countNum++;
							if (countNum == count) {
								return false;
					//�װ� �ƴ϶�� result�� ����
							} else {
								result += line+"\r\n";
							}
						}
					 
				}
				BufferedWriter bw = new BufferedWriter(new FileWriter(file));//�� ��ġ�϶��� �����۵�(oldData)�� ����
				bw.write(result);
				bw.close();
				return true;
		

	}

	boolean delete(String oldData) throws IOException { 	//������ ����
		BufferedReader br = new BufferedReader(new FileReader(file));
		// �ؽ�Ʈ ������ �� ���� ������Ŵ
		int count = 0;
		//�ؽ�Ʈ �� �� ���ϴ� �ݺ���
		while (true) {
			String line1 = br.readLine();
			
			if(line1 != null) {
				count++;
			} else {
				break;
			}
		}
		//ó�� �������� null�̶�� ������ �ƿ����� ����̱� ������ false���� 
		if(count==0) {
			 System.out.println("���� �߰��� �����Ͱ� �����ϴ�/ ���� �߰� �� �ٽ� �õ��� �ּ���.");
			 return false;
		}

			//���� ���� �߿� �ٸ� ���ڸ� ī��Ʈ�� else ���� ���� ī��Ʈ
		int countNum = 0;
		String result = "";//result�� lang.txt�� �־������
		
		BufferedReader br1 = new BufferedReader(new FileReader(file));
			//���� ����ŭ �ݺ��ϸ� ���ڿ� ��
		for (int i = 0; i < count; i++) {
			//���� br.readLine()���ִ� ���ڿ��� line�̶�� ���� ����
			 String	line = br1.readLine(); 
			
			//�Ű������� ���� ���ڿ��� line�� ���ڿ��� ���ٸ� �����ؾ� �� �������̹Ƿ� ����
				if(oldData.equals(line)) { 
				} else {
			/*line1�� ���ڿ��� �Ű������� ���� ���ڿ��� ���� �ٸ��ٸ� countNum�� Ƚ�� ����
			���࿡ ���⿡�� �׳� result�� line�� �����Ѵٸ� ���ο� ���ڰ� �߰� �ȴ�.
			���� �ؽ�Ʈ�� �� ������ ���ϰ� �ؽ�Ʈ�� �� �� ��ŭ �������� line�� ���ڿ��� �Ű������� ����
			���ڿ��� ���� �ٸ��ٸ� ���� ���ڿ��� �Է��� ����*/
			//���� �˻��ϴ� ���� ���ڿ� �ؽ�Ʈ������ �� ���� ������ false����
			//�˻� �� �� ���� countNum�� ����
					countNum++;
					if (countNum == count) {
						return false;
			//�װ� �ƴ϶�� result�� ����
					} else {
						result += line+"\n";
					}
				}
			 
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));//�� ��ġ�϶��� �����۵�(oldData)�� ����
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
