package Controller;
import io.javalin.Javalin;
import io.javalin.http.Context;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import Model.Question;
import Model.Answer;
import Service.QuestionService;
import Service.AnswerService;
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
        app.put("/questions/{question_id}", this::updateQuestionByIDHandler);
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
    public void updateQuestionByIDHandler(Context context) throws JsonProcessingException{

        ObjectMapper mapper = new ObjectMapper();

        Question question = mapper.readValue(context.body(), Question.class);

        int questionID = Integer.parseInt(context.pathParam("question_id"));
        Question updateQuestion = questionService.updateQuestionByID(questionID, question);

        if(updateQuestion == null || question.question_text.length() > 255 || question.question_text ==""){
            context.status(400);
        }
        else{
            context.json(mapper.writeValueAsString(updateQuestion));
            context.status(200);
        }
    }
}

