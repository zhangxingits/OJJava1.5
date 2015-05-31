package com.zx.test;

import org.apache.commons.lang.StringEscapeUtils;

public class SqlEscapeExample {
	public static void main(String[] args) {
		String userName = "1' or '1'='1";
		String password = "123456";
		String sql = "SELECT COUNT(userId) FROM t_user WHERE userName='"
				+ userName + "' AND password ='" + password + "'";
		System.out.println(sql);
		userName = StringEscapeUtils.escapeSql(userName);   //  1'' or ''1''=''1
		password = StringEscapeUtils.escapeSql(password);
		sql = "SELECT COUNT(userId) FROM t_user WHERE userName='"
				+ userName + "' AND password ='" + password + "'";
		System.out.println(sql);
		
		String str = "中国";  
        System.out.println("用escapeJava方法转义之后的字符串为:"+StringEscapeUtils.escapeJava(str));  
        System.out.println("用unescapeJava方法反转义之后的字符串为:"+StringEscapeUtils.unescapeJava(StringEscapeUtils.escapeJava(str)));  
          
        System.out.println("用escapeHtml方法转义之后的字符串为:"+StringEscapeUtils.escapeHtml(str));  
        System.out.println("用unescapeHtml方法反转义之后的字符串为:"+StringEscapeUtils.unescapeHtml(StringEscapeUtils.escapeHtml(str)));  
          
        System.out.println("用escapeXml方法转义之后的字符串为:"+StringEscapeUtils.escapeXml(str));  
        System.out.println("用unescapeXml方法反转义之后的字符串为:"+StringEscapeUtils.unescapeXml(StringEscapeUtils.escapeXml(str)));  
          
        System.out.println("用escapeJavaScript方法转义之后的字符串为:"+StringEscapeUtils.escapeJavaScript(str));  
        System.out.println("用unescapeJavaScript方法反转义之后的字符串为:"+StringEscapeUtils.unescapeJavaScript(StringEscapeUtils.escapeJavaScript(str)));  
        /**输出结果如下： 
         用escapeJava方法转义之后的字符串为:/u4E2D/u56FD/u5171/u4EA7/u515A 
        用unescapeJava方法反转义之后的字符串为:中国
        用escapeHtml方法转义之后的字符串为:中国
        用unescapeHtml方法反转义之后的字符串为:中国
        用escapeXml方法转义之后的字符串为:中国
        用unescapeXml方法反转义之后的字符串为:中国
        用escapeJavaScript方法转义之后的字符串为:/u4E2D/u56FD/u5171/u4EA7/u515A 
        用unescapeJavaScript方法反转义之后的字符串为:中国*/  
	}
}
