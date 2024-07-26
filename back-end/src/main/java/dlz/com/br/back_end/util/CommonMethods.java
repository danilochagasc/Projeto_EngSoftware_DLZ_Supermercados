package dlz.com.br.back_end.util;

import dlz.com.br.back_end.exception.general.EntityNotFound;
import org.springframework.data.jpa.repository.JpaRepository;

public class CommonMethods {

    public static <T> T getEntityById(Long id, JpaRepository<T, Long> repository) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFound("Entity not found with id: " + id));
    }
}
