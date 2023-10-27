package DSA.journey.backracking;

import java.util.ArrayList;

public class NQueen {

    public static void main(String[] args) {
        System.out.println(new NQueen().solveNQueens(4));
    }
    public ArrayList<ArrayList<String>> solveNQueens(int n)
    {
        char [][] mat=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mat[i][j]='.';
            }
        }
        ArrayList<ArrayList<String>>ans=new ArrayList<>();
        rec(0,n,mat,ans);
        return ans;

    }
    public void rec(int row,int n,char[][]mat,ArrayList<ArrayList<String>>ans){

        if(row==n){
            ArrayList<String> temp=new ArrayList<>();
            for(int i=0;i<mat.length;i++){
                String s="";
                for(int j=0;j<mat[0].length;j++){
                    s=s+mat[i][j];
                }
                temp.add(s);
            }
            ans.add(temp);
            return;
        }

        for(int i=0;i<n;i++){
            if(isValid(row,i,mat,n)){
                mat[row][i]='Q';
                rec(row+1,n,mat,ans);
                mat[row][i]='.';
            }
        }
    }

    public boolean isValid(int row,int col,char[][]mat,int n){

        int i=row;
        int j=col;
        while(i>=0 && j>=0){
            if(mat[i][j]=='Q'){
                return false;
            }
            i--;
            j--;
        }
        i=row;
        j=col;
        while(i>=0 &&j<n){
            if(mat[i][j]=='Q'){
                return false;
            }
            i--;
            j++;
        }
        i=row;
        while(i>=0){
            if(mat[i][col]=='Q'){
                return false;
            }
            i--;
        }

        return true;
    }
}
