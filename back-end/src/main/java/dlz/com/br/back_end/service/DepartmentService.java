package dlz.com.br.back_end.service;

import dlz.com.br.back_end.data.dto.response.DepartmentResponseDTO;
import dlz.com.br.back_end.repository.DepartmentRepository;
import dlz.com.br.back_end.util.CommonMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentResponseDTO getDepartamentById(Long id) {
        return new DepartmentResponseDTO(CommonMethods.getEntityById(id,departmentRepository));
    }

    public List<DepartmentResponseDTO> getAllDepartments() {
        return departmentRepository.findAll().stream().map(DepartmentResponseDTO::new).toList();
    }


}
