// Import Java util collection to use the two classes Scanner and ArrayList

import java.util.Scanner;
import java.util.ArrayList;

// Create class

public class Main {
    public static void main(String[] args) {

        // Instantiate Haversine and Scanner classes

        Scanner scanner = new Scanner(System.in);
        Haversine haversine = new Haversine();


        // Declare the ArrayList

        ArrayList<Venue> listOfVenues = new ArrayList<>();
        ArrayList<StaffID> listOfStaffID = new ArrayList<>();
        ArrayList<Suggestions> listOfVenueSuggestions = new ArrayList<>();


        // Declare Uid

        int uID = 1;


// While loop to make sure only valid options (integers) can be input into user menu

        while (true) {

            // Declare userOption

            int userOption = -1;

            // Display menu via the console

            try {
                System.out.println("+=====================================+");
                System.out.println("| COMPANIES MONTHLY SOCIAL EVENT      |");
                System.out.println("+=====================================+");
                System.out.println("| HR OPTIONS:                         |");
                System.out.println("|     1. Add a new venue              |");
                System.out.println("|     2. Remove all venues            |");
                System.out.println("|     3. Show venue votes             |");
                System.out.println("+-------------------------------------+");
                System.out.println("| EMPLOYEE OPTIONS:                   |");
                System.out.println("|     4. List all venues              |");
                System.out.println("|     5. Find closest venues          |");
                System.out.println("|     6. Vote for the month venue     |");
                System.out.println("|     7. Suggest a new venue          |");
                System.out.println("|     8. Exit                         |");
                System.out.println("+-------------------------------------+\n");
                System.out.print("Enter your option (in number format):\n");

                userOption = Integer.parseInt(scanner.nextLine());

                // catch anything that is not an integer

            } catch (Exception e) {

                // Refresh the console every time the menu is displayed. Makes User experience better by clearing screen for user.

                System.out.print("\033[H\033[2J");

                // Tell user that they have input an invalid option

                System.out.println("\nInvalid option! Please Try Again:\n");
            }


            // Embed password into source code as stated in brief

            String HRPasswordfixed = "hr2018";


            // Menu option 1

            if (userOption == 1) {


                System.out.print("Please enter the HR password:\n");
                String HRPassword = scanner.nextLine();

                // Validating that the user input matches HRPasswordfixed
                boolean isValidPassword = HRPassword.equals(HRPasswordfixed);


                if (isValidPassword) {
                    System.out.println("Password accepted!\n");

                    System.out.println("*** ADDING A NEW VENUE ***\n");

                    System.out.print("Enter the name of the venue:");
                    String newVenueName = scanner.nextLine();
                    System.out.print("Enter the venue category (P)ub, (R)estaurant, or (C)lub:");
                    String newVenueCat = scanner.nextLine();

                    // Created two doubles and boolean along with a while loop to catch any exceptions that are not doubles and throw back error message
                    boolean validInput = false;
                    double newVenueLat = 0.0;
                    double newVenueLon = 0.0;


                    while (!validInput) {
                        try {

                            System.out.print("Enter the venue latitude:");
                            newVenueLat = Double.parseDouble(scanner.nextLine());
                            System.out.print("Enter the venue longitude:");
                            newVenueLon = Double.parseDouble(scanner.nextLine());
                            validInput = true;
                        } catch (Exception e) {
                            System.out.println("Invalid input - must be a number (coordinate).");
                        }

                    }

                    System.out.print("Enter the description of the venue:");
                    String newVenueDescr = scanner.nextLine();
                    System.out.print("Does the venue require reservation? (Y)es/(N)o:");
                    String newVenueRes = scanner.nextLine();

                    // Start venue votes at 0

                    int venueVotes = 0;
                    boolean isValidCategory = newVenueCat.contains("P") || newVenueCat.contains("R") || newVenueCat.contains("C");
                    boolean isValidReservation = newVenueRes.contains("Y") || newVenueRes.contains("N");

                    // If the venue has met the requirements the add the venue otherwise let them know why it was not added
                    if (isValidCategory && isValidReservation) {


                        // Change P to Pub, C to Club and R to Restaurant

                        Venue newVenue = new Venue(uID++, newVenueName, newVenueCat.replace("P", "Pub").replace("R", "Restaurant").replace("C", "Club"), newVenueLat, newVenueLon, newVenueDescr, newVenueRes, venueVotes);


                        listOfVenues.add(newVenue);


                        System.out.println("\nThank you, venue added.\n");

                    } else {
                        System.out.println("\nIncorrect Venue Format.\n");
                        System.out.println("Make sure you enter a correct category in the following format: P, R or C.");
                        System.out.println("Also make sure you have entered if the venue needs reservation entering either Y or N.\n");

                    }


                } else {
                    System.out.println("Invalid password! Please Try Again:");

                }

            }
            if (userOption == 2) {
                System.out.print("Please enter the HR password:\n");
                String HRPassword = scanner.nextLine();
                boolean isValidPassword = HRPassword.equals(HRPasswordfixed);


                if (isValidPassword) {
                    System.out.print("Password accepted!\n");

                    System.out.print("*** REMOVE ALL VENUES ***\n");
                    System.out.print("Are you sure you want to delete all venues? Please enter (Y)es/(N)o\n");
                    String removeAllVenues = scanner.nextLine();

                    boolean isProcessYes = removeAllVenues.contains("Y");
                    boolean isProcessNo = removeAllVenues.contains("N");
                    if (isProcessYes) {

                        // If user says yes to the prompt then continue with removing all venues.
                        listOfVenues.clear();
                        System.out.println("Thank you, all venues removed.");


                        // If user says no then send them back to home console menu
                    } else if (isProcessNo) {
                        System.out.println("Ok, no venues removed.");

                        // Anything that is not Y or N will have this displayed to them.
                    } else {
                        System.out.println("Incorrect Option. Enter Y for yes, or N for No.");

                    }

                } else {
                    System.out.println("Invalid password! Please Try Again:");

                }
            }

            if (userOption == 3) {


                // Declare new ArrayList

                ArrayList<Venue> highestVenueVotes = new ArrayList<>();


                System.out.print("Please enter the HR password:\n");
                String HRPassword = scanner.nextLine();
                boolean isValidPassword = HRPassword.equals(HRPasswordfixed);


                if (isValidPassword) {
                    System.out.print("Password accepted!\n");

                    System.out.print("*** VENUE VOTES ***\n");

                    if (listOfVenues.size() > 0) {

                        int max = listOfVenues.get(0).getVenueVotes();


                        // To determine which venue has the most votes
                        for (Venue v : listOfVenues) {
                            System.out.println(v.getID() + (")") + (" ") + v.getVenueName() + (":") + (" ") + v.getVenueVotes() + (" "));

                            if (v.getVenueVotes() > max) {
                                max = v.getVenueVotes();
                                highestVenueVotes.clear();
                            }
                            if (v.getVenueVotes() == max) {
                                highestVenueVotes.add(v);
                            }
                        }

                        if (highestVenueVotes.size() >= 1) {
                            System.out.println("The highest voted venue(s) is:");

                            for (Venue highVotes : highestVenueVotes) {
                                System.out.println(highVotes.getVenueName());
                            }

                            // Displays the venue, or venues if there is a clash, with the highest amount of votes.

                            System.out.println("\nWith a total number of " + highestVenueVotes.get(0).getVenueVotes() + " Votes.\n");


                        } else {
                            System.out.println("\nNo venues created in our list yet!\n");
                        }
                    }

                } else {
                    System.out.println("\nInvalid password! Please Try Again:\n");
                }

            }

            if (userOption == 4) {

                for (Venue v : listOfVenues) {

                    // Uses the getters created in the venue class to list all venues.
                    System.out.println("Venue: " + v.getVenueName());
                    System.out.println("Venue Category: " + v.getVenueCat());
                    System.out.println("https://www.google.com/maps/?q=" + v.getVenueLat() + "," + v.getVenueLon());
                    System.out.println("\n-------------------------------------------\n");


                }

            }

            if (userOption == 5) {

                boolean validInput = false;
                System.out.println("*** FIND CLOSEST VENUE ***\n");

                while (!validInput) {
                    try {
                        // Allows a user to enter their current latitude and longitude
                        System.out.print("\nEnter your current latitude:");
                        double startLat = Double.parseDouble(scanner.nextLine());
                        System.out.print("\nEnter your current longitude:");
                        double startLon = Double.parseDouble(scanner.nextLine());
                        System.out.print("\nEnter the Venues latitude:");
                        double endLat = Double.parseDouble(scanner.nextLine());
                        System.out.print("\nEnter the Venues longitude:");
                        double endLon = Double.parseDouble(scanner.nextLine());

                        validInput = true;

                        // Inherit method from Haversine class to workout distance in KM

                        double dist = Haversine.distance(startLat, startLon, endLat, endLon);

                        // Use printf and %.2f to get the total distance to just 2 decimal places

                        System.out.printf("\nThe distance is: " + "%.2f", dist);
                        System.out.print(" Kilometres\n");


                    } catch (Exception e) {
                        System.out.println("Invalid input - must be an integer (coordinate). ");

                    }

                }
            }


            if (userOption == 6) {

                System.out.println("*** VOTE ON THE VENUE OF THE MONTH ***\n");
                System.out.println("Here are the venue options for this month:");
                System.out.println("------------------------------------------");

                // Retrieve venues to display to user
                for (Venue v : listOfVenues) {
                    System.out.println(v.getID() + "." + " " + v.getVenueName() + " " + "(" + v.getVenueCat() + ")");
                }

                boolean validInput = false;

                while (!validInput) {
                    try {
                        boolean found = false;
                        System.out.print("Please enter your employee number:");
                        int addEmployeeNumber = Integer.parseInt(scanner.nextLine());
                        StaffID staffID = new StaffID(addEmployeeNumber);

                        // Checks if the user ID already exists in the list because they cannot vote twice
                        for (StaffID s : listOfStaffID) {
                            if (s.equals(staffID)) {
                                System.out.println("\nSorry, you have already voted. Please try again next month.\n");
                                found = true;

                            }
                            validInput = true;
                        }

                        // If the employee ID is unique then add it too the ArrayList and add one vote to the venue they voted for
                        if (!found) {
                            System.out.println("Please enter the venue code to cast your vote:");
                            int addVenueCode = Integer.parseInt(scanner.nextLine());
                            if (listOfVenues.size() >= addVenueCode) {
                                listOfVenues.get(addVenueCode - 1).setVenueVotes();
                                listOfStaffID.add(staffID);

                                System.out.println("\nThank you, your vote was saved!\n");


                            } else {
                                System.out.println("\nSorry, you entered a venue that does not exist. Please try again.\n");

                                break;

                            }


                        }

                        // If anything but an integer is input then an exception is caught.
                    } catch (Exception e) {
                        System.out.println("Invalid input - must be an integer ");

                    }


                }

            }


            if (userOption == 7) {
                System.out.println("*** SUGGEST A NEW VENUE ***\n");
                System.out.print("Enter the name of the venue you want to suggest:\n");
                String newSuggestion = scanner.nextLine();


                // Instantiate the class
                Suggestions newVenueSuggestion = new Suggestions(newSuggestion);

                // Add venue suggesiton to ArrayList
                listOfVenueSuggestions.add(newVenueSuggestion);


                System.out.println("Thank you, your suggestion was saved.");


            }
            if (userOption == 8) {
                System.out.println("Exiting the program!");
                // If user inputs 8 it will exit application
                break;

            }
        }

    }
}