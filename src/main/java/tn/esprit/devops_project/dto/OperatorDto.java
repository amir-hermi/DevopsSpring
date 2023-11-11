package tn.esprit.devops_project.dto;

import lombok.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OperatorDto implements Serializable {
    private static final long serialVersionUID = 1L;

    Long idOperateur;
    String fname;
    String lname;
    String password;
    Set<InvoiceDto> invoices;

    // Constructors, getters, and setters

    // Additional constructor to convert from entity to DTO
    public OperatorDto(tn.esprit.devops_project.entities.Operator operator) {
        this.idOperateur = operator.getIdOperateur();
        this.fname = operator.getFname();
        this.lname = operator.getLname();
        this.password = operator.getPassword();
        // Convert set of Invoice entities to set of InvoiceDTOs
        // Assume you have a similar conversion method for Invoice entities
        // this.invoices = convertInvoicesToDTOs(operator.getInvoices());
    }

    // Additional static method for conversion if needed
    public static OperatorDto fromEntity(tn.esprit.devops_project.entities.Operator operator) {
        return new OperatorDto(operator);
    }
}
