package Domains;

public class GameResult {
    private final int strikes;
    private final int balls;

    public GameResult(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public boolean isThreeStrike() {
        return strikes == 3;
    }

    public boolean isNothing() {
        return strikes == 0 && balls == 0;
    }

    // OutputView에서 사용하기 편하도록 Getter 제공
    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }
}