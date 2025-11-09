public class Nqueen {

    public static boolean issafe(char board[][] , int row,int col){
        //vertical
        for(int i=row-1 ; i>=0; i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        // diagonal
        for(int i=row-1 , j=col-1 ; i>=0 &&j>=0 ; i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1 , j=col+1 ; i>=0 &&j<board.length ; i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static void nqueen(char board[][],int row){
        if(row==board.length){
            print(board);
            return;
        }
        for(int i=0 ; i<board.length ; i++){
            if(issafe(board, row, i)){
            board[row][i]='Q';
            nqueen(board, row+1);
            board[row][i]='x';
        }}
    }

    public static void print(char board[][]){
        System.out.println("------------");
        for (int i=0; i<board.length ; i++){
            for(int j=0;j<board.length ; j++){
               System.out.print(board[i][j]);
           } System.out.println();
        }}
          
    public static void main(String[] args) {
       int n=4;
       char board[][]=new char[n][n];
       for (int i=0; i<board.length ; i++){
        for(int j=0;j<board.length ; j++){
            board[i][j]='x';
       }}
        nqueen(board,0);
        // print(board);
    }
    
}
