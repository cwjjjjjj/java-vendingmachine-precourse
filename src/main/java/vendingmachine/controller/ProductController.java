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

    public static boolean validateEmptyStock(Products products) {
        //재고가 하나라도 있으면 진행 가능
        return products.getProducts().stream().anyMatch(product -> product.getStock() > 0);
    }

    public static int minPrice(Products products) {
        return products.getProducts().stream().mapToInt(Product::getPrice).min()
            .orElse(Integer.MAX_VALUE);
    }
}
