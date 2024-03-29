package co.jiwon.prj.common;


import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.engines.SEEDEngine;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;

public class BuncyEncryption {
	
	private final String key = "!#121351227989^541";
	
	  public byte[] encrypt(String plainText) {	//암호화
	        byte[] keyBytes = key.getBytes(); 	//String을 byte로 변환
	        byte[] textBytes = plainText.getBytes();

	        // 블록 암호 운용
	        // 블록보다 데이터가 짧을 경우 패딩을 사용함
	        // 블록 암호 알고리즘으로는 SEED 알고리즘을 사용함
	        BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new SEEDEngine());
	        // 초기화 및 키 파라미터 생성 첫 번째 매개변수가 true 라면 암호화 모드
	        cipher.init(true, new KeyParameter(keyBytes));

	        return getBytes(textBytes, cipher);
	    }

	    public byte[] decrypt(String cipherText) {	// 복호화
	        byte[] keyBytes = key.getBytes();
	        byte[] textBytes = cipherText.getBytes();

	        BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new SEEDEngine());
	        cipher.init(false, new KeyParameter(keyBytes));

	        return getBytes(textBytes, cipher);
	    }

	    private byte[] getBytes(byte[] targetData, BufferedBlockCipher cipher) {
	        byte[] outputData = new byte[cipher.getOutputSize(targetData.length)];

	        int tam = cipher.processBytes(targetData, 0, targetData.length, outputData, 0);

	        try {
	            cipher.doFinal(outputData, tam);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return outputData;
	    }

}
