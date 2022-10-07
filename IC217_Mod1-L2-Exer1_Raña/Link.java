package HandsOnExe2;

import java.util.ArrayList;
import java.util.Scanner;

public class Link {
    public int data;
    public Link next;                       //next Link in the list
    public Link previous;                    //previous Link in the list

    public Link(int data){                  //Constructor
        this.data = data;
    }
    public void displaying(){              //displaying the data in the list
        System.out.print(data + " ");
    }
    


public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    LinkedList newLink = new LinkedList();
   
    boolean duplicate = false;
    
    System.out.println("*********************************");
    System.out.println("*  Linked List Implementation   *");
    System.out.println("*********************************");
    System.out.print("Enter the size of your Linked List: ");
    int size = scanner.nextInt();  
    
     for(int counter = 1; counter <= size;){
        System.out.print("Enter Element " + counter + ": " );
        int temp = scanner.nextInt();
        for(int i = 0; i<=counter - 2; i++){
         duplicate = false;
         if(temp == newLink.head.data){
             duplicate = true;
             break;
         }
     }if(duplicate){
         System.out.println("Duplicate!");
         

     }
     else{
             newLink.insertHead(temp);
             counter ++;
         }
        }

     newLink.menu();
     scanner.close();
    }
}

class LinkedList{
    public Link head;                  //will refer to the first node/item
    public Link tail;                  // will refer to the last node/item


    public LinkedList(){
        head = null;                   //initializing the value of the first and last item
        tail = null; 
    }
    public boolean isEmpty(){          //check if the list is empty
        return head == null;
    }

    public void insertHead( int data){   //inserting the data inputted by the user, every new input is the Head
        Link newLink = new Link(data);
        newLink.next = head;
        head = newLink;
        
        
    }
    public Link searchElement(int key){                        //searching in the list
        Link theLink = head;
        if(!isEmpty()){
            while (theLink.data != key){
                if(theLink.next == null){
                    System.out.println(key  + " is not found!");
                    return null;
                }else{
                    theLink = theLink.next;
                }
            }
        }else{
            System.out.println("Empty Linked List!");
        }System.out.println(key + " is found in the Linked List!");
        return theLink;
    }
    public Link insertAt(int newElement, int position )
         {     
                                                                                        
            Link newLink = new Link(newElement);                          //allocate node to new element
            newLink.data = newElement;
            newLink.next = null;
            Link current = head;
            while(current != null){                                  // check if the value that will be insert is already in the list
                if(current.data == newElement){
                    System.out.println("Already Exists! Can't Accept Duplicate Values");
                    return null;
                }
                current = current.next;
            }
          
            
            
            if(position < 1) {                                          //check if the position is > 0
              System.out.print("\nposition should be >= 1.");
            } else if (position == 1) {
              
          
              newLink.next = head;                                      // if the position is 1, make next of the
              head = newLink;                                           //  new node as head and new node as head
            } else {
              
            
             
              Link temp = new Link(position);                             //Else, make a temp node and traverse to the 
              temp = head;                                                //   node previous to the position
              for(int i = 1; i < position-1; i++) {
                if(temp != null) {
                  temp = temp.next;
                }
              }
           
              
              if(temp != null) {                                          // If the previous node is not null, make 
                newLink.next = temp.next;                                  //   newNode next as temp next and temp next 
                temp.next = newLink;                                      //   as newNode.
              } else {
                
               
                System.out.println("\nCan't insert for that posistion since it overlaps the size of the list.");        //When the previous node is null or the position overlaps the size of the list
              System.out.println();
            }       
            }
            return null;
          } 
          
          
          
        
    public void display(){
        System.out.print("List: ");
        Link theLink = head;
        while(theLink != null){
           theLink.displaying();
           theLink = theLink.next;

        }
    }
    public int length() {                             //checks the size of the list
 
		Link temp = this.head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
    public Link delete(int key){                    //deleting a specific value/node/data
        
        Link current = head;
        Link previous = head;
        while(current.data != key){
            if(current.next == null){
                System.out.println("Element did not Exist!");
                return null;
            }else{
                previous = current;
                current = current.next;

            }
        }if(current == head){
            head = head.next;
        }else{
            previous.next = current.next;
        }return current;
    }
    public  void sortingElements(){                           //sorting elements with the use of Arraylist
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();
        Link ptr1 = head;
        Link mid = head;
        Link current = head;
        
        while (ptr1.next != null) {

            ptr1 = ptr1.next;
            if(ptr1.next !=null) {
              ptr1 = ptr1.next;
              mid = mid.next;
            }
          }System.out.println();
          System.out.println("First set: ");
         

          while(current != mid.next){
            
            System.out.print(current.data + " ");
            array1.add(current.data);
            current = current.next;
          }
          for (int step = 0; step < array1.size() - 1; step++) {                         //sorting elements of First Set using selection sort algorithm
            int min_idx = step; 
            for (int i = step + 1; i < array1.size(); i++) { 
            if (array1.get(i) < array1.get(min_idx)) { 
            min_idx = i; 
            } 
            } 
            int temp = array1.get(step); 
            array1.set(step, array1.get(min_idx)); 
            array1.set(min_idx, temp); 
            } System.out.println("\nSorting the Elements: \n" + array1);

          System.out.println();
          System.out.println("Second set: ");
          while(mid.next != null){
            System.out.print(mid.next.data + " ");
            array2.add(mid.next.data);
            mid = mid.next;
            
          }for (int step = 0; step < array2.size() - 1; step++) {             //sorting elements of Second Set using selection sort algorithm
            int min_idx = step; 
            for (int i = step + 1; i < array2.size(); i++) { 
            if (array2.get(i) < array2.get(min_idx)) { 
            min_idx = i; 
            } 
            } 
            int temp = array2.get(step); 
            array2.set(step, array2.get(min_idx)); 
            array2.set(min_idx, temp); 
            } System.out.println("\nSorting the Elements: \n" + array2);




        } 
        
    public int checkSize(){                               //checks the actual size of the list
            Link current = head;
            int count = 0; 

            while(current != null){
                count++;
                current = current.next;
            }return count;
        }

      
 
    
    public void menu(){
        Scanner scan = new Scanner(System.in);
        Scanner string = new Scanner(System.in);
        int choice;
        System.out.println("\nMenu: ");
        System.out.println("[1] SEARCH");
        System.out.println("[2] INSERT");
        System.out.println("[3] DELETE");
        System.out.println("[4] DISPLAY");
        System.out.println("[5] SORT");
        System.out.println("[6] EXIT");
        System.out.println();
        System.out.print("Enter Your Choice: ");
        choice = scan.nextInt();
        String YN;
        switch(choice){
            case 1: 
                    do{
                    System.out.print("Enter Element to Search: ");
                    int searchElement = scan.nextInt();
                    searchElement(searchElement);
                    
                    System.out.print("Do you want to continue? Y if Yes, N if No : ");
                    YN = string.nextLine();
                    if(YN.equals("n") || YN.equals("N")){
                        menu();
                    }
                     }while(YN.equals("Y") || YN.equals("y"));  
            break; 
            
            case 2: 
                    do{
                     
                       
                    System.out.println();
                    System.out.print("Enter the position of your element: ");
                    int positionElement = scan.nextInt();
                    System.out.print("Enter the element: ");
                    int newElement = scan.nextInt();
                
                     insertAt(newElement, positionElement);
                       display();
                       System.out.println(); 
                     System.out.print("Do you want to continue? Y if Yes, N if No : ");
                    YN = string.nextLine();
                    if(YN.equals("n") || YN.equals("N")){
                    menu();
                    }
                    }while(YN.equals("Y") || YN.equals("y"));  
                    
              break; 
            case 3: 
                     do{
                    System.out.print("Enter Element to Delete: ");
                    int deleteElement = scan.nextInt();
                    delete(deleteElement);
                    display();
                    
                    System.out.println();
                    System.out.print("Do you want to continue? Y if Yes, N if No : ");
                    YN = string.nextLine();
                    if(YN.equals("n") || YN.equals("N")){
                        menu();
                    }
                     }while(YN.equals("Y") || YN.equals("y"));  
            break; 
            case 4: 
                    do{
                    System.out.println("Displaying the Elements: ");
                     display();
                     System.out.println();
                     System.out.print("Do you want to continue? Y if Yes, N if No : ");
                    YN = string.nextLine();
                    if(YN.equals("n") || YN.equals("N")){
                        menu();
                    }
                    }while(YN.equals("Y") || YN.equals("y")); 
                break;
           
            case 5: do{sortingElements();
                        System.out.println();
                        System.out.print("Do you want to continue? Y if Yes, N if No : ");
                       YN = string.nextLine();
                       if(YN.equals("n") || YN.equals("N")){
                           menu();
                       }
                       }while(YN.equals("Y") || YN.equals("y")); 
                    break;

                case 6: System.out.println("************************************");
                        System.out.println("*       Thank you! See you!        *");
                        System.out.println("*       LORJOHN M. RAÑA 2IT        *");
                        System.out.println("************************************");
                        System.exit(0);
        
        
                }
                scan.close();
                string.close();
            }
        }
    

                    
            
   





















        
    
    


