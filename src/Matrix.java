public class Matrix {
    private final double[][] matrix;
    private final int numRows;
    private final int numCols;
    private Double det;

    public Matrix(int numRows, int numCols) {
        this.matrix = new double[numRows][numCols];
        this.numRows = numRows;
        this.numCols = numCols;
    }

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
        this.numRows = matrix.length;
        this.numCols = matrix[0].length;
    }

    public double[] getCol(int colIndex) {
        double[] col = new double[numRows];
        for (int i = 0; i < numRows; i++) {
            col[i] = matrix[i][colIndex];
        }
        return col;
    }
    public double[] getRow(int rowIndex) {
        return matrix[rowIndex];
    }

    public Matrix transpose() {
        double[][] transposedMatrix = new double[numCols][numRows];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return new Matrix(transposedMatrix);
    }
    public double determinant() {
        if (numRows != numCols) {
            throw new IllegalStateException("Determinant is not defined for non-square matrices");
        }
        if (det != null) {
            return det;
        }
        return calculateDeterminant(matrix);
    }

    private double calculateDeterminant(double[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        } else if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        double determinant = 0;

        for (int i = 0; i < n; i++) {
            double[][] submatrix = new double[n-1][n-1];
            for (int row = 1; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (col < i) {
                        submatrix[row-1][col] = matrix[row][col];
                    } else if (col > i) {
                        submatrix[row-1][col-1] = matrix[row][col];
                    }
                }
            }
            determinant += matrix[0][i] * Math.pow(-1, i) * calculateDeterminant(submatrix);
        }
        det = determinant;
        return determinant;
    }

}
