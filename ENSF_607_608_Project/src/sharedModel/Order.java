package sharedModel;

import java.time.LocalDate;
import java.util.LinkedHashSet;

/**
 * Exercise 1 Code
 * 
 * @author Nathan Jack
 * @version 1.0
 * @since Oct 9th, 2020
 * 
 *        Sources: Code requirements from assignment
 * 
 *        Description: Order object generated by user. Hold item information for
 *        order and prints PO to console.
 */
public class Order implements PrintTableConstants {

	private LinkedHashSet<OrderLine> OrderLines = new LinkedHashSet<OrderLine>();
	private int orderID;
	private LocalDate date;

	/**
	 * Constructor
	 * 
	 * @param item     Item object of tool to be ordered
	 * @param supplier supplier name from tool
	 * @param orderID  unique 5 digit hash generated by shopapp at time of order.
	 */
	public Order(int orderID) {
		this.setDate();
		this.setOrderID(orderID);
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public LocalDate getDate() {
		return date;
	}

	/**
	 * Set date to todays date.
	 */
	public void setDate() {
		LocalDate now = LocalDate.now();
		this.date = now;

	}

	public void setOrderLines(LinkedHashSet<OrderLine> orderlines) {
		this.OrderLines = orderlines;
	}

	public LinkedHashSet<OrderLine> getOrderLines() {
		return this.OrderLines;
	}

	/**
	 * Adds a single custom OrderLine to this Order.
	 * @param itemId (integer) ItemId of tool to be orderd
	 * @param qty (integer) qty of item to be ordered
	 */
	public void addOrderLine(int itemId, int qty,String supplierName) {
		this.OrderLines.add(new OrderLine(itemId, qty,supplierName));
	}
	
	@Override
	public String toString() {
		String HeaderFormat = TABLEBREAK;
		HeaderFormat += "| OrderId: %-10d | Order Date: %-18s |%n";
		HeaderFormat += TABLEBREAK;
		String res = String.format(HeaderFormat, this.getOrderID(), this.getDate(), "", "");
		
		return res;
	}

}
