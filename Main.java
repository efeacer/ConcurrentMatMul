import modelClasses.*;

public class Main {

    // Constants
    private static final int OUTER_DIM1 = 150;
    private static final int INNER_DIM = 150;
    private static final int OUTER_DIM2 = 150;

    public static void main(String[] args) {

        Matrix matrix1 = new RandomMatrix(OUTER_DIM1, INNER_DIM);
        Matrix matrix2 = new RandomMatrix(INNER_DIM, OUTER_DIM2);

        MatrixMultiplier serialMultiplier = new SerialMatrixMultiplier(matrix1, matrix2);
        MatrixMultiplier parallelMultiplier = new ConcurrentMatrixMultiplier(matrix1, matrix2);

        long start;
        long stop;

        start = System.currentTimeMillis();
        Matrix serialResult = serialMultiplier.multiply();
        stop = System.currentTimeMillis();
        long serialTime = stop - start;

        start = System.currentTimeMillis();
        Matrix parallelResult = parallelMultiplier.multiply();
        stop = System.currentTimeMillis();
        long parallelTime = stop - start;

        if (!serialResult.equals(parallelResult)) {
            System.err.println("Serial and concurrent multiplication results are not equal.");
            System.exit(-1);
        }

        System.out.printf("Serial Execution Time (ms): %d%n", serialTime);
        System.out.printf("Concurrent Execution Time (ms): %d%n", parallelTime);
    }
}