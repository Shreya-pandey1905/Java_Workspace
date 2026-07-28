import jakarta.mail.*;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class Operation {
    String to;


    public static void sendMail(String to,String subject,String message) throws MessagingException {
        final String from ="projectemail040@gmail.com";
        final String password="yhmi pfbh mblu njku";

        Properties props = new Properties();

        props.put("mail.smtp.auth","true"); // this means mail require username and password before sending the mail
        props.put("mail.smtp.starttls.enable","true"); // STARTTTLS upgrades the connection from plain text to encryptes text
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port","587");

        Session session= Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from,password);
            }
        });


        // creates a new email msg
        Message msg = new MimeMessage(session); // Multipurpose internet mai sender
        msg.setFrom(new InternetAddress(from));
        msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to)); // convert string to internet address

        msg.setSubject(subject);
        msg.setText(message);
        Transport.send(msg);
        System.out.println("Message sent successfully");

    }
}
