package lk.kaushalya.ecomm.client;

import lk.kaushalya.ecomm.user.remote.TestRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        System.out.println("Client Application Started...");

        try {
            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.enterprise.naming.SerialInitContextFactory");
            props.put(Context.PROVIDER_URL,"iiop://localhost:3700");
            InitialContext ic = new InitialContext(props);
            TestRemote testRemote = (TestRemote) ic.lookup("java:global/ecomm-user-1.0/TestSessionBean");
            testRemote.test();

            String name = ic.lookup("Name").toString();
            System.out.println("User Name: "+name);

        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Client Application Stopped...");
    }
}