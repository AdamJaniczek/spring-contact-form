package pl.com.itsystems.springcontactform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactFormController {
    private ContactFormService contactFormService;

    public ContactFormController(ContactFormService contactFormService) {
        this.contactFormService = contactFormService;
    }

    @GetMapping("/kontakt")
    public String contactForm(Model model){
        model.addAttribute("contactForm", new ContactForm());
        return "contact-form";
    }

    @GetMapping("/status")
    public String status(boolean success, Model model) {
        model.addAttribute("status", success);
        return "status";
    }

    @PostMapping("/send")
    public String send(ContactForm contactForm) {
        boolean sendStatus = contactFormService.send(contactForm);
        return "redirect:/status?success=" + sendStatus;
    }

}
