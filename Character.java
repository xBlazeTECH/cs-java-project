import java.util.Scanner;
public class Character {
private int attack;
private int hp;
private String name;
private int gold = 500;
public Character(String name, int hp, int attack){
this.attack = attack;
this.hp = hp;
this.name = name;
}
public void setGold(int g){
  this.gold = g;
}
public void setAttack (int a){
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
public void buy(Item item){
Scanner scan = new Scanner(System.in);
System.out.println(item.getName()+" will cost "+item.getPrice()+" gold. How many "+item.getName()+"s would you like to buy?");
  int quantity = scan.nextInt();
  if(quantity*item.getPrice() > this.getGold()){
    System.out.println("Sorry, you don't have enough gold!");
    
  }
  else{
    System.out.println("You bought"+quantity+" "+item.getName()+"!");
    this.setGold(this.getGold()-quantity*item.getPrice());
    System.out.println("You have"+this.getGold()+"gold left!");
}  
}
public void battle(Character enemy){
while(this.getHp() > 0 && enemy.getHp() > 0){
    System.out.println("It's your turn, what would you like to do?");
    System.out.println("1. Attack");
    System.out.println("2. Run");
    Scanner sc = new Scanner(System.in);
    int choice = sc.nextInt();
    if(choice == 1){
      System.out.println("You attacked!");
      enemy.setHp(enemy.getHp() - this.getAttack());
      System.out.println(this.getName() + " did " + this.getAttack() + " damage ");
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
      if(this.getHp() <= 0){
        this.setHp(0);
      System.out.println("Inmate wins!");
    }
      System.out.println(this.getName() + " has " + this.getHp() + " hp left! ");
    }
    else if(choice == 2){
      System.out.println("You ran away!");
      break;
    }
    else{
      System.out.println("Please choose from the options");
    }
}  
}
}