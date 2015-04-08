package org.istv.indicateurs;

import java.io.*;

public class Files {

	String resourcePath;
	String resourceName;
	String resourceLue="";
	
	public Files()
	{
		
	}
	
	public Files(String resourcePath, String resourceName)
	{
		this.resourcePath = resourcePath;
		this.resourceName = resourceName;
	}
	
	public void read()
	{
		//String fichier = resourcePath + resourceName;
		String fichier = "test.txt";
		
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
		//		System.out.println(ligne);
				resourceLue+=ligne+"\n";
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public String output()
	{
		String fichier = "test.txt";
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				resourceLue+=ligne+"\n";
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		
		return resourceLue;
	}

	public String output(String resourcePath, String resourceName)
	{
		String fichier = resourcePath + resourceName;
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				resourceLue+=ligne+"\n";
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		
		return resourceLue;
	}
	
}