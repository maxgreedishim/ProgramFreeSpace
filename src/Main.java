import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

class Main {
    private static JFrame frame = new JFrame("Освобождаем место на диске");


    public static void main (String[] args){

        frame.setVisible(true);
        frame.setSize(500,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new JLabel("                          " +
                "                         Вы хотите освободить место? "), BorderLayout.CENTER);
        JPanel panel = new JPanel();
        JButton ok = new JButton("Да");
        JButton cancel = new JButton("Нет");
        frame.add(panel);
        panel.add(ok);
        ok.addActionListener (new Action1());
        panel.add(cancel);
        cancel.addActionListener (new Action2());

    }
    static class Action1 implements ActionListener {

        public void actionPerformed (ActionEvent e) {
                String path = "C:/ProgramData/Microsoft/Diagnosis/ETLLogs";
                File[] file = new File(path).listFiles();
                if (file.length == 0) System.out.println("пусто");
                for (File myFile : file) {
                    if (myFile.isFile() == true) {
                        myFile.delete();
                    }
                }
            System.exit(1);
        }
    }
    static class Action2 implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            System.exit(1);
        }
    }
}