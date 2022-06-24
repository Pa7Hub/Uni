package Q3.math.matrixCalculations.src;

/**
 * Builds a new Matrix from given Parameters
 */
public class MatrixBuilder {

    public Matrix transpose(Matrix matrix) {
        int expectedRows = matrix._nbrOfColumns;
        int expectedColumns = matrix._nbrOfRows;
        Integer[][] result = new Integer[expectedRows][expectedColumns];
        for (int i = 0; i < matrix._nbrOfRows; i++) {
            for (int j = 0; j < matrix._nbrOfColumns; j++) {
                result[j][i] = matrix._matrix[i][j];
            }
        }
        return new Matrix(result);
    }
}