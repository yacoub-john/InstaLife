 import java.util.*;
 import java.util.Random;
 import java.util.Scanner;
 import java.text.NumberFormat;

 public class RandomEvents
 {
   public static int walletValid = 0, walletShown = 1; // manage if wallet event  is shown or not.
   public static int lotteryValid = 0, lotteryShown = 1; //manage if lottery event is shown or not.
   public static int accidentValid = 0, accidentShown = 1; //manage if accident event is shown or not.
   public static int leakValid = 0, leakShown = 1; //manage if leak option is shown or not.
   public static int gardenValid = 0, gardenShown = 1; //manage if lottery option is shown or not.
   public static int travelValid = 0, travelShown = 1; //manage if lottery option is shown or not.
   public static int feverValid = 0, feverShown = 1; //manage if lottery option is shown or not.
   public static int beachValid = 0, beachShown = 1; //manage if lottery option is shown or not.
   public static int learnValid = 0, learnShown = 1; //manage if lottery option is shown or not.
   public static int readValid = 0, readShown = 1; //manage if lottery option is shown or not.
  

   /**
   * Decides if a random event should occur.
   *pre: none 
   *post:A decision is made if a random event should occur or not at all.
   */
   public static void runEvent(int house, int age)
   {
     Random r = new Random();
     int reveal = r.nextInt(30); //picks a number from 0-30 and only options 1-10 are random events

     if(reveal == 1 && age > 15 ) // calls droppingWallet if age is greater than 15 and randomized reveal is 1
     {
       droppingWallet();
     }

      else if(reveal == 2 && age > 17) // calls winALottery if age is greater than 17 and randomized reveal is 2
     {
       winALottery();
     }

      else if(reveal == 3 && age > 12)  // calls accident if age is greater than 12 and randomized reveal is 3
     {
       accident();
     }

      else if(reveal == 4 && age > 12)  // calls decorateGarden if age is greater than 12 and randomized reveal is 4
     {
       decorateGarden();
     }

      else if(reveal == 5 && age > 17)  // calls tavelAround if age is greater than 17 and randomized reveal is 5
     {
       tavelAround();
     }

       else if(reveal == 6 && age > 15)  // calls fever if age is greater than 16 and randomized reveal is 6
     {
       fever();
     }

      else if(reveal == 7 && age > 16)  // calls beach if age is greater than 16 and randomized reveal is 7
     {
       beach();
     }

      else if(reveal == 8 && age > 12)  // calls learningSkills if age is greater than 12 and randomized reveal is 8
     {
       learningSkills();        
     }

      else if(reveal == 9 && age > 12)   // calls readBooks if age is greater than 12 and randomized reveal is 9
     {
       readBooks();
     }

      else if(reveal == 10 && house == 1 )  // calls hoseleak if the character has a house and randomized reveal is 10
     {
       houseLeak();
     }
   }
   
  /**
  *The player finds a wallet and decides what to do with it.
  *pre: none 
  *post: A decision is made on what to do with the waller and the players feelings change accordingly.
  */
   public static void  droppingWallet()
   {
     Scanner input = new Scanner(System.in);
     Random r = new Random();
     boolean validation = false;
     int choice;

     System.out.println();
     System.out.println("You see a wallet on the road, It contains the lost person's id and money.");
     System.out.println("1. Pick it up and hand it to the lost and found office ");//happiness +
     System.out.println("2. Take the money inside, then hand it to the lost and found office ");//money+happiness-
     System.out.println("3. Take the money inside and throw it away");//money+ happiness- inteligence- look-
    
    while(!validation)
    {
      System.out.print("Enter your choice: ");
      choice = input.nextInt();


      if (choice >0 && choice <= 3 )
     {
       validation = true;

       if(choice == 1) // player reurns happy after returning the wallet
       {
        System.out.println();
        System.out.println("You walk away feeling happy!!");
        Choices.playerCharacter.changeStats(0,(r.nextInt(5)+2),0,0,0); // happiness increases
       }

       if(choice == 2) // player reurns happy after returning the wallet and you got a reward.
       {
         System.out.println();
         System.out.println("Your walk away happy and you got $10 for giving the wallet back");
         Choices.playerFinances.deposit(10); //$10 dollar bonus
         Choices.playerCharacter.changeStats(0,(r.nextInt(5)+2),0,0,0); //happiness increases
       }

       if(choice == 3) // player reurns guilty after keeping the wallet
       {
        System.out.println();
        System.out.println("You walk away feeling guilty as you kept the money");
        Choices.playerCharacter.changeStats(1,(r.nextInt(5)+2),0,(r.nextInt(5)+2),(r.nextInt(5)+2)); //happiness dcreases
        Choices.playerFinances.deposit(10); //$10 dollar bonus
       }
     }
     
     else
     { 
       System.out.println();      
       System.out.println("Invalid Input"); // if a wrong value inputed a message is displayed.     
     }
    
   }     
  }

     
  /**
  *The player gets a chance to buy a lottery ticket or not.
  *pre: none 
  *post: A decision is made on buy the lottery or not. If the player buy the lottery, he or she will have a chance to win
  *$500000 to $10000000.
  */
   public static void winALottery()
   {
     Random r = new Random();
     Scanner input1 = new Scanner(System.in);
     NumberFormat money = NumberFormat.getCurrencyInstance();
     int choice1, winnings;
     int lotteryTest = r.nextInt(1000); //random decides the lottery's outcome
     boolean validation = false;

     System.out.println();
     System.out.println("Do you want to buy a lottery ticket? ");
     

     while(!validation)
     {
       System.out.print("Enter your choice ( 1: Yes 2: No): "); //Yes: money- No: nothing happened
       choice1 = input1.nextInt();

       if (choice1 >0 && choice1 <= 2 )
       {
         validation = true;

         if(lotteryTest == 1)
        {
          System.out.println();
          winnings = (r.nextInt(10000000)+ 500000) ;
          System.out.println("Congratulation, you won "  +  money.format(winnings) + ". " ); //money+ happiness increaseness+
          Choices.playerFinances.deposit(winnings);
          Choices.playerCharacter.changeStats(0,(r.nextInt(5)+2),0,0,0);
        }
        else
        {   
          System.out.println();        
          System.out.println("Sorry, you won for nothing."); // happiness-        
          Choices.playerCharacter.changeStats(1,(r.nextInt(5)+2), 0, 0, 0 );
          Choices.playerFinances.withdraw(20);
        }
       }
       else
       {    
         System.out.println();   
         System.out.println("Invalid Input"); // if a wrong value inputed a message is displayed.     
       }
     }
   }


   /**
   *The player witnesses an impending car accident and decides whether to step forward to rescue.
   *pre: none 
   *post: A decision is made on what to do with the accident the player's feeling are changes accordingly.
   */
   public static void accident()
   {
     Random r = new Random();
     Scanner input = new Scanner(System.in);
     boolean validation = false;
     int choice2;

     System.out.println();
     System.out.println("You see a boy about to be hit by a car on the road, and you can push him away.");
    
     while(!validation)
     {
        System.out.print("Enter your choice ( 1: Yes 2: No): ");//Yes: health- No: nothing happened
        choice2 = input.nextInt();

       if(choice2 > 0 && choice2 <= 2 )
       {
         validation = true;

         if(choice2 == 1)
          {
            System.out.println();
            System.out.println("You pushed the boy away but you were injured by the car, so you need to be hospitalized (you do not need to pay the hospitalization fee). In order to thank you, the boy’s parents gave you a sum of money and uploaded it to the Internet, so you became a hero."); //Write this matter in the final profile
          }
          if(choice2 == 2)
          {
            System.out.println();
            System.out.println("You see the boy was hit and walked away.");//happiness-
            Choices.playerCharacter.changeStats(1,(r.nextInt(5)+2),0,0,0);
          }
       }
       else
       {
         System.out.println();
         System.out.println("Invalid Input"); // if a wrong value inputed a message is displayed.
       }
     }    
   }

   /**
   *The player's house is leaking, and the player decides to repair it or not.
   *pre: none 
   *post: A decision is made on what to do with the house leak the player's feeling are changed accordingly.
   */
   public static void houseLeak()
   {
     Random r = new Random();
     boolean validation = false;
     Scanner input = new Scanner(System.in);
     int choice3;

     System.out.println();
     System.out.println("Your house is suddenly leaking, but it is not very serious. If you want to repair it, the price will be high. Do you want to repair it? ");
     

     while(!validation)
     {
       System.out.print("Enter your choice ( 1: Yes 2: No): ");
       choice3 = input.nextInt();

       if(choice3 > 0 && choice3 <= 2 )
       {
         validation = true;

         if (choice3 == 1)
          {
            System.out.println();
            System.out.println("The repairman repaired the leaking area for you and checked your house.");
            Choices.playerCharacter.changeStats(0,0,0,0,(r.nextInt(5)+2));//money- look+
            Choices.playerFinances.withdraw(250);
          } 
          if(choice3 == 2)
          {
            System.out.println();
            System.out.println("Your room becomes damp, which has a great impact on your mood and health.");
            Choices.playerCharacter.changeStats(1,(r.nextInt(5)+2),0,0,(r.nextInt(5)+2));//happiness- look-
          } 
       }
       else
       {
         System.out.println();
         System.out.println("Invalid Input"); // if a wrong value inputed a message is displayed.
       }
     }     
   }

   /**
   *The player can decide to decorate their garden or not.
   *pre: none 
   *post: A decision is made on what to do with the garden(decorate or not) change the player's feeling accordingly.
   */
   public static void decorateGarden()
   {
     Random r = new Random();
     boolean validation = false;
     Scanner input = new Scanner(System.in);
     int choice4;

     System.out.println();
     System.out.println("Your garden is empty, you can choose whether to decorate your garden. ");
     
     while(!validation)
     {
       System.out.print("Enter your choice ( 1: Yes 2: No): ");
       choice4 = input.nextInt();

       if(choice4 > 0 && choice4 <= 2 )
       {
         validation = true;

         if (choice4 == 1)
        {
           System.out.println();
           System.out.println("Your garden has become beautiful and tidy."); //money- look+ happiness+
           Choices.playerCharacter.changeStats(0,(r.nextInt(5)+2),0,0,(r.nextInt(5)+2));
           Choices.playerFinances.withdraw(200);
        } 
        if(choice4 == 2)
        {
          System.out.println();
          System.out.println("You didn't do anything, your garden is still messy.");//happiness-
          Choices.playerCharacter.changeStats(1,(r.nextInt(5)+2),0,0,0); 
        }  
       }
       else
       {
         System.out.println();
         System.out.println("Invalid Input"); // if a wrong value inputed a message is displayed.
       }
     }    
   }

   /**
   *The player gets a chance to travel around the world and he/she can decide where to go.
   *pre: none 
   *post: A decision is made on what to do with the travel change the player's feeling accordingly.
   */
   public static void tavelAround()
   {
     Random r = new Random();
     boolean validation = false;
     Scanner input = new Scanner(System.in);
     int choice5;

     System.out.println();
     System.out.println("Now that you have the opportunity to travel abroad, where do you want to go? ");
     System.out.println("1.China.");
     System.out.println("2.Europe");
     System.out.println("3.America");
     System.out.println("4.Russia");
     System.out.println("5.I want to stay at home");
    

     while(!validation)
     {
        System.out.print("Enter your choice: ");
        choice5 = input.nextInt();

       if(choice5 > 0 && choice5 <= 5 )
       {
         validation = true;

         if (choice5 == 1)
          {
            System.out.println();
            System.out.println("You tried different cuisines in China and visited the Forbidden City"); //money- look+ happiness+
            Choices.playerCharacter.changeStats(0,(r.nextInt(5)+2),0,0,(r.nextInt(5)+2));
            Choices.playerFinances.withdraw(2000);
          } 
          if(choice5 == 2)
          {
            System.out.println();
            System.out.println("You went to many European countries and experienced the customs of the different countries");//happiness+ money- look+
            Choices.playerCharacter.changeStats(0,(r.nextInt(5)+2),0,0,(r.nextInt(5)+2));
            Choices.playerFinances.withdraw(2000);
          }
          if (choice5 == 3)
          {
            System.out.println();
            System.out.println("You didn't feel much difference when you went to America, but you went to Disneyland."); //money- 
            Choices.playerFinances.withdraw(2000);
          } 
          if (choice5 == 4)
          {
            System.out.println();
            System.out.println("You feel cold in Russia. You saw a bear crossing the road on your way to travel."); //money- look+ 
            Choices.playerCharacter.changeStats(0,0,0,0,(r.nextInt(5)+2));
            Choices.playerFinances.withdraw(2000);
          } 
          if (choice5 == 5)
          {
            System.out.println();
            System.out.println("You spent a long holiday at home"); //happiness- look-
            Choices.playerCharacter.changeStats(1,(r.nextInt(5)+2),0,0,(r.nextInt(5)+2));
          }         
       }
       else
       {
         System.out.println();
         System.out.println("Invalid Input"); // if a wrong value inputed a message is displayed.
       }
     }  
   }
  
   /**
   *The player have a fever at the time and he/she can decide to go the hospital or not.
   *pre: none 
   *post: A decision is made on what to do with the fever change the player's feeling accordingly.
   */
   public static void fever()
   {
     Random r = new Random();
     boolean validation = false;
     Scanner input = new Scanner(System.in);
     int choice6;

     System.out.println();
     System.out.println("You've got a fever because of the cold weather and need treatment.");//health-
     System.out.println("1.Go to the hospital.");
     System.out.println("2.Taking aspirin at home");
     

     while(!validation)
     {
       System.out.print("Enter your choice: ");
       choice6 = input.nextInt();

       if(choice6 > 0 && choice6 <= 2 )
       {
         validation = true;
          
         if (choice6 == 1)
        {
          System.out.println();
          System.out.println("After treatment in the hospital, you will soon recover"); //money- health+
          Choices.playerCharacter.changeStats(0,0,(r.nextInt(5)+2),0,0);
          Choices.playerFinances.withdraw(200);
        } 
        if(choice6 == 2)
        {
          System.out.println();
          System.out.println("Aspirin didn't make you feel better. After two days in bed, your condition improved.");//happiness- health- money-
          Choices.playerCharacter.changeStats(1,(r.nextInt(5)+2),(r.nextInt(5)+2),0,0);
          Choices.playerFinances.withdraw(200);
        }
       }
       else
       {
         System.out.println();
         System.out.println("Invalid Input"); // if a wrong value inputed a message is displayed.
       }
     }  
   }

   /**
   *The player went to the beach and see a girl drowning, the player have a chance to decide to rescue her or not.
   *pre: none 
   *post: A decision is made on what to do with the girl(rescue or not) change the player's feeling accordingly.
   */
   public static void beach()
   {
     Random r = new Random();
     boolean validation = false;
     Scanner input = new Scanner(System.in);
     int choice7;

     System.out.println();
     System.out.println("Your are on a long weekend trip, you go to the beach and you see a girl drowning, do you want choose to rescue her?");
    
     while(!validation)
     {
        System.out.print("Enter your choice ( 1: Yes 2: No): ");
        choice7 = input.nextInt();

       if(choice7 > 0 && choice7 <= 2 )
       {
         validation = true;

         if (choice7 == 1)
         {
           System.out.println();
           System.out.println("You rescued the girl and sent her to the medical station. In order to thank you, she gave you a sum of money and gave you the hero medal a few days later."); //money+ look+ happiness+
           Choices.playerCharacter.changeStats(0,(r.nextInt(5)+2),0,0,(r.nextInt(5)+2));
           Choices.playerFinances.deposit(200);
         } 
         if(choice7 == 2)
         {
           System.out.println();
           System.out.println("You didn't do anything, the girl was rescued by others, you went home because of guilt.");//happiness- look-
           Choices.playerCharacter.changeStats(1,(r.nextInt(5)+2),0,0,(r.nextInt(5)+2));
         }         
       }
       else
       {
         System.out.println();
         System.out.println("Invalid Input"); // if a wrong value inputed a message is displayed.
       } 
     }
   }
  
   /**
   *The player have a chance to learn more skills, he or she can decide what to learn.
   *pre: none 
   *post: A decision is made on what skill to learn change the player's feeling accordingly.
   */
   public static void learningSkills()
   {
     Random r = new Random();
     Scanner input = new Scanner(System.in);
     boolean validation = false;
     int choice8;

     System.out.println();
     System.out.println("You are inspired for some reasons and want to learn new skills to improve your ability. What do you want to do? ");
     System.out.println("1.Financial management"); //money+ intelligance+
     System.out.println("2.Basketball");// health+ look+
     System.out.println("3.Cooking");//health+ happiness+
     System.out.println("4.Musical instrument"); //happiness+ intelligance+
     System.out.println("5.Nothing, I just want to lie in my bed."); 

      while(!validation)
      { 
        System.out.print("Enter your choice: ");
         choice8 = input.nextInt();

        if(choice8 > 0 && choice8 <= 5 )
        {
          validation = true;

           if (choice8 == 1) // leaning Financial management
          {
            System.out.println();
            System.out.println("You have learned a lot about the basics of finance in two years, and according to these, the one stock you started brought you a lot of income."); 
            Choices.playerCharacter.changeStats(0,0,0,(r.nextInt(5)+2),0); // inteligence increases
            Choices.playerFinances.deposit(200); // Bonus $200
          } 

          if(choice8 == 2) // learning  basketball
          {
            System.out.println();
            System.out.println("You have been playing basketball for two years, so your practice skills have improved a lot, and you have become healthier.");
            Choices.playerCharacter.changeStats(0,(r.nextInt(5)+2),0,0,(r.nextInt(5)+2)); // inteligence and looks increases
          }

          if (choice8 == 3) // learning Cooking
          {
            System.out.println();
            System.out.println("You have been learning how to cook for two years, so you have mastered the practice of many different flavors of cuisine, and therefore you have become healthier because you eat healthy food for a long time."); 
            Choices.playerCharacter.changeStats(0,(r.nextInt(5)+2),(r.nextInt(5)+2),0,0); // inteligence increases
          }

          if (choice8 == 4) // learning to play an instrument
          {
            System.out.println();
            System.out.println("You have learned how to play the guitar in two years. Although you have not reached the level of a master, you have made many friends during the learning process."); 
            Choices.playerCharacter.changeStats(0,(r.nextInt(5)+2),(r.nextInt(5)+2),0,0); // inteligence increases
          }
          
          if (choice8 == 5) // choosing to do nothing
          {
            System.out.println();
            System.out.println("Please cherish your time."); 
          }
        }

        else
        {
          System.out.println();
          System.out.println("Invalid Input"); // if a wrong value inputed a message is displayed.
        }
      }
    
    
   }

   /**
   *The player have a chance to read books and increase his or her knowledge, he or she can choose which kind of book to read.
   *pre: none 
   *post: A decision is made on what book the player read,and it change the player's feeling accordingly.
   */
   public static void readBooks()
   {
     Random r = new Random();
     boolean validation = false;
     Scanner input = new Scanner(System.in);
     int choice9;

     System.out.println();
     System.out.println("You decided to pass the time to read a book in the afternoon, what book do you want to read?");
     System.out.println("1.Financial books");
     System.out.println("2.Science fiction ");
     System.out.println("3.Horror story ");
     System.out.println("4.Celebrity biographies ");
     System.out.println("5.History books ");
     System.out.println("6.Play on your cell phone ");

     while(!validation)
     {
       System.out.print("Enter your choice: ");
       choice9 = input.nextInt();

       if(choice9 > 0 && choice9 <= 6 )
       {
         validation = true;

        if (choice9 == 1) // read Financial books
        {
          System.out.println();
          System.out.println("You increase your intelligence"); 
          Choices.playerCharacter.changeStats(0,0,0, (r.nextInt(5)+2) ,0); //inteligence increases
        } 
        if(choice9 == 2) // read Science fiction books
        {
          System.out.println();
          System.out.println("You increase your happiness");
          Choices.playerCharacter.changeStats(0,(r.nextInt(5)+2),0,0,0); //happiness increases
        }
        if (choice9 == 3) // read Horror Stories
        {
          System.out.println();
          System.out.println("You increase your happiness"); 
          Choices.playerCharacter.changeStats(0,(r.nextInt(5)+2),0, 0,0); //happiness increases
        } 
        if (choice9 == 4) // read Celebrity biographies
        {
          System.out.println();
          System.out.println("You increase your intelligance"); 
          Choices.playerCharacter.changeStats(0,0,0, (r.nextInt(5)+2) ,0); //inteligence increases
        } 
        if (choice9 == 5) // read historical books
        {
          System.out.println();
          System.out.println("You increase your intelligance");
          Choices.playerCharacter.changeStats(0,0,0, (r.nextInt(5)+2) ,0); //inteligence increases

        } 
        if (choice9 == 6) // play on your cell phone
        {
          System.out.println();
          System.out.println("Nothing happened "); //intelligance-
          Choices.playerCharacter.changeStats(1,0,0,(r.nextInt(5)+2),0); 
          
        }

      }
       else
       {
         System.out.println();
         System.out.println("Invalid Input"); // if a wrong value inputed a message is displayed.
       }
     }     
   }
 
 }