package lk.kaushalya.ecomm.user.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.PostActivate;
import jakarta.ejb.PrePassivate;
import jakarta.ejb.Remove;
import jakarta.ejb.Stateful;
import lk.kaushalya.ecomm.user.remote.TestRemote;

@Stateful(mappedName = "TestNewSessionBean")
//@Singleton
//@Startup
public class TestNewSessionBean implements TestRemote {
    int i = 0;

    @PostConstruct
    public void init(){
        System.out.println("TestNewSessionBean init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("TestNewSessionBean destroy");
    }

    public TestNewSessionBean() {
        System.out.println("TestNewSessionBean Created: "+this);
    }

    @PostActivate
    public  void  postActivate(){
        System.out.println("TestNewSessionBean : PostActivate....");
    }

    @PrePassivate
    public  void  prePassivate(){
        System.out.println("TestNewSessionBean : PrePassivate....");
    }

    @Remove
    @Override
    public void remove(){
        System.out.println("TestNewSessionBean : Remove....");
    }

    @Override
    public String test() {
        i++;

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "TestNewSessionBean Test Count : " +i;
    }
}
