package io.davidabejirin.assessment.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class ApiResponse <T>{
    private HttpStatus status;
    private String message;
    private T data;
}
