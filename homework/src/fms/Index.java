package fms;

import java.io.IOException;
import java.util.Scanner;

public class Index {
	public static void main(String[] args) {
		//FMS(lang.txt) day14 2;15;59(��������)2;27;34(���μ���)
		//1. ���� �߰�
			//�߰��� ���� : 
		
			//������ �߰��Ǿ����ϴ�.
		//2. ���� ����
			//������ ������ : !
			//���ο� ������ : ?
		
				//1. �Է��Ͻ� ������ ���� �������Դϴ�.
				//2. ������ ! ��(��) ? (��)�� �����Ǿ����ϴ�.
		//3. ���� ����
			//������ ���� : ~~~ 
		
				//1. �Է��Ͻ� ������ ���� �������Դϴ�.
				//2. �Է��Ͻ� ~~~�� ���������� �����Ǿ����ϴ�.
		//4. ��ü ���
			//Java
			//HTML
			//Spring
			//...
		//5. ������
		Scanner sc = new Scanner(System.in);
		//Index.java���Ͽ� ������ �� �ۼ��ϰ� �Ǹ� ������ �ʹ� �������.
		//������� ������ ���� ���ִ� FileManager Ŭ������ �����
		//�� ���ο� �޼ҵ�� ��ɸ� �����Ѵ�.
		FileManager manager = new FileManager("lang.txt");
		while(true) {
			System.out.println("1. ���� �߰�\n2. ���� ����\n"
					+ "3. ���� ����\n4. ��ü ���\n5. ������");
			int choice = sc.nextInt();
			
			if(choice == 5) {
				System.out.println("�ȳ���������");
				break;
			}
			String data = null;
			String updateData = null;
			switch(choice) {
			case 1:
				//�����߰�
				System.out.print("�߰��� ������ : ");
				data = sc.next();
				try {
					if(manager.insert(data)) {
						System.out.println(data+"��(��) �߰��Ǿ����ϴ�.");
					}else {
						System.out.println("�߰� ���� / �ٽ� �õ��ϼ���");
					}
				} catch (IOException e) {
				}
				break;
			case 2:
				//���� ����
				System.out.print("������ ������ : ");
				data = sc.next();
				System.out.print("���ο� ������ : ");
				updateData = sc.next();
				try {
					if(manager.update(data, updateData)) {
						System.out.println(data+"��(��) " +updateData+"��(��) �����Ǿ����ϴ�");
					}else {
						System.out.println("������ ������ �����߽��ϴ�/�Է��Ͻ� �����Ϳ� ��ġ�ϴ� �����Ͱ� �����ϴ�.");
					}
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				break;
			case 3:
				//���� ����
				
				System.out.print("������ ������ : ");
				data = sc.next();
				try {
					if(manager.delete(data)) {
						System.out.println(data+"��(��) �����Ǿ����ϴ�");
					}else {
						System.out.println("������ ������ �����߽��ϴ�/�Է��Ͻ� �����Ϳ� ��ġ�ϴ� �����Ͱ� �����ϴ�.");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				break;
			case 4:
				//��ü ���
				try {
					manager.selectAll();
				} catch (IOException e) {
				}
			}
		}
	}
	
	
	
}






