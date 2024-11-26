package vendingmachine.model;

import java.util.List;

public class Products {

    private static List<Product> products;

    public Products(List<Product> productList) {
        this.products = productList;
    }

    public List<Product> getProducts() {
        return products;
    }

    public static Product getProductByName(String name) {
        return products.stream().filter(product -> product.getName().equals(name)).findFirst()
            .orElse(null);
    }
}
