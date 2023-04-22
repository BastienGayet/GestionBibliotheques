package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Bibliotheque extends JFrame
{

    private JPanel mainPanel;
    private JButton auteurButton;
    private JButton membreButton;
    private JButton livreButton;
    private JButton pretButton;


    public Bibliotheque()
    {
        //setSize(1000,1000);
        setTitle("Gestion Bibliotheque JAVA");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        auteurButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              

            }
        });
        
        membreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        livreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        
        pretButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args)
    {
        Bibliotheque bibliotheque = new Bibliotheque();
        bibliotheque.pack();
        bibliotheque.setLocationRelativeTo(null);
        bibliotheque.setVisible(true);
        bibliotheque.setSize(500,500);

    }
}

