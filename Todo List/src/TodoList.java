
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TodoList extends JFrame implements ActionListener {

	JButton addButton, clearButton;
	JPanel listHolder, addHolder;
	JTextField siteField;
	JList<String> displayList;
	JScrollPane scrollPane;
	GridLayout gLayout;
	JLabel header;
	
	DefaultListModel<String> listModel; //where we store tasks
	
	TodoList() {

		listHolder = new JPanel();
		addHolder = new JPanel();
		gLayout = new GridLayout(0,1);
		
		/* Buttons */
		addButton = new JButton("add task");
		clearButton = new JButton("clear all contents");
		
		
		header= new JLabel("TASKS:");
		
		/* Text Fields */
		siteField = new JTextField(15);
		
		/* Lists and display */
		listModel = new DefaultListModel<String>(); // using this instead of an array list to hold tasks strings
		displayList = new JList<String>(listModel); // holds listModel contents for display
		
		scrollPane = new JScrollPane(displayList);
		
		
		/* Action Listener */
		addButton.addActionListener(this); // do some action on click
		clearButton.addActionListener(this);
		
		addHolder.setLayout(new FlowLayout());
		listHolder.setLayout(gLayout);
		
		/* UX setup */
		setLayout(new BorderLayout());// many layouts available. We picked border layout.
		addHolder.add(siteField);
		addHolder.add(addButton);
		addHolder.add(clearButton);
		listHolder.add(scrollPane);
		
		
		add(listHolder,BorderLayout.CENTER); 
		add(addHolder, BorderLayout.SOUTH);
		
		header.setHorizontalAlignment(JLabel.CENTER); // center justifies the label contents
		
		add(header, BorderLayout.NORTH); // organization of components within frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // allows close operation
		setLocation(250,100); //controls the position of the window
		setVisible(true); //shows the window
		setSize(600,350); //controls the size of the window
		
		addHolder.getRootPane().setDefaultButton(addButton);
	}

	public void actionPerformed(ActionEvent e) {
	switch(e.getActionCommand()) {
			case ("add task"):	
				listModel.addElement(siteField.getText());
				siteField.setText("");
				break;
				
			case ("clear all contents"):
				listModel.clear();
				break;
			
			default: 
				System.out.println("invalid entry: " + e.getActionCommand());
				break;
		}	
	}
	
	public static void main(String[] args) {
		new TodoList();
	}
	
}