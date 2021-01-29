
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//import java.util.Random;

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
	JLabel resultLabel;
	JPanel listHolder, addHolder;
	JTextField siteField;
	JList displayList;
	JScrollPane scrollPane;
	GridLayout gLayout;
	
	ArrayList<TodoListData> taskList = new ArrayList<TodoListData>(); // where we store the to-do list items
	
	TodoList() {
		
		/* initial data */
        taskList.add(TodoListData("Long"));
        taskList.add(TodoListData("Ship"));
        taskList.add(TodoListData("To pay"));
        taskList.add(TodoListData("Window"));
        taskList.add(TodoListData("Friendly"));
        taskList.add(TodoListData("To cook"));
		
		//taskList = new ArrayList();
		listHolder = new JPanel();
		addHolder = new JPanel();
		gLayout = new GridLayout(0,1);
		
		/* Buttons */
		addButton = new JButton("+");
		clearButton = new JButton("clear all contents");
		
		/* Labels */
		resultLabel = new JLabel("Your OTP Code");
		
		/* Text Fields */
		siteField = new JTextField(15);
		
		/* Lists and display */
		displayList = new JList<>(taskList.toArray(new String[0]));
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
		
		resultLabel.setHorizontalAlignment(JLabel.CENTER); // center justifies the label contents
		
		//add(resultLabel, BorderLayout.CENTER); // organization of components within frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // allows close operation
		setLocation(250,100); //controls the position of the window
		setVisible(true); //shows the window
		setSize(600,350); //controls the size of the window
 
	}

	
	private TodoListData TodoListData(String string) {
		// TODO Auto-generated method stub
		return null;
	}


	public void actionPerformed(ActionEvent e) {
	//	resultLabel.setText(String.valueOf(OTP.generate(length)));
	switch(e.getActionCommand()) {
			case ("+"):	
				TodoListData taskData = new TodoListData(siteField.getText());
				taskList.add(taskData);
				
				//System.out.println("add button selected");
				break;
			case ("clear all contents"):
				taskList.clear();
				break;
			
			default: 
				System.out.println("invalid entry: " + e.getActionCommand());
				break;
		}	
		
		
		 
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TodoList();

	}
	

}