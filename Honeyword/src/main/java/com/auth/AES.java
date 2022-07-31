//package com.auth;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//import javax.crypto.KeyGenerator;
//import javax.crypto.SecretKey;
//import javax.crypto.Cipher;
//import javax.crypto.spec.SecretKeySpec;
//import java.util.Random;
//import javax.crypto.BadPaddingException;
//import javax.crypto.IllegalBlockSizeException;
//import javax.crypto.NoSuchPaddingException;
//import javax.xml.bind.DatatypeConverter;
//import org.apache.commons.codec.binary.Base64;
//
//public class AES {
//    private static final String ALGORITMO = "AES/CBC/PKCS5Padding";
//private static final String CODIFICACION = "UTF-8";
// String key = "E1BB465D57CAE7ACDBBE8091F9CE83DF";
//    static String plaintext = "test  123";
//    public static Random r = null;
//    public static String encodedKey = null;
//    public static SecretKey SecKey = null;
//    public static SecretKey originalKey = null;
//
//    public static void test() {
//        try {
//
//            KeyGenerator KeyGen = KeyGenerator.getInstance("AES");
//            KeyGen.init(128);
//            SecKey = KeyGen.generateKey();
//
//
//            System.out.println(" key: " + SecKey);
//            System.out.println(" encodedKey: " + encodedKey);
////            byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
////            SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
//            System.out.println("originalKey: " + originalKey);
//            System.out.println("==Java==");
//            System.out.println("plain:   " + plaintext);
//            byte[] byteCipherText = encrypt(plaintext, SecKey);
//            System.out.println(" byteCipherText : " + byteCipherText);
//
//            String decryptedText = decrypt(byteCipherText, SecKey);
//            System.out.println("decrypted:" + decryptedText);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static String encrypt(String plainText, SecretKey SecKey) throws NoSuchAlgorithmException, NoSuchPaddingException,InvalidKeyException, IllegalBlockSizeException,BadPaddingException, IOException{
////        Cipher AesCipher = Cipher.getInstance("AES");
////        byte[] byteText = plaintext.getBytes();
////        AesCipher.init(Cipher.ENCRYPT_MODE, SecKey);
////        byte[] byteCipherText = AesCipher.doFinal(byteText);
////        return byteCipherText;
//        
//        byte[] raw = DatatypeConverter.parseHexBinary(SecKey);
//	SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
//	Cipher cipher = Cipher.getInstance(ALGORITMO);
//	cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
//	byte[] cipherText = cipher.doFinal(plaintext.getBytes(CODIFICACION));
//	byte[] iv = cipher.getIV();
//	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//	outputStream.write(iv);
//	outputStream.write(cipherText);
//	byte[] finalData = outputStream.toByteArray();
//	String encodedFinalData = DatatypeConverter.printBase64Binary(finalData);
//	return encodedFinalData;
//    }
//
//    public static String decrypt(byte[] byteCipherText, SecretKey SecKey) throws Exception {
//        Cipher cipher = Cipher.getInstance("AES");
//
//        cipher.init(Cipher.DECRYPT_MODE, SecKey);
//        byte[] decryptedByte = cipher.doFinal(byteCipherText);
//        String decryptedText = new String(decryptedByte);
//        return decryptedText;
//    }
//
//    public static String getSecretKeys() {
//        byte[] encodedBytes = null;
//        try {
//
//            KeyGenerator KeyGen = KeyGenerator.getInstance("AES");
//            KeyGen.init(128);
//            SecretKey SecKey = KeyGen.generateKey();
////            byte[] encodedBytes = Base64.encodeBase64("Test".getBytes());
////            System.out.println("encodedBytes " + new String(encodedBytes));
////            byte[] decodedBytes = Base64.decodeBase64(encodedBytes);
////            System.out.println("decodedBytes " + new String(decodedBytes));
//
//            encodedBytes = Base64.encodeBase64(SecKey.toString().getBytes());
//            return new String(encodedBytes);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new String(encodedBytes);
//    }
//
//    public static SecretKey getSecretKey(String key) {
//        try {
//            byte[] decodedBytes = Base64.decodeBase64(key.getBytes());
//            originalKey = new SecretKeySpec(decodedBytes, 0, decodedBytes.length, "AES");
//            System.out.println("originalKey: " + originalKey);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return originalKey;
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Secret Key: " + getSecretKey("amF2YXguY3J5cHRvLnNwZWMuU2VjcmV0S2V5U3BlY0AxN2EzMA=="));
//    }
//}
