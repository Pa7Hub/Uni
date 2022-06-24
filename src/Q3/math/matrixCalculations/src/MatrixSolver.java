package Q3.math.matrixCalculations.src;

import Q3.math.matrixCalculations.src.Exceptions.IllegalMatrixDimensionsException;

/**
 * Computes operations with two given Matrices
 */
public class MatrixSolver {
    Matrix _matrix1;
    Matrix _matrix2;
    MatrixBuilder _builder;

    public MatrixSolver() {
        _builder = new MatrixBuilder();
    }

    public Matrix multiplication(Matrix matrix1, Matrix matrix2) throws IllegalMatrixDimensionsException {
        _matrix1 = matrix1;
        _matrix2 = _builder.transpose(matrix2);
        if (!_matrix1._nbrOfColumns.equals(_matrix2._nbrOfColumns)) throw new IllegalMatrixDimensionsException("Cannot multiply two matrices if matrix1's amount of Columns doesn't match matrix2's amount of Rows!");
        int expectedNbrOfRows = _matrix1._nbrOfRows;
        int expectedNbrOfColumns = _matrix2._nbrOfRows;

        Integer[][] result = new Integer[expectedNbrOfRows][expectedNbrOfColumns];
        int resultRow = 0;
        int resultColumn = 0;
//         TODO: this sucks, as we save the Matrix as a Matrix object only to "discard" it and use the raw Matrix. We should use the Matrix Object.
        for (Integer[] row1 : _matrix1._matrix) {
            for (Integer[] row2 : _matrix2._matrix) {
                int sum = 0;
                int currentRowElement = 0;
                for (Integer integer : row2) {
                    sum += row1[currentRowElement] * integer;
                    currentRowElement++;
                }
                result[resultRow][resultColumn] = sum;
                resultColumn++;
            }
            resultRow++;
            resultColumn = 0;
        }
        return new Matrix(result);
    }

}