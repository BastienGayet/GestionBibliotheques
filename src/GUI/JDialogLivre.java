package GUI;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JDialogLivre extends JDialog
{
    private JPanel mainPanel;
    private JTextField textFieldTitre;
    private JTextField textFieldAuteur;
    private JTextField textFieldAnnePublication;
    private JTextField textFieldPrix;
    private JTextField textFieldEditeur;
    private JTextField textFieldISBN;
    private JButton suprimerButton;
    private JButton ajouterButton;
    private JButton modifierButton;
    private JTable table1;
    private JCheckBox disponibleCheckBox;
    private JTextField textFieldDomaine;
    private JTextField textFieldGenre;

    public  JDialogLivre()
    {
        super((JFrame)null, "Gestion Livre",true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700,500);
    }
    public static void main(String[] args) {
        JDialogLivre dialog = new JDialogLivre();
        dialog.setVisible(true);
    }

}
