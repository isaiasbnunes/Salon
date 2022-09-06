package net.bragadev.salon.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String barcode;
	private String unitOfMeasure;
	private double quantity;
	private String description;
	private double priceBuy;
	private double priceSale;
	
	
	@Column(nullable = false, columnDefinition = "TINYINT", length = 1)
	private boolean activeSales  = true;
	
	@Column(nullable = false, columnDefinition = "TINYINT", length = 1)
	private boolean payCommission  = true;
	
	@Column(nullable = false, columnDefinition = "TINYINT", length = 1)
	private boolean enabled = true;
	
	@ManyToOne(optional = false)
	private Distributor distributor;
	
	@ManyToOne(optional = false)
	private CategoryProduct category;
	
	@ManyToOne(optional = false)
	private Brand brand;

	
	public Product() {
	}
	
	public Product(Long id, String name, String barcode, String unitOfMeasure, double quantity, String description,
			double priceBuy, double priceSale, boolean activeSales, boolean payCommission, boolean enabled,
			Distributor distributor, CategoryProduct category, Brand brand) {
		this.id = id;
		this.name = name;
		this.barcode = barcode;
		this.unitOfMeasure = unitOfMeasure;
		this.quantity = quantity;
		this.description = description;
		this.priceBuy = priceBuy;
		this.priceSale = priceSale;
		this.activeSales = activeSales;
		this.payCommission = payCommission;
		this.enabled = enabled;
		this.distributor = distributor;
		this.category = category;
		this.brand = brand;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPriceBuy() {
		return priceBuy;
	}

	public void setPriceBuy(double priceBuy) {
		this.priceBuy = priceBuy;
	}

	public double getPriceSale() {
		return priceSale;
	}

	public void setPriceSale(double priceSale) {
		this.priceSale = priceSale;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public Distributor getDistributor() {
		return distributor;
	}

	public void setDistributor(Distributor distributor) {
		this.distributor = distributor;
	}

	public CategoryProduct getCategory() {
		return category;
	}

	public void setCategory(CategoryProduct category) {
		this.category = category;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public boolean isActiveSales() {
		return activeSales;
	}

	public void setActiveSales(boolean activeSales) {
		this.activeSales = activeSales;
	}

	public boolean isPayCommission() {
		return payCommission;
	}

	public void setPayCommission(boolean payCommission) {
		this.payCommission = payCommission;
	}
	
	
}
