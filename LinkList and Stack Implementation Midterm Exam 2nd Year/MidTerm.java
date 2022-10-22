import java.util.Scanner;

/**
 * @(#)MidTerm.java
 *
 *                  MidTerm application
 *
 * @author
 * @version 1.00 2022/10/20
 */

public class MidTerm {

  public static void main(String[] args) {

    Scanner n = new Scanner(System.in);
    System.out.println("Please choose the data structure you want to implement: ");
    System.out.println("[A] STACK");
    System.out.println("[B] LINKEDLIST");
    System.out.print("Enter your choice: ");
    String choice = n.nextLine();
    if (choice.equals("A") || choice.equals("a")) {
      stack newStack = new stack();
      for (int i = 1; i < newStack.maxSize + 1; i++) {
        System.out.print("Enter Element " + i + " : ");
        int element = n.nextInt();
        if (element == -1) {
          break;
        } else {
          newStack.push(element);
        }

      }
      newStack.menuStack();
    }
    if (choice.equals("B") || choice.equals("b")) {
      mylinkedList newList = new mylinkedList();
      newList.runner();
    }
    n.close();
  }
}
