package LeetCode;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int r=board.length;
        int w=board[0].length;
        boolean visited[][]=new boolean[r][w];
        for (int i=0;i<r;i++){
            for (int j=0;j<w;j++){
                if(explore(board,visited,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean explore(char[][] board, boolean[][] visited, String word, int i, int j, int start) {
        if(start>=word.length()){
            return true;
        }
        if(i<0||i>=board.length||j<0||j>=board[0].length||visited[i][j]||word.charAt(start)!=board[i][j]){
            return false;
        }
        visited[i][j]=true;
        boolean result=explore(board,visited,word,i+1,j,start+1)||
                explore(board,visited,word,i-1,j,start+1)||
                explore(board,visited,word,i,j-1,start+1)||
                explore(board,visited,word,i,j+1,start+1);
        visited[i][j]=false;
        return result;

    }
    public static void main(String[] args){
        char[][] input={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word="SEE";

        WordSearch wordSearch=new WordSearch();
        System.out.println(wordSearch.exist(input,word));
    }
}
