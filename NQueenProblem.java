/* Java program to solve N Queen Problem using
backtracking */
public class NQueenProblem
{
  public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(n == 0) return res;
        boolean[][] grid = new boolean[n][n];
        dfs(res, grid, 0);
        return res;
    }
    
    private void dfs (List<List<String>> res, boolean[][] grid, int rowNum){
        int n = grid.length;
        if(rowNum >= n){
         //  System.out.println("rowNum:"+rowNum);
            ArrayList<String> sol = new ArrayList<String>();
            for(int i=0; i<n; i++){
                StringBuffer buf = new StringBuffer();
                for(int j=0; j<n; j++){
                    if(grid[i][j] == true)
                       buf.append("Q");
                    else
                       buf.append(".");
                }
                sol.add(buf.toString());
            }
            res.add(sol);
            return ;
        }
        for(int j=0; j<n; j++){
            if(isSafe(grid, n, rowNum, j)){
                grid[rowNum][j] = true;
                dfs(res,grid, rowNum+1);
                grid[rowNum][j] = false;
            }
        }
    }
     private boolean isSafe(boolean[][] grid, int n, int x, int y){
        //check cols
        for(int i=x; i>=0; i--){
            if(grid[i][y] == true) return false;
        }
       
        //check left upper
        for(int i=x, j=y; i>=0 && j>=0; i--, j--){
            if(grid[i][j] == true) return false;
        }
       
        //check right upper
        for(int i=x, j=y; i>=0&& j<n; i--, j++){
            if(grid[i][j] == true) return false;
        }
       
        return true;
    }

	// driver program to test above function
	public static void main(String args[])
	{
		NQueenProblem Queen = new NQueenProblem();
		Queen.solveNQueens(5);
	}
}
// This code is contributed by Abhishek Shankhadhar
