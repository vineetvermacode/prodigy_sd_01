public class Sudoko_solver {
    public boolean isSafe(char[][] board,int row,int col,int number)
    {
        // row and col.
        for(int i=0;i<board.length;i++)
        {
            if(board[i][col]==(char)(number+'0'))
            {
                return false;
            }
        }
        for(int i=0;i<board.length;i++)
        {
            if(board[row][i]==(char)(number+'0'))
            {
                return false;
            }
        }
        
        
        //grid
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        
        for(int i=sr;i<sr+3;i++)
        {
            for(int j=sc;j<sc+3;j++)
            {
                if(board[i][j]==(char)(number+'0'))
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean helper(char[][] board,int row,int col)
    {
        if(row==board.length)
        {
            return true;
        }
        int nrow=0;
        int ncol=0;
        if(col==board.length-1)
        {
            nrow=row+1;
            ncol=0;
        }
        else
        {
            nrow=row;
            ncol=col+1;
        }
        
        if(board[row][col]!='.')
        {
            if(helper(board,nrow,ncol))
            {
                return true;
            }
        }
        else
        {
            //fill the place
            for(int i=1;i<=9;i++)
            {
                if(isSafe(board,row,col,i))
                {
                    board[row][col]=(char)(i+'0');
                    if(helper(board,nrow,ncol))
                    {
                        return true;
                    }
                    else
                    {
                        board[row][col]='.';
                    }
                }
            }
        }
        return false;
    }

    public static void display(char[][] board)
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]=='.')
                {
                    System.out.print("_"+" ");
                }
                else
                {
                    System.out.print(board[i][j]+" ");
                }
            }
            System.out.println("");
        }
    }
    public static char[][] board={{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
    public static void main(String[] args) {
        System.out.println("Input Sudoku:");
        display(board);
        Sudoko_solver m=new Sudoko_solver();
        m.helper(board,0,0);
        System.out.println("\nSolved Sudoku:");
        display(board);
    }
}