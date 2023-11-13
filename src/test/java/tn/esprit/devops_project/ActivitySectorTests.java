package tn.esprit.devops_project;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.ActivitySector;
import tn.esprit.devops_project.repositories.ActivitySectorRepository;
import tn.esprit.devops_project.services.ActivitySectorImpl;

import java.util.Optional;

public class ActivitySectorTests {

    @InjectMocks
    ActivitySectorImpl service;

    @Mock
    ActivitySectorRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddActivitySector() {
        ActivitySector sector = new ActivitySector(1L, "S01", "Finance", null);
        when(repository.save(any(ActivitySector.class))).thenReturn(sector);
        ActivitySector created = service.addActivitySector(sector);
        assertNotNull(created);
        assertEquals(sector.getIdSecteurActivite(), created.getIdSecteurActivite());
    }

    @Test
    public void testRetrieveActivitySector() {
        Long id = 1L;
        ActivitySector sector = new ActivitySector(id, "S01", "Finance", null);
        when(repository.findById(id)).thenReturn(Optional.of(sector));
        ActivitySector found = service.retrieveActivitySector(id);
        assertNotNull(found);
        assertEquals(id, found.getIdSecteurActivite());
    }
}
