package pl.com.itsystems.springcontactform;

import org.springframework.stereotype.Service;

@Service
public class ContactFormService {
    private boolean sendStatus;

    public boolean send(ContactForm contactForm) {
        if (contactForm.geteMailAddress().isBlank()) {
            sendStatus = false;
            return false;
        } else {
            sendStatus = true;
            return true;
        }
    }

    public boolean getSendStatus() {
        return sendStatus;
    }
}
