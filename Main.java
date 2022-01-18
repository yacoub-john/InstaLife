/* 
 John Yacoub, Chris Chen 
 June 19,2020 
 ICS 4U1
 Mr.Vittorio
 Final Project (Insta Life) 
*/

import java.util.*;
import java.util.Random; 


class Main {
  public static void main(String[] args) 
  {

    final String [] maleNames =  new String [] {"Dwight", "Charles", "Donald", "Ben","James","Robert","John","Benjamin","Richard", "Logan","David","Thomas","Ronald","Joseph","Gary","George","Kenneth","Paul","Edward","Jerry","Dennis","Frank","Daniel","Raymond","Roger","Stephen","Gerald","Walter","Harold","Steven","Lawrence","Terry","Wayne","Arthur","Jack","Carl","Henry", "Willie","Bruce","Joe","Peter","Billy","Roy","Ralph","Anthony","Jimmy","Albert","Bobby","Eugene","Johnny","Harry","Howard","Mark","Alan","Louis","Philip","Patrick","Dale", "Danny","Stanley","Leonard","Timothy","Gregory","Samuel","Ronnie","Norman","Ernest","Russell","Francis","Melvin","Earl","Frederick","Allen","Bill","Tommy","Phillip","Marvin","Steve","Don","Clarence","Barry","Glenn","Jim","Eddie","Mike", "Andrew", "Jeffrey","Leroy","Alfred","Martin","Lee", "Tom","Ray","Herbert","Gene","Bernard","Theodore","Curtis","Keith","Clifford" };
    //Array of common men names for random name generator.

    final String [] femaleNames = new String [] {"Mary","Linda","Barbara","Patricia","Carol","Sandra","Nancy","Sharon","Judith","Susan","Betty","Carolyn","Margaret","Shirley","Judy","Karen","Donna","Kathleen","Joyce","Dorothy","Janet","Diane","Janice","Joan","Elizabeth","Brenda","Gloria","Virginia","Marilyn","Martha","Beverly","Helen","Bonnie","Ruth","Frances","Jean","Ann","Phyllis","Pamela","Jane","Alice","Peggy","Cheryl","Doris","Catherine","Elaine","Cynthia","Marie","Lois","Connie" };
    // Array of common women names for random name generator.

    final String[] country = new String [] {"Afghanistan","Albania","Algeria","Andorra","Angola","Antigua and Barbuda","Argentina","Armenia","Australia", "Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin", "Bhutan","Bolivia","Bosnia","Botswana","Brazil", "Brunei","Bulgaria","Burkina Faso","Burundi","Côte d'Ivoire","Cabo Verde","Cambodia","Cameroon","Canada","Central African Republic","Chad","Chile","China","Colombia","Comoros","Congo","Costa Rica","Croatia","Cuba","Cyprus","Czechia","Czech Republic","Denmark","Djibouti","Dominica","Dominican Republic","Ecuador","Egypt","El Salvador","Eritrea","Estonia","Eswatini","Ethiopia","Fiji","Finland","France","Gabon","Gambia","Georgia","Germany","Ghana","Greece","Grenada","Guatemala","Guinea", "Guyana","Haiti","Honduras","Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Israel","Italy","Jamaica","Japan","Jordan","Kazakhstan","Kenya","Kiribati","Kuwait","Kyrgyzstan","Laos","Latvia","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands","Mauritania","Mauritius","Mexico","Micronesia","Moldova","Monaco","Mongolia","Montenegro","Morocco","Mozambique","Myanmar","Namibia","Nauru","Nepal","Netherlands","New Zealand","Nicaragua","Niger","Nigeria","North Korea","North Macedonia","Norway","Oman","Pakistan","Palau","Palestine","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Poland","Portugal","Qatar","Romania","Russia","Rwanda", "Samoa","San Marino","Sao","Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia", "Slovenia","Solomon Islands","Somalia","South Africa","South Korea","South Sudan","Spain","Sri Lanka","Sudan","Suriname","Sweden","Switzerland","Syria","Tajikistan","Tanzania","Thailand", "Timor-Leste","Togo","Tonga","Trinidad and Tobago","Tunisia","Turkey","Turkmenistan","Tuvalu","Uganda","Ukraine", "United Arab Emirates","United Kingdom","United States of America","Uruguay","Uzbekistan","Vanuatu","Venezuela","Vietnam","Yemen","Zambia","Zimbabwe"};
    // Array of country names for country generator.

    Random r = new Random();

    String fathersName = "", mothersName = "" , familyName = "", playerName = "", genderType = "";
    int year, gender, playerAge = 0, mothersAge, fathersAge, mothersLife, fathersLife, maxAge;

    gender = r.nextInt(2);
    fathersName = maleNames[r.nextInt(101)];
    familyName = maleNames[r.nextInt(101)];
    mothersName = femaleNames[r.nextInt(51)]; 
    // randomly genreates name for the family using the common names arrays.

    if(gender == 1) // determins the gender of the character and assigns an approperiate name for them.
    {
      genderType = "female";
      playerName = femaleNames[r.nextInt(51)];
    }

    if(gender == 0)
    {
      genderType = "male";
      playerName = maleNames[r.nextInt(101)];
    }

    year = (r.nextInt(2040-1990+1))+1990; // decides current year.
    mothersAge = (r.nextInt(35-25+1))+25; // decides mothers age.
    fathersAge = (r.nextInt(35-25+1))+25; // decides fathers age.
    mothersLife = (r.nextInt(90-70+1))+70; // decides mothers life.
    fathersLife = (r.nextInt(90-70+1))+70; // decides father life.
    maxAge = (r.nextInt(90-70+1))+70;
    // Starting year and the parents ages are rand generated

    System.out.println();
    System.out.println();
    System.out.println("ALL CHARACTERS AND EVENTS ");
    System.out.println("IN THIS GAME ARE FICTIONAL");
    System.out.println("AND ARE RANDOMLY GENERATED.");
    System.out.println("ANY RESEMBLANCE TO REAL");
    System.out.println("PEOPLE OR REAL EVENTS IS");
    System.out.println("CONCIDENTAL");

    System.out.println();
    System.out.println(playerAge + " Years Old -" + year);
    System.out.println("You were born a " + genderType + ", in " + country[r.nextInt(190)] + ".");
    System.out.println();
    System.out.println("Your name is " + playerName + " " + familyName + "." );
    System.out.println();
    System.out.println("Your parents are: ");
    System.out.println(fathersName + " " + familyName + " (Father), " + fathersAge + ".");
    System.out.println(mothersName + " " + familyName + " (Mother), " + mothersAge + ".");
    System.out.println(); 
    //Displayes the initial startup information on the character and thier family.

    Choices playerChoices = new Choices(year, playerAge, gender, mothersAge, fathersAge, mothersLife, fathersLife, maxAge);               // starts the characters life and gives them choices/actions.
    Choices.menu();
    


  }
  
}
