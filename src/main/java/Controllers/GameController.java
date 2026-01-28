package Controllers;

import Domains.Validator;
import Views.InputView;

public class GameController {
    private final InputView inputView;

    public GameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        do {
            playGame();
        } while (isRestartRequested());
    }

    private void playGame() { }

    private boolean isRestartRequested() {
        try {
            String command = inputView.readRestartCommand();
            Validator.validateRestartCommand(command);
            return command.equals("1");
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return isRestartRequested(); // 잘못 입력하면 재귀적으로 다시 물어봄
        }
    }
}