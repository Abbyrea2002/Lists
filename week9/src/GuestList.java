/**
 * Created by abbyr on 29/11/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
import java.util.Scanner;
public class GuestList{
   private AListArray<String> guestList;
      // Constructor to initialize the guest list
    public GuestList() {
         guestList = new AListArray<>();
      }

      /**
       * Adds a guest to the list in alphabetical order or removes them if they already exist.
       * @param name The name to be added or removed.
       */
      public void addOrRemoveGuest(String name) {
         int position = findInsertPosition(name);

         if (position <= guestList.getLength() && guestList.getEntry(position).equalsIgnoreCase(name)) {
            // If the name is already in the list, remove it

            guestList.remove(position);
         } else {
            // Otherwise, add the name at the appropriate position
            guestList.add(position, name);

         }
      }

      /**
       * Finds the correct alphabetical position to insert the name.
       * @param name The name to be inserted.
       * @return The index where the name should be inserted.
       */
      private int findInsertPosition(String name) {
         int i = 1;
         while (i <= guestList.getLength() && name.compareToIgnoreCase(guestList.getEntry(i)) > 0) {
            i++;
         }
         return i;
      }

      /**
       * Displays the current guest list.
       */
      public void showGuestList() {
         if (guestList.isEmpty()) {
            System.out.println("The guest list is currently empty.");
         } else {
            System.out.println("Current Guest List:");
            for (int i = 1; i <= guestList.getLength(); i++) {
               System.out.println(guestList.getEntry(i));
            }
         }
      }

      /**
       * Main method to test the functionality of the GuestList class.
       */
      public static void main(String[] args) {
         GuestList guestListManager = new GuestList();
         Scanner scanner = new Scanner(System.in);

         while (true) {
            System.out.print("Enter a name: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("xxx")) {
               System.out.println("\nFinal Guest List:");
               guestListManager.showGuestList();

               break;
            } else if (input.equalsIgnoreCase("ShowMeTheList")) {
               guestListManager.showGuestList();
            } else if (!input.isEmpty()) {
               guestListManager.addOrRemoveGuest(input);
            }
         }

         scanner.close();
      }
}//class
