import app.BaseballApplication;
import base.Application;
import io.OutputHandler;

public class Main {

    public static void main(String[] args) {
        Application baseballApplication = new BaseballApplication();
        try {
            baseballApplication.startGame();
        } catch (Exception e) {
            OutputHandler.printDefaultExceptionMessage(e);
        }
    }
}
