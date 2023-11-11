package tn.esprit.devops_project.dto;

import lombok.*;
import tn.esprit.devops_project.entities.SupplierCategory;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDto implements Serializable {
    private static final long serialVersionUID = 1L;

    Long idSupplier;
    String code;
    String label;
    SupplierCategory supplierCategory;
    Set<SupplierDto> invoices;
    Set<ActivitySectorDto> activitySectors;

    // Constructors, getters, and setters

    // Additional constructor to convert from entity to DTO
    public SupplierDto(tn.esprit.devops_project.entities.Supplier supplier) {
        this.idSupplier = supplier.getIdSupplier();
        this.code = supplier.getCode();
        this.label = supplier.getLabel();
        this.supplierCategory = supplier.getSupplierCategory();
        // Convert set of Invoice entities to set of InvoiceDTOs
        // Assume you have a similar conversion method for Invoice entities
        // this.invoices = convertInvoicesToDTOs(supplier.getInvoices());
        // Convert set of ActivitySector entities to set of ActivitySectorDTOs
        // Assume you have a similar conversion method for ActivitySector entities
        // this.activitySectors = convertActivitySectorsToDTOs(supplier.getActivitySectors());
    }

    // Additional static method for conversion if needed
    public static SupplierDto fromEntity(tn.esprit.devops_project.entities.Supplier supplier) {
        return new SupplierDto(supplier);
    }

    // Method to convert DTO to entity if needed
    public static tn.esprit.devops_project.entities.Supplier toEntity(SupplierDto supplierDTO) {
        tn.esprit.devops_project.entities.Supplier supplier = new tn.esprit.devops_project.entities.Supplier();
        supplier.setIdSupplier(supplierDTO.getIdSupplier());
        supplier.setCode(supplierDTO.getCode());
        supplier.setLabel(supplierDTO.getLabel());
        supplier.setSupplierCategory(supplierDTO.getSupplierCategory());
        // Convert set of InvoiceDTOs to set of Invoice entities
        // Assume you have a similar conversion method for InvoiceDTOs
        // supplier.setInvoices(convertInvoicesToEntities(supplierDTO.getInvoices()));
        // Convert set of ActivitySectorDTOs to set of ActivitySector entities
        // Assume you have a similar conversion method for ActivitySectorDTOs
        // supplier.setActivitySectors(convertActivitySectorsToEntities(supplierDTO.getActivitySectors()));
        // Set other properties as needed
        return supplier;
    }
}
