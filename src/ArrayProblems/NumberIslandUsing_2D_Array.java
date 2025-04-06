package ArrayProblems;

public class NumberIslandUsing_2D_Array {



    public static int numIslandCount(char[][] grid){
        int count = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for (int j = 0 ; j < grid[i].length ; j++){
                if(grid[i][j] == '1'){
                    count++;
                    callDFS(grid,i,j);

                }
            }
        }
        return count;
    }

    public static void callDFS(char[][] grid , int i ,int j){

        if(i < 0 || j < 0 || i >= grid.length  || j >= grid[i].length ||  grid[i][j] == '0' )
        {
            return;
        }
            grid[i][j] = '0';
            callDFS(grid, i, j + 1); //check  right side of array i.
            callDFS(grid, i, j - 1); // check left side of array i.
            callDFS(grid, i + 1, j); // check down side of array.
            callDFS(grid, i - 1 , j); // check up side of array




    }



    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1','0','0','0'},
                {'1', '1','0','0','0'},
                {'0', '0','1','0','0'},
                {'0', '0','0','1','1'},

        };
        System.out.println(numIslandCount(grid));

    }
}
