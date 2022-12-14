import sweeper.Box;
import sweeper.Coord;
import sweeper.Game;
import sweeper.Ranges;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class JavaSweeper extends JFrame {

    private final Game game;
    private JPanel panel;
    private JLabel label;
    private final int COWS = 9;
    private final int ROWS = 9;
    private final int BOMBS = 10;
    private final int IMAGE_SIZE = 50;


    public static void main(String[] args) {
        new JavaSweeper();
    }

    private JavaSweeper() {
        game = new Game(COWS, ROWS, BOMBS);
        game.start();
        setImages();
        initLabel();
        initPanel();
        initframe();
    }

    private void initLabel() {
        label = new JLabel(" Welcome!");
        add(label, BorderLayout.SOUTH);
    }

    private void initPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                for (Coord coord : Ranges.getAllCoords()) {

                    g.drawImage((Image) game.getBox(coord).image,
                            coord.x * IMAGE_SIZE, coord.y * IMAGE_SIZE, this);
                }
            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() / IMAGE_SIZE;
                int y = e.getY() / IMAGE_SIZE;
                Coord coord = new Coord(x, y);
                if (e.getButton() == MouseEvent.BUTTON1)
                    game.pressLeftButton(coord);
                if (e.getButton() == MouseEvent.BUTTON3)
                    game.pressRightButton(coord);
                if (e.getButton() == MouseEvent.BUTTON2)
                    game.start();
                label.setText(getMessage());

                panel.repaint();
            }

            private String getMessage() {
                String str;
                str = switch (game.getState()){
                    case PLAYED ->  "Think twice!";
                    case BOMBED -> "You lose!";
                    case WINNER -> "Congranulation!";
                };
                return str;

            }
        });
        panel.setPreferredSize(new Dimension(
                Ranges.getSize().x * IMAGE_SIZE,
                Ranges.getSize().y * IMAGE_SIZE));
        add(panel);
    }

    private void initframe() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Java Sweeper");
        setResizable(false);
        setVisible(true);
        setIconImage(getImage("icon"));
        pack();
        setLocationRelativeTo(null);
    }

    private void setImages() {
        for (Box box : Box.values()) box.image = getImage(box.name().toLowerCase());
    }

    private Image getImage(String name) {
        String filename = "img/" + name + ".png";
        ImageIcon icon = null;
        try {
            icon = new ImageIcon(Objects.requireNonNull(getClass().getResource(filename)));
        } catch (Exception e) {
            System.out.println("Icon cannot be found!");
        }
        assert icon != null;
        return icon.getImage();
    }
}