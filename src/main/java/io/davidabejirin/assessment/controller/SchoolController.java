package io.davidabejirin.assessment.controller;

import io.davidabejirin.assessment.dto.AddScoreDTO;
import io.davidabejirin.assessment.models.Subject;
import io.davidabejirin.assessment.service.impl.ResultServiceImpl;
import io.davidabejirin.assessment.service.impl.ScoreServiceImpl;
import io.davidabejirin.assessment.utils.ApiResponse;
import io.davidabejirin.assessment.utils.Term;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/school")
public class SchoolController {

    private final ScoreServiceImpl scoreService;
    private final ResultServiceImpl resultService;

    @PostMapping(value = "/add-score/{studentId}")
    public ResponseEntity<ApiResponse<Subject>> addScore(@PathVariable (value = "studentId") Long studentId,  @RequestBody  AddScoreDTO addScoreDTO){
        return new ResponseEntity<>(scoreService.addScore(studentId, addScoreDTO), CREATED);
    }

    @GetMapping(value = "/get-result/{studentId}")
    public ResponseEntity<ApiResponse<Object>>  getResult(@PathVariable(value = "studentId") Long studentId ,
                                                          @RequestParam(value = "name") String name ,
                                                          @RequestParam (value = "schoolClass") String schoolClass ,
                                                          @RequestParam (value = "term") String term){
        return new ResponseEntity<>(resultService.getStudentResult(studentId, name, schoolClass, term) , OK);
    }

    @GetMapping(value = "/get-score/{studentId}")
    public ResponseEntity<ApiResponse<Object>>  getTermlyResult(@PathVariable(value = "studentId") Long studentId ,
                                                          @RequestParam (value = "term") String term){
        return new ResponseEntity<>(resultService.getStudentTermlyResult(studentId , Term.valueOf(term)) , OK);
    }
}
