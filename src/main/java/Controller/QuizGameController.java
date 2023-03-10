package Controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import com.fasterxml.jackson.core.JsonProcessingException;
import Model.Question;
import Model.Answer;
import Service.QuestionService;
import Service.AnswerService;
import io.javalin.http.Context;
import javax.naming.Context;
import java.util.List;

public class QuizGameController {
    QuestionService questionService;
    AnswerService answerService;
    public QuizGameController(){
        this.questionService = new QuestionService();
        this.answerService = new AnswerService();
    }

    public Javalin startAPI(){
        Javalin app = Javalin.create();
        app.get("/questions", this::getAllQuestionsHandler);
        app.get("/answers", this::getAllAnswersHandler);
        app.get("questions/{question_id}", this::getQuestionByIDHandler);
        app.get("answers/{answer_id}", this::getAnswersByIDHandler);
        app.delete("/questions/{question_id}", this::getDeleteQuestionByIDHandler);
        return app;
    }

    public void getAllQuestionsHandler(Context context) {
        List<Question> questions = questionService.getAllQuestions();
        context.json(questions);
        context.status(200);
    }

    public void getAllAnswersHandler(Context context){
        List<Answer> answers = answerService.getAllAnswers();
        context.json(answers);
        context.status(200);
    }
    public void getQuestionByIDHandler(Context context){
        int questionID = Integer.parseInt(context.pathParam("question_id"));
        Question getQuestion = questionService.getQuestionByID(questionID);

        if(getQuestion != null){
            context.json(getQuestion);
            context.status(200);
        }
    }
    public List<Answer> getAnswersByIDHandler(Context context){
        int answerID = Integer.parseInt(context.pathParam("answer_id"));

        List<Answer> getAnswers = answerService.getAnswersByID(answerID);

        if(getAnswers != null){
            context.json(getAnswers);
            context.status(200);
        }
        return getAnswers;
    }
    public void getDeleteQuestionByIDHandler(Context context) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        int question_id = Integer.parseInt(Context.pathParam("question_id"));
        Question question = questionService.deleteQuestionID(question_id);

        if(question!=null){
            context.json(objectMapper.writeValueAsString(question));
            context.status(200);
        }
        else{
            context.status(400);
        }
    }
}

// pk is unique. answers belong to a question.
//something in question