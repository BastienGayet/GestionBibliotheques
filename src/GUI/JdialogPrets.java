package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class JdialogPrets extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton modifierButton;
    private JTextField textField4;
    private JTable table1;

    public JdialogPrets(JFrame parent, boolean modal , String titre) {
        super(parent, modal);
        setTitle(titre);
        setContentPane(contentPane);
        pack();
        // Créer les titres de colonnes
        String[] columnNames = {"Titre Livre","Numéro Membre ", "Date d'umprunt", "Date retour"};

        // Créer des données pour la table
        //
        Object[][] data = {
        };

        // Définir le modèle de table avec les données et les noms de colonnes
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Appliquer ce modèle à votre table
        table1.setModel(model);
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        JdialogPrets dialog = new JdialogPrets(null, true, "Prets");
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
