package myAPP2024;

public class Order {
private static int currentOrderId = 0; // Static counter for unique order IDs
private int OrderId;
String OrderName;
int OrderCount;
double priceoforderforoneitem;

public Order(int orderId, String orderName, int orderCount, double priceoforder) {
	super();
	this.OrderId = ++currentOrderId; 	OrderName = orderName;
	OrderCount = orderCount;
	this.priceoforderforoneitem = priceoforder;
}
@Override
public String toString() {
	return "Order [OrderId=" + OrderId + ", OrderName=" + OrderName + ", OrderCount=" + OrderCount + ", priceoforder="
			+ priceoforderforoneitem + "]";
}
public int getOrderCount() {
	return OrderCount;
}
public void setOrderCount(int orderCount) {
	OrderCount = orderCount;
}
public double getPriceoforder() {
	return priceoforderforoneitem;
}
public void setPriceoforder(double priceoforder) {
	this.priceoforderforoneitem = priceoforder;
}
public int getOrderId() {
	return OrderId;
}
public void setOrderId(int orderId) {
	this.OrderId = orderId;
}
public String getOrderName() {
	return OrderName;
}
public void setOrderName(String orderName) {
	OrderName = orderName;
}
public Order(String orderName, int orderCount) {
	super();
	OrderName = orderName;
	OrderCount = orderCount;
}

}
