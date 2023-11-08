package tn.esprit.devops_project.services;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.StockRepository;
import tn.esprit.devops_project.services.Iservices.IStockService;

import javax.transaction.Transactional;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class StockServiceImplTest {
    @InjectMocks
    StockServiceImpl iStockService;
    @Mock
    StockRepository stockRepository;

    Stock stock1 = new Stock(1L,"NEW STOCK TEST 1",null);
    List<Stock> listStock = new ArrayList<Stock>() {
        {
            add( new Stock(2L,"NEW STOCK TEST 2",null));
            add( new Stock(3L,"NEW STOCK TEST 3",null));
        }
    };
    @Test
    void addStock() {
        Mockito.when(stockRepository.save(stock1)).thenReturn(stock1);

        Stock stockAjoute = iStockService.addStock(stock1);

        assertEquals("NEW STOCK TEST 1", stockAjoute.getTitle());
    }
    @Test
     void retrieveStock() {
       Stock stock = stockRepository.save(stock1);
       Stock retrievedStock = iStockService.retrieveStock(stock.getIdStock());
        assertNotNull(retrievedStock);
        assertEquals("NEW STOCK TEST 1", retrievedStock.getTitle());
       /* Mockito.when(stockRepository.findById(1L)).thenReturn(Optional.of(stock1));
        Stock stock = iStockService.retrieveStock(1L);
        assertNotNull(stock);*/
    }

    @Test
     void retrieveAllStock() {
        Mockito.when(stockRepository.findAll()).thenReturn(listStock);
        List<Stock> stocksRetournes = iStockService.retrieveAllStock();
        assertEquals(2, stocksRetournes.size());
        assertEquals(2L, stocksRetournes.get(0).getIdStock());
        assertEquals(3L, stocksRetournes.get(1).getIdStock());
    }
    @Test
    void deleteStock(){
        iStockService.deleteStock(1L);
        Mockito.verify(stockRepository).deleteById(1L);
    }

    @Test
    void updateStock(){
        Stock updatedStock = new Stock(1L,"NEW STOCK updated !",null);
        iStockService.updateStock(updatedStock);
        Mockito.verify(stockRepository).save(updatedStock);
    }
}