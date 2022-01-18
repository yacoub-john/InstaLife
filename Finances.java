import java.util.*;
import java.text.NumberFormat;
import java.util.Random; 

/**
* Finances class.
*/
public class Finances 
{
  public static double balance, salary, monthlyOut = 0, netWorth = 0, homeVal = 0, carVal = 0; // values for the players assets.
  public static int year, age;
  
  /**
  * Constructor
  * pre: none
  * post: Transfers passed values to the Finances class.
  */
  public Finances(int year, int age)
  {
    this.year = year;
    this.age = age; 
  }

   /**
  * Checks if the character has a partnerChosen and assigns a proper balance.
  * pre: none
  * post: The balance is changed if the character has a partner
  */
  public static void partnerBalance()
  {
    if(Choices.playerPartner.partnerChosen == 1)
    {
      Random r = new Random();
      deposit( (r.nextInt(100000) + 10000 ) );
    }

    if(salary > 0)
    {
      deposit(2*salary + 2*salary*Career.bonus);
    }
  }

  /**
  * Displayes the characters financial information.
  * pre: none
  * post: The financial Information of the player is shown.
  */
  public static void checkBalance()
  {
    NumberFormat money = NumberFormat.getCurrencyInstance();
    System.out.println();
    System.out.println("Your Finance: ");
    System.out.println("Annual Salary: " + money.format(salary) );
    
    if(Choices.playerPartner.partnerChosen == 1)
    {
      System.out.println("Combined Bank Balance: " + money.format(balance) );
    }
    
    else 
    {
      System.out.println("Bank Balance: " + money.format(balance) );
    }
   
    System.out.println("Your monthly Outgoings: " + money.format(monthlyOut) );
    System.out.println("Your net worth: " +  money.format(balance + homeVal+ carVal) );
    System.out.println();
  }

  /**
  * Depostits the passed value into the characters balance.
  * pre: none
  * post: The passes value is depostied into the characters balance.
  */
  public static void deposit(double amount)
  {
    balance = balance + amount;
  }

  /**
  * Deducts the passed value from the characters balance.
  * pre: none
  * post: The passes value is deducted from the characters balance.
  */
  public static void withdraw(double amount)
  {
    balance = balance - amount;

    if(age < 18)
    {
      balance = 0;
    }
    
  }

  /**
  * Calulates the player spending on atwo year basis.
  * pre: none
  * post: The players balance after 2 years are calulated.
  */
  public static void yearlyCalculation()
  {
    balance = balance + 2*salary - 24*monthlyOut;
  }

  /**
  * Displays the houses the player can purchase with their prices.
  * pre: none
  * post: The player can buy a house if they have enough money in their account.
  */
  public static void buyHouse()
  {
    int bedroom = 0, bathroom = 0, list, random ,price ,decision;
    Random rand = new Random();
    Scanner input = new Scanner(System.in);
    NumberFormat money = NumberFormat.getCurrencyInstance();


    int[] prices = new int[10];  //array for the prices of the houses. 
    String[] houses  = new String [10]; // array to store the home names
    
    System.out.println();
    for(int i=0; i<= prices.length-1 ; i++)
    {
      
      random = rand.nextInt(3); 
      bedroom = (rand.nextInt(4) + 2 ); // random number of bedrooms 
      bathroom = (rand.nextInt(3) + 2 ); // random number of bathrooms; 

      String[] houseTypes = new String[]
      { ( bedroom + " bedroom home," + bathroom + " bathroom(s), off street parking"),                 
      ( bedroom + " bedroom penthouse," + bathroom + " bathroom(s), off street, parking"),                                          ( bedroom + " bedroom apartment," + bathroom + " bathroom(s), off street, parking") 
      };
      // An array list with all the possible house for purchase.

      price = 100000*bathroom*bedroom; // price is proportional to number of bedrooms and bathrooms.
      houses[i] = houseTypes[rand.nextInt(3)];
      prices[i] = price;
      System.out.println((i+1) + ". " + houses[i] + " for: " +  money.format(price) );
    }

    int choice = 0;
    boolean validation = false;
    
   
    while(!validation)
    {
      System.out.println();
      System.out.println("Which house would you like to buy [0] To exit :   ");
      choice = input.nextInt();
    

      if(choice >= 0 && choice <= 10)
      {

        if(choice == 0)  // returns back to menu
        {
          Choices.menu();
        }

        else if(balance >= prices[choice-1])
        {
          System.out.println("Congratulations you bought a: " + houses[choice-1] ); // player can buy the house.
          withdraw(prices[choice-1]); // withdraws from balance
          homeVal = prices[choice-1]; // adds home value to net worth
          Choices. menu(); // returns back to menu
          Choices.house = 1;
        }

        else
        {
          System.out.println("Sorry you can not afford this house."); // player cannot afford the house.
        }
      }

      else
      {
        System.out.println("Invalid Input"); // if a wrong value inputed a message is displayed.
      }
    }

  }

  /**
  * Displays the cars the player can purchase with their prices.
  * pre: none
  * post: The player can buy a car if they have enough money in their account.
  */
  public static void buyCar()
  {
    int litres = 0, doors = 0, list, random ,price ,decision;
    Random rand = new Random();
    Scanner input = new Scanner(System.in);
    NumberFormat money = NumberFormat.getCurrencyInstance();


    int[] prices = new int[10];  //array for the prices of the cars. 
    String[] cars  = new String [10]; // array to store the cars names
    
    System.out.println();
    for(int i=0; i<= prices.length-1 ; i++)
    {
      
      random = rand.nextInt(3); 
      litres = (rand.nextInt(4) + 2 ); // random number of litres engine 
      doors = (rand.nextInt(3) + 2 ); // random number of doors 

      String[] carTypes = new String[]
      { ( litres + "L engine," + doors + " pertrol car"),                 
      ( litres + "L engine," + doors + " diesel SUV"), ( litres + "L engine," + doors + " pertrol sports car") };
      // An array list with all the possible house for purchase.

      price = 10000*litres*doors; // price is proportional to number of doors and litres.
      cars[i] = carTypes[rand.nextInt(3)];
      prices[i] = price;
      System.out.println((i+1) + ". " + cars[i] + " for: " +  money.format(price) );
    }

    int choice = 0;
    boolean validation = false;
    while(!validation)
    {
      System.out.println();
      System.out.println("Which car would you like to buy [0] To exit :   ");
      choice = input.nextInt();
    

      if(choice >= 0 && choice <= 10)
      {

        if(choice == 0)  // returns back to menu
        {
          Choices.menu();
        }

        else if(balance >= prices[choice-1])
        {
          System.out.println("Congratulations you bought a: " + cars[choice-1] ); // player can buy the car.
          withdraw(prices[choice-1]); // withdraws from balance
          carVal = prices[choice-1]; // adds car value to net worth
          Choices.menu(); //returns back to menu

        }

        else
        {
          System.out.println("Sorry you can not afford this house."); // player cannot afforf the car.
        }
      }

      else
      {
        System.out.println("Invalid Input"); // if a wrong value inputed a message is displayed.
      }
    }
  }
}