package tcp;

public class InverterStateTest {

	public static void main(String[] args) {
		
		String rescode = "0x02";
		String evcode = "0x04";
		double pcpower = 43.0;
		double tcpower = 28.0;
		
		SendStatusHTTP send = 
				new SendStatusHTTP(rescode, evcode,pcpower,tcpower);
		send.start();
	}

}
