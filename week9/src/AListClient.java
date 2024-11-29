/**
 * Created by abbyr on 26/11/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
import java.util.Arrays;
import java.util.Random;

public class AListClient
{
   public static void main(String[] args){

//      AListChain2 myList = new AListChain2();
//
//      myList.add(1);
//      myList.add(2);
//      myList.add(3);
//      myList.add(4, 2);
//      System.out.println("List should be 1, 4, 3, 3");
//      System.out.println(Arrays.toString(myList.toArray()));
//
//      myList.remove(2);
//      System.out.println("List should be 1, 2, 3");
//      System.out.println(Arrays.toString(myList.toArray()));
//
//      myList.replace(2, 22);
//      System.out.println("List should be 1, 22, 3");
//      System.out.println(Arrays.toString(myList.toArray()));
//
//      System.out.println("List of " + myList.getLength() + " elements contains 22 is " + myList.contains(22));
//      System.out.println("List of " + myList.getLength() + " elements contains 2 is " + myList.contains(2));
//
//      System.out.println("List is empty? " + myList.isEmpty());
//      myList.clear();
//      System.out.println("List is empty? " + myList.isEmpty());
//
//      for(int i=1; i<=250; i++){
//         myList.add(i);
//      }
//      System.out.println(Arrays.toString(myList.toArray()));
      AListChain2 list = new AListChain2();
      for (int i = 1; i <= 100; i++) {
         list.add(i);
      }
      System.out.println("List is " + list.toString());

      // Step 2: Generate 10 random positions
      Random random = new Random();
      int[] randomPositions = random.ints(10, 1, 101).toArray();

      // Step 3: Test getNodeAt() and output results
      for (int position : randomPositions) {
         int steps = list.getNodeJumps(position); // Track the number of jumps
         int value = (int) list.getNodeAt(position).getData(); // Get the node's value
         System.out.println("getNodeAt(" + position + ") returns " + value + " in " + steps + " steps");
      }
   }




}//class
