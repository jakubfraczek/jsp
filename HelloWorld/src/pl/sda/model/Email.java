package pl.sda.model;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	private final String username = "javalodz2@gmail.com";
	private final String password = "javalodz22";
	private Properties props = new Properties();

	private MessageConfirm mc;

	public Email(MessageConfirm mc) {
		this.mc = mc;
	}

	private void setProp() {
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
	}

	public void send(){
		setProp();
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		try {
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(username));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mc.getEmail()));
		msg.setSubject("Powiadomienie");
		msg.setText(mc.getMessage());
		Transport.send(msg);
		} catch (MessagingException e){
			throw new RuntimeException(e);
		}
	}

}
