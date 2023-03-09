package Controller;
import io.javalin.Javalin;

public class QuizGameController {

//    QuestionService question;
//    AnswerService answer;
//    public QuizGameController(){
//        this.QuestionService = new QuestionService();
//        this.AnswerService = new AnswerService();
//    }

    public Javalin startAPI(){
        Javalin app = Javalin.create();
//        app.get("/questions", this::getAllQuestionsHandler);
        return app;
    }

//    public void getAllQuestionsHandler(Context context) throws JsonProcessingException{
//        List<Question> questions = questionService.getAllMesages();
//        context.json(messages);
//        context.status(200);
//    }
}

