package test;

import java.util.Arrays;
import java.util.StringTokenizer;

public class test {

	public static void main(String[] args) {
		String datas[] = new String[5];
		String data = "01a,00000,050,00.1,0";
		StringTokenizer st = 
				new StringTokenizer(data);
		int i = 0;
		while(st.hasMoreElements()) {
			datas[i] = st.nextToken(",");
			i++;
		}
		System.out.println(Arrays.toString(datas));
		
	}

}
