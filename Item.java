import java.util.Scanner;
public class Item{
private int price;
private String name;
public void setPrice (int p){
  this.price = p;}
public int getPrice(){
  return this.price;}
public void setName(String n){
  this.name = n;}
public String getName(){
  return this.name;}
public Item(String name, int price){
  this.price = price;
  this.name = name;
}
}