package dlz.com.br.back_end.exception.general;


public class EntityNotFound extends RuntimeException{

        public EntityNotFound(String message) {
            super(message);
        }
}
