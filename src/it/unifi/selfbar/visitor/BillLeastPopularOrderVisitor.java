package it.unifi.selfbar.visitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import it.unifi.selfbar.bill.Bill;
import it.unifi.selfbar.order.Order;

public class BillLeastPopularOrderVisitor implements Visitor {

	public void visitBill(Bill bill) {
		List<Order> list = bill.getListOrders();
		HashMap<Order, Integer> hashmap = createTableOfOccurence(list);
		Order order = getLeastRequestedOrder(hashmap);
		//System.out.println(order);
	}

	private HashMap<Order, Integer> createTableOfOccurence(List<Order> list) {
		HashMap<Order, Integer> hashmap = new HashMap<>();
		for (Order order : list) {
			if (hashmap.containsKey(order)) {
				// conto un order in più
				int occurence = hashmap.get(order) + 1;
				hashmap.put(order, occurence);
			} else {
				// primo inserimento di quell'order
				hashmap.put(order, 1);
			}
		}
		System.out.println(hashmap);
		return hashmap;
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
