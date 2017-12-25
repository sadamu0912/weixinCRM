package com.xjxspace.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONArray;
public class Common {
	
	public static Map<String,Object> getReqParamMap(HttpServletRequest req){
		Map<String,Object> param = new HashMap<String,Object>();	
		Enumeration enumeration = req.getParameterNames();
		while(enumeration.hasMoreElements()){
			String name = (String)enumeration.nextElement();
			String value = req.getParameter(name);
			param.put(name, value);
		}
		return param;
	}
	public static String  getLoginFlagFromSession(HttpServletRequest req){
		HttpSession session = req.getSession();
		String loginFlag =(String) session.getAttribute("loginFlag");
		return loginFlag;
	}
	public static boolean isLogin(HttpServletRequest req){
		HttpSession session = req.getSession();
		String loginFlag =(String) session.getAttribute("loginFlag");
		if(loginFlag!=null&&!"".equals(loginFlag)){
		return true;	
		}
		return false;
	}
	
	public static void putLoginFlagIntoSession(HttpServletRequest req){
		HttpSession session = req.getSession();
		session.setAttribute("loginFlag", "true");
	}
	
	public static <T> String listToJsonStning (List<T> list,Class clazz){
		if(list==null||list.size()== 0 ){
			return "";
		}
		JSONArray array = new JSONArray();
		for(int i= 0 ;i<list.size();i++){
		array.add(list.get(i));
		}
		if(array.size()!= 0 ){
		return array.toJSONString();
		}else{
			return "";
		}
	}
}
