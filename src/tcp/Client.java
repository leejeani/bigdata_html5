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

public class Client extends Thread{
	boolean flag = true;
	String address = "192.168.1.34";
	Socket socket;
	Sender sender;
	
	public Client()  {
		
	}
	public void connectServer() throws UnknownHostException, IOException{
		while(true) {
			
			try {
			socket = new Socket(address, 8888);
			}catch(ConnectException e) {
				System.out.println("Connect Server Fail !!");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				continue;
			}	
			System.out.println("Connected Server ..");
			new Receiver(socket).start();
			sender = new Sender(socket);
			break;
		}
	}
	public void run() {
		while(true) {
			//System.out.println("REConnection");
			//System.out.println(socket.isClosed());
			if(socket.isClosed() == true) {
				try {
					connectServer();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void sendMsg(String str) throws Exception {
		
		Thread t = new Thread(sender);
		if(str.equals("q")) {
			sender.setSendMsg(str);
			t.start();
			Thread.sleep(3000);
			socket.close();
		}else {
			sender.setSendMsg(str);
			t.start();
		}

	}
	
	
	class Sender implements Runnable{
		Socket socket;
		OutputStream out;
		DataOutputStream outw;
		String sendMsg;
		public Sender(Socket socket) throws IOException {
			this.socket = socket;
			out = socket.getOutputStream();
			outw = new DataOutputStream(out);
		}
		public void setSendMsg(String sendMsg) {
			this.sendMsg = sendMsg;
		}
		@Override
		public void run() {
			try {
				if(outw != null) {
					outw.writeUTF(sendMsg);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	class Receiver extends Thread{
		Socket socket;
		InputStream in;
		DataInputStream inr;
		public Receiver(Socket socket) throws IOException {
			this.socket = socket;
			in = socket.getInputStream();
			inr = new DataInputStream(in);
		}
		@Override
		public void run() {
			try {
				while(inr != null) {
						String str = inr.readUTF();
						System.out.println(str);
						if(str.trim().equals("q")) {
							break;
						}
				}
			} catch (Exception e) {
				System.out.println("종료");
				
			}finally {
				if(socket != null) {
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
			
		}
	}
	
	
	
	public static void main(String args[]) {
		Client client = null;
		try {
			client = new Client();
			client.connectServer();
			client.start();
		} catch (Exception  e1) {
			e1.printStackTrace();
		} 
		
		
		while(true) {
			@SuppressWarnings("resource")
			Scanner scanner = 
				new Scanner(System.in);
			System.out.println("41(얼라이좌),42(얼라이우),43(얼라이센터),44(얼라이종료),50(얼라이완료),82(충전25),85(충전50),87(충전70),100(충전100),121(충전end),122(충전error),0(pay)");
			String str = scanner.nextLine();
			if(str.equals("41")){
				try {
					client.sendMsg("04b,10000");
				} catch (Exception e) {
					e.printStackTrace();
					scanner.close();
					break;
				}	
			}else if(str.equals("42")){
				try {
					client.sendMsg("04b,00120");
				} catch (Exception e) {
					e.printStackTrace();
					scanner.close();
					break;
				}	
			}else if(str.equals("43")){
				try {
					client.sendMsg("04b,00000");
				} catch (Exception e) {
					e.printStackTrace();
					scanner.close();
					break;
				}	
			}else if(str.equals("44")){
				try {
					client.sendMsg("04b,00001");
				} catch (Exception e) {
					e.printStackTrace();
					scanner.close();
					break;
				}	
			}else if(str.equals("50")){
				try {
					client.sendMsg("05b,00001");
				} catch (Exception e) {
					e.printStackTrace();
					scanner.close();
					break;
				}	
			}else if(str.equals("82")){
				try {
					client.sendMsg("08b,00000,025,34.0");
				} catch (Exception e) {
					e.printStackTrace();
					scanner.close();
					break;
				}	
			}else if(str.equals("85")){
				try {
					client.sendMsg("08b,00000,049,36.0");
				} catch (Exception e) {
					e.printStackTrace();
					scanner.close();
					break;
				}	
			}else if(str.equals("87")){
				try {
					client.sendMsg("08b,00000,073,44.0");
				} catch (Exception e) {
					e.printStackTrace();
					scanner.close();
					break;
				}	
			}else if(str.equals("100")){
				try {
					client.sendMsg("08b,00000,100,24.0");
				} catch (Exception e) {
					e.printStackTrace();
					scanner.close();
					break;
				}	
			}else if(str.equals("121")){
				try {
					client.sendMsg("12b,00001");
				} catch (Exception e) {
					e.printStackTrace();
					scanner.close();
					break;
				}	
			}else if(str.equals("122")){
				try {
					client.sendMsg("12b,00002");
				} catch (Exception e) {
					e.printStackTrace();
					scanner.close();
					break;
				}	
			}else if(str.equals("0")){
				System.out.println("Input ID");
				String id = scanner.nextLine();
				SendHTTP send = new SendHTTP(id, 34);
				send.start();
			}
			
		}
	}
	
}






