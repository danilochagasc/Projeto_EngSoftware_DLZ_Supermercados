package dlz.com.br.back_end.data.dto.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(

        @NotBlank(message = "Name cannot be blank")
        String name,

        @NotBlank(message = "Email cannot be blank")
        @Email(message = "Email must be valid")
        String email,

        @NotBlank(message = "Password cannot be blank")
        String password,

        @NotBlank(message = "Phone cannot be blank")
        @Size(min = 11, max = 11, message = "Phone must have 11 characters")
        String phone,

        @NotBlank(message = "Address cannot be blank")
        String address
) {
}
