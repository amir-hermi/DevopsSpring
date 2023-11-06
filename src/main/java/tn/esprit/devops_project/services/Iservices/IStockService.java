package tn.esprit.devops_project.services.Iservices;

import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.entities.Supplier;

import java.util.List;

public interface IStockService {

    Stock addStock(Stock stock);
    Stock retrieveStock(Long id);
    List<Stock> retrieveAllStock();
    void deleteStock(Long id);
    Stock updateStock(Stock stock);

}
