package tn.esprit.devops_project.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devops_project.dto.StockDto;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.services.Iservices.IStockService;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class StockController {

    IStockService stockService;

    @PostMapping("/stock")
    StockDto addStock(@RequestBody StockDto stockDTO){
        Stock stock = StockDto.toEntity(stockDTO);
        return StockDto.fromEntity(stockService.addStock(stock));
    }

    @GetMapping("/stock/{id}")
    Stock retrieveStock(@PathVariable Long id){
        return stockService.retrieveStock(id);
    }

    @GetMapping("/stock")
    List<Stock> retrieveAllStock(){
        return stockService.retrieveAllStock();
    }
    @GetMapping("/stock/delete/{id}")
    void deleteStock(@PathVariable Long id){
        stockService.deleteStock(id);
    }
    @GetMapping("/stock/update")
    StockDto updateStock(@RequestBody StockDto stockDto){
        Stock stock = StockDto.toEntity(stockDto);
        return StockDto.fromEntity(stockService.updateStock(stock));
    }


}
