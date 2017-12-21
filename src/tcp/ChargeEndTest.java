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
		// id 값은 패드를 통해 초기에 받아서 
		// 최종 충전 종료시 
		// 서버로 전송 해야 합니다.
		// 현재 진행 완료된 충전 건 이
		// 있어야 테스트가 가능 합니다.
		
		String id = "xxxxx";
		double total = 34;
		
		SendHTTP send = new SendHTTP(id, total);
    	send.start();
	}
	
}






