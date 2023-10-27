package DSA.journey.backracking;

public class ValidSudoku {
    public static void main(String[] args) {
        char [][]A =
                {{'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};

        new ValidSudoku().solveSudoku(A);

    }
    public void solveSudoku(char[][]mat) {
        int n=mat.length;
        int row=0;
        int col=0;
        rec(mat,n,row,col);
    }

    public void rec(char[][]mat,int n,int row,int col){
        if(col==n){
            row++;
            col=0;
        }

        if(row==n){
            return;
        }

        if(mat[row][col]!='.'){
            rec(mat,n,row,col+1);
        }

        for(int i=1;i<=n;i++){
            if(isValid(mat,n,row,col,i)){
                mat[row][col]=(char)(i+'0');
                rec(mat,n,row,col+1);
                 mat[row][col]='.';
            }
        }
    //    row++;
    }




    public boolean isValid(char[][]mat,int n,int row,int col,int x){

        //check in row
        for(int j=0;j<n;j++){
            if(mat[row][j]-'0'==x){
                return false;
            }
        }

        //check in col
        for(int i=0;i<n;i++){
            if(mat[i][col]-'0'==x){
                return false;
            }
        }

        //check in its cube
        int r=row-row%3;
        int c=col-col%3;
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                if(mat[i][j]-'0'==x){
                    return false;
                }
            }
        }

        return true;
    }

}
