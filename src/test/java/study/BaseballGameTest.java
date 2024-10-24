package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BaseballGameTest {

    @Test
    @DisplayName("게임 진행을 위한 필요 데이터 생성")
    void plaGame(){
        // given
        String userInput = "123";

        // when
        BaseballGame game = new BaseballGame();
        BaseballScore score = game.playGame(userInput);

        // then
        assertNotNull(score);
    }
}
