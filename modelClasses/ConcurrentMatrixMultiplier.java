package modelClasses;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentMatrixMultiplier extends MatrixMultiplier {

    private List<Thread> threads;
    private Matrix result;

    public ConcurrentMatrixMultiplier(Matrix matrix1, Matrix matrix2) {
        super(matrix1, matrix2);
        result = new Matrix(outerDim1, outerDim2);
        threads = new ArrayList<>();
        for (int row = 0; row < outerDim1; row++) threads.add(new MultiplierThread(result, row));
    }

    @Override
    public Matrix multiply() {
        for (Thread t: threads) t.run();
        for (Thread t: threads)
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        return result;
    }

    private class MultiplierThread extends Thread {

        private Matrix result;
        private int row;

        MultiplierThread(Matrix result, int row) {
            this.result = result;
            this.row = row;
        }

        @Override
        public void run() { for (int col = 0; col < outerDim2; col++) innerProduct(result, row, col); }
    }
}