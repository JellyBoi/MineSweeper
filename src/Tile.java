import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Tile extends JButton implements ActionListener{
    public JLabel num = new JLabel();
    public Tile[][] tilelist;
    public int r, c, type;
    private MineSweeper game;

    // Tile Constructor
    public Tile(MineSweeper g, int x, int y) {
        super();
        this.add(num, JPanel.CENTER_ALIGNMENT);

        game = g;
        r = x;
        c = y;
        tilelist = new Tile[9][27];

        num.setText((int)(Math.random() * 8) + "");

        switch(num.getText()) {
            case "0":
                num.setText("   ");
                this.type = 0;
                break;
            case "1":
                num.setText("   ");
                this.type = 0;
                break;
            case "2":
                num.setText("   ");
                this.type = 0;
                break;
            case "3":
                num.setText("   ");
                this.type = 0;
                break;
            case "4":
                num.setText("   ");
                this.type = 0;
                break;
            case "5":
                num.setText("   ");
                this.type = 1;
                break;
            case "6":
                num.setText("   ");
                this.type = 1;
                break;
            case "7":
                num.setText("   ");
                this.type = 1;
                break;
        }

        this.addActionListener(this);
        this.setBounds(x * 25, y * 25, 25, 25);
        this.setBackground(Color.gray);

    }

    // Returns tile row
    public int getRow() {
        return this.r;
    }

    public int getType() { return this.type; }

    // Returns tile column
    public int getColumn() {
        return this.c;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object src = actionEvent.getSource();
        if(src==this) {
            if(this.getType() == 1){
                game.lose();
            }
        }
    }
}
