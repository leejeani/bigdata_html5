package tcp;

import java.net.HttpURLConnection;
import java.net.URL;

public class SendHTTP extends Thread {

	HttpURLConnection conn;
	URL url;
	String id;
	double total;

	public SendHTTP(String id, double total) {
		this.id = id;
		this.total = total;
	}

	public void run() {

		try {
			url = new URL( "http://52.10.92.150/charge.sm?cmd=payend&id="+id+"&ctotal="+total );
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
