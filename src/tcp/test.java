package tcp;

import java.util.Arrays;
import java.util.StringTokenizer;

public class test {

	public static void main(String[] args) {
		String s = "08b,00000,007,76.1,0";
		final String datas[] = new String[5];
		StringTokenizer st = 
				new StringTokenizer(s);
		int i = 0;
		while (st.hasMoreElements()) {
			datas[i] = st.nextToken(",");
			i++;
		}
		System.out.println(Arrays.toString(datas));
		
		String a = "10102";
		int d = Integer.parseInt(a);
		System.out.println(d);
	}

}
