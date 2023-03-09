package Controller;
import io.javalin.Javalin;
import io.javalin.http.Context;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import Model.Question;
import Service.QuestionService;
import java.util.List;
import java.util.ArrayList;

public class QuizGameController {
    QuestionService questionService;
//    AnswerService answerService;
    public QuizGameController(){
        this.questionService = new QuestionService();
//        this.answerService = new AnswerService();
    }

    public Javalin startAPI(){
        Javalin app = Javalin.create();
        app.get("/questions", this::getAllQuestionsHandler);
        return app;
    }

    public void getAllQuestionsHandler(Context context) throws JsonProcessingException{
        List<Question> questions = questionService.getAllQuestions();
        context.json(questions);
        context.status(200);
    }
}

// pk is unique. answers belong to a question.
//something in question