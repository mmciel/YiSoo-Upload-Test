package com.mmciel.Bean;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import java.util.List;


import org.apache.commons.io.FileUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 获取json配置文件 关于项目名称的数据
 * @author mmciel
 *
 */
public class ProjectDataList {
	private final String FILEPATH =this.getClass().getClassLoader().getResource("").getPath().replace("/build/classes/", "").replace("%20", " ")
			+ "/WebContent/WEB-INF/userdata/projectdata.json";
	private final String WEBFILEPATH = this.getClass().getClassLoader().getResource("").getPath().replace("/classes/", "").replace("%20", " ")
			+ "/userdata/projectdata.json";
	private List<String> dataList = new ArrayList<String>();
	public ProjectDataList() {
		File file=new File(WEBFILEPATH);
		if(!file.exists()) {
			file = new File(WEBFILEPATH);
		}
        String input;
        JSONArray projectdata;
		try {
			input = FileUtils.readFileToString(file, "UTF-8");
			JSONObject jsonObject = JSONObject.fromObject(input);
			if (jsonObject!=null) {
				projectdata = jsonObject.getJSONArray("name");
		        for (int i = 0; i < projectdata.size(); i++) {
		            dataList.add((String) projectdata.get(i));
		        }
			}	
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("project.json文件读取异常");
		}

	}

	public List<String> getDataList() {
		return dataList;
	}

	public void setDataList(List<String> dataList) {
		this.dataList = dataList;
	}

	public String getFILEPATH() {
		return FILEPATH;
	}
	/**
	 * 保存json
	 * @param list 项目名列表
	 */
	public void addJsonFile(List<String> list) {
		JSONArray jsonArray = new JSONArray();  
		for(int i=0;i<list.size();i++) {
			jsonArray.add(i,list.get(i));
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name",jsonArray);
		System.out.println(jsonObject);
	    File file = new File(WEBFILEPATH);

		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	    String s = jsonObject.toString();
	    FileOutputStream writerStream;
		try {
			writerStream = new FileOutputStream(file);
		    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(writerStream, "UTF-8"));
		    writer.write(s);
		    writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
//	public static void main(String[] args) {
//		ProjectDataList temp = new ProjectDataList();
//		List<String> datalist = new ArrayList<String>();
//		datalist.add("123");
//		datalist.add("567");
//		datalist.add("567");
//		temp.addJsonFile(datalist);
//	}


}
