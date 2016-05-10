/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;



public class Correo {

    public void enviarCorreo(String to, String mensaje,String asunto) {

        Properties propiedades = new Properties();

        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        propiedades.setProperty("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.port", "587");

        Session session = Session.getInstance(propiedades,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(correo, contraseña);
            }
        });

        try {

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress("monitor3bases@gmail.com", "Monitor 3"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(asunto);
            message.setText(mensaje);

            Transport.send(message);
        } catch (Exception e) {
            System.out.println("Error al enviar correo: " + e.getMessage());
        }
    }

    private final String correo = "monitor3bases@gmail.com"; // Correo de la empresa
    private final String contraseña = "bases3211";
}
