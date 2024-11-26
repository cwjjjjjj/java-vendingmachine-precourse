package vendingmachine.controller;

import static vendingmachine.view.InputView.inputInteger;
import static vendingmachine.view.OutputView.printPurchasingMoneyMessage;

public class MoneyController {

    public int receiveMoney() {
        printPurchasingMoneyMessage();
        return inputInteger();
    }
}
