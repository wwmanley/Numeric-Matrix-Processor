package processor;

public class MatrixProcessor {

    private Matrix A;
    private Matrix B;
    private double[][] cofactors;

    public MatrixProcessor(Matrix A, Matrix B) {
        this.A = A;
        this.B = B;
    }

    public MatrixProcessor(Matrix A) {
        this.A = A;
    }

    public void printMatrix(double[][] matrix) {
        for (double[] array : matrix) {
            for (double element : array) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public void addMatrix() {
        double[][] matrixSum = new double[A.row][A.column];

        if (B == null) {
            return;
        }

        if (A.getMatrix().length != B.getMatrix().length) {
            System.out.println("ERROR");
            return;
        }

        for (int i = 0; i < A.getMatrix().length; i++) {
            for (int j = 0; j < A.getMatrix()[A.row - 1].length; j++) {
                matrixSum[i][j] = A.getMatrix()[i][j] + B.getMatrix()[i][j];
            }
        }

        printMatrix(matrixSum);
    }

    public double[][] multiplyBy(double constant, double[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = matrix[i][j] * constant;
            }
        }

        return matrix;
    }

    public void multiplyMatrices() {


        double[][] product = new double[A.row][B.column];

        for (int i = 0; i < A.row; i++) {
            for (int j = 0; j < B.column; j++) {
                for (int k = 0; k < A.column; k++) {
                    product[i][j] += A.getMatrix()[i][k] * B.getMatrix()[k][j];
                }
            }
        }

        printMatrix(product);

    }

    public void transpose(int menuOptions) {

        double[][] transpose = new double[A.row][A.column];
        double[][] copyOfInitial = A.getMatrix().clone();

        switch (menuOptions) {
            case 1:
                printMatrix(mainDiagonalTranspose(transpose, copyOfInitial));
                break;
            case 2:
                sideDiagonalTranspose(transpose, copyOfInitial);
                break;
            case 3:
                verticalTranspose(transpose, copyOfInitial);
                break;
            case 4:
                horizontalTranspose(transpose, copyOfInitial);
                break;
        }
    }

    public double[][] mainDiagonalTranspose(double[][] transpose, double[][] copyOfInitial) {
        for (int i = 0; i < transpose.length; i++) {
            for (int j = 0; j < transpose[i].length; j++) {
                if (i == j) {
                    transpose[i][j] = copyOfInitial[i][j];
                } else {
                    transpose[i][j] = copyOfInitial[j][i];
                }
            }
        }
        return transpose;
    }

    public void sideDiagonalTranspose(double[][] transpose, double[][] copyOfInitial) {
        int i = 0;
        int j = 0;
        for (int columns = transpose.length - 1; columns >= 0; columns--) {
            for (int rows = transpose.length - 1; rows >= 0; rows--) {
                transpose[i][j] = copyOfInitial[rows][columns];
                if (j + 1 == transpose.length) {
                    j = 0;
                    i++;
                } else {
                    j++;
                }
            }
        }
        printMatrix(transpose);
    }

    public void verticalTranspose(double[][] transpose, double[][] copyOfInitial) {
        int j = 0;
        for (int i = 0; i < transpose.length; i++) {
            for (int columns = transpose.length - 1; columns >= 0; columns--) {
                transpose[i][j] = copyOfInitial[i][columns];
                if (j + 1 == transpose.length) {
                    j = 0;
                } else {
                    j++;
                }
            }
        }
        printMatrix(transpose);
    }

    public void horizontalTranspose(double[][] transpose, double[][] copyOfInitial) {
        int j = 0;
        int row = transpose.length - 1;
        for (int i = 0; i < transpose.length; i++) {
            for (int columns = 0; columns < transpose.length; columns++) {
                transpose[i][j] = copyOfInitial[row][columns];
                if (j + 1 == transpose.length) {
                    j = 0;
                    row--;
                } else {
                    j++;
                }
            }
        }
        printMatrix(transpose);
    }

    // Recursively find the determinant of the given matrix
    public double determinant(int n, double[][] matrix) {

        double total = 0;

        double[][] currentMatrix = matrix.clone();
        double[][] smallerMatrix = new double[n-1][n-1];
        double[][] cofactorMatrix = new double[currentMatrix.length][currentMatrix.length];

        if (n == 1) {
            return matrix[0][0];
        }

        if (n == 2) {
            total = (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
            //System.out.println("test " + total);
            //cofactor(total);
            return total;
        }


        // badColumn is the column where the current element in currentMatrix is
        int badColumn = 0;
        // currentRow and currentColumn are used to set the values of the smallerMatrix
        int currentColumn = 0;
        int currentRow = 0;

        // Iterate through top row of currentMatrix, then set values for smallerMatrix
        for (int h = 0; h < currentMatrix[0].length; h++) {
            for (int i = 0; i < currentMatrix[0].length; i++) {
                for (int j = 0; j < currentMatrix.length; j++) {
                    for (int k = 0; k < currentMatrix.length; k++) {
                        // fill up matrix
                        if (j != h && k != badColumn) {
                            smallerMatrix[currentRow][currentColumn] = currentMatrix[j][k];
                            if (currentColumn == smallerMatrix.length - 1) {
                                currentColumn = 0;
                                currentRow++;
                            } else {
                                currentColumn++;
                            }
                        }
                    }
                }
                // In the determinant equation, every other value is subtracted. Start with adding.
                if ((i % 2 == 0 || i == 0) && h == 0) {
                    double elementTotal = currentMatrix[0][badColumn] * (determinant(n - 1, smallerMatrix));
                    total += elementTotal;
                } else if (i % 2 != 0 && h == 0) {
                    double elementTotal = currentMatrix[0][badColumn] * (determinant(n - 1, smallerMatrix));
                    total -= elementTotal;
                }

                if (currentMatrix.length == A.getMatrix().length) {
                    cofactorMatrix[h][i] = Math.pow(-1, h + i) * (determinant(n - 1, smallerMatrix));
                }
                badColumn++;
                // Set the variables back to 0 for the next iteration
                currentColumn = 0;
                currentRow = 0;
            }
            badColumn = 0;
        }

        if (currentMatrix.length == A.getMatrix().length) {
            cofactor(cofactorMatrix);
        }

        return total;
    }


    public void cofactor(double[][] matrix) {

        double[][] transpose = new double[matrix.length][matrix.length];

        matrix = mainDiagonalTranspose(transpose, matrix);


        cofactors = matrix.clone();
    }



    public double[][] inverse() {

        double determinant = determinant(A.getMatrix().length, A.getMatrix());

        if (determinant == 0) {
            return null;
        }

        return multiplyBy((1 / determinant), cofactors);


    }
}
