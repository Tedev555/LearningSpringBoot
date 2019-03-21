package com.tedory.learning;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/main_path")
public class ProductServiceController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ObjectMapper mapper;
    private static Map<String, Product> productRepo = new HashMap<>();
    static {
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);

        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);
    }

    //Default HTTP request is GET method. not require any Request Body
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<Object> getProduct() throws JsonProcessingException {
        logger.info("Get products: \n" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(productRepo.values()));
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }

    //Using HTTP request POST. require parameter
    @RequestMapping(value = "/create_product", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) throws JsonProcessingException {
        productRepo.put(product.getId(), product);
        logger.info("Create product: \n" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(product));
        return new ResponseEntity<>(productRepo.values(), HttpStatus.CREATED);
    }

    //Using Using HTTP request PUT method. require parameter
    @RequestMapping(value = "/update_product/{id}", method = RequestMethod.PUT)
    public  ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) throws JsonProcessingException {
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
        logger.info("Update product: \n" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(product));
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }

    //Using HTTP request DELETE method. no require parameter
    @RequestMapping(value = "/delete_product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id) throws JsonProcessingException {
        Product delProduct = productRepo.get(id);
        productRepo.remove(id);
        logger.info("Delete product: \n" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(delProduct));
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }
}
