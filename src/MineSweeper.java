import javax.swing.*;
import java.awt.*;

public class MineSweeper extends JFrame {
    private MenuBar menubar;
    private JPanel board;
    private Tile[][] tilelist;

    // Game Constructor
    public MineSweeper() {
        super("MineSweeper");

        board = new JPanel();
        board.setBackground(Color.darkGray);
        board.setLayout(new GridLayout(9, 27));
        this.add(board);

        menubar = new MenuBar(this);
        setJMenuBar(menubar);

        newGame();
    }

    // New Game method
    public void newGame() {
        tilelist = new Tile[9][27];

        for(int r = 0; r <= 8; r++) {
            for (int c = 0; c <= 26; c++) {
                tilelist[r][c] = new Tile(this, r , c);
            }
        }
        for(Tile[] t : tilelist) {
            for(Tile x : t) {
                board.add(x);
            }
        }
        repaint();
    }

    // Board reset method (New game menu option)
    public void reset() {
        for(Tile[] x : tilelist) {
            for(Tile t : x) {
                t.setEnabled(true);
                t.setText((int) (Math.random() * 8) + "");

                switch(t.getText()) {
                    case "0":
                        t.setText("   ");
                        t.type = 0;
                        break;
                    case "1":
                        t.setText("   ");
                        t.type = 0;
                        break;
                    case "2":
                        t.setText("   ");
                        t.type = 0;
                        break;
                    case "3":
                        t.setText("   ");
                        t.type = 0;
                        break;
                    case "4":
                        t.setText("   ");
                        t.type = 0;
                        break;
                    case "5":
                        t.setText("   ");
                        t.type = 1;
                        break;
                    case "6":
                        t.setText("   ");
                        t.type = 1;
                        break;
                    case "7":
                        t.setText("   ");
                        t.type = 1;
                        break;
                }
            }
        }
    }

    public void lose() {
        System.out.println("You lost");

        for(Tile[] x : tilelist) {
            for(Tile t : x) {
                if (t.type == 1) { t.setText("X"); }
                else { t.setText("O"); }

                t.setEnabled(false);
            }
        }

        LoseScreen w = new LoseScreen();
        w.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        w.setBounds(1000,700,300,200);
        w.setVisible(true);
        w.setResizable(false);
    }

    public static void main(String args[]) {
        try {
            // Set System L&F
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException e) {
            System.out.println("LAF not supported.");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
        catch (InstantiationException e) {
            System.out.println("LAF cannot be instantiated");
        }
        catch (IllegalAccessException e) {
            System.out.println("Illegal access.");
        }

        MineSweeper window = new MineSweeper();
        window.setBounds(540, 360, 1180, 680);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setResizable(false);
    }
}