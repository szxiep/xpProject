package com.cxc.common.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密
 * @author xp
 */
public class MD5Util{
	
	/*** 
     * MD5加码 生成32位md5码 
     */  
	public static String md5(String plainText) {
        String re_md5 = new String();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
 
            re_md5 = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return re_md5;
    }

  
    /** 
     * 加密解密算法 执行一次加密，两次解密 
     */   
    private static String convertMD5(String inStr){  
  
        char[] a = inStr.toCharArray();  
        for (int i = 0; i < a.length; i++){  
            a[i] = (char) (a[i] ^ 't');  
        }  
        String s = new String(a);  
        return s;  
  
    }  
  
    // 测试主函数  
    public static void main(String args[]) {  
        /*String s = new String("123456Q2@#￥%……&**#");  
        System.out.println("原始：" + s);  
        System.out.println("MD5后：" + MD5(s));  
        System.out.println("加密的：" + jiaM(s));  
        System.out.println("解密的：" + jieM(jiaM(s))); */ 
    	System.out.println(md5("123456"));
    }
}