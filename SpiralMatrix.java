/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

*/
////////////////// define an 2d array for spiral directions, and dfs explore the matrix

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new ArrayList<Integer>();
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<Integer>(m*n);
        //spiral order from west, south, east, north
        int[][] Dir = {{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][] visited = new boolean[m][n];
        
        spiralOrderHelper(res, matrix, m, n, 0,0, visited, Dir, 0);
        return res;
    }
    
    private void spiralOrderHelper(ArrayList<Integer> res, int[][] matrix, int m, int n, int i, int j, boolean[][] visited, int[][] Dir, int k){
        if(i<0 || i>= m || j<0 || j>=n || visited[i][j]) return;
        res.add(matrix[i][j]);
        visited[i][j] = true;
        int[] D = Dir[k];
        int x = i + D[0];
        int y = j + D[1];
        
        //change direction if necessary
        if(x<0 || x>= m || y<0 || y>=n || visited[x][y] ){
            k = (k+1) % 4;
            D = Dir[k];
            x = i + D[0];
            y = j + D[1];
        }
        spiralOrderHelper(res, matrix, m, n, x, y, visited, Dir, k);
        
    }
}