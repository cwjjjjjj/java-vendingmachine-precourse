package vendingmachine.controller;

import static vendingmachine.view.InputView.input;
import static vendingmachine.view.OutputView.printOrderMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import vendingmachine.model.Product;
import vendingmachine.model.Products;

public class ProductController {

    public Products initStock() {
        printOrderMessage();
        return makeProductList();
    }

    private Products makeProductList() {
        String stockInput = input();
        StringTokenizer semicolonSt = new StringTokenizer(stockInput, ";");
        List<Product> products = new ArrayList<>();
        return processProductInput(semicolonSt, products);
    }

    private Products processProductInput(StringTokenizer semicolonSt, List<Product> productList) {
        while (semicolonSt.hasMoreTokens()) {
            String processingInput = semicolonSt.nextToken();
            processingInput = processingInput.replace("[", "").replace("]", "");
            String name = processingInput.split(",")[0];
            int price = Integer.parseInt(processingInput.split(",")[1]);
            int stock = Integer.parseInt(processingInput.split(",")[2]);
            productList.add(new Product(name, price, stock));
        }
        return new Products(productList);
    }
}
