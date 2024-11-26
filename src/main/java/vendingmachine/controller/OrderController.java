package vendingmachine.controller;

import static vendingmachine.controller.ProductController.minPrice;
import static vendingmachine.controller.ProductController.validateEmptyStock;
import static vendingmachine.model.Products.getProductByName;
import static vendingmachine.view.InputView.input;
import static vendingmachine.view.OutputView.printPurchasingItemMessage;
import static vendingmachine.view.OutputView.printPurchasingMoney;

import vendingmachine.model.Product;
import vendingmachine.model.Products;

public class OrderController {

    public void makeOrder(Products products, int purchasingMoney) {
        while (validateEmptyStock(products) && purchasingMoney > minPrice(products)) {
            printPurchasingMoney(purchasingMoney);
            //투입금액(남은금액) 출력
            printPurchasingItemMessage();
            String purchasingItemName = input();
            Product purchasingItem = getProductByName(purchasingItemName);
            purchasingMoney -= purchasingItem.getPrice();
        }
        giveChange();
    }

    public void giveChange() {
        
    }
}
