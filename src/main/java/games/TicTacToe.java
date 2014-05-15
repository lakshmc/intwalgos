package games;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 11/7/13
 * Time: 2:54 PM
 */
public class TicTacToe {

    public static void main(String[] args) {
        //int[][] board = getRandomBoard();

        int[][] board1 = {{1,1,1},{0,0,0},{0,0,0}};
        processBoard(board1);

        board1 = new int[][] {{0,0,0},{1,1,1},{0,0,0}};
        processBoard(board1);
        board1 = new int[][] {{0,0,0},{0,0,0},{1,1,1}};
        processBoard(board1);
        board1 = new int[][] {{1,0,0},{1,0,0},{1,0,0}};
        processBoard(board1);
        board1 = new int[][] {{0,1,0},{0,1,0},{0,1,0}};
        processBoard(board1);
        board1 = new int[][] {{0,0,1},{0,0,1},{0,0,1}};
        processBoard(board1);
        board1 = new int[][] {{1,0,0},{0,1,0},{0,0,1}};
        processBoard(board1);
        board1 = new int[][] {{0,0,1},{0,1,0},{1,0,0}};
        processBoard(board1);

    }

    private static void processBoard(int[][] board){
        printBoard(board);
        //System.out.println("winner:"+getWinner(board));
        System.out.println();
    }

    private static int[][] printBoard(int[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        return board;
    }

    /*private static int[][] getRandomBoard() {
        Random rand = new Random();
        int[][] board = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = rand.nextInt(2);
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        return board;
    }*/

    private static int getWinner(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            boolean result0 = true;
            boolean result1 = true;
            for (int j = 0; j < board.length - 1; j++) {
                if (board[i][j] != board[i][j + 1]) {
                    result0 = false;
                }
                if (board[j][i] != board[j + 1][i]) {
                    result1 = false;
                }
            }
            if (result0) {
                return board[i][0];
            }
            if (result1) {
                return board[0][i];
            }
        }
        boolean result0 = true;
        boolean result1 = true;
        for (int j = 0; j < board.length - 1; j++) {
            if (board[j][j] != board[j + 1][j + 1]) {
                result0 = false;
            }
            if (board[board.length - 1 - j][j] != board[board.length - 2 - j][j + 1]) {
                result1 = false;
            }
        }
        if (result0) {
            return board[0][0];
        }
        if (result1) {

            return board[board.length - 1][0];
        }
        return -1;
    }


}
