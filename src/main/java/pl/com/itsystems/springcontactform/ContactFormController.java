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
    public String status(Model model) {
        boolean sendStatus = contactFormService.getSendStatus();
        if (sendStatus) {
            model.addAttribute("message", "Wiadomość wysłana poprawnie.");
            model.addAttribute("sendStatus", "text-success");
        } else {
            model.addAttribute("message", "Wiadomość nie wysłana, podaj poprawny adres e-mail.");
            model.addAttribute("sendStatus", "text-danger");
        }
        return "status";
    }

    @PostMapping("/send")
    public String send(ContactForm contactForm, Model model) {
        boolean sendStatus = contactFormService.send(contactForm);
        if (sendStatus) {
            return "redirect:/status";
        } else {
            return "redirect:/status";
        }
    }

}
