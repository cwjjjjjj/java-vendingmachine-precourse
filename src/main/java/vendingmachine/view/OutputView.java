package vendingmachine.view;

public class OutputView {

    private static final String HAVING_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String HAVING_COIN_MESSAGE = "\n자판기가 보유한 동전";
    private static final String STOCK_MESSAGE = "\n상품명과 가격, 수량을 입력해 주세요.";
    private static final String PURCHASING_MONEY_MESSAGE = "\n투입 금액을 입력해 주세요.";

    public static void printHavingMoneyMessage() {
        System.out.println(HAVING_MONEY_MESSAGE);
    }
}
