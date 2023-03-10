import Controller.QuizGameController;
import io.javalin.Javalin;

public class Application {
    public static void main(String[] args) {

        QuizGameController controller = new QuizGameController();
        Javalin app = controller.startAPI();
        app.start(8080);
    }


}
