package Orders;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import clients.Client;
import enums.OrderStatus;

public class Order {
	public static SimpleDateFormat sdfDateMoment = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	public Date moment;
	private OrderStatus orderStatus;
	private Client client;
	private List<OrderItem> itens = new ArrayList();
	
	public Order(Date moment, OrderStatus orderStatus, Client client) {
		this.moment = moment;
		this.orderStatus = orderStatus;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public void addItem(OrderItem item) {
		itens.add(item);
	}
	
	public void removeItem(OrderItem item) {
		itens.remove(item);
	}
	
	public Client getCliente() {
		return client;
	}

	public void setCliente(Client cliente) {
		this.client = client;
	}
	
	public List<OrderItem> getItens() {
		return itens;
	}

	public double getTotal() {
		double total = 0;
		for(OrderItem item : itens) {
			total += item.subTotal();
		}
		return total;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: " + sdfDateMoment.format(this.getMoment()) + "\n");
		sb.append("Order status: ");
		sb.append(this.getOrderStatus() + "\n");
		sb.append("Client: ");
		sb.append(client);
		sb.append("Order items: \n");
		for (OrderItem item : this.getItens()) {
			sb.append(item);
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", this.getTotal()));
		return sb.toString();
	}
}
