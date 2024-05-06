package pl.com.itsystems.springcontactform;

public class ContactForm {
    private String name;
    private String eMailAddress;
    private String message;

    public ContactForm() {
    }

    public ContactForm(String name, String eMailAddress, String message) {
        this.name = name;
        this.eMailAddress = eMailAddress;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteMailAddress() {
        return eMailAddress;
    }

    public void seteMailAddress(String eMailAddress) {
        this.eMailAddress = eMailAddress;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
