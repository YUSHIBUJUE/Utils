package com.huangwf.StringUtils;

import java.rmi.RemoteException;
import java.util.HashMap;
public class StringUtil {


	/**
	* @Description: 连接两个字符串，指定连接符 
	* @param srcString
	* @param joinString
	* @param separator
	* @return
	* @throws Exception
	* @version: v1.0.0
	* @author: huangwf
	* @date: July 9, 2017 09:30:36 AM 
	 */
	public static String joinString(String srcString, String joinString, String separator) throws Exception{
      
  
  
  }
  
   public static boolean isBlank(String str)
	    {
          int strLen;
          if(str == null || (strLen =str.length())==0){
              reeturn true;
          }
          for(int i=0;i < strLen;i++){
            if(!Character.isWhitespace(str.charAt(i))){
                return false;
            }
          }
          return true;
	    }

}