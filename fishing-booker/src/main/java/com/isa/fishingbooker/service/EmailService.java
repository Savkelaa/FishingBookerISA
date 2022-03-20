package com.isa.fishingbooker.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.isa.fishingbooker.model.Instructor;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.isa.fishingbooker.model.Client;
import com.isa.fishingbooker.model.BoatOwner;
import com.isa.fishingbooker.model.CottageOwner;
@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	/*
	 * Koriscenje klase za ocitavanje vrednosti iz application.properties fajla
	 */
	@Autowired
	private Environment env;

	/*
	 * Anotacija za oznacavanje asinhronog zadatka
	 * Vise informacija na: https://docs.spring.io/spring/docs/current/spring-framework-reference/integration.html#scheduling
	 */
	@Async
	public void sendNotificaitionAsync(Client user) throws MailException, InterruptedException {
		System.out.println("Async metoda se izvrsava u drugom Threadu u odnosu na prihvaceni zahtev. Thread id: " + Thread.currentThread().getId());
		//Simulacija duze aktivnosti da bi se uocila razlika
		Thread.sleep(1000);
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Primer slanja emaila pomoću asinhronog Spring taska");
		mail.setText("Pozdrav " + user.getName() + ",\n\nhvala što pratiš ISA.");
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	
	@Async
	public void sendNotificaitionAsync(BoatOwner user) throws MailException, InterruptedException {
		System.out.println("Async metoda se izvrsava u drugom Threadu u odnosu na prihvaceni zahtev. Thread id: " + Thread.currentThread().getId());
		//Simulacija duze aktivnosti da bi se uocila razlika
		Thread.sleep(1000);
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Primer slanja emaila pomoću asinhronog Spring taska");
		mail.setText("Pozdrav " + user.getName() + ",\n\nhvala što pratiš ISA.");
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	
	@Async
	public void sendNotificaitionAsync(Instructor user) throws MailException, InterruptedException {
		System.out.println("Async metoda se izvrsava u drugom Threadu u odnosu na prihvaceni zahtev. Thread id: " + Thread.currentThread().getId());
		//Simulacija duze aktivnosti da bi se uocila razlika
		Thread.sleep(1000);
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Primer slanja emaila pomoću asinhronog Spring taska");
		mail.setText("Pozdrav " + user.getName() + ",\n\nhvala što pratiš ISA.");
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	
	
	@Async
	public void sendNotificaitionAsync(CottageOwner user) throws MailException, InterruptedException {
		System.out.println("Async metoda se izvrsava u drugom Threadu u odnosu na prihvaceni zahtev. Thread id: " + Thread.currentThread().getId());
		//Simulacija duze aktivnosti da bi se uocila razlika
		Thread.sleep(1000);
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Primer slanja emaila pomoću asinhronog Spring taska");
		mail.setText("Pozdrav " + user.getName() + ",\n\nhvala što pratiš ISA.");
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	
	



}
