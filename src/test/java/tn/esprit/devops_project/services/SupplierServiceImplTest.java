package tn.esprit.devops_project.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
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
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SupplierServiceImplTest {


    Long idSupplier;
    String code;
    String label;
    @Enumerated(EnumType.STRING)
    SupplierCategory supplierCategory;
    @OneToMany(mappedBy="supplier")
    @JsonIgnore
    Set<Invoice> invoices;
    @ManyToMany
    private Set<ActivitySector> activitySectors;




    @InjectMocks
    SupplierServiceImpl isupplierService;
    @Mock
    SupplierRepository supplierRepository;

    Supplier supp1 = new Supplier(1L , "code1" ,"label" , SupplierCategory.ORDINAIRE , null , null  ) ;
    List<Supplier> listsupplier = new ArrayList<Supplier>() {
        {
            add( new Supplier(2L , "code1" ,"label" , SupplierCategory.ORDINAIRE , null , null  ) );
            add( new Supplier(3L , "code1" ,"label" , SupplierCategory.ORDINAIRE , null , null  ) );

        }
    };


//
//    @Test
//    void retrieveAllSuppliers() {
//    }

    @Test
    void addSupplier() {

        Mockito.when(supplierRepository.save(supp1)).thenReturn(supp1);

        Supplier supplierAjoute = isupplierService.addSupplier(supp1);

        assertEquals("code1", supplierAjoute.getCode());

    }

//    @Test
//    void updateSupplier() {
//    }
//
//    @Test
//    void deleteSupplier() {
//    }
//
//    @Test
//    void retrieveSupplier() {
//    }
}