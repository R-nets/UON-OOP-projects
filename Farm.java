/**Author: Author: Rao Genqiang
*Student No: C3466217
*Date: 29-11-2024
*Description: Keywords
*/

import java.util.Scanner;

public class Farm {
    Scanner s = new Scanner(System.in);
    private String name;
    private Sensor[] sensors;// Each farm can hold up to 3 types of sensors
    private int sensorCount;
    
    //construction
    public Farm(String name){
        this.name = name;
        this.sensors = new Sensor[3];  // up to 3 sensors per farm
        this.sensorCount = 0;  // initial number
    }
         
    //farmname
    public String getName(){
        return name;
        }
    
    //3 Adding new sensors and linked to private void addSensor
    public String addSensor(Sensor sen) {
        for (int i = 0; i < sensorCount; i++) {
            if (sensors[i].getType().equals(sen.getType())) {
                sensors[i].addQuantity(sen.getQuantity());
                return "The " + sen.getType() + " sensor is created to farm, " + name + ".";
            }
        }
        // Check if up to the top num
        // Add the new sensor to the farm
        if (sensorCount < 3) {
            sensors[sensorCount] = sen;
            sensorCount++;
            return "The " + sen.getType() + " sensor is created to farm, " + name + ".";
        }
        return "*Error, Farm already holds 4 different types of sensors.";
        //according to the Specification
    }
    
    //4 Removing sensors in the same time linked to private void removeSensors
    public String removeSensor(String type, int quantity) {
        for (int i = 0; i < sensorCount; i++) {
            if (sensors[i].getType().equals(type)) {
                if (sensors[i].getQuantity() >= quantity) {
                    sensors[i].reduceQuantity(quantity);
                    if (sensors[i].getQuantity() == 0) {
                        // if its quantity is 0
                        sensors[i] = sensors[sensorCount - 1];  // Remove the sensor
                        sensors[sensorCount - 1] = null;
                        sensorCount--;
                    }
                    return quantity + " of sensor " + type + " removed from farm " + name + ".";
                } else {
                    return "Error, there is not Enough Quantity to remove.";
                }
            }
        }
        return "Error, the Sensor type not found in farm.";
    }

    //6query about the total cost, connected to private void totalSensorCost
    public String calculateTotalValue() {
        double totalValue = 0;
        int totalQuantity = 0;

        for (int i = 0; i < sensorCount; i++) {
            totalQuantity += sensors[i].getQuantity();
            totalValue += sensors[i].getPrice() * sensors[i].getQuantity();
        }

        return "Farm " + name + " has cumulative sensor value $" + totalValue;
    }

    //7 help exporting more info, linked to private void totalInfoFarm
    public String exportData() {
        StringBuilder sb = new StringBuilder();
        if (sensorCount == 0) {
            sb.append(name).append("\n");
        } else {
            for (int i = 0; i < sensorCount; i++) {
                Sensor sensor = sensors[i];
                sb.append(name).append("-farm ")
                  .append(sensor.getType()).append("-sensor ")
                  .append(" $").append(sensor.getPrice()).append("-price ")
                  .append(" ").append(sensor.getWeight()).append("kg-weight ")
                  .append(" ").append(sensor.getQuantity()).append("-quantity\n");
            }
        }
        return sb.toString();
    }

    // Helper for interacting with sensors in the farm
    public Sensor[] getSensors() {
        return sensors;
    }

    public int getSensorCount() {
        return sensorCount;
    }
    
    public void setSensorCount(int count) {
    this.sensorCount = count;
    }
}

