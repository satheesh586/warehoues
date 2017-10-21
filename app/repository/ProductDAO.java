package repository;

import models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by satheesh on 19/10/17.
 */
public class ProductDAO {

    public static Set<Product> listAll() {
        return Product.products;
    }

    public static Product findByEan(String ean) {
        for (Product candidate : Product.products) {
            if (candidate.ean.equals(ean)) {
                return candidate;
            }
        }
        return null;
    }

    public static List<Product> findByName(String name) {
        List<Product> results = new ArrayList<Product>();
        for (Product candidate : Product.products) {
            if (candidate.name.toLowerCase().contains(name.toLowerCase())) {
                results.add(candidate);
            }
        }
        return results;
    }

    public static boolean remove(Product product) {
        return Product.products.remove(product);
    }

    public void save(Product receivedProduct) {
        Product.products.add(receivedProduct);
    }
}
