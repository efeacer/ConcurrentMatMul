package modelClasses;

public class Matrix {

    // Propertie(s)
    private double[][] arr2D;
    private int numRows;
    private int numCols;

    Matrix(int numRows, int numCols) {
        assert numRows > 0 && numCols > 0;
        this.numRows = numRows;
        this.numCols = numCols;
        arr2D = new double[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) arr2D[row][col] = 0;
        }
    }

    public Matrix(double[][] otherArr2D) {
        numRows = otherArr2D.length;
        boolean sizeCheck = true;
        numCols = otherArr2D[0].length;
        for (int row = 1; row < numRows; row++) {
            if (otherArr2D[row].length != numCols) {
                sizeCheck = false;
                break;
            }
        }
        assert sizeCheck;
        arr2D = new double[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            System.arraycopy(otherArr2D[row], 0, arr2D[row], 0, numCols);
        }
    }

    public Matrix(Matrix other) {
        numRows = other.numRows;
        numCols = other.numCols;
        arr2D = new double[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                arr2D[row][col] = other.get(row, col);
            }
        }
    }

    void set(int row, int col, double val) {
        assert row >= 0 && row < numRows && col >= 0 && col < numCols;
        arr2D[row][col] = val;
    }

    double get(int row, int col) {
        assert row >= 0 && row < numRows && col >= 0 && col < numCols;
        return arr2D[row][col];
    }

    int numRows() { return numRows; }

    int numCols() { return numCols; }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int row = 0; row < numRows; row++) {
            if (row != 0) str.append(" ");
            for (int col = 0; col < numCols; col++) {
                str.append(arr2D[row][col]);
                if (col != numCols - 1) str.append(", ");
            }
            if (row != numRows - 1) str.append(System.lineSeparator());
        }
        str.append("]");
        return str.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (getClass() != other.getClass()) return false;
        Matrix matrix = (Matrix) other;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (get(row, col) != matrix.get(row, col)) return false;
            }
        }
        return true;
    }
}