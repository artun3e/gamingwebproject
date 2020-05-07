
package cs308.sabanciuniv.edu;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

// added theeese for mail with image
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;


public class JavaMailUtil {
	public static void sendMail(String name, String recipient, String verificationCode)
	{
		try {
			System.out.println("Preparing to send the verification e-mail...");
			Properties properties = new Properties();
			
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "587");
			
			String emailAddress = "cs308group14@gmail.com";
			String password = "kodumla100les";
			
			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(emailAddress, password);
				}
			});
			String textMessage = "Hello, " + name + "\nYour verification code is as follows: " + verificationCode;
			Message message = prepareMessage(session, emailAddress, recipient, textMessage);
			Transport.send(message);
			System.out.println("Message sent successfully!!!");
		} 
		catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void sendMailwithMessage(String messageInput, String recipient)
	{
		try {
			System.out.println("Preparing to send the verification e-mail...");
			Properties properties = new Properties();
			
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "587");
			
			String emailAddress = "cs308group14@gmail.com";
			String password = "kodumla100les";
			
			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(emailAddress, password);
				}
			});
			String textMessage = messageInput;
			Message message = prepareMessage(session, emailAddress, recipient, textMessage);
			Transport.send(message);
			System.out.println("Message sent successfully!!!");
		} 
		catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}		
	private static Message prepareMessage(Session session, String emailAddress, String recipient, String textMessage)
	{
		Message message = new MimeMessage(session);
		try{
			message.setFrom(new InternetAddress(emailAddress));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			message.setSubject("Verification e-mail!");
			message.setText(textMessage);
			return message;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static Message prepareMessageWithTopic(Session session, String emailAddress, String recipient, String textMessage,String topic)
	{
		Message message = new MimeMessage(session);
		try{
			message.setFrom(new InternetAddress(emailAddress));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			message.setSubject(topic);
			message.setText(textMessage);
			return message;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void sendMailwithMessageAndTopic(String messageInput, String recipient,String topic)
	{
		try {
			System.out.println("Preparing to send the verification e-mail...");
			Properties properties = new Properties();
			
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "587");
			
			String emailAddress = "cs308group14@gmail.com";
			String password = "kodumla100les";
			
			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(emailAddress, password);
				}
			});
			String textMessage = messageInput;
			Message message = prepareMessageWithTopic(session, emailAddress, recipient, textMessage,topic);
			Transport.send(message);
			System.out.println("Message sent successfully!!!");
		} 
		catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}		
	public static void  SendInlineImagesInEmail(String content, String recipient, String topic, int count ) {
		  
		      // Recipient's email ID needs to be mentioned.
		      String to = recipient;

		      
		
		      // Sender's email ID needs to be mentioned
		      String from = "cs308group14@gmail.com";
		      final String username = "manishaspatil";//change accordingly
		      final String password = "kodumla100les";//change accordingly

		      // Assuming you are sending email through relay.jangosmtp.net
		      String host = "relay.jangosmtp.net";

		      Properties props = new Properties();
		      props.put("mail.smtp.auth", "true");
		      props.put("mail.smtp.starttls.enable", "true");
		      props.put("mail.smtp.host", host);
		      props.put("mail.smtp.port", "25");

		      Session session = Session.getInstance(props,
		         new javax.mail.Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		               return new PasswordAuthentication(username, password);
		            }
		         });

		      try {

		         // Create a default MimeMessage object.
		         Message message = new MimeMessage(session);

		         // Set From: header field of the header.
		         message.setFrom(new InternetAddress(from));

		         // Set To: header field of the header.
		         message.setRecipients(Message.RecipientType.TO,
		            InternetAddress.parse(to));

		         // Set Subject: header field
		         message.setSubject(topic);

		         // This mail has 2 part, the BODY and the embedded image
		         MimeMultipart multipart = new MimeMultipart("related");

		         // first part (the html)
		         BodyPart messageBodyPart = new MimeBodyPart();
		         String htmlText = "<H1>Hello</H1><img src=\"cid:image\">";
		         messageBodyPart.setContent(htmlText, "text/html");
		         // add it
		         multipart.addBodyPart(messageBodyPart);

		         // second part (the image)
		         messageBodyPart = new MimeBodyPart();
		         DataSource fds = new FileDataSource(
		            "/home/manisha/javamail-mini-logo.png");

		         messageBodyPart.setDataHandler(new DataHandler(fds));
		         messageBodyPart.setHeader("Content-ID", "<image>");

		         // add image to the multipart
		         multipart.addBodyPart(messageBodyPart);

		         // put everything together
		         message.setContent(multipart);
		         // Send message
		         Transport.send(message);

		         System.out.println("Sent message successfully....");

		      } catch (MessagingException e) {
		         throw new RuntimeException(e);
		      }
		   }
		}