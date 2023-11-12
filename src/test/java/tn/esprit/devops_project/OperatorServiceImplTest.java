package tn.esprit.devops_project;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.services.OperatorServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class OperatorServiceImplTest {

    @Mock
    private OperatorRepository operatorRepository;

    @InjectMocks
    private OperatorServiceImpl operatorService;

    @Test
    void retrieveAllOperators() {
        // Arrange
        Operator operator1 = new Operator(1L, "John", "Doe", "password", null);
        Operator operator2 = new Operator(2L, "Jane", "Doe", "password", null);

        when(operatorRepository.findAll()).thenReturn(Arrays.asList(operator1, operator2));

        // Act
        List<Operator> operators = operatorService.retrieveAllOperators();

        // Assert
        assertEquals(2, operators.size());
        assertEquals(operator1, operators.get(0));
        assertEquals(operator2, operators.get(1));
    }

    @Test
    void retrieveOperator() {
        // Arrange
        Long operatorId = 1L;
        Operator operator = new Operator(operatorId, "John", "Doe", "password", null);

        when(operatorRepository.findById(operatorId)).thenReturn(Optional.of(operator));

        // Act
        Operator retrievedOperator = operatorService.retrieveOperator(operatorId);

        // Assert
        assertEquals(operator, retrievedOperator);
    }

    // Add more test methods for other service methods (addOperator, deleteOperator, updateOperator) if needed.
}
