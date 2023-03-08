package Model;

public class Answer {
    public int choice_id;
    public int question_id;
    public Boolean is_correct;
    public String answer_text;
    public String choice_list;

    public Answer(){

    }
    public Answer(int choice_id, int question_id, boolean is_correct, String answer_text, String choice_list){
        this.choice_id = choice_id;
        this.question_id = question_id;
        this.is_correct = is_correct;
        this.answer_text = answer_text;
        this.choice_list = choice_list;
    }
    public int getChoice_id(){
        return choice_id;

    }
    public void setChoice_id(int choice_id){
        this.choice_id = choice_id;
    }
    public int getQuestion_id(){
        return question_id;
    }
    public void setQuestion_id(int question_id){
        this.question_id =question_id;
    }
    public Boolean getIs_correct(){
        return  is_correct;
    }
    public void setIs_correct(Boolean is_correct){
        this.is_correct = is_correct;
    }
    public String getAnswer_text(){
        return answer_text;
    }
    public void setAnswer_text(String answer_text){
        this.answer_text = answer_text;
    }
    public String getChoice_list(){
        return choice_list;
    }
    public void setChoice_list(String choice_list){
        this.choice_list = choice_list;
    }

    @Override
    public  boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(o==null|| getClass()!=o.getClass()){
            return false;
        }
        Answer answer = (Answer) o;
        return choice_id == answer.choice_id && question_id == answer.question_id
                && is_correct ==answer.is_correct &&choice_list.equals(answer.choice_list) &&
                answer_text.equals(answer.answer_text);
    }
    @Override
    public String toString(){
        return "Answer{"+
                "choice_id=" +choice_id +
                ", question_id=" +question_id +
                ", is_correct=" +is_correct +
                ", choice_list=" + choice_list +'\'' +
                ", answer_text=" + answer_text +'\'' + '}';
    }
}