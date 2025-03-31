package lesson6_1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductCatalog {
    private Map<String, BigDecimal> products;

    public ProductCatalog() {
        this.products = new HashMap<>();
    }

    public void addProduct(String name, BigDecimal price) {
        products.put(name, price);
    }

    public List<String> getProductNames() {
        return new ArrayList<>(products.keySet());
    }

    public BigDecimal getProductPrice(String name) {
        return products.getOrDefault(name, BigDecimal.ZERO);
    }
}