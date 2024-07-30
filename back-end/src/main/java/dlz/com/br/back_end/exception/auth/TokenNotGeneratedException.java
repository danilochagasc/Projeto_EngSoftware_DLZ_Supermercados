package dlz.com.br.back_end.exception.auth;

public class TokenNotGeneratedException extends RuntimeException {
    public TokenNotGeneratedException(String message) {
        super(message);
    }
}
