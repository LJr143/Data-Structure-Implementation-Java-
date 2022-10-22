import java.util.ArrayList;

import java.util.Scanner;

/**
 * @(#)stack.java
 *
 *
 * @author
 * @version 1.00 2022/10/20
 */

public class stack {

  public int maxSize;
  private int[] stackArray;
  private int top;

  public stack() {
    maxSize = 15;
    stackArray = new int[maxSize];
    top = -1;
  }

  public void push(int data) {
    stackArray[++top] = data;
  }

  public int pop(int data) {
    stackArray[top] = 0;
    top--;
    return stackArray[top];
  }

  public int peek() {
    return stackArray[top];
  }

  public boolean isEmpty() {
    return (top == -1);
  }

  public boolean isFull() {
    return (top == maxSize - 1);
  }

  public int checkSize() {
    int count = 0;
    while (count < stackArray.length && stackArray[count] != 0) {
      count++;
    }
    return count;
  }

  public void displayStack(int[] array) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == 0) {
        break;
      }
      System.out.print(array[i] + " ");
    }
    System.out.println();
  }

  public int[] removeDuplicate() {
    ArrayList<Integer> tempArrayList = new ArrayList<>();
    ArrayList<Integer> tempArrayList2 = new ArrayList<>();

    for (int i = 0; i < stackArray.length; i++) { // adding contents of the stack into an arraylist
      if (stackArray[i] != 0) {
        tempArrayList.add(stackArray[i]);
      }
    }
    for (Integer data : tempArrayList) { // Checking for duplicate values using for each loop
      if (!tempArrayList2.contains(data)) {
        tempArrayList2.add(data);
      }

    }

    for (int l = 0; l < tempArrayList2.size(); l++) { // adding all the values inside temporary

      stackArray[l] = tempArrayList2.get(l);
    }

    int temp = tempArrayList.size() - tempArrayList2.size(); // Popping the remaining place in the array
    for (int i = 1; i <= temp; i++) {
      pop(top);
    }
    if (temp == 0) {
      System.out.println("[There are no Duplicates!]");
    } else {
      System.out.println("[Successfully remove " + temp + " Duplicate/s!]");
    }
    return stackArray;
  }

  public void checkSizeOddEven() {
    int temp = checkSize() % 2;
    if (temp == 0) {
      System.out.println("[The Stack Size is Even!]");
    } else {
      System.out.println("[The Stack size is Odd!]");
      System.out.println("[Popping.... to make the size Even]");
      pop(top);
      checkSizeOddEven();
    }

  }

  public void sorting() {
    for (int i = 0; i < checkSize() - 1; i++) {
      int min_indx = i;
      for (int j = i + 1; j < checkSize(); j++) {
        if (stackArray[j] < stackArray[min_indx]) {
          min_indx = j;
        }

      }
      int temp = stackArray[i];
      stackArray[i] = stackArray[min_indx];
      stackArray[min_indx] = temp;
    }

    System.out.println("\nSorted Elements: ");
    displayStack(stackArray);

  }

  public void menuStack() {
    Scanner n1 = new Scanner(System.in);
    Scanner string = new Scanner(System.in);
    System.out.println("\nMENU: ");
    System.out.println("[1] PEEK");
    System.out.println("[2] PUSH");
    System.out.println("[3] POP");
    System.out.println("[4] DISPLAY");
    System.out.println("[5] SORT");
    System.out.println("[6] EXIT");
    System.out.print("\nEnter your choice: ");
    int a = n1.nextInt();

    switch (a) {
      case 1:
        System.out.println("PEEK");
        System.out.println("Value: " + peek());
        System.out.print("Do you want to continue? Y/N : ");
        String YN = string.nextLine();
        if (YN.equals("Y") || YN.equals("y")) {
          menuStack();
        }
        if (YN.equals("N") || YN.equals("n")) {
          System.exit(0);
        }
        break;
      case 2:
        if (isFull()) {
          System.out.println("STACK IS FULL!");
          menuStack();
        } else {
          System.out.println("      PUSH      ");
          System.out.print("Enter element to push: ");
          int elementToPush = n1.nextInt();
          push(elementToPush);

          System.out.print("Do you want to continue? Y/N : ");
          String YN1 = string.nextLine();
          if (YN1.equals("Y") || YN1.equals("y")) {
            menuStack();
          } else if (YN1.equals("N") || YN1.equals("n")) {
            System.exit(0);
          }
        }
        break;
      case 3:
        Scanner n2 = new Scanner(System.in);
        if (isEmpty()) {
          System.out.println("Stack is Empty!");

        } else {
          // Every popping of the top the value will become zero
          System.out.println("     POP    ");
          System.out.println("Current Value of the top: " + pop(top));

          System.out.print("Do you want to continue? Y/N : ");
          String YesNo = n2.nextLine();
          if (YesNo.equals("Y") || YesNo.equals("y")) {
            menuStack();
          } else if (YesNo.equals("N") || YesNo.equals("n")) {
            System.exit(0);
          }
        }
        break;
      case 4:
        System.out.println("DISPLAY");
        displayStack(stackArray);

        System.out.print("Do you want to continue? Y/N : ");
        String YN3 = string.nextLine();
        if (YN3.equals("Y") || YN3.equals("y")) {
          menuStack();
        } else if (YN3.equals("N") || YN3.equals("n")) {
          System.exit(0);
        }

        break;
      case 5:
        System.out.println("SORT");
        System.out.println("        *Removing Duplicates....");
        removeDuplicate();
        System.out.println("        *Checking if size is odd....");
        checkSizeOddEven();
        System.out.println("        *Sorting the elements (using selection sort):");
        sorting();

        System.out.print("Do you want to continue? Y/N : ");
        String YN4 = string.nextLine();
        if (YN4.equals("Y") || YN4.equals("y")) {
          menuStack();
        } else if (YN4.equals("N") || YN4.equals("n")) {
          System.exit(0);
        }

        break;
      case 6:
        System.out.println();
        System.out.println("The program will now exit ......  ");
        System.out.println();
        System.out.println("**********************************************************************");
        System.out.println("*Thank you for giving this system of mine a chance of your glance :) *");
        System.out.println("**********************************************************************");
        System.out.println("\n[Lorjohn M. Raña 2IT]");
        System.out.println("[Bachelor of Science in Information Technology]");

        System.exit(0);
        break;
      default:
        System.out.println("Wrong Input!");
        menuStack();
    }
    n1.close();
    string.close();
  }

}
