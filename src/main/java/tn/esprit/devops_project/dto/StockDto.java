package tn.esprit.devops_project.dto;

import lombok.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockDto implements Serializable {
    private static final long serialVersionUID = 1L;

    long idStock;
    String title;
    Set<StockDto> products;

    // Constructors, getters, and setters

    // Additional constructor to convert from entity to DTO
    public StockDto(tn.esprit.devops_project.entities.Stock stock) {
        this.idStock = stock.getIdStock();
        this.title = stock.getTitle();
        // Convert set of Product entities to set of ProductDTOs
        // Assume you have a similar conversion method for Product entities
        // this.products = convertProductsToDTOs(stock.getProducts());
    }

    // Additional static method for conversion if needed
    public static StockDto fromEntity(tn.esprit.devops_project.entities.Stock stock) {
        return new StockDto(stock);
    }

    // Method to convert DTO to entity if needed
    public static tn.esprit.devops_project.entities.Stock toEntity(StockDto stockDTO) {
        tn.esprit.devops_project.entities.Stock stock = new tn.esprit.devops_project.entities.Stock();
        stock.setIdStock(stockDTO.getIdStock());
        stock.setTitle(stockDTO.getTitle());
        // Convert set of ProductDTOs to set of Product entities
        // Assume you have a similar conversion method for ProductDTOs
        // stock.setProducts(convertProductsToEntities(stockDTO.getProducts()));
        // Set other properties as needed
        return stock;
    }
}
