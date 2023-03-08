package Model;

public class Question {
    public int choice_id;
    public int question_id;

    //cant be blank and under 255 characters
    public String question_text;

    public Question(){

    }
    //retriving all questions
    public Question(int choice_id, int question_id, String question_text){
        this.choice_id = choice_id;
        this.question_id = question_id;
        this.question_text = question_text;
    }

    public int getQuestion_id(){
        return question_id;
    }
    public void setQuestion_id(int question_id){
        this.question_id = question_id;
    }

    public int getChoice_id(){
        return choice_id;
    }
    public void setChoice_id(int choice_id){
        this.choice_id = choice_id;
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
        return question_id== question.question_id && choice_id==question.choice_id
                && question_text.equals(question.question_text);
    }
    @Override
    public String toString(){
        return "Question{ " +
                "question_id=" +question_id +
                ", choice_id=" +choice_id +
                ", question_text=" +question_text + '\''+'}';
    }

}
