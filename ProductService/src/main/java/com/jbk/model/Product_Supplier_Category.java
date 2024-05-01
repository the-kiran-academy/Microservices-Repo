package com.jbk.model;

public class Product_Supplier_Category {

	private ProductModel productModel;
	private SupplierModel supplierModel;
	private CategoryModel categoryModel;

	public Product_Supplier_Category() {
		// TODO Auto-generated constructor stub
	}

	public Product_Supplier_Category(ProductModel productModel, SupplierModel supplierModel,
			CategoryModel categoryModel) {
		super();
		this.productModel = productModel;
		this.supplierModel = supplierModel;
		this.categoryModel = categoryModel;
	}

	public ProductModel getProductModel() {
		return productModel;
	}

	public void setProductModel(ProductModel productModel) {
		this.productModel = productModel;
	}

	public SupplierModel getSupplierModel() {
		return supplierModel;
	}

	public void setSupplierModel(SupplierModel supplierModel) {
		this.supplierModel = supplierModel;
	}

	public CategoryModel getCategoryModel() {
		return categoryModel;
	}

	public void setCategoryModel(CategoryModel categoryModel) {
		this.categoryModel = categoryModel;
	}

}
