package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public RedesController(){
		
		super();
	}
	
	private String os() {
		String osName = System.getProperty("os.name");
		return osName;
	}
	
	
	@SuppressWarnings("deprecation")
	public void ip(){
		
		String proc = "";
		
		if(os().contains("Windows")) {
			proc = "ipconfig";
		}else if(os().contains("Linux")){
			proc = "ifconfig";
		}
		
		try {
			Process p = Runtime.getRuntime().exec(proc);
			InputStream fluxo = p.getInputStream();
			InputStreamReader reader = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(reader);
			String linha = buffer.readLine();
			while(linha != null) {
				if(linha.contains("IPv4")) {
					System.out.println(linha);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			reader.close();
			fluxo.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	@SuppressWarnings("deprecation")
	public void ping(String proc) {
		String[] arrProc = proc.split(" ");
		try {
			Process p = Runtime.getRuntime().exec(arrProc);
			InputStream fluxo = p.getInputStream();
			InputStreamReader reader = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(reader);
			String linha = buffer.readLine();
			while(linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			fluxo.close();
			reader.close();
			buffer.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
