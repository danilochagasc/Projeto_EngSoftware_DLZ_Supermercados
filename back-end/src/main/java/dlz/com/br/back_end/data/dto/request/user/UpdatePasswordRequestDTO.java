package dlz.com.br.back_end.data.dto.request.user;

import jakarta.validation.constraints.NotBlank;

public record UpdatePasswordRequestDTO(

        @NotBlank(message = "Old password cannot be blank")
        String oldPassword,

        @NotBlank(message = "New password cannot be blank")
        String newPassword
) {
}
