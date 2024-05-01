package com.jbk.service;

import com.jbk.model.SupplierModel;

public interface SupplierService {
	
	public boolean addSupplier(SupplierModel supplierModel);
	
	public SupplierModel getSupplierById(long supplierId);
	
	public boolean updateSupplier(SupplierModel supplierModel);

}
