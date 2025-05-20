/**Author: Rao Genqiang
*Date: 29-11-2024
*Description: Controller bar 2.0
*/
import java.util.Scanner;

public class Interface {
    private Scanner s = new Scanner(System.in);
    private Farm[] farms = new Farm[5]; // Manage up to 5 farms
    private int farmCount = 0; // for farms added
    
    public void run(){
        int start;
        //this method should control the flow of the program
        while(true){
            System.out.println("****************************INTERFACE::Navigation Bar****************************");
            System.out.println("\nSmart Farm System Started:");
            System.out.println();
            System.out.println("1.Add Farm; 2.Remove Farm");
            System.out.println("3.Add Sensor; 4.Remove Sensors");
            System.out.println("5. Query Sensors; 6. The total cost");
            System.out.println("7. The overall info");
            System.out.println("8. Exiting the Program");
            System.out.println();
            
            //use of the public int getValidIntInput(String start)
            start = getValidIntInput("Please, Select your action(1-8): ");

            switch(start){
                case 1:
                    addFarm();
                break;
                case 2:
                    removeFarm();
                break;
                case 3:
                    addSensor();
                break;
                case 4:
                    removeSensors();
                break;
                case 5:
                    querySensors();
                    break;
                case 6:
                    totalSensorCost();
                break;
                case 7:
                    totalInfoFarm();
                break;
                case 8:
                    System.out.println("See you, System Exiting...");
                    s.close();
                    return;
                    //see you, exist the run() programme
                default:
                    System.out.println("*please try again within the value(1-8)");
                }   
        }
        
    }

    //1addFarm; adding a farm
    private void addFarm() {
        if (farmCount >= 5) {
            System.out.println("*Error, Cannot add more than 5 farms, you can press 2 to remove one of your farms");
            return;
        }

        System.out.print("Enter your farm name: ");
        String farmName = s.nextLine();
        
        for (int i = 0; i < farmCount; i++) {
            if (farms[i].getName().equals(farmName)) {
                System.out.println("*Sorry, there is an error, the Farm already exists.");
                return;
            }
        }

        farms[farmCount] = new Farm(farmName);
        farmCount++;
        System.out.println("The " + farmName + " farm was added.Applause!!");
    }

    
    //2removeFarm; remove farm
    private void removeFarm(){

        System.out.print("Enter the farm name you want to remove: ");
        String name = s.nextLine();

        for (int i = 0; i < farmCount; i++) {
            if (farms[i].getName().equals(name)) {
                // Remove the farm
                for (int j = i; j < farmCount - 1; j++) {
                    farms[j] = farms[j + 1];
                }
                farms[farmCount - 1] = null;
                farmCount--;
                System.out.println("Your Farm " + name + " was removed.");
                return;
            }
        }
        System.out.println("*Error, this Farm has not founded yet!");
        }

    
    //3adding Sensor
    private void addSensor() {
        System.out.print("Enter the farm name to add a sensor to: ");
        String farmName = s.nextLine();
    
        // Check if the farm exists
        Farm farm = findFarmByName(farmName);
        if (farm == null) {
            System.out.println("*Farm does not exist, try again please!");
            return;
        }
    
        // Check if the farm already holds 3 different types of sensors
        if (farm.getSensorCount() >= 3) {
            System.out.println("*Error: Farm already holds 3 different types of sensors. Cannot add more.");
            return;
        }
    
        // Prompt user to select a sensor type
        System.out.println("\nPress 1 for Temperature, 2 for Pressure, 3 for Humidity, ");
        System.out.println("4 for Soil Temperature, 5 for Soil Humidity & 6 for Soil PH\n");
        int sensorTypeChoice = getValidIntInput("Enter the sensor type by number (1-6): ");
    
        String sensorType = "";
        switch (sensorTypeChoice) {
            case 1: 
                sensorType = "Temperature"; 
                break;
            case 2: 
                sensorType = "Pressure"; 
                break;
            case 3: 
                sensorType = "Humidity"; 
                break;
            case 4: 
                sensorType = "Soil Temperature"; 
                break;
            case 5: 
                sensorType = "Soil Humidity"; 
                break;
            case 6: 
                sensorType = "Soil PH"; 
                break;
            default: 
                System.out.println("*Invalid choice, try again please!"); 
                return;
        }

        // Check if the sensor type already exists in any of the farms
        Sensor existingSensor = findSensorInFarms(sensorType);
    
        if (existingSensor != null) {
            // If the sensor already exists
            System.out.println("Sensor " + existingSensor.getType() + " exists, with price $" +
                    existingSensor.getPrice() + " and weight " + existingSensor.getWeight() + "kg. Adding additional sensors.");
            
            // Ask for the quantity
            int quantityToAdd = getValidIntInput("Enter the quantity of sensors to add: ");
            
            existingSensor.addQuantity(quantityToAdd);
            System.out.println(quantityToAdd + " additional sensors of type " + sensorType + " added to farm " + farmName + ".");
        } else {
            // If the sensor doesn't exist, prompt for all the details
            double price = getValidDoubleInput("Enter the price of the sensor: ");
            double weight = getValidDoubleInput("Enter the weight of the sensor (kg): ");
            int quantity = getValidIntInput("Enter the quantity of the sensor: ");
    
            // Create a new sensor object and add it to the farm
            Sensor newSensor = new Sensor(sensorType, price, weight, quantity);
            farm.addSensor(newSensor);
            System.out.println(quantity + " sensors of type " + sensorType + " added to farm " + farmName + ".");
        }
    }
        // check the sensor type input
        private Sensor findSensorInFarms(String sensorType) {
            for (int i = 0; i < farmCount; i++) {
                Farm farm = farms[i];
                for (int j = 0; j < farm.getSensorCount(); j++) {
                    Sensor sensor = farm.getSensors()[j];
                    if (sensor.getType().equals(sensorType)) {
                        return sensor; // Return the first matching sensor
                    }
                }
            }
            return null; // No matching sensor found
    }


    //4 remove many sensors
    private void removeSensors() {
            System.out.print("Enter the farm name to remove sensors from: ");
        String farmName = s.nextLine();
        
        // find the farm
        Farm farm = findFarmByName(farmName);
        if (farm == null) {
            System.out.println("*Error: Farm not found.");
            return;
        }
        
        // get the sensor type
        System.out.println("\nPress 1 for Temperature, 2 for Pressure, 3 for Humidity, ");
        System.out.println("4 for Soil Temperature, 5 for Soil Humidity & 6 for Soil PH\n");
        int sensorTypeChoice = getValidIntInput("Enter the sensor type to remove in quantity by number (1-6): ");
        
        String sensorType = "";
         switch (sensorTypeChoice) {
            case 1: 
                sensorType = "Temperature"; 
                break;
            case 2: 
                sensorType = "Pressure"; 
                break;
            case 3: 
                sensorType = "Humidity"; 
                break;
            case 4: 
                sensorType = "Soil Temperature"; 
                break;
            case 5: 
                sensorType = "Soil Humidity"; 
                break;
            case 6: 
                sensorType = "Soil PH"; 
                break;
            default: 
                System.out.println("*Invalid choice, try again please!"); 
                return;
        }
        
        // get the quantity to remove
        int quantityToRemove = getValidIntInput("Enter the quantity to remove: ");
        
        Sensor sensorToRemove = null;
        for (int i = 0; i < farm.getSensorCount(); i++) {
            if (farm.getSensors()[i].getType().equals(sensorType)) {
                sensorToRemove = farm.getSensors()[i];
                break;
            }
        }
    
        // check the sensor exists in the farm
        if (sensorToRemove == null) {
            System.out.println("*Error: Sensor type " + sensorType + " is not present in the farm.");
            return;
        }
    
        // check if there are enough sensors to remove
        if  (sensorToRemove.getQuantity() < quantityToRemove) {
            System.out.println("*Error, There are not enough " + sensorType + " sensors in this farm.");
            return;
        }
    
        // reduce the quantity
        sensorToRemove.reduceQuantity(quantityToRemove);
        
        // if the quantity is now 0 remove it from the farm
        if (sensorToRemove.getQuantity() == 0) {
            // remove the sensor
            for (int i = 0; i < farm.getSensorCount(); i++) {
                if (farm.getSensors()[i] == sensorToRemove) {
                    // Shift elements to the left
                    for (int j = i; j < farm.getSensorCount() - 1; j++) {
                        farm.getSensors()[j]  = farm.getSensors()[j + 1];
                    }
                    // Set the last sensor to null
                    farm.getSensors()[farm.getSensorCount() - 1] = null;
                    farm.setSensorCount(farm.getSensorCount() - 1); // Update the sensor count
                    break;
                }
            }
            System.out.println( quantityToRemove + " items of Sensor " + sensorType + " removed from " + farmName + "-farm .");
        } else {
            System.out.println(quantityToRemove + " items of Sensor " + sensorType + " removed from " + farmName + "-farm .");
        }
    }

    //5 query for the list of sensors in farm
    private void querySensors() {
        System.out.print("Enter the farm name to query: ");
        String farmName = s.nextLine();

        Farm farm = findFarmByName(farmName);
        if (farm == null) {
            System.out.println("*This farm not founded yet.");
            return;
        }

        System.out.println("Sensors in " + farmName + " farm:");
        for (Sensor sensor : farm.getSensors()) {
            if (sensor != null) {
                System.out.println(sensor);
            }
        }
    }
    
    //6query about the total cost
    private void totalSensorCost() {
        System.out.print("Enter the farm name to query value: ");
        String farmName = s.nextLine();

        Farm farm = findFarmByName(farmName);
        if (farm == null) {
            System.out.println("*The farm you type is not founded.");
            return;
        }

        System.out.println(farm.calculateTotalValue());
    }

    
    //7exporting more info
    private void totalInfoFarm() {
        System.out.print("Enter the farm name to export data from: ");
        String farmName = s.nextLine();

        Farm farm = findFarmByName(farmName);
        if (farm == null) {
            System.out.println("Farm not found.");
            return;
        }
        System.out.println(farm.exportData());
    }
    
    // find farm by name
    private Farm findFarmByName(String name) {
        for (int i = 0; i < farmCount; i++) {
            if (farms[i].getName().equals(name)) {
                return farms[i];
            }
        }
        return null;
    }
    
    //to ensure the input is integer
    public int getValidIntInput(String prompt) {
        int value = -1;
        while (value < 0) {  // Loop until we get a positive number
            System.out.print(prompt);
            try {
                value = Integer.parseInt(s.nextLine());  // Attempt to read an integer
                if (value < 0) {
                    System.out.println("Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return value;
    }
    //to ensure the input is a decimal
    public double getValidDoubleInput(String prompt) {
        double value = -1;
        while (value < 0) {  // Loop till get a positive decimal
            System.out.print(prompt);
            try {
                value = Double.parseDouble(s.nextLine());  // Attempt to read a double
                if (value < 0) {
                    System.out.println("Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return value;
    }


    //Excuting code
    public static void main(String[] args) {
        Interface intFace = new Interface();
        intFace.run();
    
    }
}
