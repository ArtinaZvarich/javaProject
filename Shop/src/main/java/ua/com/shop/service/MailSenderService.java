package ua.com.shop.service;

public interface MailSenderService {

	void sendMail(String theme, String mailBody, String email);
}
