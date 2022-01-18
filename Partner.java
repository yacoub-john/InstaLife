import java.util.*;
import java.util.Random;

/**
 * Partner class.
 */
public class Partner {
  public static int playerGender, partnerGender, partnerChosen = 0, partnerAge = 0;

  /**
   * Constructor pre: none post: Transfers passed values to the Finances class and
   * gender of the partner is determined.
   */
  public Partner(int gender) {

    if (playerGender == 1) // assigns the partner's gender the opposite of the character.
    {
      partnerGender = 0;
    }

    if (playerGender == 0) {
      partnerGender = 1;
    }
  }

  /**
   * Diplayes and allows you to choose of 4 possible partners. pre: none post: The
   * names and stats of possible partners is displayed and the players choice is
   * made.
   */
  public static void findPartner(int age) {
    final String[] maleNames = new String[] { "Dwight", "Charles", "Donald", "Ben", "James", "Robert", "John",
        "Benjamin", "Richard", "Logan", "David", "Thomas", "Ronald", "Joseph", "Gary", "George", "Kenneth", "Paul",
        "Edward", "Jerry", "Dennis", "Frank", "Daniel", "Raymond", "Roger", "Stephen", "Gerald", "Walter", "Harold",
        "Steven", "Lawrence", "Terry", "Wayne", "Arthur", "Jack", "Carl", "Henry", "Willie", "Bruce", "Joe", "Peter",
        "Billy", "Roy", "Ralph", "Anthony", "Jimmy", "Albert", "Bobby", "Eugene", "Johnny", "Harry", "Howard", "Mark",
        "Alan", "Louis", "Philip", "Patrick", "Dale", "Danny", "Stanley", "Leonard", "Timothy", "Gregory", "Samuel",
        "Ronnie", "Norman", "Ernest", "Russell", "Francis", "Melvin", "Earl", "Frederick", "Allen", "Bill", "Tommy",
        "Phillip", "Marvin", "Steve", "Don", "Clarence", "Barry", "Glenn", "Jim", "Eddie", "Mike", "Andrew", "Jeffrey",
        "Leroy", "Alfred", "Martin", "Lee", "Tom", "Ray", "Herbert", "Gene", "Bernard", "Theodore", "Curtis", "Keith",
        "Clifford" };
    // Array of common men names for random name generator.

    final String[] femaleNames = new String[] { "Mary", "Linda", "Barbara", "Patricia", "Carol", "Sandra", "Nancy",
        "Sharon", "Judith", "Susan", "Betty", "Carolyn", "Margaret", "Shirley", "Judy", "Karen", "Donna", "Kathleen",
        "Joyce", "Dorothy", "Janet", "Diane", "Janice", "Joan", "Elizabeth", "Brenda", "Gloria", "Virginia", "Marilyn",
        "Martha", "Beverly", "Helen", "Bonnie", "Ruth", "Frances", "Jean", "Ann", "Phyllis", "Pamela", "Jane", "Alice",
        "Peggy", "Cheryl", "Doris", "Catherine", "Elaine", "Cynthia", "Marie", "Lois", "Connie" };
    // Array of common women names for random name generator.

    Random random = new Random();
    Scanner input = new Scanner(System.in);
    boolean validaion = false;
    int choice;

    if (partnerGender == 1) // if the partner's gender is female 4 random female names are displayed with
                            // ther stats.
    {
      String[] femalePartners = new String[] { "", "", "", "", "" };
      System.out.println();

      for (int i = 0; i < femalePartners.length - 1; i++) // displays the stats of the partners and their names.
      {
        partnerAge = age - random.nextInt(3);
        femalePartners[i] = femaleNames[random.nextInt(51)] + " " + maleNames[random.nextInt(101)];
        System.out.println(i + 1 + ". " + femalePartners[i] + ": ");
        System.out.println("Age: " + partnerAge + " ");
        System.out.println("Happiness 😊 : " + (random.nextInt(51) + 50) + " ");
        System.out.println("Health ❤ : " + (random.nextInt(51) + 50) + " ");
        System.out.println("Intelligence 🤓 : " + (random.nextInt(51) + 50) + " ");
        System.out.println("Looks 😏 : " + (random.nextInt(51) + 50));
        System.out.println();
      }

      while (!validaion) // ensures player chooses and approperiate value.
      {
        System.out.println("Pick a Partner: ");
        choice = input.nextInt();

        if (choice > 0 && choice < 5) {
          System.out.println("Your Partner is: " + femalePartners[choice - 1]); // players choice made.
          partnerChosen = 1;
          validaion = true;
        }

        else if (choice == 0) {
          Choices.menu();
        }

        else {
          System.out.println("Invalid input"); // if a wrong value inputed a message is displayed.
        }
      }
    }

    if (partnerGender == 0) // if the partner's gender is male 4 random male names are displayed with ther
                            // stats.
    {
      String[] malePartners = new String[] { "", "", "", "", "" };
      System.out.println();

      for (int i = 0; i < malePartners.length - 1; i++) // displays the stats of the partners and their names.
      {
        partnerAge = age + random.nextInt(3);
        malePartners[i] = maleNames[random.nextInt(101)] + " " + maleNames[random.nextInt(101)];
        System.out.println(i + 1 + ". " + malePartners[i] + ": ");
        System.out.println("Age: " + partnerAge + " ");
        System.out.println("Happiness 😊 : " + (random.nextInt(51) + 50));
        System.out.println("Health ❤ : " + (random.nextInt(51) + 50));
        System.out.println("Intelligence 🤓 : " + (random.nextInt(51) + 50));
        System.out.println("Looks 😏 : " + (random.nextInt(51) + 50));
        System.out.println();
      }

      while (!validaion) // ensures player chooses and approperiate value.
      {
        System.out.println("Pick a Partner [0] To Exit: ");
        choice = input.nextInt();

        if (choice > 0 && choice < 5) {
          System.out.println("Your Partner is: " + malePartners[choice - 1]); // players choice made.
          partnerChosen = 1;
          validaion = true;
        }

        else if (choice == 0) {
          Choices.menu();
        }

        else {
          System.out.println("Invalid input"); // if a wrong value inputed a message is displayed.
        }
      }

    }

  }

}