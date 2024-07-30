package dlz.com.br.back_end.service;

import dlz.com.br.back_end.data.dto.request.auth.AuthRequestDTO;
import dlz.com.br.back_end.data.dto.request.user.UpdatePasswordRequestDTO;
import dlz.com.br.back_end.data.dto.request.user.UpdateUserRequestDTO;
import dlz.com.br.back_end.data.dto.response.AuthResponseDTO;
import dlz.com.br.back_end.data.dto.request.user.UserRequestDTO;
import dlz.com.br.back_end.data.dto.response.UserResponseDTO;
import dlz.com.br.back_end.data.entity.User;
import dlz.com.br.back_end.exception.auth.InvalidPasswordException;
import dlz.com.br.back_end.exception.general.EntityNotFound;
import dlz.com.br.back_end.exception.user.UserAlreadyExistsException;
import dlz.com.br.back_end.infra.security.TokenService;
import dlz.com.br.back_end.repository.UserRepository;
import dlz.com.br.back_end.util.CommonMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    public UserResponseDTO getUserById(Long idUser) {
        return new UserResponseDTO(CommonMethods.getEntityById(idUser, userRepository));
    }

    public AuthResponseDTO createUser(UserRequestDTO userRequestDTO){

        Optional<User> user = userRepository.findByEmail(userRequestDTO.email());

        if(user.isEmpty()){
            User newUser = new User(userRequestDTO);
            newUser.setPassword(passwordEncoder.encode(userRequestDTO.password()));
            userRepository.save(newUser);
            String token = tokenService.generateToken(newUser);

            return new AuthResponseDTO(token, newUser.getName(), newUser.getIdUser());
        }else {
            throw new UserAlreadyExistsException();
        }
    }

    public UserResponseDTO updateUser(Long idUser, UpdateUserRequestDTO updateUserRequestDTO){
        User user = CommonMethods.getEntityById(idUser, userRepository);

        user.setName(updateUserRequestDTO.name());
        user.setEmail(updateUserRequestDTO.email());
        user.setPhone(updateUserRequestDTO.phone());
        user.setAddress(updateUserRequestDTO.address());

        return new UserResponseDTO(userRepository.save(user));
    }

    public UserResponseDTO updatePassword(Long idUser, UpdatePasswordRequestDTO updatePasswordRequestDTO) {
        User user = CommonMethods.getEntityById(idUser, userRepository);

        if (passwordEncoder.matches(updatePasswordRequestDTO.oldPassword(), user.getPassword())) {
            user.setPassword(passwordEncoder.encode(updatePasswordRequestDTO.newPassword()));
            return new UserResponseDTO(userRepository.save(user));
        } else {
            throw new InvalidPasswordException("Invalid old password");
        }
    }

    public String deleteUser(Long idUser){
        userRepository.delete(CommonMethods.getEntityById(idUser,userRepository));

        return "Deleted with success";
    }

    public AuthResponseDTO login(AuthRequestDTO authRequestDTO){
        User user = userRepository.findByEmail(authRequestDTO.email()).orElseThrow(() -> new EntityNotFound("User not found"));

        if(passwordEncoder.matches(authRequestDTO.password(), user.getPassword())){
            String token = tokenService.generateToken(user);

            return new AuthResponseDTO(token, user.getName(), user.getIdUser());
        }else {
            throw new InvalidPasswordException("Invalid password");
        }
    }
}
