package Views;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    // 3자리 숫자 입력 받기
    public String readNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextLine();
    }

    // 재시작 또는 종료 버튼 입력 받기 (1 또는 2)
    public String readRestartCommand() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scanner.nextLine();
    }
}
