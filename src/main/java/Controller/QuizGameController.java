package Controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import com.fasterxml.jackson.core.JsonProcessingException;
import Model.Question;
import Model.Answer;
import Service.QuestionService;
import Service.AnswerService;
import io.javalin.http.Context;
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
        app.delete("/questions/{question_id}", this::getDeleteQuestionByIDHandler);
        app.post("/questions/{question_id}", this::postQuestionHandler);
        app.post("answers/{answer_id}", this::postAnswerHandler);
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

    public void getDeleteQuestionByIDHandler(Context context){

        int question_id = Integer.parseInt(context.pathParam("question_id"));
        Question deletedQuestion = questionService.deleteQuestionID(question_id);

        if(deletedQuestion!= null){
            context.json(deletedQuestion);
            context.status(200);
        }
        else {
            context.status(200);
        }
    }
    public void postQuestionHandler(Context context) throws JsonProcessingException{

        ObjectMapper objectMapper = new ObjectMapper();
        Question question = objectMapper.readValue(context.body(), Question.class);
        Question addQuestion= questionService.addQuestion(question);

        if(addQuestion!=null){
            context.json(objectMapper.writeValueAsString(addQuestion));
            context.status(200);
        }

        else{
            context.status(400);
        }
    }
    public void postAnswerHandler(Context context) throws JsonProcessingException{

        ObjectMapper mapper = new ObjectMapper();
        Answer answer = mapper.readValue(context.body(), Answer.class);
        Answer addAnswer = answerService.addAnswer(answer);

        if(addAnswer != null){
            context.json(mapper.writeValueAsString(addAnswer));
            context.status(200);
        }
        else{
            context.status(400);
        }
    }
}
