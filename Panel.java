import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Panel extends JPanel{

    private Board b;
    private int w;




    public Panel(int width, int height){
        setSize(width, height);
        b = new Board(200);
        w = 8;
        setupMouse();
        setupKeyListener();



    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        b.drawBoard(g2);
    }

    public void setupKeyListener(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_R){
                    b = new Board(200);
                    repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }


    public void setupMouse(){
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                int row = y / (b.getSize());
                int col = x / (b.getSize());
                b.takeTurn(row, col);

                if(w==0){
                    repaint();
                }

                w = b.checkForWinner();

                if(w==1){
                    System.out.println("0's win");
                }
                if(w==-1){
                    System.out.println("X's win");
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

}

