package algorithm;

public class TerrainLevel {

    public int execute(int[] terrainLevels) {

        int water = 0;
        int currentValue, lowestMax;

        // define the first max for the left side, and do the same for the right
        int maxLeft = terrainLevels[0];
        int maxRight = terrainLevels[terrainLevels.length-1];

        // store the max value (left side) for the current position
        int[] maxValuesFromLeft = new int [terrainLevels.length];

        maxValuesFromLeft[0] = maxLeft;

        // iterate the array starting on the second element (since the first element is already a max and a border can´t have water)
        for (int currentPosition = 1; currentPosition < terrainLevels.length -1; currentPosition++) {

            // update max in case of higher value
            if(maxLeft < terrainLevels[currentPosition]){
                maxLeft = terrainLevels[currentPosition];
            }

            maxValuesFromLeft[currentPosition] = maxLeft;
        }

        // iterate the array from the opposite side (right to left), also starting on the second element
        for (int currentPosition = terrainLevels.length -2; currentPosition > 0; currentPosition--) {

            currentValue = terrainLevels[currentPosition];

            // if a new max if found, it means that can´t be water in it
            if(currentValue > maxRight){
                maxRight = currentValue;
                continue;
            }

            // calculate the lowest of the 2 max values, since the water level is measured with it
            lowestMax = maxValuesFromLeft[currentPosition] > maxRight ? maxRight : maxValuesFromLeft[currentPosition];

            // if the current value is not the same as the lowest max, and since we already excluded the chance of the current max being higher, it means the is water
            if(currentValue != lowestMax){
                // the water level its equal to the difference between the lowest max and the current value
                water += lowestMax - currentValue;
            }
        }

        return water;
    }

}
