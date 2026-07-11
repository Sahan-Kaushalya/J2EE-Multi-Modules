package lk.kaushalya.ecomm.cdi;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;

//@ApplicationScoped
@Dependent
public class MyService implements Serializable {
    // if we use @SessionScoped in here, the bean instance is tied to a user's HTTP session.
    // The application server may need to serialize the session to save memory or to persist it across server restarts.
    // This process is called "passivation". When the session is needed again, it's deserialized back into memory,
    // which is called "activation". For this to work, any objects stored in the session,
    // including this @SessionScoped bean, must implement the java.io.Serializable interface.
    public void doSomething() {
        System.out.println("MyService doSomething...." + this);
    }
}