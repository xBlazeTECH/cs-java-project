import java.util.Scanner;

public class Item {
  private int price;
  private String name;

  // New Code
  private int power;

  public void setPower(int p) {
    this.power = p;
  }

  public int getPower() {
    return power;
  }

  // End

  public void setPrice(int p) {
    this.price = p;
  }

  public int getPrice() {
    return this.price;
  }

  public void setName(String n) {
    this.name = n;
  }

  public String getName() {
    return this.name;
  }

  public Item(String name, int price, int power) { // Added power parameter
    this.price = price;
    this.name = name;
    this.power = power; // Add Power Parameter
  }
}