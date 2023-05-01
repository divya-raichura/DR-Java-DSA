import java.util.Arrays;
import java.util.Comparator;

public class GreedyFractionalKnapSack {
    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;
        double maxValue = fractionalKnapsack(weights, values, capacity);
        System.out.println("Maximum value we can obtain = " + maxValue);
    }

    static class Item {
        int weight, value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    static double fractionalKnapsack(int[] weights, int[] values, int capacity) {
        Item[] items = new Item[weights.length];
        for (int i = 0; i < weights.length; i++) {
            items[i] = new Item(weights[i], values[i]);
        }

        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                double ratio1 = (double) o1.value / o1.weight;
                double ratio2 = (double) o2.value / o2.weight;
                return Double.compare(ratio2, ratio1);
            }
        });

        double totalValue = 0;
        for (Item item : items) {
            if (capacity == 0) {
                break;
            }
            if (item.weight <= capacity) {
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                double fraction = (double) capacity / item.weight;
                totalValue += fraction * item.value;
                capacity = 0;
            }
        }
        return totalValue;
    }
}
