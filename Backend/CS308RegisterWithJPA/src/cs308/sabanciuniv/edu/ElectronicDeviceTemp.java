package cs308.sabanciuniv.edu;

import javax.persistence.Entity;

@Entity
public class ElectronicDeviceTemp {
	private double price;
	private String currency;
	private boolean onSale;
	private String merchant;
	private String brand;
	private String category;
	private String imageURLs;
	private String manufacturer;
	private String name;
	private String primaryCategory;
	private String sourceURL;
	public ElectronicDeviceTemp(double price, String currency, boolean onSale, String merchant, String brand,
			String category, String imageURLs, String manufacturer, String name, String primaryCategory,
			String sourceURL) {
		super();
		this.price = price;
		this.currency = currency;
		this.onSale = onSale;
		this.merchant = merchant;
		this.brand = brand;
		this.category = category;
		this.imageURLs = imageURLs;
		this.manufacturer = manufacturer;
		this.name = name;
		this.primaryCategory = primaryCategory;
		this.sourceURL = sourceURL;
	}
	public ElectronicDeviceTemp() {
		super();
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public boolean isOnSale() {
		return onSale;
	}
	public void setOnSale(boolean onSale) {
		this.onSale = onSale;
	}
	public String getMerchant() {
		return merchant;
	}
	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImageURLs() {
		return imageURLs;
	}
	public void setImageURLs(String imageURLs) {
		this.imageURLs = imageURLs;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrimaryCategory() {
		return primaryCategory;
	}
	public void setPrimaryCategory(String primaryCategory) {
		this.primaryCategory = primaryCategory;
	}
	public String getSourceURL() {
		return sourceURL;
	}
	public void setSourceURL(String sourceURL) {
		this.sourceURL = sourceURL;
	}
	@Override
	public String toString()
	{
		return "Category: " + this.getCategory() + "\nBrand: " + this.getBrand() + "\nName: " + this.getName() + "\nPrice: " + this.getPrice() + this.getCurrency() + "\nOn sale: "  + this.isOnSale();
	}
}
