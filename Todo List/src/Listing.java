import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JScrollPane;
import java.util.ArrayList;
import java.util.Collections;;
public class Listing extends JFrame {

    public static void main(String[] args) {

        new Listing();
    }

    Listing() {

        final ArrayList<String> wordlist = new ArrayList<String>();
        wordlist.add("Head");
        wordlist.add("Green");
        wordlist.add("Water");
        wordlist.add("To sing");
        wordlist.add("Dead");
        wordlist.add("Long");
        wordlist.add("Ship");
        wordlist.add("To pay");
        wordlist.add("Window");
        wordlist.add("Friendly");
        wordlist.add("To cook");

        JList<String> displayList = new JList<>(wordlist.toArray(new String[0]));
        JScrollPane scrollPane = new JScrollPane(displayList);

        getContentPane().add(scrollPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}

/*  using this as a template to display ArrayList items using JList for to-do list*/
 