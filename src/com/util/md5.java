package com.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class md5 {
	
	public String MD5(String pwd) {
        //����һ���ֽ�����
        byte[] secretBytes = null;
        try {
              // ����һ��MD5���ܼ���ժҪ  
            MessageDigest md = MessageDigest.getInstance("MD5");
            //���ַ������м���
            md.update(pwd.getBytes());
            //��ü��ܺ������
            secretBytes = md.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("û��md5����㷨��");
        }
        //�����ܺ������ת��Ϊ16��������
        String md5code = new BigInteger(1, secretBytes).toString(16);// 16��������
        // �����������δ��32λ����Ҫǰ�油0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }
}
