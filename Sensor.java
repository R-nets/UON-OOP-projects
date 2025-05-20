/**Author: Author: Rao Genqiang
*Date: 29-11-2024
*Description: Description to the Interface.java
*/
public class Sensor
{
    private String type;
    private double price;
    private double weight;
    private int quantity;

    //construction, use the type of the sensors
    public Sensor(String type,double price, double weight, int quantity){
        this.type = type;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
    }
    //return the values
    public String getType(){
        return type;
    }
    public double getPrice(){
        return price;
    }
    
    public double getWeight(){ 
        return weight; 
    }
    
    public int getQuantity(){ 
        return quantity; 
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    //replace the value of quantity
    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }
    public void reduceQuantity(int quantity) {
        this.quantity -= quantity;
    }
    
    //showing the sensor info
    public String toString() {
        return type + " sensor has price $" + price + 
        ", weight " + weight + "kg, and quantity " + quantity + ".";
    }
    
    
    //add other methods
}
