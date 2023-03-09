package Model;

public class Answer {
    public int answer_id;
    public int question_id;
    public Boolean is_correct;
    public String choice_list;

    public Answer(int answer_id){
        this.answer_id = answer_id;
    }
    public Answer(int answer_id, int question_id, boolean is_correct, String choice_list){
        this.answer_id = answer_id;
        this.question_id = question_id;
        this.is_correct = is_correct;
        this.choice_list = choice_list;
    }
    public int getAnswer_id(){
        return answer_id;

    }
    public void setAnswer_id(int answer_id){
        this.answer_id = answer_id;
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
    public String getChoice_list(){
        return choice_list;
    }
    public void setChoice_list(String choice_list){
        this.choice_list = choice_list;
    }
//  Since we deleted answer_text need to figure out something different later
//    @Override
//    public  boolean equals(Object o){
//        if(this==o){
//            return true;
//        }
//        if(o==null|| getClass()!=o.getClass()){
//            return false;
//        }
//        Answer answer = (Answer) o;
//        return answer_id == answer.answer_id && question_id == answer.question_id
//                && is_correct ==answer.is_correct &&choice_list.equals(answer.choice_list) &&
//                answer_text.equals(answer.answer_text);
//    }
    @Override
    public String toString(){
        return "Answer{"+
                "answer_id=" +answer_id +
                ", question_id=" +question_id +
                ", is_correct=" +is_correct +
                ", choice_list=" + choice_list +'\'';
    }
}