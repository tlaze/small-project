package Model;
public class Answer {
    public int answer_id;
    public String choice_list;
    public String correct_answer;
    public Answer(){}
    public Answer(int answer_id, String choice_list, String correct_answer){
        this.answer_id = answer_id;
        this.choice_list = choice_list;
        this.correct_answer = correct_answer;
    }
    public int getAnswer_id(){
        return answer_id;
    }
    public String getChoice_list(){
        return choice_list;
    }
    public String getCorrect_answer(){
        return correct_answer;
    }
    @Override
    public String toString(){
        return "Answer{" +
                "answer_id= " +answer_id +
                " choice_list=" + choice_list +
                " correct_answer= " + correct_answer +'\''+'}';
    }
}