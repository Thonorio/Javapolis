package usage;

import algorithm.TerrainLevel;

import java.util.Scanner;

public class MainTerrainLevel {

    public MainTerrainLevel() {

        System.out.println("Welcome to Javapolis!");

        // read user input
        Scanner userInput = new Scanner(System.in);

        // ask indefinitely
        do{
            System.out.print("Please input the terrain levels: ");

            // parse into individual elements
            String[] individualValues = userInput.nextLine().replaceAll("[\\[\\]\"]", "").split(",");

            // create an array with the different terrain levels
            int[] terrainLevels = new int[individualValues.length];

            try{
                // fill the array
                for (int currentValue = 0; currentValue < individualValues.length; currentValue++) {
                    terrainLevels[currentValue] = Integer.parseInt(individualValues[currentValue]);
                }

            }catch (NumberFormatException  e){
                // If there is an error, display the error message and go back to asking for the terrain levels
                System.out.println("The input was not a valid set of numbers");
                continue;
            }

            TerrainLevel terrainLevel = new TerrainLevel();

            // run the algorithm
            System.out.println("The water level in this terrain is " + terrainLevel.execute(terrainLevels));

        }while(true);

    }

    public static void main(String[] args) {
        new MainTerrainLevel();
    }
}
