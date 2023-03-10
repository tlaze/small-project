package Model;
public class Answer {
    public int answer_id;
    public String choice_list;
    public boolean correct_answer;

    public Answer(int answer_id, String choice_list, boolean correct_answer){
        this.answer_id = answer_id;
        this.choice_list = choice_list;
        this.correct_answer = correct_answer;
    }
    @Override
    public String toString(){
        return "Answer{" +
                "answer_id= " +answer_id +
                " choice_list=" + choice_list +
                " correct_answer= " + correct_answer +'\''+'}';
    }
}