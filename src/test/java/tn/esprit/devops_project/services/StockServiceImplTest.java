package tn.esprit.devops_project.services;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.StockRepository;
import tn.esprit.devops_project.services.Iservices.IStockService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class StockServiceImplTest {
    @InjectMocks
    IStockService iStockService;
    @Mock
    StockRepository stockRepository;


    @Test
    void addStock() {
        Stock stock = new Stock();
        stock.setTitle("NEW STOCK TEST");

        Set<Product> produits = new HashSet<>();
        Product produit1 = new Product();
        produit1.setTitle("Produit 1");
        produit1.setCategory(ProductCategory.ELECTRONICS);
        produit1.setPrice(200f);
        produit1.setQuantity(1);
        produit1.setStock(stock);
        produits.add(produit1);

        Product produit2 = new Product();
        produit2.setTitle("Produit 2 ");
        produit2.setCategory(ProductCategory.BOOKS);
        produit2.setPrice(800f);
        produit2.setQuantity(3);
        produit2.setStock(stock);
        produits.add(produit2);

        stock.setProducts(produits);

        Mockito.when(stockRepository.save(stock)).thenReturn(stock);

        Stock stockAjoute = iStockService.addStock(stock);

        assertNotNull(stockAjoute.getIdStock());
        assertEquals("Produit 1", stockAjoute.getTitle());
        assertEquals(2, stockAjoute.getProducts().size());

        // Vous pouvez également effectuer d'autres assertions si nécessaire

    }
}