package dlz.com.br.back_end.data.dto.response;

import dlz.com.br.back_end.data.entity.User;

public record UserResponseDTO(

        Long id,
        String name,
        String email,
        String phone,
        String address
) {
    public UserResponseDTO(User user) {
        this(user.getIdUser(), user.getName(), user.getEmail(), user.getPhone(), user.getAddress());
    }
}
