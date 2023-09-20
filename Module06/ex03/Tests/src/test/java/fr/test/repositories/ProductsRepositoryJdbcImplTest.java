package fr.test.repositories;

import fr.test.models.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImplTest {
    //expected
    private ProductsRepository productsRepositoryImpl = null;
    private EmbeddedDatabase dataSource = null;


    @BeforeEach
    public void init() {
        dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL) // Specify the database type
                .addScript("schema.sql") // Optional: Initialize with SQL scripts
                .addScript("data.sql") // Optional: Initialize with SQL scripts
                .build();
        productsRepositoryImpl = new ProductsRepositoryJdbcImpl(dataSource);
    }

    private final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(
            new Product(1L, "product1", 100),
            new Product(2L, "product2", 200),
            new Product(3L, "product3", 300),
            new Product(4L, "product4", 400),
            new Product(5L, "product5", 500)
    );

    final Product EXPECTED_UPDATED_PRODUCT = new Product(1L, "updatedProduct1", 150);

    final Product EXPECTED_INSERTED_PRODUCT = new Product(6L, "Product6", 600);

    @Test
    public  void itShouldReturnAllProduct() {
        //given

        //when

        List<Product> results = productsRepositoryImpl.findAll();
        //then
        assertIterableEquals(EXPECTED_FIND_ALL_PRODUCTS, results);

    }

    @ParameterizedTest
    @ValueSource(longs = { 1 , 2, 3, 4, 5})
    void itShouldReturnProductWithThisId(long id) {
        //given

        //when
        Optional<Product> result = productsRepositoryImpl.findById(id);

        //then
        Product expedtedProduct = null;
        if (id <= EXPECTED_FIND_ALL_PRODUCTS.size())
                expedtedProduct = EXPECTED_FIND_ALL_PRODUCTS.get((int)id - 1);

        assertTrue(result.isPresent());
        assertEquals(expedtedProduct, result.get());
    }

    @ParameterizedTest
    @ValueSource(longs = { 0 , 10, 99, -99})
    void itShouldReturnEmptyWhenNoProductHaveThisId(long id) {
        //given


        //when
        Optional<Product> result = productsRepositoryImpl.findById(id);

        //then
        Optional<Product> expedtedProduct = Optional.empty();

        assertFalse(result.isPresent());
        assertEquals(expedtedProduct, result);
    }

    @Test
    void itShouldUpdateProductThatExit() {
        //given
        Product product = new Product(1L, EXPECTED_UPDATED_PRODUCT.getName(), EXPECTED_UPDATED_PRODUCT.getPrice());

        //when
        productsRepositoryImpl.update(product);
        Optional<Product> updatedProduct = productsRepositoryImpl.findById(product.getId());
        //then

        assertTrue(updatedProduct.isPresent());
        assertEquals(EXPECTED_UPDATED_PRODUCT, updatedProduct.get());
    }
    @ParameterizedTest
    @ValueSource(longs = { 0 , -1, 99, 10})
    void itShouldDoNothingWhenUpdateProductThatNotExit(long id) {
        //given
        Product product = new Product(id, "updatedProduct1", 250);

        //when
        productsRepositoryImpl.update(product);
        Optional<Product> updatedProduct = productsRepositoryImpl.findById(product.getId());
        //then

        assertFalse(updatedProduct.isPresent());
        assertEquals(Optional.empty(), updatedProduct);
    }


    @Test
    void isShouldAddProduct() {
        //given
        Product product =  new Product();
        product.setName(EXPECTED_INSERTED_PRODUCT.getName());
        product.setPrice(EXPECTED_INSERTED_PRODUCT.getPrice());

        //when
        productsRepositoryImpl.save(product);

        //then
        assertEquals(EXPECTED_INSERTED_PRODUCT.getId(), product.getId());
        Optional<Product> savedProduct = productsRepositoryImpl.findById(product.getId());

        assertTrue(savedProduct.isPresent());
        assertEquals(EXPECTED_INSERTED_PRODUCT, savedProduct.get());
    }


    @ParameterizedTest
    @ValueSource(longs = { 1 , 2, 3, 4, 5})
    void itShouldDeleteProductThatExist(long id) {
        //given

        //when
        productsRepositoryImpl.delete(id);
        //then
        Optional<Product> expected = Optional.empty();
        Optional<Product> deletedProduct = productsRepositoryImpl.findById(id);

        assertFalse(deletedProduct.isPresent());
        assertEquals(expected, deletedProduct);
    }


    @ParameterizedTest
    @ValueSource(longs = { 0 , -1, 99, 10})
    void itShouldDoNothingWhenDeleteProductThatNotExit(long id) {
        //given

        //when
        productsRepositoryImpl.delete(id);
        List<Product> results = productsRepositoryImpl.findAll();
        //then
        Optional<Product> expected = Optional.empty();
        assertIterableEquals(EXPECTED_FIND_ALL_PRODUCTS, results);
    }




    @AfterEach
    void destroy() {
        this.dataSource.shutdown();
    }

}
