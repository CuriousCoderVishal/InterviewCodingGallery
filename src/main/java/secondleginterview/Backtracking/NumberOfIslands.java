package secondleginterview.Backtracking;

public class NumberOfIslands {
    public static void main(String[] args) {
        int a[][]={{1,1,0},
                {0,1,0},
                {0,0,1}};

        System.out.println(numberOfIslands(a,a.length,a[0].length));
    }

    private static int numberOfIslands(int[][] matrix, int rows, int column) {
        int countIslands = 0;
        for (int i=0;i< rows;i++){
            for (int j=0;j< column;j++){
                if(matrix[i][j]==1){
                    countIslands=countIslands+1;
                    visitIslands(matrix,rows,column);
                }
            }
        }
        return countIslands;
    }

    private static void visitIslands(int[][] matrix, int rows, int column) {



        if(rows < 0 || column < 0 || rows >= matrix.length || column >= matrix[0].length){
            return;
        }

        if (matrix[rows][column]==0){
            return;
        }

        matrix[rows][column]=0;

        visitIslands(matrix,rows,column+1);
        visitIslands(matrix,rows+1,column);
        visitIslands(matrix,rows,column-1);
        visitIslands(matrix,rows+1,column);
    }
}
