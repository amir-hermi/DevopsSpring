package tn.esprit.devops_project.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.devops_project.entities.ActivitySector;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.entities.SupplierCategory;
import tn.esprit.devops_project.repositories.SupplierRepository;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SupplierServiceImplTest {

    @InjectMocks
    SupplierServiceImpl isupplierService;
    @Mock
    SupplierRepository supplierRepository;

    @Autowired
    SupplierServiceImpl supplierService;

    Supplier supp1 = new Supplier(1L , "code1" ,"label" , SupplierCategory.ORDINAIRE , null , null  ) ;
    List<Supplier> listsupplier = new ArrayList<Supplier>() {
        {
            add( new Supplier(2L , "code1" ,"label" , SupplierCategory.ORDINAIRE , null , null  ) );
            add( new Supplier(3L , "code1" ,"label" , SupplierCategory.ORDINAIRE , null , null  ) );

        }
    };

    @Test
    void retrieveAllSuppliers() {
        Mockito.when(supplierRepository.findAll()).thenReturn(listsupplier);
        List<Supplier> suppliersRetournes = isupplierService.retrieveAllSuppliers();
        assertEquals(2, suppliersRetournes.size());
        assertEquals(2L, suppliersRetournes.get(0).getIdSupplier());
        assertEquals(3L, suppliersRetournes.get(1).getIdSupplier());
    }

    @Test
    void addSupplier() {
        Mockito.when(supplierRepository.save(supp1)).thenReturn(supp1);
        Supplier supplierAjoute = isupplierService.addSupplier(supp1);
        assertEquals("code1", supplierAjoute.getCode());
    }

    @Test
    void retrieveSupplier() {
        Mockito.when(supplierRepository.findById(1L)).thenReturn(Optional.of(supp1));
        Supplier suppp = isupplierService.retrieveSupplier(1L);
        assertNotNull(suppp);

    }

    @Test
    void updateSupplier() {
        Supplier updatedSupplier = new Supplier(1L , "code1" ,"label" , SupplierCategory.ORDINAIRE , null , null  ) ;
        isupplierService.updateSupplier(updatedSupplier);
        Mockito.verify(supplierRepository).save(updatedSupplier);
    }

    @Test
    void deleteSupplier() {
        isupplierService.deleteSupplier(1L);
        Mockito.verify(supplierRepository).deleteById(1L);

    }



}