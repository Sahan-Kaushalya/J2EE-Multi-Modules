package lk.kaushalya.ecomm.user.bean;

import jakarta.ejb.Stateless;
import lk.kaushalya.ecomm.user.dto.UserDTO;
import lk.kaushalya.ecomm.user.remote.UserRemote;

import java.util.List;

@Stateless
public class UserSessionBean implements UserRemote {

    @Override
    public UserDTO getUser(Long userId) {
        return new UserDTO();
    }

    @Override
    public UserDTO getUserByEmail(String userEmail) {
        return new UserDTO();
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        return new UserDTO();
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        return new UserDTO();
    }

    @Override
    public String deleteUser(Long userId) {
        System.out.println("UserSessionBean User Delete Success......");
        return "UserSessionBean : Delete User";
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return List.of();
    }
}
