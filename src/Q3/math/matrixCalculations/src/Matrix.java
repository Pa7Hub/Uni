package Q3.math.matrixCalculations.src;

public class Matrix {
    Integer _nbrOfRows;
    Integer _nbrOfColumns;
    Integer[][] _matrix;

    public Matrix(Integer[][] matrix) {
        _nbrOfRows = matrix.length;
        _nbrOfColumns = matrix[0].length;
        _matrix = matrix;
    }

    public Integer getMatrixElement(Integer rowIndex, Integer columnIndex) {
        return _matrix[rowIndex][columnIndex];
    }

    /**
     * Prints each row of the Matrix for easy testing
     */
    public void printMatrix() {
        for (Integer[] row : _matrix) {
            StringBuilder rowContent = new StringBuilder();
            for (Integer rowElement : row) {
                if (rowElement != null) {
                    rowContent.append(rowElement);
                    rowContent.append(" ");
                }
            }
            System.out.println(rowContent);
        }
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix1 = (Matrix) o;
        if (!this._nbrOfRows.equals(matrix1._nbrOfRows) || !this._nbrOfColumns.equals(matrix1._nbrOfColumns)) return false;
        for (int row = 0; row < this._nbrOfRows; row++) {
            for (int column = 0; column < this._nbrOfColumns; column++) {
                if (!this.getMatrixElement(row, column).equals(matrix1.getMatrixElement(row, column))) {
                    return false;
                }
            }
        }
        return true;
    }
}