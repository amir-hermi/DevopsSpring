package tn.esprit.devops_project.dto;

import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDetailDto implements Serializable {
    private static final long serialVersionUID = 1L;

    Long idInvoiceDetail;
    int quantity;
    float price;
    ProductDto product;

    // Constructors, getters, and setters

    // Additional constructor to convert from entity to DTO
    public InvoiceDetailDto(tn.esprit.devops_project.entities.InvoiceDetail invoiceDetail) {
        this.idInvoiceDetail = invoiceDetail.getIdInvoiceDetail();
        this.quantity = invoiceDetail.getQuantity();
        this.price = invoiceDetail.getPrice();
        this.product = ProductDto.fromEntity(invoiceDetail.getProduct());
    }

    // Additional static method for conversion if needed
    public static InvoiceDetailDto fromEntity(tn.esprit.devops_project.entities.InvoiceDetail invoiceDetail) {
        return new InvoiceDetailDto(invoiceDetail);
    }
}
