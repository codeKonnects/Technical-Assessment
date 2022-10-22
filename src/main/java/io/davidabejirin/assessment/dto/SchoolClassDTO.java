package io.davidabejirin.assessment.dto;

import io.davidabejirin.assessment.models.Clazz;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolClassDTO {
    private Long id;
    private String name;

    public SchoolClassDTO(Clazz clazz) {
        this.id = clazz.getId();
        this.name = clazz.getName();
    }
}
