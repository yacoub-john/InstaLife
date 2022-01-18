import java.util.Random;
import java.util.*;

/**
* School class.
*/
public class School 
{
  public static int year, age, collegeDecision, paymentPlan, carrerType;

  /**
  * Constructor
  * pre: none
  * post: Transfers passed values to the Finances class.
  */
  public School(int year , int age) 
  {
    this.year = year;
    this.age = age;
  }

  /**
  * The character starts elemtary school.
  * pre: none
  * post: Starting elemtntary Schhol as well as the randomized orgranization are displayed.
  */
  public static void elementary()
  {
    Random rand = new Random();

    System.out.println();
    System.out.println("You are starting Elementary School");
    String [] level = new String[] {"Public", "Private" , "Catholic"}; //Array of orgranizations.
    System.out.println("Type: " + level[rand.nextInt(3)]  ); // randomly determines school orgranization.
    System.out.println("Level: Elementary School ");
    System.out.println("Years: 8 ");
    System.out.println();
  }
   
  /**
  * The character starts high school.
  * pre: none
  * post: Starting high Schhol as well as the randomized orgranization are displayed.
  */
  public static void highschool()
  {
    Random rand = new Random();

    System.out.println();
    System.out.println("You are starting High School");
    String [] level = new String[] {"Public", "Private" , "Catholic"}; //Array of orgranizations.
    System.out.println("Type: " + level[rand.nextInt(3)]  ); // randomly determines school orgranization.
    System.out.println("Level: High School");
    System.out.println("Years: 4 ");
    System.out.println();
  }

  /**
  * Allows the player to decide on higher eduaction and thier major.
  * pre: none
  * post: If higher education is chosen the character starts college and thier desired major is displayed, a message is displayed   * otherwise.
  */
  public static void college()
  {
    Random rand = new Random();
    String [] grade = new String[] {"A", "B","C"}; // array of possible grades.
    Scanner in = new Scanner(System.in);
    boolean vald = false;
    int decision;

    System.out.println();
    System.out.println("You graduated High School with " + (rand.nextInt(3)+1) + " qualification(s) at grade " +grade[rand.nextInt(3)] ); // randomly decides qualifications.
    
    while(!vald)
    {

      System.out.println("You have enough qualifications to go to higher eduaction.");
      System.out.println("Do you wish to enroll in higher education? ");
      System.out.println();
      System.out.println("[1] Enroll [2] Not Ready");
      decision = in.nextInt();

      if(decision == 1) // Player decides to enter higher eduaction.
        {
          System.out.println();
          System.out.println("Your University offers: ");

          String [] rand1 = new String[] {"Public Health","Nursing","Sport Science","Animal Studies", "Paramedic Science" };
          String [] rand2 = new String[] {"Computer Science","Software Engineering","Cyber Security","Robotics","Hardware Design"};
          String [] rand3 = new String[] {"Chemistry","Art","Statistics","Math","Physics" };
          int education = rand.nextInt(3);
          
          if(education == 0) // if assigned the first array it is displayed and a choice is made from it. 
          {
            for(int i = 0; i <rand1.length; i++ )
            {
              System.out.println( (i+1) + ". "+ rand1[i]); // Displayes options for major.
            }

            Scanner input = new Scanner(System.in);
            boolean val = false;
            int choice = 0;

            while(!val) // ensures player enter approeriate value.
            {
              System.out.println("Enter your choice");
              choice = input.nextInt();
              if(choice>0 && choice<=5)
              {
                System.out.println("Your chose: " + rand1[choice-1] ); // players choise is made.
                carrerType = 1; // manages carreer for career class. (Health)
                System.out.println();
                val = true;
              }

              else
              {
                System.out.println("Invalid Input"); // if a wrong value inputed a message is displayed.
              }
            }
          }
          
          if(education == 1) // if assigned the second array it is displayed and a choice is made from it. 
          {
            for(int i = 0; i <rand2.length; i++ )
            {
              System.out.println((i+1) + ". "+ rand2[i]); // Displayes options for major.
            }

            Scanner input = new Scanner(System.in);
            boolean val = false;
            int choice = 0;

            while(!val) // ensures player enter approeriate value.
            {
              System.out.println("Enter your choice");
              choice = input.nextInt();
              if(choice>0 && choice<=5)
              {
                System.out.println("Your chose: " + rand2[choice-1] ); //players choice is made.
                carrerType = 2; // manages carreer for career class. (Computers)
                System.out.println();
                val = true;
              }

              else
              {
                System.out.println("Invalid Input"); // if a wrong value inputed a message is displayed.
              }
            }
          }

          if(education == 2) // if assigned the third array it is displayed and a choice is made from it. 
          {
            for(int i = 0; i <rand3.length; i++ )
            {
              System.out.println((i+1) + ". "+ rand3[i]); // Displayes options for major.
            }

            Scanner input = new Scanner(System.in);
            boolean val = false;
            int choice = 0;

            while(!val) // ensures player enter approeriate value.
            {
              System.out.println("Enter your choice");
              choice = input.nextInt();
              
              if(choice>0 && choice<=5)
              {
                System.out.println("Your chose: " + rand3[choice-1] );  //players choice is made.
                carrerType = 3; // manages carreer for career class (Subjects.).
                System.out.println();
                val = true;
              }

              else
              {
                System.out.println("Invalid Input"); // if a wrong is value inputed a message is displayed.
              }
            }
          }

          collegeDecision = 1; //variable value if decision is yes.
          payment();
          vald = true;
      }

      else if(decision == 2)
      {
        collegeDecision = 0; //variable value if decision is no.
        carrerType = 0;
        System.out.println();
        System.out.println("Your decided not to enter higher eduaction.");
        System.out.println();
        vald = true;
      }

      else 
      {
        System.out.println("Invalid Input."); // if a wrong value is inputed a message is displayed.
      }
    }   
  }

  /**
  * Allows the player to decide on how to pay for college.
  * pre: none
  * post: A decision is made on the payment for college.   
  */
  public static void payment()
  {
    System.out.println("How are you going to pay for college?");
    System.out.println("[1] On your Own [2] Loan [3] Your Parents");

    boolean valid = false;
    Random rand = new Random(); // descides parents payment plan decision.
    Scanner input = new Scanner(System.in);
    int paymentdescision; // decision for payment options.

    while(!valid)
    {
      System.out.println("Enter choice: ");
      paymentdescision = input.nextInt();
      
      if(paymentdescision == 1 ) // Option for pay on your own is chosen.
      {
        System.out.println("You decided to pay for college.");
        System.out.println();
        paymentPlan = 1; //payment option for paying on your own.
        valid = true ;
      }

      else if(paymentdescision == 2 ) // Option for pay using a loan is chosen.
      {
        System.out.println("You decided to get a loan for college.");
        System.out.println();
        paymentPlan = 2; //payment option for paying using a loan.
        valid = true ;
      }

      else if(paymentdescision == 3 ) // Option for parent paying is chosen.
      {
        int parentsDecision = rand.nextInt(2);

        if(parentsDecision == 1)
        {
          System.out.println("Your parents decided to pay for college!!!");
          System.out.println();
          paymentPlan = 3; //payment option for your parents paying.
          valid = true ;
        }

        if(parentsDecision == 2)
        {
          System.out.println("Your parents decided not to pay for college."); //payment option for your parents not paying.
          System.out.println("You decided to pay for college.");
          System.out.println();
          paymentPlan = 1;  //payment option for paying on your own.
          valid = true ;
        }

      }
      
      else
      {
        System.out.println("Invalid Input."); // if a wrong value is inputed a message is displayed.
        System.out.println();
      }

    }

  }


  
}