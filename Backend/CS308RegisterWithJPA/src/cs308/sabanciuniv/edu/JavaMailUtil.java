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
}
