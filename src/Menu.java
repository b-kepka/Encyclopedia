import javax.swing.*;

public class Menu extends JMenuBar {
    JMenu fileMenu, infoMenu;
    JMenuItem info, wczytaj, exit;
    public Menu() {
        fileMenu = new JMenu("File");
        infoMenu = new JMenu("Info");
        info = new JMenuItem("Info");
        wczytaj = new JMenuItem("Wczytaj dane");
        exit = new JMenuItem("Exit");
        fileMenu.add(wczytaj);
        fileMenu.add(exit);
        infoMenu.add(info);
        info.addActionListener(e -> JOptionPane.showMessageDialog(
                null,
                "Bartłomiej Kępka\nKlasa 4pP\nProjekt Encyklopedia",
                "Informacje",
                JOptionPane.INFORMATION_MESSAGE)
        );

        exit.addActionListener(e -> System.exit(1));
        this.add(fileMenu);
        this.add(infoMenu);
    }
}
