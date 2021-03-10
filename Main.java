import javax.swing.*;
import java.awt.*;

public class Main {

    public static final int WIDTH = 815, HEIGHT = 800;

    public static void main(String[] args) {

        JFrame window = new JFrame("Tic Tac Toe");

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, WIDTH, HEIGHT + 22); //22 is due to the title bar

        Panel panel = new Panel(WIDTH, HEIGHT);

        panel.setFocusable(true);
        panel.grabFocus();
        window.add(panel);
        window.setVisible(true);
        window.setResizable(true);

    }
}
