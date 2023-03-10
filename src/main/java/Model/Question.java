package Model;

public class Question {
    public int question_id;
    public String question_text;
    //retriving all questions
    public Question(){}
    public Question(int question_id, String question_text){
        this.question_id = question_id;
        this.question_text = question_text;
    }
    public int getQuestion_id(){
        return question_id;
    }
    public void setQuestionByID(int question_id){
        this.question_id = question_id;
    }
    public String getQuestion_text(){
        return question_text;
    }
    public void setQuestion_text(String question_text){
        this.question_text = question_text;
    }
    @Override
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(o==null || getClass() !=o.getClass()){
            return false;
        }
        Question question = (Question) o;
        return question_id== question.question_id && question_text.equals(question.question_text);
    }
    @Override
    public String toString(){
        return "Question{ " +
                "question_id= " +question_id +
                " question_text= " + question_text + '\''+'}';
    }

}
