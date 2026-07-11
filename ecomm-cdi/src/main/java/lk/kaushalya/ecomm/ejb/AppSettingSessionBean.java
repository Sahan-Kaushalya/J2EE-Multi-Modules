package lk.kaushalya.ecomm.ejb;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import lk.kaushalya.ecomm.annotation.Console;
import lk.kaushalya.ecomm.annotation.Email;
import lk.kaushalya.ecomm.cdi.Logger;
import lk.kaushalya.ecomm.cdi.MyService;
import lk.kaushalya.ecomm.cdi.NotificationService;
import lk.kaushalya.ecomm.ejb.remote.AppSetting;

@Singleton
public class AppSettingSessionBean implements AppSetting {

    @Inject
    private MyService myService;

    @Inject
    @Email
    private NotificationService notificationService;

    @Inject
    @Console
    private Event<String> logEvent;
//
//    @PostConstruct
//    public void init(){
//        myService = new MyService();
//    }

    @Override
    public String getName() {
        //myService.doSomething();
        logEvent.fire("Hello Ecommerce from AppSetting SessionBean");
        notificationService.notify("Hello Ecommerce from AppSetting SessionBean");
        return "Ecommerce Web Application";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String getDescription() {
        return "This is the ecommerce web application setting bean implementation";
    }

    @Override
    public String getDevelopers() {
        return "Develop by Kaushalya";
    }
}
