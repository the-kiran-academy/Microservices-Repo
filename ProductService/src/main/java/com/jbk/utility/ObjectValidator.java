package com.jbk.utility;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.jbk.exception.ResourceNotExistsException;
import com.jbk.exception.SomethingWentWrongException;
import com.jbk.model.CategoryModel;
import com.jbk.model.ProductModel;
import com.jbk.model.SupplierModel;

@Component
public class ObjectValidator {

	@Autowired
	private RestTemplate restTemplate;

	public Map<String, String> validateProduct(ProductModel productModel) {
		Map<String, String> validationMap = new HashMap<String, String>();

		String productName = productModel.getProductName();
		double productPrice = productModel.getProductPrice();
		int productQty = productModel.getProductQty();
		int deliveryCharges = productModel.getDeliveryCharges();
		long supplierId = productModel.getSupplierId();
		long categoryId = productModel.getCategoryId();

		if (productName == null || productName.trim().equals("")) {
			validationMap.put("Product Name", "Invalid Product Name");
		}

		if (productPrice <= 0) {
			validationMap.put("Product Price", "Product Price Must be Greater than 0");
		}

		if (productQty <= 0) {
			validationMap.put("Product Qty", "Product Qty Must be Greater than 0");
		}

		if (deliveryCharges < 0) {
			validationMap.put("Charges ", "Delivery Charges Should Not be Negative");
		}

		if (supplierId > 0) {
			try {
				//supplierService.getSupplierById(supplierId);
				
				try {
					SupplierModel supplierModel = restTemplate.getForObject(
							"http://SUPPLIER-SERVICE/supplier/get-supplier-by-id/" + productModel.getSupplierId(),
							SupplierModel.class);
					if(supplierModel==null || supplierModel.getSupplierId()<=0) {
						validationMap.put("Supplier", "Invalid Supplier Id");
					}


				} catch (ResourceAccessException e) {
					validationMap.put("Supplier", "Supplier Service is down");
				}

			} catch (ResourceNotExistsException e) {
				validationMap.put("Supplier", e.getMessage());
			} catch (SomethingWentWrongException e) {
				validationMap.put("Supplier", e.getMessage());
			}
		} else {
			validationMap.put("Supplier", "Invalid Supplier Id");
		}

		if (categoryId > 0) {
			try {
			//categoryService.getCategoryById(categoryId);
				try {
					CategoryModel categoryModel = restTemplate.getForObject(
							"http://CATEGORY-SERVICE/category/get-category-by-id/" + productModel.getCategoryId(),
							CategoryModel.class);
					if (categoryModel==null || categoryModel.getCategoryId() <= 0) {
						validationMap.put("Category", "Invalid Category Id");
					}
				} catch (ResourceAccessException e) {
					validationMap.put("Category", "Category Service is down");
				}
			} catch (ResourceNotExistsException e) {
				validationMap.put("Supplier", e.getMessage());
			} catch (SomethingWentWrongException e) {
				validationMap.put("Supplier", e.getMessage());
			}
		} else {
			validationMap.put("Supplier", "Invalid Supplier Id");
		}

		return validationMap;

	}

}
