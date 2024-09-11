import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LogReader {
	public String search(String file){
		ArrayList<String> path = new ArrayList<String>(); 
		boolean ans = false;
		String file_path ="";
		try{

		FileInputStream fstream = new FileInputStream("search_history.log");

		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		
		String strLine;
		
		/* read log line by line */

		while ((strLine = br.readLine()) != null) {

		    Matcher matcher1 = Pattern.compile("<message>(.+?)</message>").matcher(strLine);
		    while (matcher1.find()) {
		        path.add(matcher1.group(1));
		    }

		   
//		     ans = path.contains(file);
		}
		for(String s:path){
			String sp[] = s.split("/");
			String st[] = file.split("/");
			if(sp[0].contains(st[0]) && sp[sp.length-1].contains(st[st.length-1])){
			   file_path = s;
			   ans = true;
		   }
		}
		fstream.close();

		} catch (Exception e) {

		System.err.println("Error: " + e.getMessage());

		}
		if(ans){
			return file_path;
		}
		else{
			return "File not found";
		}
	
	    
	
	}
	/*
	public static void main(String a[])
	{
		LogReader l = new LogReader();
		String s = l.search("E:/student.java");
		System.out.println(s);
		

	}*/
	}