package io.davidabejirin.assessment.verticles;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AllRouters extends AbstractVerticle {
    private final AddScoreHandler addScoreHandler;
    private final ResultHandler resultHandler;

    @Override
    public void start() throws Exception {
        super.start();
        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());
        router.post("/api/score/:studentId").handler(rc -> {addScoreHandler.addScore(rc);});
        router.get("/api/result").handler(rc ->
        {try{
            resultHandler.getResult(rc);
        }catch (Exception e){
            System.out.println(e);
        }});
        router.get("/api/all-result").handler(resultHandler::getStudentTermlyResult);
        vertx.createHttpServer()
                .requestHandler(router)
                .listen(8081);
    }
}
