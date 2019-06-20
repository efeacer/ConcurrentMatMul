package modelClasses;

public abstract class MatrixMultiplier {

    private Matrix matrix1;
    private Matrix matrix2;
    int outerDim1;
    private int innerDim;
    int outerDim2;

    MatrixMultiplier(Matrix matrix1, Matrix matrix2) {
        assert matrix1.numCols() == matrix2.numRows();
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        outerDim1 = matrix1.numRows();
        innerDim = matrix1.numCols();
        outerDim2 = matrix2.numCols();
    }

    public abstract Matrix multiply();

    void innerProduct(Matrix result, int row, int col) {
        double temp = 0;
        for (int i = 0; i < innerDim; i++) temp += matrix1.get(row, i) * matrix2.get(i, col);
        result.set(row, col, temp);
    }
}