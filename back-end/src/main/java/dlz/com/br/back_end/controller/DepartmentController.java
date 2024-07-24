package dlz.com.br.back_end.controller;

import dlz.com.br.back_end.data.dto.response.DepartmentResponseDTO;
import dlz.com.br.back_end.service.DepartmentService;
import dlz.com.br.back_end.util.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Department", description = "Operações relacionadas a Departamentos")
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Operation(summary = "Lista todos os Departamentos disponíveis",
            description = "Retorna uma lista com todos os departamentos disponíveis",
            tags = {"Department"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = DepartmentResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<List<DepartmentResponseDTO>> getAllDepartments() {
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.getAllDepartments());
    }

    @Operation(summary = "Busca um Departamento pelo ID",
            description = "Retorna um departamento específico de acordo com o ID informado",
            tags = {"Department"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = DepartmentResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @GetMapping(value = "/{idDepartment}", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<DepartmentResponseDTO> getDepartmentById(@PathVariable Long idDepartment) {
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.getDepartamentById(idDepartment));
    }
}
