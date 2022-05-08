package mailing.utilities;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail1 {
	Session newSession = null;
	MimeMessage mimeMessage = null;
	public Mail1() {}
	public void mailThis(String to, String msg) {
		//String to = "alaaeddinebenzerki@gmail.com"; // to address. It can be any like gmail, hotmail etc.
		  final String from = "immo.tunisie.agence@gmail.com"; // from address. As this is using Gmail SMTP.
		  final String password = "azertyyterza"; // password for from mail address. 
		 
		  Properties prop = new Properties();
		  prop.put("mail.smtp.host", "smtp.gmail.com");
		  prop.put("mail.smtp.port", "465");
		  prop.put("mail.smtp.auth", "true");
		  prop.put("mail.smtp.socketFactory.port", "465");
		  prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		 
		  Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
		   protected PasswordAuthentication getPasswordAuthentication() {
		    return new PasswordAuthentication(from, password);
		   }
		  });
		 
		  try {
		 
		   Message message = new MimeMessage(session);
		   message.setFrom(new InternetAddress(from));
		   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		   message.setSubject("Message from Java Simplifying Tech");
		    
		   //String msg = "This email sent using JavaMailer API from Java Code!!!";
		    
		   MimeBodyPart mimeBodyPart = new MimeBodyPart();
		   mimeBodyPart.setContent(msg, "text/html");
		     
		   Multipart multipart = new MimeMultipart();
		   multipart.addBodyPart(mimeBodyPart);
		    
		   message.setContent(multipart);
		 
		   Transport.send(message);
		 
		   System.out.println("Mail successfully sent..");
		 
		  } catch (MessagingException e) {
		   e.printStackTrace();
		  }
		 }
	/*
	public void mail(String emailRecipient,String subject,String body) {
		this.setupServerProperties();
		try {
			this.draftEmail(emailRecipient,subject,body);
			this.sendEmail();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Email sent successfully.");
	}
	
	private void sendEmail() throws MessagingException {
		String fromUser = "immo.tunisie.agence@gmail.com";
		String fromUserPassword = "azretyytreza";
		String emailHost = "smtp.gmail.com";
		Transport transport = newSession.getTransport("smtp");
		transport.connect(emailHost,fromUser,fromUserPassword);
		transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());
		transport.close();
		
	}
	private MimeMessage draftEmail(String emailRecipient,String subject,String body) throws AddressException, MessagingException {
		mimeMessage = new MimeMessage(newSession); 
		mimeMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(emailRecipient));
		mimeMessage.setSubject(subject);
		MimeMultipart multiPart = new MimeMultipart();
		MimeBodyPart bodyPart = new MimeBodyPart();
		bodyPart.setContent(body,"html/text");
		multiPart.addBodyPart(bodyPart);
		mimeMessage.setContent(multiPart);
		return mimeMessage;
	}
	private void setupServerProperties() {
		Properties properties = System.getProperties();
		properties.put("mail.smtp.port", "547");
		properties.put("mail.smtp.aut","true");
		properties.put("email.smtp.starttls.enable", "true");
		newSession = Session.getDefaultInstance(properties,null);
	}
	*/
}
