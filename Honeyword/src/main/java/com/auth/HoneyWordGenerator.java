/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auth;

import java.util.ArrayList;
import java.util.HashMap;
//import sun.org.mozilla.javascript.internal.regexp.SubString;

/**
 *
 * @author user
 */
public class HoneyWordGenerator {

    public static HashMap<String, String> generator(int pos, String pass) throws Exception {
        HashMap<String, String> passResult = new HashMap<String, String>();
        int position = 0;
        String password1 = "";
        String hashedPassword = "";
        String realedPassword = "";
        position = pos;
        System.out.println("position: " + position);
        password1 = (String) reverse(pass);
        System.out.println("password: " + password1);
        String[] realPassword = new String[20];
        String[] hashPassword = new String[20];

        for (int i = 0; i < 20; i++) {
            System.out.println(i + "th password");
            if (i == pos) {
                realPassword[i] = pass;
                System.out.println("realPassword[i]: " + realPassword[i]);
                hashPassword[i] = (String) HashData.generateHash(pass);
                System.out.println("im in if");
                System.out.println("hashPassword[i]: " + hashPassword[i]);
            } else {
                realPassword[i] = (String) replace(password1);
                 System.out.println("im in else");
                System.out.println("realPassword[i]: " + realPassword[i]);
                hashPassword[i] = (String) HashData.generateHash(realPassword[i]);
                System.out.println("hashPassword[i]: " + hashPassword[i]);
            }
            realedPassword += realPassword[i] + ",";
            hashedPassword += hashPassword[i] + ",";
        }
        hashedPassword = hashedPassword.substring(0, hashedPassword.length() - 1);
        realedPassword = realedPassword.substring(0, realedPassword.length() - 1);
        passResult.put("real", realedPassword);
        passResult.put("hash", hashedPassword);
//        System.out.println("hashedPassword: " + hashedPassword);

        return passResult;
    }

    public static String replace(String pass) {
        String password = "";
        password = pass;
        for (int i = 0; i < 3; i++) {
            int random = (int) (Math.random() * (126 - 33));
            random = random + 33;
            
            char c = (char) random;
            
            System.out.println("Reverse String: " + pass);
            
            password = password.replace(password.charAt(i), c);
            System.out.println("random: " + random + " character is :" + (char) random);
        }
        System.out.println("Reverse String: " + password);
        return reverse(password);
    }

    public static String reverse(String pass) 
    {
        String password = "";
        for (int i = pass.length() - 1; i >= 0; i--) {
            password += pass.charAt(i);
        }
        return password;
    }

    public static void main(String[] args) throws Exception {
        generator(10, "anurath123");
    }
}
