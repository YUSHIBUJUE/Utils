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
	
		if(isBlank(srcString)){
			if(isBlank(joinString)){
				return null;
			}else{
				return joinString;
			}
		}else{
			if(isBlank(joinString)){
			   return srcString;
			}else{
			   if(isBlank(separator)){
			     return srcString.concat(joinString);
			   }else{
				if(srcString.lastIndexOf(separator) == srcString.length()-separator.length()){
				   	return srcString.concat(joinString);
				}else{
					return srcString.concat(separator).concat(joinString);
				}
			   }
			}
		
		}
	}
  	/**
	 * @Function: parseMap
	 * @Description: 将字符串解析成HashMap对象,其中KEY将统一使用大写
	 *
	 * @param paramString 要解析的字符串。多组键值之间用“|”分隔，键值之间用“^”分隔，如：key1^value1|key2^value2|key3^value3
	 * @return
	 * @throws Exception
	 *
	 * @version: v1.0.0
	 * @author: huangwf
	 *
 	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2017-7-18     huangwf           v1.0.0               修改原因
	 */
	public static HashMap parseMap(String paramString) throws Exception {
		HashMap arrayMap = new HashMap();
		if (isNotBlank(paramString)) {
			String[] conditionArray = paramString.split("\\|");
			for (int i = 0; i < conditionArray.length; i++) {
				int index = conditionArray[i].indexOf('^');
				if (index > 1) {// 有分割符^并且不是在第一字符
					arrayMap.put(conditionArray[i].substring(0, index).toUpperCase(), conditionArray[i].substring(index + 1));
				}
			}
		}
		return arrayMap;
	}
	
	/**
	 * 对字符串进行模糊化处理（第一个字符正常处理保留，后面的以*代替）
	 * @Function: getMaskedStr
	 * @Description: 对字符串进行模糊化处理（第一个字符保留，后面的以*代替）
	 *
	 * @param:	str 待处理的字符串
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: huangwf
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2017-7-18     huangwf           v1.0.0               修改原因
	 */
	public static String getMaskedStr(String str) throws Exception, RemoteException {
		if (isNotBlank(str)) {
			StringBuilder sb = new StringBuilder();
			sb.append(str.charAt(0));
			for (int i = 1; i < str.length(); i++) {
				sb.append("*");
			}
			return sb.toString();
		}
		return str;
	}
	
   	public static boolean isBlank(String str){
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
