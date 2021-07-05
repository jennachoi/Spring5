package co.jiwon.prj.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {
	
	// private로 작성해서 응집도를 높여준다. 
	
	final static char[] hexArray = "!@gfcgrtsx102tyukjopbn$".toCharArray();	// 암호화 키값
	
	private byte[] sha256(String msg) throws NoSuchAlgorithmException {
	    MessageDigest md = MessageDigest.getInstance("SHA-256");
	    md.update(msg.getBytes());
	    return md.digest();
	}

	private String bytesToHex1(byte[] bytes) {
	    StringBuilder builder = new StringBuilder();
	    for (byte b: bytes) {
	      builder.append(String.format("%02x", b));
	    }
	    return builder.toString();
	}
	
	
	private String bytesToHex2(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for ( int j = 0; j < bytes.length; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);
	}

	// 방식1 암호키 없이 암호화
	// 박싱/언박싱으로 정보 보안 강화 
	public String typeOne(String str) throws NoSuchAlgorithmException {
		return bytesToHex1(sha256(str));
	}
	
	

	// 방식2 암호키를 사용하여 암호화
	public String typeTwo(String str) throws NoSuchAlgorithmException {
		return bytesToHex2(sha256(str));
	}
	
}
