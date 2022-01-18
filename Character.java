 import java.util.*;
 import java.util.Random; 

/**
* Character class.
*/
public class Character
{
  public int age, year, happiness, health, smarts, looks, intial = 0; // overall stats of the character.

  /**
   * Constructor
   * pre: none
   * post: Transfers passed values to the character class.
   */
  public Character(int age, int year)
  {
    this.age = age;
    this.year = year;
    intial++;


    if(intial == 1) // sets the values of the characters stats randomly (occurs at intial call only)
    {
      Random random = new Random();
      happiness = (random.nextInt(41)+50 );
      health = (random.nextInt(40)+50 );
      smarts = (random.nextInt(39)+50 );
      looks = (random.nextInt(38)+50 );
    }
  }

  /**
   * Displayes the statistics of the player like happiness, health, intelligence, and looks.
   * pre: none
   * post: The statistics of the player like happiness, health, intelligence, and looks are displayed.
   */

  public void viewStats()
  {
    System.out.println();
    System.out.println("Your stats are: ");
    System.out.println("Happiness 😊: " + happiness );
    System.out.println("Health ❤: " + health);
    System.out.println("Intelligence 🤓: " + smarts);
    System.out.println("Looks 😏: " + looks  );
    System.out.println();
  }
  

   /**
   * Changes (adds or subtracts) the values of the characters stats.
   * pre: none
   * post: Based on the passed values changes(addtion or subtraction) of the stats occur. 
   */

  public void changeStats(int change ,int happy, int heart, int intell, int appear)
  {
    if(change == 0 ) // adds to the stats
    {
      happiness = happiness + happy ;
      health = health + heart;
      smarts = smarts + intell;
      looks = looks + appear;
    }

    if(change == 1 ) //subtracts from the stats
    {
      happiness = happiness - happy ; 
      health = health - heart;
      smarts = smarts - intell;
      looks = looks - appear;
    }

    if(happiness > 100) // if stat greater than 100, its value is changes back to 100
    {
      happiness = 100;
    }

    if(health > 100) // if stat greater than 100, its value is changes back to 100
    {
      health = 100;
    }

    if(smarts > 100) // if stat greater than 100, its value is changes back to 100
    {
      smarts = 100;
    }

    if(looks > 100) // if stat greater than 100, its value is changes back to 100
    {
      looks = 100;
    }

    if(happiness <= 0) // if stat less than 0, its value is changes back to 1
    {
      happiness = 1;
    }

    if(health <= 0) // if stat less than 0, its value is changes back to 1
    {
      health = 1;
    }

    if(smarts <= 0) // if stat less than 0, its value is changes back to 1
    {
      smarts = 1;
    }

    if(looks <= 0) // if stat less than 0, its value is changes back to 1
    {
      looks = 1;
    }

  }
    
}
  
