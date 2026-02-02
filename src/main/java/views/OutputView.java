package views;

import domains.GameResult;

public class OutputView {
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printResult(GameResult result) {
        if (result.isNothing()) {
            System.out.println(NOTHING);
            return;
        }

        System.out.println(formatResult(result.getBalls(), result.getStrikes()));
    }

    private String formatResult(int balls, int strikes) {
        StringBuilder sb = new StringBuilder();

        if (balls > 0) {
            sb.append(balls).append(BALL).append(" ");
        }
        if (strikes > 0) {
            sb.append(strikes).append(STRIKE);
        }

        return sb.toString().trim();
    }

    public void printGameEnd() {
        System.out.println(GAME_END_MESSAGE);
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}