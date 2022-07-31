package com.alert;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {

    public static ArrayList<String> eid = new ArrayList<String>();

    public static void sendMail(String address, String name) {
        try {

            String m_from = "";
            m_from = "bhoirshubham883@gmail.com";
           

            String m_body = "", m_subject = "";
            m_subject = "Someone is trying to get enter in your account";
            m_body = "Dear " + name + ", " + "<br>Either manage your account handelings or take a look on your login details.<br> <br>Thanks and Regards,<br><br>Honeywords Ltd.";

            InternetAddress[] recipientAddress = InternetAddress.parse(address);
            Session m_Session;
            Message m_simpleMessage;
            InternetAddress m_fromAddress;
            Properties properties;

            properties = new Properties();
            
			/*
			 * m_properties.put("mail.smtp.host", "smtp.gmail.com");
			 * m_properties.put("mail.smtp.socketFactory.port", "465");
			 * m_properties.put("mail.smtp.socketFactory.class",
			 * "javax.net.ssl.SSLSocketFactory"); m_properties.put("mail.smtp.auth",
			 * "true"); m_properties.put("mail.smtp.port", "465");
			 */
            
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "465");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
        //    properties.put("mail.smtp.starttls.required", "true");
            properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
            properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            m_Session = Session.getDefaultInstance(properties, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("bhoirshubham883@gmail.com", "9637774663"); // username and the password
                }
            });

            m_simpleMessage = new MimeMessage(m_Session);
            m_fromAddress = new InternetAddress(m_from);
       //     m_toAddress = new InternetAddress(m_to);
            m_simpleMessage.setFrom(m_fromAddress);
//            m_simpleMessage.setRecipient(RecipientType.TO, m_toAddress);
            m_simpleMessage.setRecipients(RecipientType.TO, recipientAddress);
            m_simpleMessage.setSubject(m_subject);
            m_simpleMessage.setContent(m_body, "text/html");
            //m_simpleMessage.setContent(m_body,"text/plain");

            Transport.send(m_simpleMessage);
            System.out.println("mail has been send ...");
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }

    public  void sendAlertMail(String address, String name, String ipAddress) {
        try {

            String m_from = "";
            m_from = "bhoirshubham883@gmail.com";
            String toAddress = "";
            toAddress = address;
            String ip="localhost";
            String m_body = "", m_subject = "";
            m_subject = "ALERT";
            m_body = "Dear " + name + ", " + "<br>Someone is going to try your account Login.<br>He is trying to login into your account.<br>His/Her IP Address is " + ip + ".<br><br>Thanks and Regards,<br><br>Honeywords Ltd.";

            InternetAddress[] recipientAddress = InternetAddress.parse(toAddress);
            Session m_Session;
            Message m_simpleMessage;
            InternetAddress m_fromAddress;
            Properties properties;

            properties = new Properties();
            
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "465");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
        //    properties.put("mail.smtp.starttls.required", "true");
            properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
            properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");


            m_Session = Session.getDefaultInstance(properties, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("bhoirshubham883@gmail.com", "9637774663"); // username and the password
                }
            });
            m_simpleMessage = new MimeMessage(m_Session);
            m_fromAddress = new InternetAddress(m_from);
//            m_toAddress = new InternetAddress(m_to);
            m_simpleMessage.setFrom(m_fromAddress);
//            m_simpleMessage.setRecipient(RecipientType.TO, m_toAddress);
            m_simpleMessage.setRecipients(RecipientType.TO, recipientAddress);
            m_simpleMessage.setSubject(m_subject);
            m_simpleMessage.setContent(m_body, "text/html");
            //m_simpleMessage.setContent(m_body,"text/plain");

            Transport.send(m_simpleMessage);
            System.out.println("mail has been send ...");
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }

	/*
	 * public static void main(String[] args) throws SQLException, Exception {
	 * 
	 * Mail send_mail = new Mail(); String empName = "Prashant N"; String title =
	 * "<b>Hi !" + empName + " Welcome to DeDuplication</b>"; //
	 * send_mail.sendMail("testproject201@gmail.com", "pranaya.jadhav@eiosys.com",
	 * "Please apply for leave for the following dates",
	 * title+"<br>by<br><b>HR<b>"); send_mail.sendMail("pniladhe431@gmail.com",
	 * "Prashant"); System.out.println("mail has been send ..."); }
	 */
}
