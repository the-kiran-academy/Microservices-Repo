package com.jbk.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.exception.ResourceNotExistsException;
import com.jbk.model.SupplierModel;
import com.jbk.service.SupplierService;

@RestController
@RequestMapping("supplier")
public class SupplierController {

	@Autowired
	private SupplierService service;

	// add supplier

	@PostMapping("add-supplier")
	public ResponseEntity<String> addSupplier(@RequestBody @Valid SupplierModel supplierModel) {
		service.addSupplier(supplierModel);

		return ResponseEntity.ok("Supplier Added !!");
	}

	@GetMapping("get-supplier-by-id/{supplierId}")
	public ResponseEntity<SupplierModel> getSupplierById(@PathVariable long supplierId) {
		SupplierModel supplierModel = service.getSupplierById(supplierId);
		return ResponseEntity.ok(supplierModel);

	}
	
	@PutMapping("update-supplier")
	public ResponseEntity<String> updateSupplier(@RequestBody @Valid SupplierModel supplierModel) throws Exception{
		
	boolean isUpdated=	service.updateSupplier(supplierModel);
	if(isUpdated) {
		return ResponseEntity.ok("Supplier Updated !!");
	}
	else{
		//return ResponseEntity.ok("Supplier Not Exists with ID : " + supplierModel.getSupplierId());
		throw new ResourceNotExistsException("Supplier Not Exists with ID : " + supplierModel.getSupplierId());

	}
		
		
	}
}
