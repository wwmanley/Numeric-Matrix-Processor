package processor;

class MatrixProcessor {

    private Matrix A;
    private Matrix B;

    public MatrixProcessor(Matrix A, Matrix B) {
        this.A = A;
        this.B = B;
    }

    public void printMatrix(int[][] matrix) {
        for (int[] array : matrix) {
            for (int element : array) {
                System.out.printf(element + " ");
            }
            System.out.println();
        }
    }

    public void addMatrix() {
        int[][] matrixSum = new int[A.row][A.column];

        if (A.getMatrix().length != B.getMatrix().length) {
            System.out.println("ERROR");
            return;
        }

        for (int i = 0; i < A.getMatrix().length; i++) {
            for (int j = 0; j < A.getMatrix()[A.row-1].length; j++) {
                matrixSum[i][j] = A.getMatrix()[i][j] + B.getMatrix()[i][j];
            }
        }

        printMatrix(matrixSum);
    }
}
