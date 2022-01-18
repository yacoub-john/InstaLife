import java.util.*;
import java.util.Random; 
import java.text.NumberFormat;

/**
* Career class.
*/
public class Career
{
  public static int jobChosen;  // variable thats manages if job is chosen
  public static double bonus, bal; // variables that manage the bonus, and the salary

  /**
  *Diplayes and allows you to choose of 18 different jobs based on eduaction.
  *pre: none 
  *post: The title and salaries of possible jobs is displayed and the players choice is made.
  */
  public static void findJob()
  {
    ArrayList<String> jobs = new ArrayList<String>(); // An array list with all the possible choices of jobs.
    jobs.add("Insurance Safter Programmer");
    jobs.add("Bitcoin Miner");
    jobs.add("Teacher");
    jobs.add("Site Aid");
    jobs.add("Assistant Department Biologist");
    jobs.add("English Teacher");
    jobs.add("Roofer");
    jobs.add("Accounts Product Analyst");
    jobs.add("Facilities Inspector");
    jobs.add("1st Line Solution Professor");
    jobs.add("Carpenter");
    jobs.add("Data Messenger Practioner");
    jobs.add("Project Biologist");
    jobs.add("Cleaner");
    jobs.add("Nurse");
    jobs.add("Laboratory Technician");
    jobs.add("Baker");
    jobs.add("Builder");

    int[] salary = new int[]  // An array  with all the salaries of jobs.
    { 46000,23000,38000,19000,73000,23000,14000,42000,18000,43000,27000,20000,40000,11000,41000,32000,15000,21000 } ;

    int[] type = new int[]  // An array  with all the salaries of jobs.
    {2,2,3,0,1,3,0,2,0,2,0,1,1,0,1,1,0,0} ;

   
    NumberFormat money = NumberFormat.getCurrencyInstance(); // money format
    Random r = new Random();
    Scanner input = new Scanner(System.in);
    int choice;
    boolean validation = false;

    for(int i = 0; i<salary.length; i++)
    {
      System.out.println( (i+1)+ ". "+ jobs.get(i) + ": " + money.format(salary[i])   ); // prints the jobs with their salaries
    }

    while(!validation)
    {
      System.out.println("Pick job [0] To Exit");
      choice = input.nextInt();

      if(choice>0 && choice < salary.length+1)
      {
        if(type[choice-1] == 0)
        {
          System.out.println("Congratulations you got a job as: " + jobs.get(choice-1) ); // no education required
          bal = salary[choice-1]; // new sal based on job
          Finances.salary = bal;
          validation = true;
          bonus = 0;
        }

        else if( type[choice-1] == School.carrerType )
        {
          System.out.println("Congratulations you got a job as: " + jobs.get(choice-1) ); // education mathces
          bal = salary[choice-1]; // new sal based on job
          Finances.salary = bal;
          validation = true;
          bonus = 0;
        }

        else
        {
          System.out.println("Sorry you dont have the required education."); // not enough education 
          Choices.menu();
          bonus = 0;
        }


      }

      else if(choice == 0)
      {
        Choices.menu(); // sends back to menu
      }

      else 
      {
        System.out.println("Invalid input"); // if a wrong value inputed a message is displayed.
      }

    }
    
  }


}