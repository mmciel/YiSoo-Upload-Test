package com.mmciel.Tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
/**
 * YiSooLog项目上传后记录到log.txt并打印到控制台
 * @author mmciel
 *
 */
public class YiSooLog {
	/**
	 * 
	 * @param path 日志文件路径
	 * @param name 日志文件名
	 * @param value 需要记录的字符串
	 */
	public static void setLog(String path,String name,String value) {
		File file = new File(path+"\\"+name);
		File filePath = new File(path);
		if(!filePath.exists()) {
			filePath.mkdir();
		}
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String TimeString = time.format(new java.util.Date());
		value = TimeString+ "	" + value+"\n";
		System.out.println(value);
		addFile(path+"\\"+name,value);
	}
	/**
	 * 把内容添加到文件并保存
	 * @param file 文件名
	 * @param conent 内容
	 */
	public static void addFile(String file, String conent) {
		 BufferedWriter out = null;     
	        try {     
	            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));     
	            out.write(conent);     
	        } catch (Exception e) {     
	            e.printStackTrace();     
	        } finally {     
	            try {     
	                if(out != null){  
	                    out.close();     
	                }  
	            } catch (IOException e) {     
	                e.printStackTrace();     
	            }     
	        }  
	}
	
}
