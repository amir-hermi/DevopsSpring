package tn.esprit.devops_project.dto;

import lombok.*;
import tn.esprit.devops_project.entities.ProductCategory;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {
    private static final long serialVersionUID = 1L;

    Long idProduct;
    String title;
    float price;
    int quantity;
    ProductCategory category;

    // Constructors, getters, and setters

    // Additional constructor to convert from entity to DTO
    public ProductDto(tn.esprit.devops_project.entities.Product product) {
        this.idProduct = product.getIdProduct();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
        this.category = product.getCategory();
    }

    // Additional static method for conversion if needed
    public static ProductDto fromEntity(tn.esprit.devops_project.entities.Product product) {
        return new ProductDto(product);
    }

    // Method to convert DTO to entity if needed
    public static tn.esprit.devops_project.entities.Product toEntity(ProductDto productDTO) {
        tn.esprit.devops_project.entities.Product product = new tn.esprit.devops_project.entities.Product();
        product.setIdProduct(productDTO.getIdProduct());
        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setCategory(productDTO.getCategory());
        // Set other properties as needed
        return product;
    }
}
