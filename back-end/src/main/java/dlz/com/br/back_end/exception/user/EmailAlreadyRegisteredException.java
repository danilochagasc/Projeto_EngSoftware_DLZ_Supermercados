package dlz.com.br.back_end.exception.user;

public class EmailAlreadyRegisteredException extends IllegalArgumentException {

    public EmailAlreadyRegisteredException() {
        super("Email already registered");
    }
}
