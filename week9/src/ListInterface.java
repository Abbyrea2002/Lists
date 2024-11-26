/**
 * Created by abbyr on 26/11/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
public interface ListInterface<T>
{
   public void add(T newEntry);
   /* Adds a new entry to the end of this list.
   Entries currently in the list are unaffected.
   The lists size is increased by 1.

   @para newEntry the object to be added as a new list entry
    */

   public void add(int newPosition, T newEntry);
   /* adds a new entry at a specific position within this list
   entries originally at and above specified position
   are at the next higher position within the list
   the lists size is increased by 1

   @param newPosition int that specifies the desired position of the new entry

   @param newEntry object to be added as new entry

      @throws IndexOutOfBoundsException if either position < 1
   or position  > getLength()

    */

   public T remove(int position);
   /*removes the entry at the given positionn from the list
   entries originallt at position higher than the given position
   are at the next lower position within the list and the lists size is decreased by 1

   @param position an int that indicates position of the entry to be removed

   @return a reference to be removed entry

   @throws IndexOutOfBoundsException if either position < 1
   or position  > getLength()
    */

   public void clear();
   /* removes all entries from list
    */

   public T replace(int position, T newEntry);
   /* replaces the entry at the given position in this list

   @param position an int that indicated the postion
   of entry to be removed

   @param newEntry object to be added as a new entry

   @return the original entry that was replaced

   @throws IndexOutOfBoundsException if either position < 1
   or position  > getLength()
    */

   public T getEntry(int position);
   /* retrives entry ar given position in list

   @param position an int that indicates position of entry to be returned

   @return a reference of the desired entry

   @throws indexOutOfBoundsException if either position < 1
   or position > getLength()


    */

   public T[] toArray();
   /* retrives all entries in this list in order in which they appears in the list

   @return newly allocated array of all entries in list.
   if lst is empty, return array is empty.
    */

   public boolean contains(T anEntry);
   /*check wether list contains a given entry

   @param anEntry the object that is the desired entry

   @return true if list contains anEntry, false otherwise
    */

   public int getLength();
   /* gets length of list

   @return integer number of entries in this list
    */

   public boolean isEmpty();
   /* check wether the list is empty

   @return true of getLength() == 0, false otherwise    */
}//class
