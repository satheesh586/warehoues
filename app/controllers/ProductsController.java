package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Product;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import repository.ProductDAO;
import java.util.Set;

import static play.data.Form.form;

/**
 * Created by satheesh on 9/6/17.
 */
public class ProductsController extends Controller {

    static ProductDAO productDao = new ProductDAO();

    private static final Form<Product> productForm = form(Product.class);

    public static Result list() {
        Set<Product> productsList = productDao.listAll();
        return ok(views.html.list.render(productsList));
    }
    public static Result newProduct() {
        return ok(views.html.form.render(productForm));
    }

    public static Result details(String ean) {
        JsonNode jsonData = Json.toJson(productDao.findByEan(ean));
        return ok(jsonData);
    }

    public static Result save() {
        Form<Product> boundForm = productForm.bindFromRequest();
        Product product = boundForm.get();
        Product.getProducts().add(product);
        return ok(String.format("Saved product %s", product));
    }
}
