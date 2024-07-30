package dlz.com.br.back_end.data.dto.response;

public record AuthResponseDTO(
        String token,

        String name,

        Long idUser
) {
}
