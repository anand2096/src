package DSA.Matirx;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {

    public static void main(String[] args) {
//       char [][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//       String word = "ABCB";
        char [][] board = {{'a','b'},{'c','d'}};
        String word = "acdb";
        System.out.println(new WordSearch().exist(board,word));
    }

    public boolean exist(char[][] board, String word) {
        if(board.length==1  && board[0].length==1){
            if(String.valueOf(board[0][0]).equals(word)){
                return true;
            }
            else return false;
//            String s="";
//            for(int i=0;i<board[0].length;i++){
//                s=s+board[0][i];
//            }
//            if(s.contains(word))
//                return true;
//            else return false;
        }
        boolean vis[][]=new boolean[board.length][board[0].length];
        boolean ans=false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
              //  if(board[i][j]==word.charAt(0)){
                    if(rec(i,j,board,vis,word,new ArrayList<Character>(),board.length,board[0].length)){
                        return true;
                    }
                }
           // }
        }

        return ans;

    }

    private boolean rec(int i, int j, char[][] board, boolean[][] vis, String word, List<Character> charList,int n,int m) {

        if(i>n || j>m){
                return false;
        }
        vis[i][j]=true;
        charList.add(board[i][j]);
        if(charList.size()==word.length()){
            String s="";
            for(int a=0;a<charList.size();a++){
                s=s+charList.get(a);
            }
            if(word.equals(s)){
                return true;
            }
        }
        else{
            if((i-1)>=0 && !vis[i-1][j])
                if(rec(i-1,j,board,vis,word,charList,n,m))return true;
            if((j+1)<m && !vis[i][j+1])
                if(rec(i,j+1,board,vis,word,charList,n,m))return true;
            if(i+1<n && !vis[i+1][j])
                if(rec(i+1,j,board,vis,word,charList,n,m)) return true;
            if(j-1>=0 && !vis[i][j-1])
                if(rec(i,j-1,board,vis,word,charList,n,m)) return true;

        }
        charList.remove(charList.size()-1);
        vis[i][j]=false;
        return false;



    }


}
