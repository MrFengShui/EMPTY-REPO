package pers.luan.web.tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileIO {

	private static InputStream is;
	private static InputStreamReader isr;
	private static BufferedReader br;
	
	public static String read(String path) {
		try {
			File file = new File(path);
			
			if (file.exists()) {
				is = new FileInputStream(file);
				isr = new InputStreamReader(is);
				br = new BufferedReader(isr);
				String line = null;
				StringBuilder builder = new StringBuilder();
				
				while ((line = br.readLine()) != null) {
					builder.append(line).append("\n\n");
				}
				
				return builder.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
