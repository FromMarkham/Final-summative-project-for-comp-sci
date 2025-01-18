
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class FSPInteractiveActivityScreenGUI extends JFrame implements ActionListener{
	
	
	ImageIcon geoDashBackground=new ImageIcon("electroMan.png");
	JLabel geoDashBackgroundLabel=new JLabel(geoDashBackground);
	
	ImageIcon[] interactiveActivityPics= {
			new ImageIcon("InteractiveActivityScreenFiles/ifStatementFillinBlank.png"),
			new ImageIcon("InteractiveActivityScreenFiles/switchStatementFillinBlank.png"),
			new ImageIcon("InteractiveActivityScreenFiles/blueCircle.png"),
			new ImageIcon("InteractiveActivityScreenFiles/yellowArrow.png"),
			new ImageIcon("InteractiveActivityScreenFiles/polarGeist.png")};
	
	JLabel[] interactiveActivityPicLabels= {
			new JLabel(interactiveActivityPics[0]),
			new JLabel(interactiveActivityPics[1]),
			new JLabel(interactiveActivityPics[2]),
			new JLabel(interactiveActivityPics[3]),
			new JLabel(interactiveActivityPics[4])};
	
	JButton backToTitleScreen=new JButton("Back to title screen");
	JButton submitAnswers=new JButton("Submit your answers");
	
	JPanel aboutProgramPanel=new JPanel();
	
	JTextField[] textFields = new JTextField[13];
	
	JLabel switchStatementTitle=new JLabel("Switch statement interactive activity");
	JLabel ifStatementTitle=new JLabel("If/Else statement interactive activity");

	JPanel[] panels = {new JPanel(),new JPanel(),new JPanel(),new JPanel(), new JPanel(), new JPanel()};
	
	JLabel[] questionDesc= {new JLabel("For this first interactive activity,"),
			new JLabel("you will fill in the blanks for an if-else statement")
			,new JLabel("This if-else statement is designed to"),
			new JLabel("accept a number of as input"),
			new JLabel("And tell the user if it's positive or negative")};
	
	//
	
	JLabel[] questionDesc2= {new JLabel("For this second interactive activity,"),
			new JLabel("you will fill in the blanks for a switch statement")
			,new JLabel("This switch statement is designed to"),
			new JLabel("accept a day number of the week as input"),
			new JLabel("And tell the user what day the number corresponds to")};

	JLabel titleText=new JLabel("Interactive activity screen");
	
	JScrollPane scrollPane = new JScrollPane(panels[3]);

	String[]answerArray = {"if", "0)", "else","switch", "monday","2","break","thursday","{"};
	

	
	public FSPInteractiveActivityScreenGUI() {
		
	    for (int i = 0; i < 12; i++) {
	    	textFields [i] = new JTextField("..........");  
	    }
		
		backToTitleScreen.setBounds(1150,700,200,100);
		backToTitleScreen.addActionListener(this);
		add(backToTitleScreen,0);
		
		submitAnswers.setBounds(650,700,200,100);
		submitAnswers.addActionListener(this);
		add(submitAnswers,0);
		
		for (int i = 2; i <=4; i++) { ///for loop for the geo dash icons dotted over the screen
			interactiveActivityPicLabels[i].setBounds(1050,(i*220)-500,400,400);
			add(interactiveActivityPicLabels[i]); 
		}
		
		panels[2].setBounds(100,15,750,90);
		add(panels[2]);
		
		titleText.setBounds(100,15,500,700);
		titleText.setFont(new Font("Calibri", Font.PLAIN, 27));
		panels[2].add(titleText);
		
		panels[3].setLayout(null);
		panels[3].setPreferredSize(new Dimension(900,2300));

		textFields[0].setBounds(200, 325, 80, 30);
		textFields[1].setBounds(380, 325, 30, 30);
		textFields[2].setBounds(250, 385, 50, 30);
		textFields[3].setBounds(300, 870, 100, 30);
		textFields[4].setBounds(630, 930, 65, 30);
		textFields[5].setBounds(630, 1210, 80, 30);
		textFields[6].setBounds(375, 1150, 80, 30);
		textFields[7].setBounds(295, 1360, 80, 40);
		textFields[8].setBounds(393, 1000, 30, 30);
		
		
		//-----------------
		panels[4].setBounds(160,90,320,30);
		panels[4].setBackground(Color.WHITE);
		panels[4].add(ifStatementTitle);
		panels[3].add(panels[4]);
		
		for (int counter=0; counter<questionDesc.length; counter++) {
			questionDesc[counter].setBounds(160, 150+(counter*20), 320, 30);
			panels[3].add(questionDesc[counter]);
		}
		
		///--------
		panels[5].setBounds(160,680,350,30);
		panels[5].setBackground(Color.WHITE);
		panels[5].add(switchStatementTitle);
		panels[3].add(panels[5]);
		
		for (int counter=0; counter<questionDesc.length; counter++) {
			questionDesc2[counter].setBounds(160, 740+(counter*20), 350, 30);
			panels[3].add(questionDesc2[counter]);
		}
		
		///------

		
		for (int counter=0; counter<=8; counter++) {
			textFields[counter].setBackground(Color.BLUE);
			panels[3].add(textFields[counter]);
		}
		
		//------------------

		interactiveActivityPicLabels[0].setBounds(150, 250, 700, 300); //fill in the blanks pictures
		panels[3].add(interactiveActivityPicLabels[0]);
		
		interactiveActivityPicLabels[1].setBounds(150, 800, 700, 700);  //fill in the blanks pictures
		panels[3].add(interactiveActivityPicLabels[1]);
		
		setSize(1400,1000);
		setTitle("FSP");
		setLayout(null);
		
		geoDashBackgroundLabel.setBounds(0,-20,1400,1000);
		add(geoDashBackgroundLabel);
		
		scrollPane.setBounds(90,110,950,575);
		add(scrollPane);
		
		setVisible(true);
		
	}
	
	public void checkAnswers() {
		int answersCorrect=0;
		for (int counter=0; counter<=8; counter++) {
			String yyy=textFields[counter].getText();
			System.out.println(yyy);
			if (yyy.equals(answerArray[counter])) {
				answersCorrect+=1;
				
			}
			
		}
		System.out.println(answersCorrect);
		JOptionPane.showMessageDialog(null,"You filled in parts correct"+answersCorrect);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
		if (event.getSource()==backToTitleScreen) {
			setVisible(false);
			new FSPTitleScreen();
		}
		
		if (event.getSource()==submitAnswers) {
			checkAnswers();
		}
		
		
		
	}
	
}