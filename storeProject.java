import java.util.*;

public class storeProject {
	private static Scanner JavaInput;
	private static Map<String, Double> items = new TreeMap<>();
	private static List<String> orderNames = new ArrayList<>();
	private static List<Double> orderPrices = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println("Welcome to Nonamoose's Market!");
		JavaInput = new Scanner(System.in);
		while (true) {
		fillItemsMap();
		printMenu();
		System.out.println("");
		System.out.print("What would you like to order? ");
		String itemName = JavaInput.nextLine();
		if (items.containsKey(itemName)) {
			Double itemPrice = items.get(itemName);
			System.out.println("Adding " + itemName + " to cart at $" + itemPrice);
			System.out.println("");
			orderNames.add(itemName);
			orderPrices.add(itemPrice);
		}
		else {
			System.out.println("This item doesn't exist. Please try again.");
		}
		System.out.print("Do you want to add another item to your cart? (y/n): ");
		String addAnotherItem = JavaInput.nextLine();
		if (addAnotherItem.contains("y")) {
			System.out.println("");
			continue;
		}
		else {
			System.out.println("Thanks for your order!");
			System.out.println("");
			System.out.println("Heres what you got:");
			for (int i = 0; i < orderNames.size(); i++){
				System.out.println(orderNames.get(i) + "\t" + orderPrices.get(i));
				}
		}
			System.out.println("");
			averageCost();
			highestCost();
			lowestCost();
			break;
		}
		}
	private static void fillItemsMap() {
		items.put("dog food", 44.95);
		items.put("cat food", 39.99);
		items.put("tug-of-war toy", 8.99);
		items.put("laser pointer", 2.99);
		items.put("food bowl", 4.99);
		items.put("fountain", 29.99);
		items.put("rabbit hay", 19.99);
		items.put("steak treats", 29.99);
		items.put("gravy topper", 3.49);
	}
	private static void printMenu() {
		System.out.println("Item\t\tPrice");
		System.out.println("=====================");
		for (Map.Entry<String, Double> entry: items.entrySet())
			System.out.println(entry.getKey() + "\t" + entry.getValue());
	}
	private static void averageCost() {
		double totalCost = 0;
		for(Double orderPrice : orderPrices)
		    totalCost += orderPrice;
		int numberOfItems = orderNames.size();
		double averageCost = totalCost / numberOfItems;
		System.out.println("Average price per item in order was " + averageCost + ".");	
	}
	private static void lowestCost() {
		double lowestCost = Double.MAX_VALUE;
		for(Double orderPrice : orderPrices) {
		    if (orderPrice < lowestCost) {
		    	lowestCost = orderPrice;
		    }
		}
		int index = orderPrices.indexOf(lowestCost);
		System.out.println("Lowest priced item cost was " + orderNames.get(index) + " with a cost of " + lowestCost + ".");
	}
	private static void highestCost() {
		double highestCost = Double.MIN_VALUE;
		for(Double orderPrice : orderPrices) {
		    if (orderPrice > highestCost) {
		    	highestCost = orderPrice;
		    }   
		}
		int index = orderPrices.indexOf(highestCost);
		System.out.println("Highest priced item cost was " + orderNames.get(index) + " with a cost of " + highestCost + ".");
	}
}
