import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import sweeper.Box;

public class JavaSweeper extends JFrame {

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
        JPanel panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                //g.drawImage(getImage("bomb"),0,0,this);
                //g.drawImage(getImage("nobomb"),IMAGE_SIZE,0,this);

                for (Box box : Box.values())
                g.drawImage((Image)box.image,box.ordinal() * IMAGE_SIZE, 0,this);

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
    }

    private void setImages(){
        for (Box box : Box.values()) box.image = getImage(box.name().toLowerCase());
    }

    private Image getImage(String name){
        String filename = "img/" + name + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(filename));
        return icon.getImage();
    }
}