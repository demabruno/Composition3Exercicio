package Orders;

import product.Product;

public class OrderItem {
	private int quantity;
	private double price;
	private Product product; 
	
	public OrderItem(int quantity, double price) {
		this.quantity = quantity;
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double subTotal() {
		return this.getPrice() * this.getQuantity();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("TV, $");
		sb.append(String.format("%.2f", this.getPrice()));
		sb.append(" Quantity: ");
		sb.append(this.getQuantity());
		sb.append(" Subtotal: $");
		sb.append(this.subTotal());
		sb.append("\n");
		
		return sb.toString();
	}
}
