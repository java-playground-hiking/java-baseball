import study.model.Baseball;
import study.model.BaseballAnswer;
import study.model.BaseballScore;
import study.model.BaseballUser;
import study.view.ResultView;

public class BaseballApplication {
    public static void main(String[] args) {
        BaseballUser user = new BaseballUser("123");
        Baseball baseball = new Baseball(new BaseballScore(), new BaseballAnswer());
        BaseballScore score = baseball.play(user);

        ResultView resultView = new ResultView();
        System.out.println(resultView.printScore(score));
    }
}
