package tn.esprit.devops_project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;
import tn.esprit.devops_project.services.ProductServiceImpl;
import tn.esprit.devops_project.services.Iservices.IProductService;
import tn.esprit.devops_project.entities.Stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductTest {

    private IProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private StockRepository stockRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        productService = new ProductServiceImpl(productRepository, stockRepository);
    }

    @Test
    public void testAddProduct() {
        Stock stock = new Stock();
        stock.setIdStock(1L);
        Product product = new Product();
        product.setIdProduct(1L);
        product.setStock(stock);

        when(stockRepository.findById(1L)).thenReturn(Optional.of(stock));
        when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);

        Product addedProduct = productService.addProduct(product, 1L);

        assertEquals(product, addedProduct);
        verify(stockRepository, times(1)).findById(1L);
        verify(productRepository, times(1)).save(Mockito.any(Product.class));
    }

    @Test
    public void testRetrieveProductByCategory() {
        ProductCategory category = ProductCategory.ELECTRONICS;
        List<Product> productList = new ArrayList<>();

        when(productRepository.findByCategory(category)).thenReturn(productList);

        List<Product> retrievedProducts = productService.retrieveProductByCategory(category);

        assertEquals(productList, retrievedProducts);
        verify(productRepository, times(1)).findByCategory(category);
    }
}