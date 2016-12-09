package it.unifi.selfbar.visitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import it.unifi.selfbar.bill.Bill;
import it.unifi.selfbar.exception.OrderNotDecorableException;
import it.unifi.selfbar.order.Order;

public class BillLeastPopularOrderVisitor implements Visitor {

	public void visitBill(Bill bill) {
		List<Order> list = bill.getListOrders();
		HashMap<Order, Integer> hashmap = createTableOfOccurence(list);
		Order order = getLeastRequestedOrder(hashmap);
		System.out.println(order);
	}

	private HashMap<Order, Integer> createTableOfOccurence(List<Order> list) {
		HashMap<Order, Integer> hashmap = new HashMap<>();
		for (Order order : list) {
			Order insideProduct = getLastOrder(order);
			insertProduct(hashmap, insideProduct);
		}
		return hashmap;
	}

	private Order getLastOrder(Order order) {
		Order rst = order;
		try {
			while (rst.getOrder() != null) {
				rst = rst.getOrder();
			}
		} catch (OrderNotDecorableException e) {
		}
		return rst;
	}

	private void insertProduct(HashMap<Order, Integer> hashmap, Order insideProduct) {
		if (hashmap.containsKey(insideProduct)) {
			// conto un order in più
			int occurence = hashmap.get(insideProduct) + 1;
			hashmap.put(insideProduct, occurence);
		} else {
			// primo inserimento di quell'order
			hashmap.put(insideProduct, 1);
		}
	}

	private Order getLeastRequestedOrder(HashMap<Order, Integer> hashmap) {
		Order rst = null;
		// ipotizzo che nessuno ordini così tanti order in un solo conto
		int occurence = 99999;
		for (Entry<Order, Integer> entry : hashmap.entrySet()) {
			int temp = entry.getValue();
			if (temp < occurence) {
				rst = entry.getKey();
				occurence = temp;
			}
		}
		return rst;
	}
}
