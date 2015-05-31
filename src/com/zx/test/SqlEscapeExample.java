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
		
		String str = "�й�";  
        System.out.println("��escapeJava����ת��֮����ַ���Ϊ:"+StringEscapeUtils.escapeJava(str));  
        System.out.println("��unescapeJava������ת��֮����ַ���Ϊ:"+StringEscapeUtils.unescapeJava(StringEscapeUtils.escapeJava(str)));  
          
        System.out.println("��escapeHtml����ת��֮����ַ���Ϊ:"+StringEscapeUtils.escapeHtml(str));  
        System.out.println("��unescapeHtml������ת��֮����ַ���Ϊ:"+StringEscapeUtils.unescapeHtml(StringEscapeUtils.escapeHtml(str)));  
          
        System.out.println("��escapeXml����ת��֮����ַ���Ϊ:"+StringEscapeUtils.escapeXml(str));  
        System.out.println("��unescapeXml������ת��֮����ַ���Ϊ:"+StringEscapeUtils.unescapeXml(StringEscapeUtils.escapeXml(str)));  
          
        System.out.println("��escapeJavaScript����ת��֮����ַ���Ϊ:"+StringEscapeUtils.escapeJavaScript(str));  
        System.out.println("��unescapeJavaScript������ת��֮����ַ���Ϊ:"+StringEscapeUtils.unescapeJavaScript(StringEscapeUtils.escapeJavaScript(str)));  
        /**���������£� 
         ��escapeJava����ת��֮����ַ���Ϊ:/u4E2D/u56FD/u5171/u4EA7/u515A 
        ��unescapeJava������ת��֮����ַ���Ϊ:�й�
        ��escapeHtml����ת��֮����ַ���Ϊ:�й�
        ��unescapeHtml������ת��֮����ַ���Ϊ:�й�
        ��escapeXml����ת��֮����ַ���Ϊ:�й�
        ��unescapeXml������ת��֮����ַ���Ϊ:�й�
        ��escapeJavaScript����ת��֮����ַ���Ϊ:/u4E2D/u56FD/u5171/u4EA7/u515A 
        ��unescapeJavaScript������ת��֮����ַ���Ϊ:�й�*/  
	}
}
