import javax.swing.*;
import java.awt.*;

public class JavaSweeper extends JFrame {

    public static void main(String[] args) {
        new JavaSweeper();
    }
    private JavaSweeper(){
        initPanel();
        initframe();
    }

    private void initPanel() {
        JPanel panel = new JPanel();
       panel.setPreferredSize(new Dimension(500,500));
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
}