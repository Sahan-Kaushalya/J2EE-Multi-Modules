package lk.kaushalya.ecomm.user.remote;

import jakarta.ejb.Remote;

@Remote
public interface TestRemote {
    String test();
    void remove();
}
