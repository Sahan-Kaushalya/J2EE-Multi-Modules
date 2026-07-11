package lk.kaushalya.ecomm.user.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.*;
import lk.kaushalya.ecomm.user.remote.TestRemote;

@Stateful(mappedName = "TestSessionBean")
//@Singleton
//@Startup
public class TestSessionBean implements TestRemote {
    int i = 0;

    @PostConstruct
    public void init(){
        System.out.println("TestSessionBean init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("TestSessionBean destroy");
    }

    public TestSessionBean() {
        System.out.println("TestSessionBean Created: "+this);
    }

    @PostActivate
    public  void  postActivate(){
        System.out.println("TestSessionBean : PostActivate....");
    }

    @PrePassivate
    public  void  prePassivate(){
        System.out.println("TestSessionBean : PrePassivate....");
    }

    @Remove
    @Override
    public void remove(){
        System.out.println("TestSessionBean : Remove....");
    }

    @Override
    public String test() {
        i++;

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Test Count : " +i;
    }
}
