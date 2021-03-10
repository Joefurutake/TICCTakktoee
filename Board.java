import java.awt.*;

public class Board {
    private int[][] board;
    private int moveCount, size;

    public static final int X = -1, O = 1;

    public Board(int size){
        board = new int[3][3];
        moveCount = 0;
        this.size = size;
    }

    public void drawBoard(Graphics2D g2){
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                g2.setStroke(new BasicStroke(1));
                g2.setColor(Color.black);
                g2.drawRect(c*size, r*size, size, size);
                int w = checkForWinner();
                g2.setStroke(new BasicStroke(5));
                if(board[r][c] == X) {
                    if (w == -1)
                        g2.setColor(Color.RED);
                    g2.drawLine(c * size, r * size, c * size + size, r * size + size);
                    g2.drawLine(c * size, r * size + size, c * size + size, r * size);
                }
                if(board[r][c] == O){
                    if(w == O)
                        g2.setColor(Color.BLUE);
                    g2.drawOval(c*size, r*size, size, size);
                }
                }
            }
        }




    public void takeTurn(int row, int col){
        if(board[row][col] ==0 ){
            if(moveCount % 2 == 0)
                board[row][col] = X;
            else
                board[row][col] = O;
            moveCount++;
        }
    }
    public int checkForWinner(){
        int w = 0;
        for (int r = 0; r < board.length; r++){
            if(board[r][0] == board[r][1] && board[r][0] == board[r][2]){
                if(board[r][0] == 0){
                    w = O;
                    break;
                }
                if(board[r][0] == X){
                    w = X;
                    break;
                }
            }
        }
        return w;
    }


    public int getSize(){
        return size;
    }
}
