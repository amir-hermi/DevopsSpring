package tn.esprit.devops_project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devops_project.dto.InvoiceDto;
import tn.esprit.devops_project.dto.SupplierDto;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.services.Iservices.IInvoiceService;

import java.util.Date;
import java.util.List;


@RestController
@AllArgsConstructor
public class InvoiceController {

    IInvoiceService invoiceService;

    @GetMapping("/invoice")
    public List<Invoice> getInvoices() {
       return invoiceService.retrieveAllInvoices();
    }

    @GetMapping("/invoice/{invoiceId}")
    public Invoice retrieveInvoice(@PathVariable Long invoiceId) {
        return invoiceService.retrieveInvoice(invoiceId);
    }

    @PutMapping("/invoice/{invoiceId}")
    public void cancelInvoice(@PathVariable Long invoiceId) {
        invoiceService.cancelInvoice(invoiceId);
    }

    @GetMapping("/invoice/supplier/{supplierId}")
    public List<Invoice> getInvoicesBySupplier(@PathVariable Long supplierId) {
        return invoiceService.getInvoicesBySupplier(supplierId);
    }

    @PutMapping(value = "/invoice/operator/{idOperator}/{idInvoice}")
    public void assignOperatorToInvoice(@PathVariable Long idOperator,@PathVariable Long idInvoice) {
        invoiceService.assignOperatorToInvoice(idOperator, idInvoice);
    }

    @GetMapping("/invoice/price/{startDate}/{endDate}")
    public float getTotalAmountInvoiceBetweenDates(@PathVariable Date startDate,@PathVariable Date endDate){
        return invoiceService.getTotalAmountInvoiceBetweenDates(startDate, endDate);
    }
    private Invoice convertDTOToEntity(InvoiceDto invoiceDTO) {
        Invoice invoice = new tn.esprit.devops_project.entities.Invoice();
        invoice.setIdInvoice(invoiceDTO.getIdInvoice());
        invoice.setAmountDiscount(invoiceDTO.getAmountDiscount());
        invoice.setAmountInvoice(invoiceDTO.getAmountInvoice());
        invoice.setDateCreationInvoice(invoiceDTO.getDateCreationInvoice());
        invoice.setDateLastModificationInvoice(invoiceDTO.getDateLastModificationInvoice());
        invoice.setArchived(invoiceDTO.getArchived());
        // Convert set of InvoiceDetailDTOs to set of InvoiceDetail entities
        // Assume you have a similar conversion method for InvoiceDetailDTOs
        // invoice.setInvoiceDetails(convertInvoiceDetailsToEntities(invoiceDTO.getInvoiceDetails()));
        invoice.setSupplier(SupplierDto.toEntity(invoiceDTO.getSupplier()));
        // Set other properties as needed
        return invoice;
    }


}
