package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChargeEndTest extends Thread{
	public static void main(String[] args) {
		// id ���� �е带 ���� �ʱ⿡ �޾Ƽ� 
		// ���� ���� ����� 
		// ������ ���� �ؾ� �մϴ�.
		// ���� ���� �Ϸ�� ���� �� ��
		// �־�� �׽�Ʈ�� ���� �մϴ�.
		
		String id = "xxxxx";
		double total = 34;
		
		SendHTTP send = new SendHTTP(id, total);
    	send.start();
	}
	
}






