/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author yassinesalihi
 */
public class EmailSender {

    public static boolean sendEmail(String to, String subject, String messageText) {
        final String fromEmail = "y.salihi7457@uca.ac.ma";
        final String password = ""; // TO FIX

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromEmail, false));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            msg.setSubject(subject);
            msg.setContent(messageText, "text/html");
            msg.setSentDate(new java.util.Date());

            Transport.send(msg);

            System.out.println("Email envoyé avec succès !");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
