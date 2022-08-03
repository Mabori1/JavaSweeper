import sweeper.Box;
import sweeper.Coord;
import sweeper.Ranges;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class JavaSweeper extends JFrame {

    private JPanel panel;
    private final int COWS = 9;
    private final int ROWS = 9;
    private final int IMAGE_SIZE = 50;


    public static void main(String[] args) {
        new JavaSweeper();
    }

    private JavaSweeper() {
        Ranges.setSize(new Coord(COWS, ROWS));
        setImages();
        initPanel();
        initframe();
    }

    private void initPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                for (Coord coord: Ranges.getAllCoords()) {

                    g.drawImage((Image) Box.values()[(coord.x + coord.y)% Box.values().length].image,
                            coord.x * IMAGE_SIZE, coord.y * IMAGE_SIZE, this);
                }
            }
        };

        panel.setPreferredSize(new Dimension(
                Ranges.getSize().x * IMAGE_SIZE,
                Ranges.getSize().y * IMAGE_SIZE));
        add(panel);
    }

    private void initframe() {

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Java Sweeper");
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setIconImage(getImage("icon"));
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