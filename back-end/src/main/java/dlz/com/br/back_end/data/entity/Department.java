package dlz.com.br.back_end.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "department")
public class Department {

    @Id
    @Column(name = "id_department")
    @Setter(AccessLevel.NONE)
    private Long idDepartment;

    @Column(name = "name")
    private String name;
}
