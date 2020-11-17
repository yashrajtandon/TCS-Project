package br.com.animais.adocao.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.animais.adocao.model.Ong;
import br.com.animais.adocao.model.Pessoa;

public class EnviarEmail {

	public static void enviarEmailPessoa(Pessoa pessoa) {
		Properties props = new Properties();
		/** Par�metros de conex�o com servidor Hotmail */
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.live.com");
		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("AdoteAquiTcs@hotmail.com", "tcs123456");
			}
		});

		/** Ativa Debug para sess�o */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("AdoteAquiTcs@hotmail.com")); // Remetente

			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(pessoa.getEmail())); // Destinat�rio(s)
			message.setSubject("Recuperando Senha do Usu�rio");// Assunto
			message.setText("Segue abaixo os dados para recupera��o: Login -> " + pessoa.getUsuario().getLogin()
					+ " / Senha -> " + pessoa.getUsuario().getSenha() + " / "
					+ "Obrigado por estar usando nosso sistema e Tenha um �timo dia.");
			/** M�todo para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void enviarEmailPessoa(Ong ong) {
		Properties props = new Properties();
		/** Par�metros de conex�o com servidor Hotmail */
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.live.com");
		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("AdoteAquiTcs@hotmail.com", "tcs123456");
			}
		});

		/** Ativa Debug para sess�o */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("AdoteAquiTcs@hotmail.com")); // Remetente

			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(ong.getEmail())); // Destinat�rio(s)
			message.setSubject("Recuperando Senha do Usu�rio");// Assunto
			message.setText("Segue abaixo os dados para recupera��o: Login -> " + ong.getUsuario().getLogin()
					+ " / Senha -> " + ong.getUsuario().getSenha()
					+ " / Obrigado por estar usando nosso sistema e Tenha um �timo dia.");
			/** M�todo para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
