package lk.kaushalya.ecomm.user.remote;

import jakarta.ejb.Remote;
import lk.kaushalya.ecomm.user.dto.UserDTO;

import java.util.List;

@Remote
public interface UserRemote {
    UserDTO getUser(Long userId);
    UserDTO getUserByEmail(String userEmail);
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO);
    String deleteUser (Long userId);
    List<UserDTO> getAllUsers();
}
