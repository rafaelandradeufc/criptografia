package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		String arq = "src/main/palavras3.txt";

		BufferedReader br = new BufferedReader(new FileReader(arq));
		    
	    File f1 =new File("src/main/ct1.tex");
	    File f2 =new File("src/main/ct2.tex");
	    File f3 =new File("src/main/ct3.tex");
	    
		
		OneTimePad otp = new OneTimePad();

		String ms1 = "vir serfissional ir";
		String ms2 = "dar veros que fazer";
		String key = "wiurueriwbhajakq1qw";
		
		String cypher1 = otp.xor(ms1, key);
		String cypher2 = otp.xor(ms2, key);
		
		
		String cf1 = new String (otp.getBytes(f1), "ISO-8859-1");
		String cf2 = new String (otp.getBytes(f2), "ISO-8859-1");
		String cf3 = new String (otp.getBytes(f3), "ISO-8859-1");



//		String keyword ="ir";
//		otp.cribDrag(cypher1, cypher2, keyword);
		
//		while (br.ready()) {
//		
//			String keyword = br.readLine();
//			
//		for (int i = 0; i < cypher1.length()-1; i++) {
//			
//			for (int j = i; j < cypher1.length()-1; j++) {
//				
//				otp.cribDrag(cypher2.substring(i, j), cypher2.substring(i, j),keyword);
//				
//			}
//			
//		}
//				
//		
//		}
//		br.close();
		
		
		while (br.ready()) {

			String keyword = br.readLine();
			otp.cribDrag(cypher1, cypher2, keyword,arq);
			//otp.cribDrag(cf1, cf2, keyword,arq);
			//otp.verMap();
			otp.cribDrag(cf2, cf3, keyword,arq);
			otp.cribDrag(cf1, cf3, keyword,arq);
		}

		br.close();
		

		otp.verMap();
		
	
	}
	
	

}