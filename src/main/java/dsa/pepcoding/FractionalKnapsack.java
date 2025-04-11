package dsa.pepcoding;

import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] weights = new int[n];
        int[] values = new int[n];

        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }
        int capacity = scanner.nextInt();

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            double ratio = (double) values[i] / weights[i];
            Item item = new Item(values[i], weights[i], ratio);
            items[i] = item;
        }

        //dsa.sorting in ascending order
        Arrays.sort(items);

        double valueInBag = 0;
        double remainingCapacity = capacity;

        //traverse from descending order to ascending
        for (int i = n - 1; i >= 0; i--) {
            if (remainingCapacity == 0) {
                break;
            }
            if (items[i].weight <= remainingCapacity) {
                valueInBag = valueInBag + items[i].value;
                remainingCapacity = remainingCapacity - items[i].weight;
            } else {
                valueInBag = valueInBag + remainingCapacity * ((double) items[i].value / items[i].weight);
                remainingCapacity = 0;
                break;
            }
        }

        System.out.println(valueInBag);


    }

    static class Item implements Comparable<Item> {

        int value;
        int weight;
        double ratio;

        public Item(int value, int weight, double ratio) {
            this.value = value;
            this.weight = weight;
            this.ratio = ratio;
        }

        @Override
        public int compareTo(Item o) {
            if (ratio > o.ratio) {
                return 1;
            } else if (ratio < o.ratio) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}
