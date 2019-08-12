package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class OneTimePad {
	
	private HashMap<String, String> map = new HashMap<String, String>();

	private BufferedReader br;
	


	public String xor(String message, String key) {
		String finalmessage = "";
		String temp1, temp2, s = "";

		if (key.length() != message.length())
			return null;

		for (int i = 0; i < key.length(); i++) {
			temp1 = Integer.toBinaryString(message.charAt(i));
			temp2 = Integer.toBinaryString(key.charAt(i));
			int n1 = temp1.length();
			int n2 = temp2.length();

			if (temp1.length() < 8) {
				for (int j = 0; j < 8 - n1; j++) {
					temp1 = "0" + temp1;
				}
			}

			if (temp2.length() < 8) {
				for (int j = 0; j < 8 - n2; j++) {
					temp2 = "0" + temp2;
				}
			}

			s = "";

			for (int k = 0; k < 8; k++) {
				s += temp1.charAt(k) ^ temp2.charAt(k);
			}

			finalmessage += (char) Integer.parseInt(s, 2);
		}

		return finalmessage;
	}

	public void cribDrag(String c1, String c2, String keyword, String arq) throws IOException {

		
		String c3 = xor(c1, c2);
		String temp;
		String result;
		

		for (int i = 0; i < c3.length() - keyword.length() + 1; i++) {

			br = new BufferedReader(new FileReader(arq));
			
			
			temp = c3.substring(i, i + keyword.length());
			result = xor(temp, keyword);
			//System.out.println(result);

			while (br.ready()) {

				String linha = br.readLine();
			//	System.out.println(linha);

//				for (int x = 0; x < result.length(); x++) {
//
//					for (int j = x; j < result.length()+1; j++) {
//
//						//System.out.println(result.substring(x, j));
//						
//						if (linha.equals(result.substring(x, j)) && linha.length() > 2) {
//					
//							
//							System.out.println("Testado:"+keyword);
//							System.out.println("Encontrado:"+linha);
//							System.out.println("Resultado do XOR :" + result);
//							System.out.println("-------------------------");
//
//						}
//
//					}
//
//				}

				
				
				
			

						//System.out.println(result.substring(x, j));
						
						if (linha.equals(result) && linha.length() > 1) {
					
							
							map.put(keyword,linha);
							
							
//							System.out.println("Testado:"+keyword);
//							System.out.println("Encontrado:"+linha);
//						    System.out.println("Resultado do XOR :" + result);
//						   System.out.println("-------------------------");

						}

					}

			
			
			
			br.close();

		}
		
		
		
	
	}

	public void verMap(){
		
		Set<String> chaves = map.keySet();
		System.out.println("Tabela de relações iguais:");
		
		for (String chave : chaves)
		{
			if(chave != null)
				
				if(!chave.equals(map.get(chave))){
				
				System.out.println("["+chave +" = "+ map.get(chave)+"]");
				
		}
			
		}
	}
	
	
	
	public byte[] getBytes(File file) {
	     int             len     = (int)file.length();  
	      byte[]          sendBuf = new byte[len];
	      FileInputStream inFile  = null;
	      try {
	         inFile = new FileInputStream(file);         
	         inFile.read(sendBuf, 0, len);  
	      } catch (FileNotFoundException fnfex) {
	      } catch (IOException ioex) {
	      }
	 return sendBuf;
	}
	
}
