package tn.esprit.devops_project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto implements Serializable {
    private static final long serialVersionUID = 1L;

    Long idInvoice;
    float amountDiscount;
    float amountInvoice;
    Date dateCreationInvoice;
    Date dateLastModificationInvoice;
    Boolean archived;
    Set<InvoiceDetailDto> invoiceDetails;
    SupplierDto supplier;

    // Constructors, getters, and setters

    // Additional constructor to convert from entity to DTO
    public InvoiceDto(tn.esprit.devops_project.entities.Invoice invoice) {
        this.idInvoice = invoice.getIdInvoice();
        this.amountDiscount = invoice.getAmountDiscount();
        this.amountInvoice = invoice.getAmountInvoice();
        this.dateCreationInvoice = invoice.getDateCreationInvoice();
        this.dateLastModificationInvoice = invoice.getDateLastModificationInvoice();
        this.archived = invoice.getArchived();
        // Convert set of InvoiceDetail entities to set of InvoiceDetailDTOs
        // Assume you have a similar conversion method for InvoiceDetail entities
        // this.invoiceDetails = convertInvoiceDetailsToDTOs(invoice.getInvoiceDetails());
        this.supplier = SupplierDto.fromEntity(invoice.getSupplier());
    }

    // Additional static method for conversion if needed
    public static InvoiceDto fromEntity(tn.esprit.devops_project.entities.Invoice invoice) {
        return new InvoiceDto(invoice);
    }
}
