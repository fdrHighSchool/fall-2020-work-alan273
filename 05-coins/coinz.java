//Mohammed,Nick,Alan

import java.util.*;   //imports everything

class Main {
  public static void println(String wordz) {
    System.out.println(wordz);
  }
  public static void main(String[] args) {
    //Making a boolean statement
    boolean gameongoing = true;
    //Using scanner
    Scanner in = new Scanner(System.in);
    String[] events = {"Shop", "Attack"};
    String[] monsters = {"Slime", "Zombie", "Eagel", "Skeleton"};

    String[] shop_names = {"Iron Sword", "Fire Magic"}; //why cant i just like put a table in a table or am i doing something wrong
    int[] shop_prices = {100, 150};
    String[] inv = {}; 
    //i cant figure out how to put both strings and numbers in tables
    
    //in lua i would use tables for everything because then you can set the table to nil and it would remove all the vars and funcs from gc but whateva
    System.out.println("Enter your name: ");
    String name = in.next();
    //first loop(Askes if the user wants to play or not)
    int coins = 500; //The amount of coins the player will bing with
    while (gameongoing) {
      
      String answer = "";
      if (coins <= 0){
        while (true) {
          System.out.println("do you want to restart? y/n ");
          answer = in.next();
          //Stores the reset(If they want to or not)
          if (answer.compareTo("n") == 0) {
            gameongoing = false;
            System.out.println("game ended!");
            break;
          }
          else if (answer.compareTo("y") == 0){
            System.out.println("restarting...\n\n\n");
            coins = 500;
            break;
          }
          else {
            System.out.println("please choose between \"y\" or \"n\" ");
          }
          //You can't chose any other answer then y/n if you do it will print "Please choose between"
        }
      }

      System.out.println("welcome to our coin game, " + name);
      System.out.println("your starting coin amount is: " + coins);
      //Welcoming the user to the game and letting them know how much coins they have
      //Using random to make random events
      Random rand = new Random();
      int randevent = rand.nextInt(2);
      String event = events[randevent];

      if (event.compareTo("Attack") == 0) {
        int randint = rand.nextInt(4);
        int monsterhp = rand.nextInt(400);
        while (monsterhp < 100){
          monsterhp = rand.nextInt(400);
        }
        String monster = monsters[randint];
        println("You ar attacked by a " + monster + "!");
        //Another loop
        while (true) {
          boolean passthru = true;
          println("The " + monster + " has " + monsterhp + " HP!");
          println("You have " + coins + " coins!");
          println("You can:\n1. Attack the monser\n2. Flee the monster");
          answer = in.next();
          if (answer.compareTo("1") == 0) {
            int damage = rand.nextInt(70);
            while (damage < 30) {
              damage = rand.nextInt(70);
            }
            println("You attack the monster for " + damage + " damage!");
            //Tells you how much dmg you have dealt 
            monsterhp -= damage;
            //Subs the dmg from monsters hp
          }
          //This is the choice where you run away
          else if (answer.compareTo("2") == 0){
            int moneylost = rand.nextInt(40);
            println("You Choos to flee!\nBut you dropped " + moneylost + " coins...");
            coins -= moneylost;
            break;
          }
          else {
            System.out.println("please choose between \"1\" or \"2\" ");
            passthru = false;
          }
          if (passthru == true) {
            if (monsterhp <= 0) {
              int earnedmoney = rand.nextInt(120);
              while (earnedmoney < 40){
                earnedmoney = rand.nextInt(120);
              }
              coins += earnedmoney;
              println("You have defeated the " + monster + "!\nThe monster has dropped " + earnedmoney + " coins!\nYou now have "+ coins + " coins!");
              break;
            }
            int dropmoney = rand.nextInt(1);
            if (dropmoney == 0){
              int moneylost = rand.nextInt(40);
              println("The monster attacks you and you drop " + moneylost + " coins!");
              coins -= moneylost;
            }
            else{
              println("The " + monster + " tries to attack you but misses!");
            }
          }
        }
      }
      else if (event.compareTo("Shop") == 0) {
        boolean inshop = true;
        while (inshop) {
          println("You run into a shop? Do you choose yo enter? (y/n)");
          answer = in.next();
          if (answer.compareTo("n") == 0) {
            System.out.println("You choose to leave the shop!");
            break;
          }
          //Shop
          else if (answer.compareTo("y") == 0){
            System.out.println("You have entered the shop!");
            while (true) {
              println("There are " + shop_names.length + " ammount of things to buy in the shop!");
              println("Type the corresponding number to purchase the item!");
              for (int i = 0; i < shop_names.length; i++) { //idk if theres something like for k, v in pairs in java so this will do
                println(i + ". " + shop_names[i]);
              }
              answer = in.next();
              println(String.valueOf(answer));
            }
          }
        }
      }
    } 
  } 
}
  
