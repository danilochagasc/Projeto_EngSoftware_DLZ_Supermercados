package dlz.com.br.back_end.data.dto.response;

import dlz.com.br.back_end.data.entity.Department;

public record DepartmentResponseDTO(
        Long idDepartment,
        String name
) {
    public DepartmentResponseDTO(Department department) {
        this(department.getIdDepartment(), department.getName());
    }
}
