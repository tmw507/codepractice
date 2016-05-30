public class Solution {
    public void solveSudoku(char[][] board) {
        
    if(board == null) return ;
        int m= board.length, n = board[0].length;
        
        boolean[][] isEmpty = new boolean[m][n];
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] columns = new HashSet[9];
        HashSet<Character>[][] subBoard  = new HashSet[3][3];

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                rows[i*3+j] = new HashSet<Character>();
                columns[i*3+j] = new HashSet<Character>();
                subBoard[i][j] = new HashSet<Character>();
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] != '.'){
                    rows[i].add(board[i][j]);
                    columns[j].add(board[i][j]);
                    subBoard[i/3][j/3].add(board[i][j]);
                    isEmpty[i][j] = false;
                }else{
                    isEmpty[i][j] = true;
                }
            }
        }
        sudokuHelper(board, isEmpty, 0, rows, columns, subBoard);
    }
    
    private boolean sudokuHelper(char[][] board, boolean[][] isEmpty, int pos, HashSet<Character>[] rows, HashSet<Character>[] columns,  HashSet<Character>[][] subBoard){
        int x = pos / 9;
        int y = pos % 9;
        // for(int i=0; i<9; i++){
        //     for(int j=0; j<9; j++)
        //       System.out.print(board[i][j]);
        //     System.out.println();   
        // }
        if(pos >= 81) return true;

        if(isEmpty[x][y] == false){
            return sudokuHelper(board, isEmpty, pos+1, rows, columns, subBoard);
        }
        
        for(char c='1'; c<='9'; c++){
            //System.out.println(c);   
            if(rows[x].contains(c) || columns[y].contains(c) || subBoard[x/3][y/3].contains(c)) continue;
            
            board[x][y] = c;
            rows[x].add(c);
            columns[y].add(c);
            subBoard[x/3][y/3].add(c);
            boolean  res = sudokuHelper(board, isEmpty, pos+1, rows, columns, subBoard);
            
            if(res == true) return true;
            rows[x].remove(c);
            columns[y].remove(c);
            subBoard[x/3][y/3].remove(c);
        }
        return false;
    }
}