package dlz.com.br.back_end.service;

import dlz.com.br.back_end.data.dto.request.user.UserRequestDTO;
import dlz.com.br.back_end.data.dto.response.UserResponseDTO;
import dlz.com.br.back_end.data.entity.User;
import dlz.com.br.back_end.exception.user.EmailAlreadyRegisteredException;
import dlz.com.br.back_end.repository.UserRepository;
import dlz.com.br.back_end.util.CommonMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO getUserById(Long idUser) {
        return new UserResponseDTO(CommonMethods.getEntityById(idUser, userRepository));
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO){
            User newUser = new User(userRequestDTO);
            return new UserResponseDTO(userRepository.save(newUser));
    }

    public UserResponseDTO updateUser(Long idUser, UserRequestDTO userRequestDTO){
        User user = CommonMethods.getEntityById(idUser, userRepository);

        user.setName(userRequestDTO.name());
        user.setEmail(userRequestDTO.email());
        user.setPhone(userRequestDTO.phone());
        user.setAddress(userRequestDTO.address());

        return new UserResponseDTO(userRepository.save(user));
    }

    public String deleteUser(Long idUser){
        userRepository.delete(CommonMethods.getEntityById(idUser,userRepository));

        return "Deleted with success";
    }
}
