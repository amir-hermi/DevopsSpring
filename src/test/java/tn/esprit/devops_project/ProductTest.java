package tn.esprit.devops_project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;
import tn.esprit.devops_project.services.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductTest {
    @MockBean
    private ProductRepository productRepository;
    @MockBean
    private StockRepository stockRepository;

   @Autowired
    private ProductServiceImpl productServiceImpl;

    @Test
    void testRetrieveAllProducts() {
        List<Product> productList = new ArrayList<>();
        when(productRepository.findAll()).thenReturn(productList);
        List<Product> actualRetrieveAllProductResult = productServiceImpl.retreiveAllProduct();
        assertSame(productList, actualRetrieveAllProductResult);
        assertTrue(actualRetrieveAllProductResult.isEmpty());
        verify(productRepository).findAll();
    }

    @Test
    void testDeleteProduct() {
        doNothing().when(productRepository).deleteById(any(Long.class));
        productServiceImpl.deleteProduct(123L);
        verify(productRepository).deleteById(any(Long.class));
    }
}