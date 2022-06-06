package com.isa.fishingbooker.service;

import com.isa.fishingbooker.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

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
		
		Thread.sleep(1000);
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("OOO STO PLAVO OKOPrimer slanja emaila pomoću asinhronog Spring taska");
		mail.setText("Pozdrav " + user.getName() + ",\n\nhvala što pratiš ISA.");
		javaMailSender.send(mail);
		System.out.println("Email poslat!");
	}


	@Async
	public void sendNotificaitionAsync(Admin user) throws MailException, InterruptedException {

		Thread.sleep(1000);
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("OOO STO PLAVO OKOPrimer slanja emaila pomoću asinhronog Spring taska");
		mail.setText("Pozdrav " + user.getName() + ",\n\nhvala što pratiš ISA.");
		javaMailSender.send(mail);
		System.out.println("Email poslat!");
	}


	//prihvatanje zahteva

	@Async
	public void sendNotificaitionAsyncAccept(Client user) throws MailException, InterruptedException {

		Thread.sleep(1000);
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Your account is activated");
		mail.setText("Hi, " + user.getName() + " " +  user.getSurname() +",\n\nyour account is activated, welcome to our site.");
		javaMailSender.send(mail);
		System.out.println("Email poslat!");
	}

	@Async
	public void sendNotificaitionAsyncAccept(CottageOwner user) throws MailException, InterruptedException {
		
		Thread.sleep(1000);
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Your account is activated");
		mail.setText("Hi, " + user.getName() + " " +  user.getSurname() +",\n\nyour account is activated, welcome to our site.");
		javaMailSender.send(mail);
		System.out.println("Email poslat!");
	}
	
	@Async
	public void sendNotificaitionAsyncAccept(BoatOwner user) throws MailException, InterruptedException {
		
		Thread.sleep(1000);
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Your account is activated");
		mail.setText("Hi, " + user.getName() + " " +  user.getSurname() +",\n\nyour account is activated, welcome to our site.");
		javaMailSender.send(mail);
		System.out.println("Email poslat!");
	}
	
	@Async
	public void sendNotificaitionAsyncAccept(Instructor user) throws MailException, InterruptedException {
		
		Thread.sleep(1000);
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Your account is activated");
		mail.setText("Hi, " + user.getName() + " " +  user.getSurname() +",\n\nyour account is activated, welcome to our site.");
		javaMailSender.send(mail);
		System.out.println("Email poslat!");
	}
	
	//odbijanje zahteva
	@Async
	public void sendNotificaitionAsyncRemove(Admin user) throws MailException, InterruptedException {

		Thread.sleep(1000);
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Your account is deleted");
		mail.setText("Hi, " + user.getName() + " " +  user.getSurname() +",\n\n Reason for deduction: " + user.getRefusalReason() + ".");
		javaMailSender.send(mail);
		System.out.println("Email poslat!");
	}

	@Async
	public void sendNotificaitionAsyncRemove(Client user) throws MailException, InterruptedException {

		Thread.sleep(1000);
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Your account is deleted");
		mail.setText("Hi, " + user.getName() + " " +  user.getSurname() +",\n\n Reason for deduction: " + user.getRefusalReason() + ".");
		javaMailSender.send(mail);
		System.out.println("Email poslat!");
	}

	@Async
	public void sendNotificaitionAsyncRemove(Instructor user) throws MailException, InterruptedException {
		
		Thread.sleep(1000);
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Your account is deleted");
		mail.setText("Hi, " + user.getName() + " " +  user.getSurname() +",\n\n Reason for deduction: " + user.getRefusalReason() + ".");
		javaMailSender.send(mail);
		System.out.println("Email poslat!");
	}
	
	@Async
	public void sendNotificaitionAsyncRemove(BoatOwner user) throws MailException, InterruptedException {
		
		Thread.sleep(1000);
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Your account is deleted");
		mail.setText("Hi, " + user.getName() + " " +  user.getSurname() +",\n\nReason for deduction:  " + user.getRefusalReason() + ".");
		javaMailSender.send(mail);
		System.out.println("Email poslat!");
	}
	
	@Async
	public void sendNotificaitionAsyncRemove(CottageOwner user) throws MailException, InterruptedException {
		
		Thread.sleep(1000);
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Your account is deleted");
		mail.setText("Hi, " + user.getName() + " " +  user.getSurname() +",\n\nReason for deduction:  " + user.getRefusalReason() + ".");
		javaMailSender.send(mail);
		System.out.println("Email poslat!");
	}
	
	///////////////////// Slanje maila za uspesnu rezevaciju novog termina za klienta koji su trenutno na rezervacijama

	@Async
	public void sendNotificaitionForReservation(FishingClassReservation fishingClassReservation) throws MailException, InterruptedException {

		Thread.sleep(500);
		System.out.println("Slanje emaila...");


		SimpleMailMessage mail = new SimpleMailMessage();
		///vidi da saljes na klijentov mail
		mail.setTo(env.getProperty("spring.mail.username"));
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Succesfull reservation");
		mail.setText("Hi, "  +"\n\nA new booking date for "+ fishingClassReservation.getPlace()  + " has been successfully booked. "  + ".");
		javaMailSender.send(mail);
		System.out.println("Email poslat!");
	}
	
	public void sendNotificaitionForCottageReservation(CottageReservation cottageReservation) throws MailException, InterruptedException {

		Thread.sleep(500);
		System.out.println("Slanje emaila...");


		SimpleMailMessage mail = new SimpleMailMessage();
		///vidi da saljes na klijentov mail
		mail.setTo(env.getProperty("spring.mail.username"));
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Succesfull reservation");
		mail.setText("Hi, "  +"\n\nA new booking date for "+ cottageReservation.getStartDate()  + " has been successfully booked. "  + ".");
		javaMailSender.send(mail);
		System.out.println("Email poslat!");
	}
	
	public void sendNotificaitionForBoatReservation(Client client, BoatReservation boatReservation) throws MailException, InterruptedException {

		Thread.sleep(500);
		System.out.println("Slanje emaila...");


		SimpleMailMessage mail = new SimpleMailMessage();
		///vidi da saljes na klijentov mail
		mail.setTo(client.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Succesfull reservation");
		mail.setText("Hi, "  +"\n\nA new booking date for "+ boatReservation.getStartDate()  + " has been successfully booked. "  + ".");
		javaMailSender.send(mail);
		System.out.println("Email poslat!");
	}

///RATE
	@Async
	public void sendNotificaitionAsyncAcceptRate(Client user) throws MailException, InterruptedException {

		Thread.sleep(1000);
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Your account is activated");
		mail.setText("Hi, " + user.getName() + " " +  user.getSurname() +",\n\nyour rate is accepted.");
		javaMailSender.send(mail);
		System.out.println("Email poslat!");
	}

	//COMPLAINT


	@Async
	public void sendNotificaitionAsyncAcceptComplaintInstructor(Instructor instructor, String complaint) throws MailException, InterruptedException {

		Thread.sleep(1000);
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(instructor.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Answer to the complaint");
		mail.setText("Hi, " + instructor.getName() + " " +  instructor.getSurname() +",\n\nAdmin answer to the complaint.\nAnswer: " + complaint );
		javaMailSender.send(mail);
		System.out.println("Email poslat!");
	}


	@Async
	public void sendNotificaitionAsyncAcceptComplaintClient(Client client, String complaint) throws MailException, InterruptedException {

		Thread.sleep(1000);
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(client.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Answer to the complaint");
		mail.setText("Hi, " + client.getName() + " " +  client.getSurname() +",\n\nAdmin answer to the complaint.\nAnswer: " + complaint );
		javaMailSender.send(mail);
		System.out.println("Email poslat!");
	}
////PENALTY

	@Async
	public void sendNotificaitionPenaltyToClient(Client client) throws MailException, InterruptedException {

		Thread.sleep(1000);
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(client.getEmail());

		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Admin give one penalty to client for instructor request");
		mail.setText("Hi, " + client.getName() + " " +  client.getSurname() +",\n\nYou have one more penalty from admin.");
		javaMailSender.send(mail);
		System.out.println("Email poslat!");
	}

	@Async
	public void sendNotificaitionPenaltyToInstructor(Instructor instructor) throws MailException, InterruptedException {

		Thread.sleep(1000);
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();

		mail.setTo(instructor.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Admin give one penalty to client for instructor request");
		mail.setText("Hi, " + instructor.getName() + " " +  instructor.getSurname() +",\n\nAdmin give 1 more penalty to client.");
		javaMailSender.send(mail);
		System.out.println("Email poslat!");
	}

////
@Async
public void sendNotificaitionToSubscribersForNewAction(Client client) throws MailException, InterruptedException {

	Thread.sleep(1000);
	System.out.println("Slanje emaila...");

	SimpleMailMessage mail = new SimpleMailMessage();

	mail.setTo(client.getEmail());
	mail.setFrom(env.getProperty("spring.mail.username"));
	mail.setSubject("New action");
	mail.setText("Hi, " + client.getName() + " " +  client.getSurname() +",\n\nA new offer with a discount for fishing lessons has been released.");
	javaMailSender.send(mail);
	System.out.println("Email poslat!");
}

@Async
public void sendNotificaitionToSubscribersForNewCottageAction(Client client) throws MailException, InterruptedException {

	Thread.sleep(1000);
	System.out.println("Slanje emaila...");

	SimpleMailMessage mail = new SimpleMailMessage();

	mail.setTo(client.getEmail());
	mail.setFrom(env.getProperty("spring.mail.username"));
	mail.setSubject("New action");
	mail.setText("Hi, " + client.getName() + " " +  client.getSurname() +",\n\nA new offer with a discount for cottage has been released.");
	javaMailSender.send(mail);
	System.out.println("Email poslat!");
}

@Async
public void sendNotificaitionToSubscribersForNewBoatAction(Client client) throws MailException, InterruptedException {

	Thread.sleep(1000);
	System.out.println("Slanje emaila...");

	SimpleMailMessage mail = new SimpleMailMessage();

	mail.setTo(client.getEmail());
	mail.setFrom(env.getProperty("spring.mail.username"));
	mail.setSubject("New action");
	mail.setText("Hi, " + client.getName() + " " +  client.getSurname() +",\n\nA new offer with a discount for boats has been released.");
	javaMailSender.send(mail);
	System.out.println("Email poslat!");
}

}
