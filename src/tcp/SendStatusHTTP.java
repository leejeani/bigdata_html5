package tcp;

import java.net.HttpURLConnection;
import java.net.URL;

public class SendStatusHTTP extends Thread {

	HttpURLConnection conn;
	URL url;
	String rescode;
	String evcode;
	double pcpower;
	double tcpower;
	public SendStatusHTTP(String rescode,String evcode,double pcpower,double tcpower) {
		this.rescode = rescode;
		this.evcode = evcode;
		this.pcpower = pcpower;
		this.tcpower = tcpower;
	}

	public void run() {

		try {
			url = new URL( "http://52.10.92.150/instate.sm?cmd=insert&rescode="+rescode+"&evcode="+evcode+"&pcpower="+pcpower+"&tcpower="+tcpower );
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setRequestMethod("GET");
			conn.connect();
			conn.getInputStream();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
