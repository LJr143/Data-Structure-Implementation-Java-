
import java.util.ArrayList;
import java.util.Scanner;

public class HandsonExe2{
   static ArrayList<Integer> array = new ArrayList<Integer>();
   static boolean duplicate;
   static int choice;
   static Scanner scanner = new Scanner(System.in);
           
      public static void search(){
        System.out.println("");
        System.out.println("********************");
        System.out.println("*      SEARCH      *");
        System.out.println("********************");
        
        int first = 0;
        int last=array.size()-1;
        int key;
        int mid = (first + last)/2;  
        System.out.print("Enter number to Search: ");
        key = scanner.nextInt();
        while( first <= last ){  
           if ( array.get(mid) < key ){  
             first = mid + 1;     
           }else if ( array.get(mid) == key ){  
             System.out.println( "\n"+key +" is found at index: " + mid);  
             break;  
           }else{  
              last = mid - 1;  
           }  
           mid = (first + last)/2;  
        }  
        if ( first > last ){  
           System.out.println("\nElement is not found!");
        } display();
        highLow();
         System.out.println("1. Back");
            System.out.println("2. Search Again");
            System.out.println("3. Exit");
            System.out.print("Enter your Choice: ");
            int choice1 = scanner.nextInt();
            switch(choice1){
                case 1: choices();
                    break;
                case 2: search();
                    break;
                case 3: System.exit(4);
                    break;
    
            }

      }  public static void display(){
        System.out.println("\nDisplaying Numbers: ");
        System.out.println( array+"\n");
      }
      
    

      public static void delete(){
        System.out.println("");
        System.out.println("********************");
        System.out.println("*      DELETE      *");
        System.out.println("********************");       
        System.out.print("Enter Value to be remove: ");
        int j = scanner.nextInt();
        for(int i=0, k=0;i<array.size();i++){
            if(array.get(i)!= j){
                continue;
                
            }else if(array.get(i) == j){
                array.remove(i);
                System.out.println("Deleted Successfully!");
            }
       
    }display();
    highLow();
    
    System.out.println("1. Back");
    System.out.println("2. Delete Again");
    System.out.println("3. Exit");
System.out.print("\nEnter your Choice: ");
    int choice2 = scanner.nextInt();
    switch(choice2){
        case 1: choices();
            break;
        case 2: delete();
            break;
        case 3: exit();
            break;

    }
}


 
 public static void Main(){
    for (int Counter = 1;Counter <= 10;) {
        duplicate = false;
        System.out.print("Enter digit " + Counter + ": ");
        int temp = scanner.nextInt();
        for (int i = 0; i <= Counter - 2; i++) { 
            if (temp == array.get(i)) { 
                duplicate = true;
                break;
            }
        }
        if (duplicate) {
            System.out.println("\n"+temp + " is Already Added! Can't Accept Duplicate Values!\n");
        } else {
            
           
           array.add(Counter - 1, temp);
            Counter++;
        }
    }System.out.println();
    System.out.println("*****************************************************");
    System.out.println("*Your Current Array: " + array+"*");
    System.out.println("*****************************************************");
    
    for (int step = 0; step < array.size() - 1; step++) { //Sorting in Ascending Order
        int min_idx = step; 
        for (int i = step + 1; i < array.size(); i++) { 
        if (array.get(i) < array.get(min_idx)) { 
        min_idx = i; 
        } 
        } 
        int temp = array.get(step); 
        array.set(step, array.get(min_idx)); 
        array.set(min_idx, temp); 

        } System.out.println();
        System.out.println("*************************************************************");
        System.out.println("*Sorted in Ascending Order : " + array+"*");
        System.out.println("*************************************************************");
        choices();
        
 }public static void choices(){
    System.out.println("");
    System.out.println("***************************");
    System.out.println("* What Do You Want to DO? *");
    System.out.println("***************************");
    System.out.println("");
    System.out.println("1. Search");
        System.out.println("2. Delete");
        System.out.println("3. Search and Delete");
        System.out.println("4. Display Array");
        System.out.println("5. Exit");

        System.out.print("Enter Choice: ");
        choice=scanner.nextInt();
        switch(choice){
            case 1: search();
                break;
            case 2: delete();
                break;
            case 3: searchDelete();
                break;
            case 4:  System.out.println();
                     System.out.println("Array:");
                     System.out.println("*********************************");
                     System.out.println("*"+array+"*");
                     System.out.println("*********************************");
                    choices();
                break;
            case 5: exit();
                break;

        }
 }public static void highLow(){
    
    int high = array.get(array.size()-1);
    int low = array.get(0);
    System.out.println("\nLowest Number is: " + low +"  Highest Number is: " + high+"\n");
   
 }public static void searchDelete(){
    System.out.println("");
        System.out.println("*********************");
        System.out.println("* SEARCH AND DELETE *");
        System.out.println("*********************");
    int first = 0;
        int last=array.size()-1;
        int key;
        int mid = (first + last)/2;  
        System.out.print("Enter number to Search and Delete: ");
        key = scanner.nextInt();
        while( first <= last ){  
           if ( array.get(mid) < key ){  
             first = mid + 1;     
           }else if ( array.get(mid) == key ){  
             System.out.println( "\n"+key +" is found at index: " + mid+"\n"); 
             for(int i=0, k=0;i<array.size();i++){
                if(array.get(i)!= key){
                    continue;
                    
                }else if(array.get(i) == key){
                    array.remove(i);
                    System.out.println("Deleted Successfully!");
                }
           
        }
             break;  
           }else{  
              last = mid - 1;  
           }  
           mid = (first + last)/2;  
        }  
        if ( first > last ){  
           System.out.println("\nElement is not found!\n");
        } display();
        highLow();
         System.out.println("1. Back");
            System.out.println("2. Search and Delete Again");
            System.out.println("3. Exit");
            System.out.print("Enter your Choice: ");
            int choice1 = scanner.nextInt();
            switch(choice1){
                case 1: choices();
                    break;
                case 2: searchDelete();
                    break;
                case 3: exit();
                    break;
    
            }
 }
 
 
 public static void exit(){
    System.out.println();
    System.out.println("***************************************************************");
    System.out.println("*Current Value of the Array: " + array+ "*");
    System.out.println("***************************************************************");
        highLow();
    System.out.println("");
    System.out.println("Thank You! See You!, Si Howard maam kay naay BEBE, Ako wala pa :(");
    System.exit(4);
 }


 public static void main(String[] args){
    System.out.println("***********************");
        System.out.println("* Hands On Exercise 2 *");
        System.out.println("***********************");
        Main();

        } 
}
   
        
        
            
            

