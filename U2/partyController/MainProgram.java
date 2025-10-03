package partyController;

import javax.swing.*;

public class MainProgram
{
    public static void main(String[] args)
    {
        boolean rightFormat = false;
        int maxNbrOfGuests = 0;

        do {
            try {
                String maxNbrOfGuestsString = JOptionPane.showInputDialog(null, "How many guests will attend?");

                if(maxNbrOfGuestsString == null){
                    System.exit(0);
                }

                maxNbrOfGuests = Integer.parseInt(maxNbrOfGuestsString);
                rightFormat = true;

            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"You need to enter a number!");
            }
        } while (!rightFormat);



        Controller controller = new Controller(maxNbrOfGuests);
    }
}
