package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static int inputInteger() {
        return Integer.parseInt(input());
    }

    public static String input() {
        return readLine();
    }
}
