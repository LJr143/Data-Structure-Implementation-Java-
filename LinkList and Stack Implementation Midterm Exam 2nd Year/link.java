import java.util.ArrayList;
import java.util.Scanner;

public class link {

    public int data;
    public link next;
    public link previous;

    public link(int data) {
        this.data = data;
    }

    public void displayElements() {
        System.out.print(data + ",");
    }
}

class mylinkedList {
    public link head;
    public link tail;

    public mylinkedList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertLast(int data) {
        link newLink = new link(data);
        if (isEmpty()) {
            head = newLink;
        } else {

            tail.next = newLink;
            newLink.previous = tail;
        }
        tail = newLink;
    }

    public link findingElement(int key) {
        link theLink = head;
        int position = 1;
        if (!isEmpty()) {
            while (theLink.data != key) {
                if (theLink.next == null) {
                    System.out.println(key + " is not found!");
                    return null;
                } else {
                    position++;
                    theLink = theLink.next;
                }
            }
        } else {
            System.out.println("Empty Linked List!");
        }

        System.out.println("[" + key + " is found in the Linked List at position " + position + "]");
        return theLink;
    }

    public link deleteElement(int key) {

        link current = head;
        link previous = head;
        while (current.data != key) {
            if (current.next == null) {
                System.out.println("Element did not Exist!");
                return null;
            } else {
                previous = current;
                current = current.next;
            }

        }
        current.data = key + 1;
        System.out.println("The element " + key + " was replaced with " + current.data);
        System.out.println("Element " + key + " is now deleted. ");
        return current;
    }

    public link removeDuplicateValues() {
        link current = head;
        link index = null;
        link temp = null;

        while (current != null) {

            temp = current;

            index = current.next;

            while (index != null) {

                if (current.data == index.data) {

                    temp.next = index.next;
                } else {

                    temp = index;
                }
                index = index.next;
            }
            current = current.next;
        }
        return index;
    }

    public void display() {
        System.out.print("List: ");
        link theLink = head;
        while (theLink != null) {
            theLink.displayElements();
            theLink = theLink.next;

        }
    }

    public void reverse() {
        link current = head;
        link prev = null;
        link next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void splitting() {
        ArrayList<Integer> arraylist1 = new ArrayList<>();
        ArrayList<Integer> arraylist2 = new ArrayList<>();
        ArrayList<Integer> combine12 = new ArrayList<>();

        link ptr1 = head;
        link mid = head;
        link current = head;

        while (ptr1.next != null) {

            ptr1 = ptr1.next;
            if (ptr1.next != null) {
                ptr1 = ptr1.next;
                mid = mid.next;
            }
        }

        System.out.println("\nDisplaying the 1st group of elements: ");
        while (current != mid.next) {
            arraylist1.add(current.data);
            combine12.add(current.data);
            current = current.next;
        }
        System.out.println(arraylist1);

        while (mid.next != null) {
            arraylist2.add(mid.next.data);
            combine12.add(mid.next.data);
            mid = mid.next;

        }
        System.out.println("Displaying the 2nd group of elements: ");
        System.out.println(arraylist2);

        for (int step = 0; step < arraylist1.size() - 1; step++) { // sorting elements of First Set using selection sort
                                                                   // algorithm
            int min_idx = step;
            for (int i = step + 1; i < arraylist1.size(); i++) {
                if (arraylist1.get(i) < arraylist1.get(min_idx)) {
                    min_idx = i;
                }
            }
            int temp = arraylist1.get(step);
            arraylist1.set(step, arraylist1.get(min_idx));
            arraylist1.set(min_idx, temp);
        }
        System.out.println("\nSorting the 1st group of elements in ascending order: \n" + arraylist1);

        for (int step = 0; step < arraylist2.size() - 1; step++) { // sorting elements of Second Set using selection
                                                                   // sort algorithm
            int min_idx = step;
            for (int i = step + 1; i < arraylist2.size(); i++) {
                if (arraylist2.get(i) < arraylist2.get(min_idx)) {
                    min_idx = i;
                }
            }
            int temp = arraylist2.get(step);
            arraylist2.set(step, arraylist2.get(min_idx));
            arraylist2.set(min_idx, temp);
        }
        System.out.println("\nSorting the 2nd group of elements in ascending order: \n" + arraylist2);

        System.out.println();
        System.out.println("Sorting the The Two sets of Elements: ");
        for (int step = 0; step < combine12.size() - 1; step++) { // sorting elements of Two Set using selection sort
                                                                  // algorithm
            int min_idx = step;
            for (int i = step + 1; i < combine12.size(); i++) {
                if (combine12.get(i) < combine12.get(min_idx)) {
                    min_idx = i;
                }
            }
            int temp = combine12.get(step);
            combine12.set(step, combine12.get(min_idx));
            combine12.set(min_idx, temp);
        }
        link first = head;
        for (int i = 0; i < combine12.size(); i++) {
            first.data = combine12.get(i);
            first = first.next;
        }

        System.out.println(combine12);
        System.out.println();
        System.out.println("The actual List: ");
        display();
    }

    public void runner() {
        Scanner scan = new Scanner(System.in);

        int element = 0;
        int counter = 1;

        for (int i = 0; i < i + 1; i++) {
            System.out.print("Enter Element " + counter + ": ");
            element = scan.nextInt();
            if (element == -1) {

                break;
            }
            insertLast(element);
            counter++;
        }

        System.out.println("Number of elements in LinkedList: " + (counter - 1));
        display();
        System.out.print("\nEnter an Element: ");
        int enterElement1 = scan.nextInt();
        findingElement(enterElement1);
        System.out.print("Enter an element to delete:  ");
        int elementDelete = scan.nextInt();
        deleteElement(elementDelete);
        display();
        System.out.println("\nDisplaying the elements in reverse: ");
        reverse();
        display();
        System.out.println("\nRemoving duplicate elements.... ");
        removeDuplicateValues();
        display();
        System.out.println();
        System.out.println("\nSplitting the elements into 2...");
        splitting();

        System.out.println();
        System.out.println();
        System.out.println("END OF THE PROGRAM");
        System.out.println("LORJOHN M. RAÑA 2IT");
        scan.close();
    }

}