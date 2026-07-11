package lk.kaushalya.ecomm.cdi;

import jakarta.enterprise.context.Dependent;
import lk.kaushalya.ecomm.annotation.SMS;

@SMS
@Dependent
public class SMSNotifier implements NotificationService{
    @Override
    public void notify(String message) {
        System.out.println("Sending SMS .....");
        System.out.println("SMS Notifier : "+message);
    }
}
