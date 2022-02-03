import java.util.*;
public class Character {
  private int attack; // Character's Attack
  private int hp; // Character's Health
  private String name; // Character's Name
  private int gold = 500; // Character's Gold

  // New Code
  private List<Item> items = new ArrayList<Item>();
  private Item equipped;
  public void addItem(Item i) {
    items.add(i);
  }
  public List<Item> getItems() {
    return items;
  }

  // End New Code

  public Character(String name, int hp, int attack){
    this.attack = attack;
    this.hp = hp;
    this.name = name;
  }
  public void setGold(int g){
    this.gold = g;
  }
  public void setAttack(int a){
    this.attack = a;
  }
  public void setHp(int h) {
    this.hp = h;
  }
  public void setName(String n){
    this.name = n;
  }
  public int getGold(){
    return this.gold;
  }
  public int getAttack(){
    return this.attack;
  }
  public int getHp(){
    return this.hp;
  }
  public String getName(){
    return this.name;
  }

  // Buy Item from Shop
  public void buy(Item item){
    Scanner scan = new Scanner(System.in);
    System.out.println(item.getName()+" will cost "+item.getPrice()+" gold. How many "+item.getName()+"s would you like to buy?");
    int quantity = scan.nextInt();
    if (quantity*item.getPrice() > this.getGold()) {
      System.out.println("Sorry, you don't have enough gold!");
    } else {
      System.out.println("You bought"+quantity+" "+item.getName()+"!");
      this.setGold(this.getGold()-quantity*item.getPrice());

      // NEW CODE
      this.addItem(item);

      // END NEW CODE

      System.out.println("You have"+this.getGold()+"gold left!");
    }  
  }

  // Battle in the Arena
  public void battle(Character enemy){

    while(this.getHp() > 0 && enemy.getHp() > 0){
      System.out.println("It's your turn, what would you like to do?");
      System.out.println("1. Attack");
      System.out.println("2. Run");
      Scanner sc = new Scanner(System.in);
      int choice = sc.nextInt();
      if(choice == 1){
        // NEW Code
        int strength = this.getAttack();
        if (!this.items.isEmpty()) {
          this.equipped = items.get(0);
          System.out.println("Equipping your " + this.equipped.getName());
          strength = strength + this.equipped.getPower();
        }

        // END NEW CODE
        System.out.println("You attacked!");
        enemy.setHp(enemy.getHp() - strength); // Change to strength.
        System.out.println(this.getName() + " did " + strength + " damage "); // Change to strength.
        if(enemy.getHp() <= 0){
          enemy.setHp(0);
          System.out.println(enemy.getName() + " has " + enemy.getHp() + " hp left! ");
          System.out.println("You win!");
          break;
        }
        System.out.println(enemy.getName() + " has " + enemy.getHp() + " hp left! ");
        System.out.println(enemy.getName() + " attacked " + this.getName() + "!");
        this.setHp(this.getHp() - enemy.getAttack());
        System.out.println(enemy.getName() + " did " + enemy.getAttack() + " damage ");
        if(this.getHp() <= 0) {
          this.setHp(0);
          System.out.println("Inmate wins!");
          // NEW CODE
          break;
          // END NEW CODE
        }
        System.out.println(this.getName() + " has " + this.getHp() + " hp left! ");
      } else if(choice == 2) {
        System.out.println("You ran away!");
        break;
      } else {
        System.out.println("Please choose from the options");
      }
    }
  }
}