/**
 * Created by abbyr on 27/11/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
public class AListChain2<T> implements ListInterface<T>
{
   private MyNode2 firstNode, lastNode;
   private int numberOfEntries;
   public MyNode2 getNodeAt(int position){
      if (position < 1 || position > numberOfEntries) return null;

      MyNode2 currentNode;
      int jumps = 0;

      // Decide whether to start from the head or tail
      if (position <= numberOfEntries / 2) {
         currentNode = firstNode;
         for (int i = 1; i < position; i++) {
            currentNode = currentNode.getNextNode();
            jumps++;
         }
      } else {
         currentNode = lastNode;
         for (int i = numberOfEntries; i > position; i--) {
            currentNode = currentNode.getPreviousNode();
            jumps++;
         }
      }

      return currentNode;
   }
   public int getNodeJumps(int position) {
      if (position < 1 || position > numberOfEntries) return -1;

      int jumps = 0;
      MyNode2 currentNode;

      // Decide whether to start from the head or tail
      if (position <= numberOfEntries / 2) {
         currentNode = firstNode;
         for (int i = 1; i < position; i++) {
            currentNode = currentNode.getNextNode();
            jumps++;
         }
      } else {
         currentNode = lastNode;
         for (int i = numberOfEntries; i > position; i--) {
            currentNode = currentNode.getPreviousNode();
            jumps++;
         }
      }
      return jumps;
   }
   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder("[");
      MyNode2 currentNode = firstNode;
      while (currentNode != null) {
         sb.append(currentNode.getData()).append(", ");
         currentNode = currentNode.getNextNode();
      }
      if (sb.length() > 1) sb.setLength(sb.length() - 2); // Remove trailing comma
      sb.append("]");
      return sb.toString();
   }






   public AListChain2(){
      firstNode = null;
      lastNode = null;
      numberOfEntries = 0;

   }
   public void add(T newEntry){
      MyNode2 newNode = new MyNode2<T>(newEntry);
      if(numberOfEntries == 0){
         firstNode = newNode;
         lastNode = newNode;
      }else{
         lastNode.setNextNode(newNode);
         newNode.setPreviousNode(lastNode);
         lastNode = newNode;
      }
      numberOfEntries++;



   }

   public void add(int newPosition, T newEntry){
      if(newPosition >= 1 && newPosition <=  numberOfEntries + 1){
         MyNode2 newNode = new MyNode2<T>(newEntry);
         if(numberOfEntries == 0){
            firstNode = newNode;
            lastNode = newNode;
         }
         else if(newPosition == 1){
            firstNode.setPreviousNode(newNode);
            newNode.setNextNode(firstNode);
            firstNode = newNode;

         }else if(newPosition == numberOfEntries + 1){
            newNode.setPreviousNode(lastNode);
            lastNode.setNextNode(newNode);
            lastNode = newNode;
         }else
         {

            MyNode2 nodeBefore = getNodeAt(newPosition - 1);
            MyNode2 nodeAfter = nodeBefore.getNextNode();
            newNode.setNextNode(nodeAfter);
            newNode.setPreviousNode(nodeBefore);
            nodeBefore.setNextNode(newNode);
            nodeAfter.setPreviousNode(newNode);
         }

         numberOfEntries++;
      }else throw new IndexOutOfBoundsException("New entry position is out of bounds");

   }

   public T remove(int position){
      T result = null;
      if(position >= 1 && position <=  numberOfEntries){
         if(numberOfEntries == 1){
            result = (T)firstNode.getData();
            firstNode = null;
            lastNode = null;
         }
         else if(position == 1){
            result = (T)firstNode.getData();
            firstNode.getNextNode().setPreviousNode(null);
            firstNode = firstNode.getNextNode();
         }else if(position == numberOfEntries){
            result = (T)lastNode.getData();
            lastNode = lastNode.getPreviousNode();
            lastNode.setNextNode(null);
         }
         else{
            MyNode2 nodeBefore = getNodeAt(position - 1);
            MyNode2 nodeToRemove = nodeBefore.getNextNode();
            MyNode2 nodeAfter = nodeToRemove.getNextNode();
            result = (T)nodeToRemove.getData();
            nodeBefore.setNextNode(nodeAfter);
            nodeAfter.setPreviousNode((nodeBefore));
         }
         numberOfEntries--;
         return result;


      }else throw new IndexOutOfBoundsException("remove position is out of bounds");
   }

   public void clear(){
      firstNode = null;
      lastNode = null;
      numberOfEntries = 0;

   }

   public T replace(int position, T newEntry){
      if(position >= 1 && position <= numberOfEntries){
         MyNode2 currentNode = getNodeAt(position);
         T dataValue = (T)currentNode.getData();
         currentNode.setData(newEntry);
         return dataValue;

      }else throw new IndexOutOfBoundsException("Replace position is out of bounds");

   }

   public T getEntry(int position){
      if(position >= 1 && position <= numberOfEntries){
         MyNode2 currentNode = getNodeAt(position);
         return (T)currentNode.getData();

      }else throw new IndexOutOfBoundsException("Get entry position is out of bounds");

   }

   public T[] toArray(){
      T[] arr = (T[]) new Object[numberOfEntries];
      MyNode2 currentNode = firstNode;
      int i = 0;
      while(i < numberOfEntries && currentNode !=null){
         arr[i++] = (T)currentNode.getData();
         currentNode.getNextNode();
      }
      return arr;

   }

   public boolean contains(T anEntry)
   {
      boolean found = false;
      int i = 1;
      while (i <= numberOfEntries && !found)
         if (getEntry(i++).equals(anEntry)) found = true;
      return found;

   }

   public int getLength(){
      return numberOfEntries;

   }

   public boolean isEmpty(){
      return (numberOfEntries == 0);

   }
}//class
