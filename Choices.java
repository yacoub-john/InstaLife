  import java.util.*;
import java.util.Random; 
import java.text.NumberFormat;

/**
* Choices class.
*/
public class Choices 
 {
    public static int year, age, gender, maxAge, yearly = 0, house = 0 ; // the current year, age of player, and their gender.
    public static int mothersAge, fathersAge, mothersLife, fathersLife, motherChosen = 0, fatherChosen = 0;                        // the parents' age counters
    public static int elementaryChosen = 0, highschoolChosen = 0 , collegeChosen = 0, partnerChosen = 0, babyChosen = 0,jobChosen= 0;
    // the chosen variables ensure that actions dont repeat.
    public static int driverValid = 0, driverShown = 0, driver = 0; // manages if the driverLicence option is shown or not.
    public static Character playerCharacter = new Character(age, year); // initiates the players stats.
    public static Finances playerFinances = new Finances(year, age); // initiates the players finances for school and carrer.
    public static School playerSchool = new School(year, age); // initiates the character school actions.
    public static Partner playerPartner = new Partner(gender); // intiates the partners interaction. 
    public static RandomEvents playerEvents = new RandomEvents(); // initiates the random events interactions. 
    public static Career playerCareer = new Career(); // initiates the career interactions. 

   
   /**
   * Constructor
   * pre: none
   * post: Trasnfers passed values to Choices class.
   */
    public Choices (int year, int age, int gender, int mothersAge, int fathersAge, int mothersLife, int fathersLife, int maxAge )
    {
      this.year = year; 
      this.age = age;
      this.gender = gender;
      this.mothersAge = mothersAge; // mothers age 
      this.fathersAge = fathersAge; // fathers age 
      this.mothersLife = mothersLife; // mothers life counter
      this.fathersLife = fathersLife; // fathers life counter
      this.maxAge = maxAge; // age where character passes away
    } 
  
   /**
   * Displays the general menu, responsible for aging and resets yearly variables.
   * pre: none
   * post: The menu is displayed and variables are incremented or reset as the character ages
   */
    public static void menu ()
    {
      boolean validation = false; // ensures player enters an approperiate choice.
      Scanner input = new Scanner(System.in);
      ageActions(); // checks for age based actions.
      yearly = 0; // turns off the yearly variables after use.
  
      while(!validation)
      {
        System.out.println("Enter [1] Choices [2] Age : ");  
        int choice = input.nextInt();
        System.out.println();

        if(choice == 1)
        { 
          Choices(); // redirect to Choices Method.
        }

        else if(choice == 2)
        {
          validation = true;
          year = year + 2 ; // years increments by 2
          age = age + 2; // age increments by 2
          mothersAge = mothersAge + 2;  // mothers age increments by 2
          fathersAge = fathersAge + 2;  // fathers age increments by 2
          Career.bonus = Career.bonus + .2;
          playerFinances.partnerBalance(); // adds to the balance the partners balance
          yearly = 1; // resets every 2 years for yearly choices resets
          driverShown = 0; // drivers test can be taken once every two years, this is its reset
          babyChosen = 0; // manages 1 baby per 2 years 
          playerFinances.yearlyCalculation(); // does the yearly calculation of total income
          System.out.println(age + " Years Old -" + year);
          playerEvents.runEvent(house, age);
          menu();
        }

        else 
        {
          System.out.println("Invalid Input."); // if a wrong value inputed a message is displayed.
        }
      }
    }

   /**
   * Randomly decides if you get your drivers license.
   * pre: none
   * post: A line is printed if you pass of fail your driving test.
   */

  public static void driverLicence()
  {
    Random r = new Random();
    int driversTest = r.nextInt(2); // randomly descides the test's outcome

    if( driversTest == 1) // if the outcome is 1 the character passes.
      {
        System.out.println("Congratulations you got your Drivers License!!!");
        driverValid = 1; // character now has a drivers license.
        menu();
        driver = 1;
      }

    else // if the outcome is 0  the character fails.
      {
        System.out.println("Sorry you failed your test.");
        driverValid = 0; // character does not have a drivers license.
        driverShown = 1;
        menu();
        driver = 0;
      }       
  }

  /**
   * Displays and let you choose one of the choices.
   * pre: none
   * post: The options are displayed, a choice is made and the approperiate actions are called.
   */

  public static void Choices()
  {
    boolean validation = false;
    int choice = 0, next;

    Scanner input = new Scanner(System.in);

    ArrayList<String> options = new ArrayList<String>(); // An array list with all the possible choices for the player.
    options.add("Menu ");
    options.add("Check Balance");
    options.add("Check Stats");
    options.add("Find a Partner");
    options.add("Partner's Stats");
    options.add("Leave Partner");
    options.add("Ready for a child");
    options.add("View jobs");
    options.add("Buy a house");
    options.add("Buy a car");
    

     if(age >= 16 && driverValid == 0 && driverShown == 0 )
     {
       options.add("Get Drivers License");
     }

    for(int i=0; i< options.size(); i++)
    {
      if(i%3 == 0)
      {
        System.out.println();
      }
      System.out.print("[" + (i+1) + "] " + options.get(i) + " "); // displays the options 
    }

    System.out.println();
    System.out.println();

    while(!validation) // ensures an approperiate value is inputed
    {
      System.out.println("Enter choice: ");
      choice = input.nextInt();

      if(choice > 0 && choice <= options.size())
      {
        validation = true;

        if(choice == 1)
        {
          menu(); // option 1: returns to menu.
        }

        if(choice == 2)
        {  
          playerFinances.checkBalance(); // option 2: displayes the players balance.
        }

        if(choice == 3)
        {
          playerCharacter.viewStats();  // option 3: displayes the players stats.        

        }

        if(choice == 4)
        {
          if(age >= 16 && partnerChosen == 0) // if the conditions are met the player can find a partner
          {
            playerPartner.findPartner(age);
            partnerChosen = 1;
            Finances.monthlyOut = 2000;
            Choices.playerCharacter.changeStats(0,2,2,0,0);
          }

          else if(age >= 16 && partnerChosen == 1)
          {
            System.out.println("Your already have a Partner."); // manages if you already found a partner
          }

          else 
          {
            System.out.println("Not Avalaible until 16"); // If conditions are not met a message is printed.
            System.out.println();
            menu();
          }
        }
        
        if(choice == 5) // views parnters stats
        {
          if(age >= 16 && partnerChosen == 1)
          {
            Random random = new Random();

            System.out.println("Age: " + playerPartner.partnerAge + " " );
            System.out.println("Happiness 😊 : " + (random.nextInt(51)+50 ) + " " );
            System.out.println("Health ❤ : " + (random.nextInt(51)+50 ) + " " );
            System.out.println("Intelligence 🤓 : " + (random.nextInt(51)+50 ) + " " );
            System.out.println("Looks 😏 : " + (random.nextInt(51)+50 ) );
            System.out.println();
          }

          else if(age >= 16 && partnerChosen == 0)
          {
            System.out.println("Currently you dont have a partner."); // manages if you dont have a partner
          }

          else 
          {
            System.out.println("Not Avalaible until 16"); // If conditions are not met a message is printed.
            System.out.println();
            menu();
          }
        }

        if(choice == 6)
        {
          if(age >= 16 && partnerChosen == 1)
          {
            System.out.println("Your have left your Partner."); // if the conditions are met the player can leave partner
            playerPartner.partnerChosen = 0;
            playerCharacter.changeStats(1,2,2,0,0);
            Finances.monthlyOut = 1000;
            partnerChosen = 0;
          }

          else if(age >= 16 && partnerChosen == 0)
          {
            System.out.println("Currently you dont have a partner."); // manages if you dont have a partner
          }

          else 
          {
            System.out.println("Not Avalaible until 16"); // If conditions are not met a message is printed.
            System.out.println();
            menu();
          }
        }
        

        if(choice == 7 ) // options 6 is choosing to have a baby.
        {
          if(age >= 25 && babyChosen == 1)
          {
            System.out.println("You decided you are ready for a baby.");
            System.out.println("9 months pass ...  )");

            Random rand = new Random();
            int result = rand.nextInt(2); // decides the babies gender.
            String name;

            if(gender == 1) // when the baby is a girl it is displayed and the player descides the name.
            {
              System.out.println("Your had a baby girl.");
              System.out.println("Enter her name:");
              name = input.nextLine();
              System.out.println("Your baby girl's name is: ");
              Finances.monthlyOut = (Finances.monthlyOut + 1000 );
            }
            
            else if(gender == 2) // when the baby is a girl it is displayed and the player descides the name.
            {
              System.out.println("Your had a baby boy.");
              System.out.println("Enter his name:");
              name = input.nextLine();
              System.out.println("Your baby boy's name is: ");
              Finances.monthlyOut = (Finances.monthlyOut + 1000 );
            }
          }
            else if(age >= 16 && partnerChosen == 0) // You can't have a baby without a partner
            {
              System.out.println("Currently you dont have a partner.");
            }

            else if(age >= 16 && partnerChosen == 1 && babyChosen == 1) // Only always one baby per 2 years.
            {
              System.out.println("Your are not ready for another baby");
            }
            else 
            {
              System.out.println("Not Avalaible until 25");
              System.out.println();
              menu();
            }  
      }

        if(choice == 8) // choise for finding a jobs
        {
          if(age >= 18 )
          {
            playerCareer.findJob();
          }

          else 
          {
            System.out.println("Finding a job is available 18 years of age."); // manages if you dont arent old enough
          }

        
        }


        if(choice == 9) // choice for buying a house
        {
          if(age >= 18 )
          {
            playerFinances.buyHouse();
          }

          else 
          {
            System.out.println("Buying house is available at 18 years of age."); // manages if you dont arent old enough
          }

        }

        if(choice == 10)
        {
          if(age >= 18 )
          {
            if(driverValid == 1)
            {
              playerFinances.buyCar();
            }

            else
            {
              System.out.println("You need a drivers licence to buy a car."); // manages if you dont have a driver license
            }
          }

          else 
          {
            System.out.println("Buying a car is available 18 years of age."); // manages if you dont arent old enough
          }
        
        }
        
        if(choice == 11 ) // option for getting you drivers license
        {
           if(age >= 16)
           {
             
            if(driverValid == 0 && driverShown == 0) //drivers licence called if parameter are met.
            {
              driverLicence();
            }
             
            if(driver == 1 )
            {
              options.remove(10); // removes drivers licence option after obtained
            }
          }

         
          else
          {
            System.out.println("Getting your drivers license is available at 16 years of age."); // manages if you dont arent old enough

          }        
          
        } 
     }

     else 
     {
       System.out.println("Invalid Input"); // if a wrong value inputed a message is displayed.
       System.out.println();
     }
    }
  }

  /**
   * Manages/Registers actions based on the age of the charcter/ his parents.
   * pre: none
   * post: Based on the character age actions like going to elemntary school, parents life also descided.
   */

  public static void ageActions()
  {
    Random rand = new Random();
    NumberFormat money = NumberFormat.getCurrencyInstance();

    if(age >= 0 && Finances.balance < 0)
    {
      System.out.println();
      System.out.println("You are in debt.");
      System.out.println();
    }

    if(age == 6 && elementaryChosen == 0) //starts elementary school and changes its chosen value to chosen (1).
    {
      elementaryChosen = 1;
      playerSchool.elementary();
      
    }

    if(age == 14 && highschoolChosen == 0) //starts highschool school and changes its chosen value to chosen (1).
    {
      highschoolChosen = 1;
      playerSchool.highschool();
    }

    if(age == 18 && collegeChosen == 0) //starts college and changes its chosen value to chosen (1).
    {
      System.out.println();
      System.out.println("You are now responsible for your monthly outgoings.");
      collegeChosen = 1;
      Finances.monthlyOut = 1000;
      playerSchool.college();
      
    }

    if( age == 20 ||  age == 22 && yearly == 1 && School.paymentPlan == 1) // withdraws the tuition for college
    {
      playerFinances.withdraw(2*14000); // pay for 2 years at a time when on your own.
    }

    if( age == 22 && yearly == 1 && School.paymentPlan == 2) // withdraws the tuition for college
    {
      playerFinances.withdraw(4*14000); // pay for 4 years at once if you chose a loan.
    }

    if(fathersLife == fathersAge && fatherChosen == 0 ) // if father passes away they leave the character an amount of money.
    { 
      int fathersWill = (rand.nextInt(900001)+ 100000 ) ; // randomized money from father
      System.out.println("Your father passed away.");
      System.out.println("He left you: $" + money.format(fathersWill) ) ;
      fatherChosen = 1; //father passed away.
      playerFinances.deposit(fathersWill); // money desposited in characters account.
    } 

    if(mothersAge == mothersLife && motherChosen == 0) // if mother passes away they leave the character an amount of money.
    { 
      int mothersWill = (rand.nextInt(900001)+ 100000 ) ; // randomized money from father.
      System.out.println("Your mother passed away.");
      System.out.println("She left you: " + money.format(mothersWill) ) ;
      motherChosen = 1; // mother passed away.
      playerFinances.deposit(mothersWill); // money desposited in characters account.
    }

    if(age == 75 && jobChosen == 0) // retires you from your job
    {
      System.out.println("You have retired, you were too old to work");
      System.out.println("You got a pension of $40,000"); // pension plan
      Career.bal = 40000;
      jobChosen = 1;
    }

    if(age >= maxAge) // player has died
    {
      System.out.println("You passed away at the age of 😪😪: " + age);
      playerCharacter.viewStats(); // view stats
      playerFinances.checkBalance(); // view balance
      System.exit(0); // program ends
    }
  }

 }