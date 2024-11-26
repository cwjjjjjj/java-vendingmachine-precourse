package vendingmachine;

import vendingmachine.controller.CoinController;
import vendingmachine.controller.MoneyController;
import vendingmachine.controller.OrderController;
import vendingmachine.controller.ProductController;
import vendingmachine.model.Products;

public class Application {
    public static void main(String[] args) {
        CoinController coinController = new CoinController();
        ProductController productController = new ProductController();
        MoneyController moneyController = new MoneyController();
        OrderController orderController = new OrderController();

        int[] coins = coinController.initMoney();
        Products products = productController.initStock();
        int money = moneyController.receiveMoney();
        orderController.makeOrder(products, money);
    }
}
