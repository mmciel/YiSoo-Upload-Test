package com.mmciel.Tools;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import org.apache.commons.fileupload.FileItem;

import com.mmciel.Bean.UserDataList;
/**
 * 关于json配置文件的操作
 * @author mmciel
 *
 */
public class FileSolve {
	/**
	 * 更改文件名，保存文件
	 * @param project 项目名称
	 * @param name 文件名
	 * @param webpath web文件地址
	 * @param oldFileName 原来的文件名称，用于获取后缀名
	 * @return 成功保存的地址
	 */
	public static String saveFile(String project,String name,String webpath,String oldFileName) {
		
		String FilePath = webpath+project;
		File fileParent = new File(FilePath);
		if (!fileParent.exists()) {
			fileParent.mkdirs();
		}
		
		UserDataList datalist = new UserDataList();
		String suffix = '.' + oldFileName.substring(oldFileName.lastIndexOf(".") + 1);
		String filename = datalist.getDataMap().get(name)+"-"+name+suffix;
		try {
			//System.out.println("保存地址"+FilePath);
			return FilePath+'/'+filename;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 获取文件名称的列表
	 * @param file 项目目录
	 * @param map 文件名的map
	 */
	public static void getListFile(File file,Map<String,String> map){
		String[] filelist = file.list();
		for(String name:filelist) {
            String number;
            if(name.indexOf('-')>1) {
            	number = name.substring(0,name.indexOf('-'));
            }else {
            	number = name;
            }
            //System.out.println(name);
            map.put(number, name);
		}
    }
//	public static void main(String[] args) {
//		FileSolve.ZipProject("C:\\Users\\mmciel\\Desktop\\", "新建文件夹");
//	}
	/**
	 * 项目文件夹打包
	 * @param path web项目路径
	 * @param projectname 项目名
	 * @return 最终文件名
	 */
	
	public static String ZipProject(String path, String projectname) {
		//System.out.println(new Date().getTime());
		String ZipName = "YiSoo-"+projectname+"-"+new Date().getTime();
//		System.out.println(projectname);
		//文件对象
		//File file = new File();//也可以是文件夹路径
		String FilePath = path+projectname+"\\";
		//待生成的zip保存路径
		String zipFilePath = path;
		//压缩
		String finalName = FileSolve.fileToZip(FilePath , zipFilePath , ZipName);
		//System.out.println(finalName);
		return finalName;
	}
	/**
	 * 文件压缩操作
	 * @param sourceFilePath 源文件路径
	 * @param zipFilePath zip文件路径
	 * @param fileName 文件名称
	 * @return 文件名
	 */
	public static String fileToZip(String sourceFilePath,String zipFilePath,String fileName){  
        String flag = null;  
        File sourceFile = new File(sourceFilePath);  
        FileInputStream fis = null;  
        BufferedInputStream bis = null;  
        FileOutputStream fos = null;  
        ZipOutputStream zos = null;  
//System.out.println("函数内：" +fileName);
        if(sourceFile.exists() == false){  
            System.out.println("待压缩的文件目录："+sourceFilePath+"不存在.");  
            sourceFile.mkdir(); // 新建目录
        }  
        try {  
            File zipFile = new File(zipFilePath + fileName +".zip");  
            if(zipFile.exists()){  
                System.out.println(zipFilePath + "目录下存在名字为:" + fileName +".zip" +"打包文件.");  
            }else{  
                File[] sourceFiles = sourceFile.listFiles();  
                if(null == sourceFiles || sourceFiles.length<1){  
                    System.out.println("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩.");  
                }else{  
                    fos = new FileOutputStream(zipFile);  
                    zos = new ZipOutputStream(new BufferedOutputStream(fos));  
                    byte[] bufs = new byte[1024*10];  
                    for(int i=0;i<sourceFiles.length;i++){  
                        //创建ZIP实体，并添加进压缩包  
                        ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());  
                        zos.putNextEntry(zipEntry);  
                        //读取待压缩的文件并写进压缩包里  
                        fis = new FileInputStream(sourceFiles[i]);  
                        bis = new BufferedInputStream(fis, 1024*10);  
                        int read = 0;  
                        while((read=bis.read(bufs, 0, 1024*10)) != -1){  
                            zos.write(bufs,0,read);  
                        }  
                    }  
                    
                    flag = fileName +".zip";  
//                    System.out.println(flag);
                }  
            }  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
            throw new RuntimeException(e);  
        } catch (IOException e) {  
            e.printStackTrace();  
            throw new RuntimeException(e);  
        } finally{  
            //关闭流  
            try {  
                if(null != bis) bis.close();  
                if(null != zos) zos.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
                throw new RuntimeException(e);  
            }  
        }  
        return flag;  
    } 

}
