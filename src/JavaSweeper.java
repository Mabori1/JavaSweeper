import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import sweeper.Box;
import sweeper.Coord;

public class JavaSweeper extends JFrame {

    private JPanel panel;
    private final int COWS = 15;
    private final int ROWS = 1;
    private final int IMAGE_SIZE = 50;



    public static void main(String[] args) {
       new JavaSweeper();
    }

    private JavaSweeper() {
        setImages();
        initPanel();
        initframe();
    }

    private void initPanel() {
         panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                for (Box box : Box.values()) {
                    Coord coord = new Coord(box.ordinal() * IMAGE_SIZE, 0);
                    g.drawImage((Image) box.image, coord.x, coord.y, this);
                }
            }
        };

        panel.setPreferredSize(new Dimension(COWS*IMAGE_SIZE, ROWS* IMAGE_SIZE));
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

    private void setImages(){
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