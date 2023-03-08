package Controller;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class QuizGameController {

    AnswerService answerService;
    QuestionService questionService;

    public QuizGameController(){
        this.answerService = new AnswerService();
        this.questionService = new QuestionService();
    }

    public Javalin startAPI(){
        Javalin app = Javalin.create();
        app.get("/question", this::getQuestionByIDHandler);
    }
}
