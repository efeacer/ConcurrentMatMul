package modelClasses;

public class SerialMatrixMultiplier extends MatrixMultiplier {

    public SerialMatrixMultiplier(Matrix matrix1, Matrix matrix2) { super(matrix1, matrix2); }

    public Matrix multiply() {
        Matrix result = new Matrix(outerDim1, outerDim2);
        for (int row = 0; row < outerDim1; row++)
            for (int col = 0; col < outerDim2; col++) innerProduct(result, row, col);
        return result;
    }
}