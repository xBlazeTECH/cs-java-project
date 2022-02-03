import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    // Print out Hello World!
    System.out.println("Hello world!");

    // Create our Characters
    Character raghav = new Character("raghav",100, 7);
    Character inmate = new Character("inmate",100, 5);

    // Create our Items
    Item ironSword = new Item("Iron Sword", 500);
    Item thornySword = new Item("Thorny Sword", 1000);
    Item goldenSword = new Item("Golden Sword", 1500);
    Item SwordofWrath = new Item("Sword of Wrath", 10000);
    Item SwordofGodsandHeavens = new Item("Sword of Gods and Heavens", 1000000);

    // Create a weapon shop
    Item[] weaponShop = new Item[]{
      ironSword,thornySword,goldenSword,SwordofWrath,SwordofGodsandHeavens
    };

    System.out.println(weaponShop[0].getName());

    // Display Main Menu
    System.out.println("Hello, and welcome to the world of dragons to meet your end! Where would you like to go?");
    System.out.println("1. Arena");
    System.out.println("2. Weapons Shop");
    System.out.println("3. Dragon Day Care");
    System.out.println("4. Village Outskirts");

    // Initialize Console Scanner
    Scanner scan = new Scanner(System.in);
    int choice = scan.nextInt();

    // Choice 1: Enter the Arena
    if(choice == 1){
      System.out.println("Welcome to the arena! What would you like to do?");
      System.out.println("1. Fight");
      System.out.println("2. Leave");
      choice = scan.nextInt();
      if(choice == 1){
        System.out.println("You've entered a fight!");
        raghav.battle(inmate);  
      }
    }

    // Choice 2: Weapons Shop
    if(choice == 2){
      System.out.println("Welcome to our village weapons shop! What would you like to buy?");
      System.out.println("1. Iron Sword");
      System.out.println("2. Thorny Sword");
      System.out.println("3. Golden Sword");
      System.out.println("4. Sword of Wrath");
      System.out.println("5 Sword of Gods and Heavens");
      choice = scan.nextInt();
      raghav.buy(weaponShop[choice-1]);
    }

  }
}
   