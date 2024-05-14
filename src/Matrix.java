public class Matrix {
    private double[][] matrix;
    private int width;
    private int height;
    public Matrix(int m, int n){
        matrix = new double[m][n];
        width = m;
        height = n;
    }
    public Matrix(double[][] matrix) {
        this.matrix = matrix;
        width = matrix.length;
        height = matrix[0].length;
    }
    public double[] getCol(int i) {
        return matrix[i];
    }
    public double[] getRow(int i) {
        double[] row = new double[width];
        int index = 0;
        for (double[] col: matrix) {
            row[index] = col[i];
            index++;
        }
        return row;
    }


}
