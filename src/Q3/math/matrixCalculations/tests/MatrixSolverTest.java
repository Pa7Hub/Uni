package Q3.math.matrixCalculations.tests;

import Q3.math.matrixCalculations.src.Exceptions.IllegalMatrixDimensionsException;
import Q3.math.matrixCalculations.src.Matrix;
import Q3.math.matrixCalculations.src.MatrixBuilder;
import Q3.math.matrixCalculations.src.MatrixSolver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MatrixSolverTest {

    @Test
    void MatrixSolverTest() throws IllegalMatrixDimensionsException {
        Integer[][] matrix1 = {
                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
        };
        Integer[][] matrix2 = {
                {1},
                {3},
                {5}
        };
        Integer[][] matrix3 = {
                {2, 1, -3, 2},
                {1, -4, 3, 0},
                {0, 0, -1, 0},
                {6, 5, -2, 3}
        };
        Integer[][] matrix4 = {
                {0},
                {1},
                {2},
                {1}
        };
        Integer[][] matrix5 = {
                {1, -1, 2},
                {3, -2, 4}
        };
        Integer[][] matrix6 = {
                {1, 2, 11, 4},
                {-2, 3, 0, 2},
                {3, 1, 4, 0}
        };
        Matrix matrixObj1 = new Matrix(matrix1);
        Matrix matrixObj2 = new Matrix(matrix2);
        Matrix matrixObj3 = new Matrix(matrix3);
        Matrix matrixObj4 = new Matrix(matrix4);
        Matrix matrixObj5 = new Matrix(matrix5);
        Matrix matrixObj6 = new Matrix(matrix6);
        MatrixBuilder builder = new MatrixBuilder();
        MatrixSolver solver = new MatrixSolver();
        Matrix result = solver.multiplication(matrixObj1, matrixObj2);
        Matrix result2 = solver.multiplication(matrixObj3, matrixObj4);
        Matrix result3 = solver.multiplication(builder.transpose(matrixObj4), builder.transpose(matrixObj3));
        Matrix result4 = solver.multiplication(matrixObj5, matrixObj6);
        result4.printMatrix();
    }

    @Test
    void MatrixTransposingTest() {
        Integer[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        MatrixBuilder builder = new MatrixBuilder();
        Matrix matrixObj2 = new Matrix(matrix2);
        Matrix result = builder.transpose(matrixObj2);
        result.printMatrix();
    }

    @Test
    void MatrixEqualityTest() {
        Integer[][] matrixA = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Integer[][] matrixB = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Matrix matrixObjA = new Matrix(matrixA);
        Matrix matrixObjB = new Matrix(matrixB);
        assertEquals(matrixObjA, matrixObjB);
    }
}