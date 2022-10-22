package io.davidabejirin.assessment.verticles;

import io.davidabejirin.assessment.service.impl.ResultServiceImpl;
import io.davidabejirin.assessment.utils.Term;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ResultHandler {
    private final ResultServiceImpl resultService;
    private static final String STUDENT_ID = "studentId";
    private static final String TERM = "term";
    private static final String SUBJECT_ID = "subjectId";
    private static final String SCHOOL_CLASS = "schoolClass";

    public void getResult(RoutingContext routingContext) {
        Long studentId = Long.valueOf(routingContext.request().getParam(STUDENT_ID));
        Long id = Long.valueOf(routingContext.request().getParam(SUBJECT_ID));
        String schoolClass = routingContext.request().getParam(SCHOOL_CLASS);
        String term = routingContext.request().getParam(TERM);
        routingContext.response().putHeader("Content-Type", "application/json")
                .setStatusCode(200)
                .end(Json.encodePrettily(resultService.getStudentResult(studentId, id, schoolClass, term)));
    }
    public void getStudentTermlyResult(RoutingContext routingContext) {
        Long studentId = Long.parseLong(routingContext.request().getParam(STUDENT_ID));
        String term = routingContext.request().getParam(TERM);
        routingContext.response().putHeader("Content-Type", "application/json")
                .setStatusCode(200)
                .end(Json.encodePrettily(resultService.getStudentTermlyResult(studentId, Term.valueOf(term))));
    }

}
