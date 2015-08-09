package ctci.laakman.arrays;

/**
 *
 */
public class MatrixRotation {
    public static void main(String[] args) {
        int n =3;
        int[][] matrix = new int[n][n];
        int index=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = index++;
            }
        }
        printMatrix(matrix,n);
        rotateMatrix90(matrix, n);
        printMatrix(matrix,n);
    }

    private static void printMatrix(int[][] matrix, int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void rotateMatrix90(int[][] matrix, int n){

        for(int layer=0; layer < n/2; layer++){
            int first = layer;
            int last = n - 1 - layer;
            for(int i = first; i < last; ++i) {
                int offset = i - first;

                int top = matrix[first][i]; // save top

                // left -> top
                matrix[first][i] = matrix[last - offset][first];

                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top; // right <- saved top
                printMatrix(matrix,n);
            }
        }
    }
}
