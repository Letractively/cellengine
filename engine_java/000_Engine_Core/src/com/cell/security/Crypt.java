package com.cell.security;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.cell.CIO;
import com.cell.CObject;
import com.cell.CUtil;
import com.cell.security.MD5;
import com.cell.util.StringUtil;
import com.sun.corba.se.impl.ior.ByteBuffer;

public class Crypt
{
	static String keyED(String txt, String encrypt_key) 
	{
		encrypt_key	= MD5.getMD5(encrypt_key);
		int 	ctr	= 0;
		String	tmp	= "";
		for (int i = 0; i < txt.length(); i++) {
			if (ctr == encrypt_key.length())
				ctr = 0;
			tmp += (char)(txt.charAt(i) ^ encrypt_key.charAt(ctr));
			ctr++;
		}
		return tmp;
	}

	static public String encrypt(String txt, String crykey)
	{
		try {
			txt = new BASE64Encoder().encode(txt.getBytes(CObject.getEncoding()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//String	encrypt_key = "a500d08a7f6f5a26e0b9db61c70a83b9"; 
		String	encrypt_key = MD5.getMD5((Math.abs(CObject.getRandom().nextInt() % 32000)) + "");
		int 	ctr 		= 0;
		String	tmp			= "";
		for (int i = 0; i < txt.length(); i++){
			if (ctr == encrypt_key.length())
				ctr = 0;
			tmp += (char)(encrypt_key.charAt(ctr)) + "" + (char)(txt.charAt(i) ^ encrypt_key.charAt(ctr));
			ctr++;
		}
		return keyED(tmp, crykey);
	}
	

	static public String decrypt(String txt, String crykey) 
	{
		txt 		= keyED(txt, crykey);
		String tmp	= "";
		for (int i = 0; i < txt.length(); i++) {
			char md5 = txt.charAt(i);
			i++;
			if (i<txt.length()) {
				tmp += (char)(txt.charAt(i) ^ md5);
			}
		}
		try {
			tmp = new String(new BASE64Decoder().decodeBuffer(tmp), CObject.getEncoding());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tmp;
	}
	
	
	static public String encryptHex(String txt, String crykey) {
		return CUtil.str2hex(encrypt(txt, crykey));
	}
	
	static public String decryptHex(String txt, String crykey) {
		return decrypt(CUtil.hex2str(txt), crykey);
	}
	
	
	
//	---------------------------------------------------------------------------------------------------------------------------------------
	
	
	public static void main(String[] args) throws UnsupportedEncodingException
	{
		System.out.println("input :");
		
		System.out.println(CUtil.str2hex("中文"));
		System.out.println("e4b8ade69687");
		System.out.println(new BASE64Encoder().encode("中文".getBytes("UTF-8")));
		
		while (true)
		{
			try 
			{
				if (System.in.available() > 0) 
				{
					String cmd = new String(CIO.readAvailable(System.in), "UTF-8");
					
					String[] kv = cmd.split("\\s");
					String src = kv[0].trim();
					String key = kv[1].trim();
					
//					String hex = str2hex(src) ;
//					System.out.println("str2hex " + src + " -> " + hex);
//					String str = hex2str(hex);
//					System.out.println("hex2str " + hex + " -> " + str);
					{
						String enc = encrypt(src, key);
						String dec = decrypt(enc, key);
						System.out.println("encrypt: " + src + " -> " + enc);
						System.out.println("decrypt: " + enc + " -> " + dec);
					}{
						String enc = encryptHex(src, key);
						String dec = decryptHex(enc, key);
						System.out.println("encryptHex: " + src + " -> " + enc);
						System.out.println("decryptHex: " + enc + " -> " + dec);
					}
					break;
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				break;
			}
			Thread.yield();
		}
		
		
		
//		System.out.println((char)('a' ^ 'e'));
//		System.out.println((char)('a' ^ 'b'));
	}
}
