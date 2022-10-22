package io.davidabejirin.assessment.verticles;

import io.davidabejirin.assessment.dto.AddScoreDTO;
import io.davidabejirin.assessment.service.impl.ScoreServiceImpl;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AddScoreHandler {
    private static final String STUDENT_ID = "studentId";
    private final ScoreServiceImpl scoreService;

    public void addScore(RoutingContext routingContext) {
       Long studentId = Long.parseLong(routingContext.pathParam(STUDENT_ID));
       final AddScoreDTO addScoreDTO = routingContext.body().asJsonObject().mapTo(AddScoreDTO.class);

        routingContext.response().putHeader("Content-Type", "application/json")
                .setStatusCode(201)
                .end(Json.encodePrettily(scoreService.addScore(studentId, addScoreDTO)));

    }
}
