package vendingmachine.view;

import vendingmachine.model.Coin;

public class OutputView {

    private static final String HAVING_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String HAVING_COIN_MESSAGE = "\n자판기가 보유한 동전";
    private static final String ORDER_MESSAGE = "\n상품명과 가격, 수량을 입력해 주세요.";
    private static final String PURCHASING_MONEY_MESSAGE = "\n투입 금액을 입력해 주세요.";
    private static final String printForm = "%d원 -  %d개";

    public static void printHavingMoneyMessage() {
        System.out.println(HAVING_MONEY_MESSAGE);
    }

    public static void printCoins(int[] coins) {
        System.out.println(HAVING_COIN_MESSAGE);
        for (int i = 0; i < coins.length; i++) {
            System.out.println(String.format(printForm, Coin.values()[i].getAmount(), coins[i]));
        }
    }

    public static void printOrderMessage() {
        System.out.println(ORDER_MESSAGE);
    }

    public static void printPurchasingMoneyMessage() {
        System.out.println(PURCHASING_MONEY_MESSAGE);
    }
}
