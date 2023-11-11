package tn.esprit.devops_project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devops_project.dto.InvoiceDetailDto;
import tn.esprit.devops_project.dto.OperatorDto;
import tn.esprit.devops_project.dto.ProductDto;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.services.Iservices.IOperatorService;

import java.util.List;

@RestController
@AllArgsConstructor
public class OperatorController {

	IOperatorService operatorService;
	
	@GetMapping("/operator")
	public List<Operator> getOperators() {
		return operatorService.retrieveAllOperators();
	}

	@GetMapping("/operator/{operatorId}")
	public Operator retrieveoperator(@PathVariable Long operatorId) {
		return operatorService.retrieveOperator(operatorId);
	}

	@PostMapping("/operator")
	public OperatorDto addOperator(@RequestBody OperatorDto operatorDTO) {
		Operator operator = convertDTOToEntity(operatorDTO);
		return OperatorDto.fromEntity(operatorService.addOperator(operator));
	}

	@DeleteMapping("/operatot/{operatorId}")
	public void removeOperator(@PathVariable Long operatorId) {
		operatorService.deleteOperator(operatorId);
	}

	@PutMapping("/operator")
	public OperatorDto modifyOperateur(@RequestBody OperatorDto operatorDTO) {
		Operator operator = convertDTOToEntity(operatorDTO);
		return OperatorDto.fromEntity(operatorService.updateOperator(operator));
	}


	private Operator convertDTOToEntity(OperatorDto operatorDTO) {
		Operator operator = new tn.esprit.devops_project.entities.Operator();
		operator.setIdOperateur(operatorDTO.getIdOperateur());
		operator.setFname(operatorDTO.getFname());
		operator.setLname(operatorDTO.getLname());
		operator.setPassword(operatorDTO.getPassword());
		// Convert set of InvoiceDTOs to set of Invoice entities
		// Assume you have a similar conversion method for InvoiceDTOs
		// operator.setInvoices(convertInvoicesToEntities(operatorDTO.getInvoices()));
		// Set other properties as needed
		return operator;
	}
}
