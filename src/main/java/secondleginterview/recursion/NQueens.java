package secondleginterview.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = 5;
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

       for (int i = 0; i < n; i++) {
           Arrays.fill(board[i], '.');
       }

        solve(0,n,result,board);
       // System.out.println(result);
    }

    private static void solve(int col, int n, List<List<String>> result, char[][] board) {

        if (col == n) {
            ArrayList<String> rowList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    rowList.add(String.valueOf(board[i][j]));
                }
                result.add(new ArrayList<>(rowList));
                rowList.clear();
            }
            System.out.println(result);
            result.clear();
            return;
        }

            for (int row = 0; row < n; row++) {
                if (isSafe(row, col, board,n)) {
                    board[row][col] = 'Q';
                    solve(col + 1, n, result, board);
                    board[row][col] = '.';
                }
            }
        }


    private static boolean isSafe(int row1, int col1, char[][] board,int n) {

        //Upper left diagnol
        int row=row1,col=col1;
        while (row>=0 && col>=0) {
            if(board[row][col] == 'Q'){
                return false;
            }
            row--;
            col--;
        }

        row=row1;col=col1;
        //Left direction column wise
        while (col>=0) {
            if(board[row][col] == 'Q'){
                return false;
            }
            col--;
        }

        row=row1;col=col1;
        //Lower left diagnol
        while (row < n && col>=0) {
            if(board[row][col] == 'Q'){
                return false;
            }
            row++;
            col--;
        }
        return true;
    }

}



