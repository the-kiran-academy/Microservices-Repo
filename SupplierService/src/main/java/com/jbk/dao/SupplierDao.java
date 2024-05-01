package com.jbk.dao;

import com.jbk.entity.SupplierEntity;

public interface SupplierDao {
	
	public boolean addSupplier(SupplierEntity supplierEntity);

	public SupplierEntity getSupplierById(long supplierId);
	
	public boolean updateSupplier(SupplierEntity supplierEntity);
}
