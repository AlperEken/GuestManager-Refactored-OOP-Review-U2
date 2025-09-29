package partyModel;

import partyController.Controller;

import javax.swing.*;
import java.util.Scanner;

public class GuestManager {
  /* Keep ONLY the following instance variables for the class:
     - number of guests currently stored in the list/array
       (not the total possible number of guests (use .length for this))
     - one array for the list with guests where
       the guests are objects of class Guest
  */
  private int nbrOfGuests = 0; //Hur många gäster som finns för tillfället!
  private Guest[] guestList; //Lista över alla gäster!

  private Controller controller;

  /* Create a constructor with one parameter which is
     the max number of elements (guests) in the list/array.
     Create the array with the max number of elements.
     Check that the max number of Guests is larger than 0.
     If max number of guests is not larger than 0 ask the user to give a new value
     until you get a value that is larger than 0.
   */
  public GuestManager(int maxNbrOfGuests){
    boolean done = false;

    if (maxNbrOfGuests <= 0){
      while (!done){
        JOptionPane.showMessageDialog(null, "You need to enter a number higher than 0!");
        try {
          String maxNbrOfGuestsString = JOptionPane.showInputDialog(null, "Enter the number of guests that shall attend");
          maxNbrOfGuests = Integer.parseInt(maxNbrOfGuestsString);
        } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(null, "Enter a NUMBER higher than 0!");
          break;
        }
        done = true;
      }
    }
    guestList = new Guest[maxNbrOfGuests];
  }

  /* A method that returns the number of guests stored in
     the guest list RIGHT NOW.
   */
  public int getNbrOfGuests(){
    return nbrOfGuests;
  }

  /* Create a method to add a guest to the list with all the parameters
     matching instance variables of Guest and Address.
     In the method create a new Guest-object and let classes Guest and Address
     take care of issues with values of the parameters.
     Add the new Guest-object to the array at the first empty element (here is where you
     use the instance variable for number of guests stored in the list). If there are no
     more empty elements call a private method in GuestManager to increase the size
     of the array and then add the new Guest-object. Do not forget to update the value
     of the instance variable for number of guests in the list.
   */

  /* Så basically, to create a method that adds a new guest by creating a guest-object
     and let the address and guest classes handle them with the constructors using parameters.

     Add the guest to the first empty place. If no place, increase the size of the array and
     make room for one more. ALSO update the variable of value the number of guests and GUI.
   */

  public void newGuest(String firstName, String lastName, int age, String street, String zipcode, String city, Countries country){
    int maxGuestsNumber = controller.getMaxGuestsNumber();

    if (nbrOfGuests == 0) {
        guestList[0] = new Guest(firstName, lastName, age, street, zipcode, city, country);
        nbrOfGuests++;
        JOptionPane.showMessageDialog(null, "Hello " + firstName + ", your have been added successfully!");
        return;
      }

    if (nbrOfGuests < maxGuestsNumber){
      for (int i = 0; i < guestList.length; i++){
        if (guestList[i] == null) {
          guestList[i] = new Guest(firstName, lastName, age, street, city, zipcode, country );
          nbrOfGuests++;
          JOptionPane.showMessageDialog(null, "Hello " + firstName + ", your have been added successfully!");
          return;
        }
      }
    }

    if (nbrOfGuests >= maxGuestsNumber){
      controller.increaseMaxGuestsNumber();
      increaseGuestList();
      guestList[nbrOfGuests] = new Guest(firstName, lastName, age, street, city, zipcode, country );
      nbrOfGuests++;
      JOptionPane.showMessageDialog(null, "Hello " + firstName + ", you have been added successfully after expanding the list!");
    }
  }


  /* Create method to delete a guest by giving the index in the array
     for the object (guest) to delete as a parameter to the method.
     This method should call the private method moveElementsToLeft to remove
     the empty element in between other objects (may not be necessary
     if the guest removed was the last guest in the list).
     Remember to update the value of the instance variable for
     number of guests in the list.
   */


  /* A guest should be deleted by index. This methods calls "moveElementsToLeft" to remove empty spaces
     within the array, however not necessary when last in array. Update the number of guests!
   */
  public void removeGuest(int index){
    guestList[index] = null;

    nbrOfGuests--;

    if (index != controller.getMaxGuestsNumber()-1){
      moveElementsToLeft(index);
    }
  }

  private void moveElementsToLeft(int index){
        /* Add code to remove empty element places that
           is not att the end of the array. Start at
           the parameter index that is the empty element
           whose gap we want to fill.

           You are not allowed to take a shortcut by using class Array or similar from a Java-library.
         */

    for (int i = index; i < nbrOfGuests-1; i++){
        guestList[i] = guestList[i+1];
      }

    guestList[nbrOfGuests-1] = null;
  }

  private void increaseGuestList(){
    /* Write code that creates a new array of Guest-objects
       that is 10 elements large that the current array instance variable .

       Copy the current array to the larger array and after that is done
       point the instance variable to the new array.

       You are not allowed to take a shortcut by using class Array or similar from a Java-library.
     */

    System.out.println("Gästlistan ökades med 10!");

    Guest temp[] = new Guest[guestList.length + 10];

    for (int i = 0; i < guestList.length; i++){
      temp[i] = guestList[i];
    }

    guestList = temp;

  }

  /* A method that returns the Guest-object at the given
     index n the parameter.
   */
  public Guest getGuestAt(int index){
    /* Add code to check that the parameter index
       has a value within the range of the array.
       If index is not in valid range return null.
       Yes, some checks are done in the Controller-object
       in this program but we do not want this class to depend
       on other classes for this, so sometimes we write redundant
       error handling in different ways to have more robust classes or code.
     */
    return null;
  }

  public String[] getInfoStrings() { // Färdig implementerad metod!
    /* Write code that returns an array of strings where each element
       represents information about one guest in the list by calling every
       Guest-object's toString method.

       The number of elements in the array should be equal to the
       number of guests currently stored in the list.
       (no strings should be created for empty places at the end of the array st)
    */

    if (nbrOfGuests == 0){
      return new String[0];
    }

    String[] infoStrings = new String[nbrOfGuests];

    for(int i = 0; i < nbrOfGuests; i++){
        infoStrings[i] = guestList[i].toString();
    }
      return infoStrings;
  }

  public String getStatistics(){
    /* Write code that calculates the following statistics and returns these as a
      formatted String using line breaks for each statistic.
      - total number of guests
      - number of adults where an adult guest is someone over the age of 13
      - number of children where a child is someone age 13 or younger
      - the name and age of the oldest guest
      - the name and age of the youngest guest

      If there are no guests in the guest list return a string that
      informs the user of this.
    */

    //This return statement is just used for the code template. Erase and replace with code for calculating tha statistics as asked for above.
    return ("Number of guests: "+nbrOfGuests+"\n"+
            "Number of adults: 6 \n"+
            "Number of children: 2 \n"+
            "Oldest guest: Fake Name of age 100 \n"+
            "Youngest guest: Bogus Name of age 7");

  }

  public void setController(Controller controller) {
    this.controller = controller;
  }

  public void setGuestList(){
    this.guestList = guestList;
  }


}
