/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;

import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Jithmalsssssss
 */
public class SendEmail {

    public void send2() {

        final String username = "xxxx@gmail.com"; //ur email
        final String password = "xxxx";
        final String DestinationMail = "admin@gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));//ur email
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(DestinationMail));//u will send to
            message.setSubject("This is Your Final Report");
            message.setText("Please Check");

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();

//=========================================================== ( attachment1 ) ==
            String file = ".\\src\\IReport\\report1.pdf";
            String fileName = "FinalReport.pdf";
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);

//==============================================================================  
//=========================================================== ( attachment2 ) ==  
//       String file2="C:\\Users\\Jithmal\\Desktop\\mailtest\\mail2.txt";
//       String fileName2 = "mail2.txt";
//    messageBodyPart = new MimeBodyPart();   
//    DataSource source2 = new FileDataSource(file2);      
//    messageBodyPart.setDataHandler(new DataHandler(source2));
//    messageBodyPart.setFileName(fileName2);
//    multipart.addBodyPart(messageBodyPart);
//==============================================================================  
//=========================================================== ( attachment3 ) ==  
//       String file3="C:\\Users\\Jithmal\\Desktop\\mailtest\\mail3.txt";
//       String fileName3 = "mail3.txt";
//    messageBodyPart = new MimeBodyPart();   
//    DataSource source3 = new FileDataSource(file3);      
//    messageBodyPart.setDataHandler(new DataHandler(source3));
//    messageBodyPart.setFileName(fileName3);
//    multipart.addBodyPart(messageBodyPart);
//==============================================================================  
//=========================================================== ( attachment4 ) ==  
//        String file4="C:\\Users\\Jithmal\\Desktop\\mailtest\\mail4.txt";
//        String fileName4 = "mail4.txt";
//    messageBodyPart = new MimeBodyPart();   
//    DataSource source4 = new FileDataSource(file4);      
//    messageBodyPart.setDataHandler(new DataHandler(source4));
//    messageBodyPart.setFileName(fileName4);
//    multipart.addBodyPart(messageBodyPart);
//==============================================================================  
            message.setContent(multipart);

            //Home hm = new Home();
            //hm.MailStatus.setText("Sending ...");
            System.out.println("sending ...");
            Transport.send(message);
            System.out.println("Mail Sent");
            JOptionPane.showMessageDialog(null, "Mail Sent");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
