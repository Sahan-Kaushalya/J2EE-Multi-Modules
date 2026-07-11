package lk.kaushalya.ecomm.cdi;

import jakarta.enterprise.context.Dependent;
import lk.kaushalya.ecomm.annotation.Email;

@Email
@Dependent
public class EmailNotifier implements NotificationService{
    @Override
    public void notify(String message) {
        System.out.println("Sending Email ....");
        System.out.println("Email Notifier : "+message);
    }
}
