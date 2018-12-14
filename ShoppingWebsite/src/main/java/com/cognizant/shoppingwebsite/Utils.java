package com.cognizant.shoppingwebsite;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;


public class Utils {

	public static void copy(String inFile,String outFile) throws IOException {
		byte[] bytes = new byte[128];
		FileInputStream fis = new FileInputStream(inFile);
		FileOutputStream fos = new FileOutputStream(outFile);
		int count = 0, read = 0;
		
		while((read = fis.read(bytes)) !=-1) {
			System.out.println(bytes);
			fos.write(bytes,0, read);// 128 at a time
			count += read;
		}
		fis.close();
		fos.close();
	}
	
	public static void copy2(String inFile,String outFile) {
		FileUtils.copyFile(inFile, outFile);
		
		
	}
}
