package org.example.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {
  public static ArrayList<String> groceryList = new ArrayList<>();

  public static void startGrocery() {
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;

    while (!exit) {
      System.out.println("Please choose an option:\n0 - Exit\n1 - Add items\n2 - Remove items");
      int choice = scanner.nextInt();
      scanner.nextLine(); // Enter tuşunu temizlemek için

      switch (choice) {
        case 0:
          exit = true;
          break;
        case 1:
          System.out.println("Enter items to add (separate with commas if adding multiple):");
          String itemsToAdd = scanner.nextLine();
          addItems(itemsToAdd);
          break;
        case 2:
          System.out.println("Enter items to remove (separate with commas if removing multiple):");
          String itemsToRemove = scanner.nextLine();
          removeItems(itemsToRemove);
          break;
        default:
          System.out.println("Invalid option, please try again.");
      }
      printSorted();
    }
    scanner.close();
  }

  public static void addItems(String input) {
    List<String> items = Arrays.asList(input.split("\\s*,\\s*"));
    for (String item : items) {
      if (!checkItemIsInList(item)) {
        groceryList.add(item);
      }
    }
    Collections.sort(groceryList);
  }

  public static void removeItems(String input) {
    List<String> items = Arrays.asList(input.split("\\s*,\\s*"));
    for (String item : items) {
      groceryList.removeIf(existingItem -> existingItem.equalsIgnoreCase(item));
    }
    Collections.sort(groceryList);
  }

  public static boolean checkItemIsInList(String product) {
    return groceryList.contains(product);
  }

  public static void printSorted() {
    System.out.println("Current Grocery List: ");
    for (String item : groceryList) {
      System.out.println(item);
    }
  }
}
