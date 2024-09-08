import java.util.*;

class Item {
    int weight;
    int value;
    

    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
    
    
    double getValuePerWeight() {
        return (double) value / weight;
    }
}

public class FractionalKnapsack {
    
    public static double getMaxValue(Item[] items, int capacity) {
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Double.compare(o2.getValuePerWeight(), o1.getValuePerWeight());
            }
        });
        
        double totalValue = 0.0;
        
        for (Item item : items) {
            if (capacity == 0) break; 
            
            
            int weightToTake = Math.min(item.weight, capacity);
            totalValue += weightToTake * item.getValuePerWeight();
            capacity -= weightToTake;
        }
        
        return totalValue;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of items:");
        int n = scanner.nextInt();
        
        Item[] items = new Item[n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("Enter weight and value for item " + (i + 1) + ":");
            int weight = scanner.nextInt();
            int value = scanner.nextInt();
            items[i] = new Item(weight, value);
        }
        
        System.out.println("Enter the capacity of the knapsack:");
        int capacity = scanner.nextInt();
        
        double maxValue = getMaxValue(items, capacity);
        System.out.println("Maximum value in Knapsack = " + maxValue);
        
        scanner.close();
    }
}
