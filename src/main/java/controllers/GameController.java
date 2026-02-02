package controllers;

import domains.BaseballNumbers;
import domains.GameResult;
import domains.NumberGenerator;
import domains.Validator;
import views.InputView;
import views.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView; // 출력 담당 클래스 (가정)
    private BaseballNumbers computerNumbers;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        do {
            playGame();
        } while (isRestartRequested());
    }

    private void playGame() {
        // 1. 컴퓨터 숫자 생성
        computerNumbers = NumberGenerator.generate();
        boolean isGameWon = false;
        // 2. 맞출 때까지 반복
        while (!isGameWon) {
            isGameWon = playTurn(computerNumbers); // 루프 내부 로직 분리 (15라인 제한 준수)
        }
        outputView.printGameEnd();
    }

    private boolean playTurn(BaseballNumbers computerNumbers) {
        try {
            String input = inputView.readNumbers();
            Validator.validateInput(input);
            GameResult result = computerNumbers.compare(parseInput(input));
            outputView.printResult(result);
            return result.isThreeStrike();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage()); // UI 일관성 유지
            return false;
        }
    }

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

    private List<Integer> parseInput(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            // 문자 '1'을 숫자 1로 변환해서 리스트에 추가
            numbers.add(Character.getNumericValue(c));
        }
        return numbers;
    }
}