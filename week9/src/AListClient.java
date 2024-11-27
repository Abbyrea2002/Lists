/**
 * Created by abbyr on 26/11/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
import java.util.Arrays;
public class AListClient
{
   public static void main(String[] args){

      AListChain2 myList = new AListChain2();

      myList.add(1);
      myList.add(2);
      myList.add(3);
      myList.add(4, 2);
      System.out.println("List should be 1, 4, 3, 3");
      System.out.println(Arrays.toString(myList.toArray()));

      myList.remove(2);
      System.out.println("List should be 1, 2, 3");
      System.out.println(Arrays.toString(myList.toArray()));

      myList.replace(2, 22);
      System.out.println("List should be 1, 22, 3");
      System.out.println(Arrays.toString(myList.toArray()));

      System.out.println("List of " + myList.getLength() + " elements contains 22 is " + myList.contains(22));
      System.out.println("List of " + myList.getLength() + " elements contains 2 is " + myList.contains(2));

      System.out.println("List is empty? " + myList.isEmpty());
      myList.clear();
      System.out.println("List is empty? " + myList.isEmpty());

      for(int i=1; i<=250; i++){
         myList.add(i);
      }
      System.out.println(Arrays.toString(myList.toArray()));



   }
}//class
