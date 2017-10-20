package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Product;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import repository.ProductDAO;

import java.util.List;

/**
 * Created by satheesh on 9/6/17.
 */
public class Products extends Controller {

    static ProductDAO productDao = new ProductDAO();

    public static Result list() {
        List<Product> productsList = productDao.findAll();
        JsonNode jsonData = Json.toJson(productsList);
        return ok(jsonData);
    }
    public static Result newProduct() {
        return ok(views.html.main.render("satheesh", null));
    }

    public static Result details(String ean) {
        return productDao.findByEan(ea
    }
    public static Result save() {
        return TODO;
    }
}
