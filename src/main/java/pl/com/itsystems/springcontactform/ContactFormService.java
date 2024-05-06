package pl.com.itsystems.springcontactform;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ContactFormService {

    private JavaMailSender mailSender;

    public ContactFormService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public boolean send(ContactForm contactForm) {
        if (contactForm.geteMailAddress().isBlank()) {
            return false;
        } else {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom("kontakt@itsystems.com.pl");
            simpleMailMessage.setReplyTo(contactForm.geteMailAddress());
            simpleMailMessage.setTo("kontakt@itsystems.com.pl");
            simpleMailMessage.setText(contactForm.getMessage());
            simpleMailMessage.setSubject("Formularz kontaktowy");
            mailSender.send(simpleMailMessage);
            return true;
        }
    }
}
