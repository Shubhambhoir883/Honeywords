/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auth;

import java.security.MessageDigest;

/**
 *
 * @author user
 */
public class HashData {

    public static String generateHash(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        System.out.println("data"+data);
        byte[] dataBytes = data.getBytes();
//        System.out.println("databytes "+dataBytes);
        md.update(dataBytes, 0, dataBytes.length);
        byte[] mdbytes = md.digest();
//        System.out.println("mdbytes "+mdbytes);

        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < mdbytes.length; i++) {
            hexString.append(Integer.toHexString(0xFF & mdbytes[i]));
//            System.out.println(i+" -> "+Integer.toHexString(0xFF & mdbytes[i]));
        }

        return hexString.toString();

    }

    public static void main(String[] args) {
        HashData hs = new HashData();
        try {
            String re = hs.generateHash("anurath@hjjgf");
//            System.out.println("Re->: "+re);
        } catch (Exception e) {
        }
    }
}
