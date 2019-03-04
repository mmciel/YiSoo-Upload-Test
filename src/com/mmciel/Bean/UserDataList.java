package com.mmciel.Bean;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * - 根据wg.json中的数据构造一个map和list
 * - 用于前端下拉框的填充
 * - 用于后端文件的重命名
 * @author mmciel
 * 
 */
public class UserDataList {
	private final String FILEPATH =this.getClass().getClassLoader().getResource("").getPath().replace("/build/classes/", "").replace("%20", " ")
			+ "/WebContent/WEB-INF/userdata/wg.json";
	private final String WEBFILEPATH = this.getClass().getClassLoader().getResource("").getPath().replace("/classes/", "").replace("%20", " ")
			+ "/userdata/wg.json";
	private Map<String, String> dataMap = null;
	private List<String> dataList = new ArrayList<String>();
	public UserDataList() {
		dataMap = new TreeMap<String, String>();
		File file=new File(WEBFILEPATH);
		if(!file.exists()) {
			file = new File(FILEPATH);
		}
        String input;
        JSONArray maindata;
		try {
			input = FileUtils.readFileToString(file, "UTF-8");
			JSONObject jsonObject = JSONObject.fromObject(input);
			if (jsonObject!=null) {
				maindata = jsonObject.getJSONArray("maindata");
				@SuppressWarnings("unchecked")
				Iterator<Object> iter = maindata.iterator();
				while(iter.hasNext()) {
					JSONObject temp = (JSONObject) iter.next();
					dataMap.put((String) temp.get("data"), (String) temp.get("id"));
					dataList.add((String) temp.get("data"));
				}
				//dataList = new ArrayList<>(dataMap.values());
				//dataList = new ArrayList<>(dataMap.keySet());
//			    for (String key : dataList) {
//			        System.out.println(key);
//			    }
			} else {

			}
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("user.json文件读取异常");
		}

	}

	public Map<String, String> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, String> dataMap) {
		this.dataMap = dataMap;
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

//	public static void main(String[] args) {
//		new UserDataList();
//	}
}
