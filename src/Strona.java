import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Strona extends JFrame {
    Menu menu;
    Encyklopedia sql;
    int currentSlide;
    public Strona() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("LOOK AND FEEL EXCEPTION:");
            System.out.println(e);
        }
        setTitle("Bartłomiej Kępka");
        setResizable(false);
        setSize(800,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        pack();
        setVisible(true);

        currentSlide = 0;
    }
    public void initComponents() {
        setContentPane(drawApp());
        menu = new Menu();
        menu.wczytaj.addActionListener(e -> {
            sql = new Encyklopedia();
            currentSlide = 0;
            setContentPane(drawApp());
            revalidate();
        });
        setJMenuBar(menu);
    }
    public JPanel drawApp(){
        sql = new Encyklopedia();
        sql.wyszukajNotatki();
        JPanel panel = new JPanel(new BorderLayout());
        JPanel center_panel = new JPanel();
        center_panel.setLayout(new BoxLayout(center_panel,BoxLayout.PAGE_AXIS));
        JPanel main_panel = new JPanel();
        main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.PAGE_AXIS));
        center_panel.setPreferredSize(new Dimension(600,400));
        JLabel title_label = new JLabel(sql.values.get(currentSlide)[0]);
        JPanel right_panel = new JPanel();
        right_panel.setPreferredSize(new Dimension(200,400));
        //right_panel.setBackground(Color.RED);
        //center_panel.setBackground(Color.GREEN);
        JTextArea textarea = new JTextArea();
        textarea.setText(sql.values.get(currentSlide)[5]);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textarea);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        scrollPane.setPreferredSize(new Dimension(500,200));
        JPanel btn_panel = new JPanel();
        btn_panel.setPreferredSize(new Dimension(500,50));
        btn_panel.setBorder(BorderFactory.createEmptyBorder(0,20,0,20));
        btn_panel.setLayout(new BoxLayout(btn_panel,BoxLayout.LINE_AXIS));
        JButton left_btn = new JButton("<-----");
        left_btn.addActionListener(e -> {
            if (currentSlide>0) {
                currentSlide--;
                setContentPane(drawApp());
                revalidate();
                System.out.println();
                System.out.println(currentSlide);
                System.out.println();
            } else {
                currentSlide = sql.values.size() - 1;
                setContentPane(drawApp());
                revalidate();
                System.out.println();
                System.out.println(currentSlide);
                System.out.println();
            }
        });
        left_btn.setPreferredSize(new Dimension(100,50));
        JButton right_btn = new JButton("----->");
        right_btn.addActionListener(e -> {
            if (currentSlide<sql.values.size()-1) {
                currentSlide++;
                setContentPane(drawApp());
                revalidate();
                System.out.println();
                System.out.println(currentSlide);
                System.out.println();
            } else {
                currentSlide = 0;
                setContentPane(drawApp());
                revalidate();
                System.out.println();
                System.out.println(currentSlide);
                System.out.println();
            }
        });
        right_btn.setPreferredSize(new Dimension(100,50));
        main_panel.add(scrollPane);
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn_panel.add(left_btn);
        btn_panel.add(Box.createHorizontalGlue());
        btn_panel.add(right_btn);
        left_btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        right_btn.setAlignmentX(Component.RIGHT_ALIGNMENT);
        main_panel.add(btn_panel);
        btn_panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        center_panel.add(title_label);
        center_panel.add(main_panel);
        main_panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        title_label.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel right_img1 = setImage(sql.values.get(currentSlide), 1);
        right_panel.add(right_img1);
        right_img1.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel right_img2 = setImage(sql.values.get(currentSlide), 3);
        right_panel.add(right_img2);
        right_img2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(center_panel, BorderLayout.CENTER);
        panel.add(right_panel, BorderLayout.EAST);
        return panel;
    }
    private JPanel setImage(String[] infoArray, int imageid) {
        String file = infoArray[imageid];
        String title = infoArray[imageid+1];
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        ImageIcon img = new ImageIcon(file);
        Image image = img.getImage();
        Image newimg = image.getScaledInstance(200, 100,  java.awt.Image.SCALE_SMOOTH);
        img = new ImageIcon(newimg);
        JLabel img_label = new JLabel(img);
        img_label.setPreferredSize(new Dimension(200,100));
        img_label.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel title_label = new JLabel("<html>"+title+"</html>", SwingConstants.CENTER); // dodać podpis zdjecia z bazy
        title_label.setAlignmentX(Component.CENTER_ALIGNMENT);
        title_label.setPreferredSize(new Dimension(200,100));
        panel.add(img_label, BorderLayout.CENTER);
        panel.add(title_label, BorderLayout.CENTER);
        return panel;
    }
}