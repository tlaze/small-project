import Controller.QuizGameController;
import io.javalin.Javalin;
import Util.ConnectionSingleton;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) {
//        this line is just for testing that your tables get set up correctly
//        if not, you'll get a stack trace

        QuizGameController controller = new QuizGameController();
        Javalin app = controller.startAPI();
        app.start(8080);
    }


}
