package modelClasses;

import java.util.Random;

public class RandomMatrix extends Matrix {

    public RandomMatrix(int numRows, int numCols) {
        super(numRows, numCols);
        Random random = new Random();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                double randomVal = 1 + (100 - 1) * random.nextDouble();
                set(row, col, randomVal);
            }
        }
    }
}