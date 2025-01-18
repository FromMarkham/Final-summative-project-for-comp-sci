
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
	
public class FSPConceptScreenGUI extends JFrame implements ActionListener{
		
	//imageicon corresponding to the background 
	ImageIcon geoDashBackground=new ImageIcon("ConceptScreenFiles/peerGynt.png");
	
	//The label that holds the imageicon corresponding to the background 
	JLabel geoDashBackgroundLabel=new JLabel(geoDashBackground);
	
	//Array that holds the imageicons for the geo dash images 
	ImageIcon[] geoDashIconArray= {new ImageIcon("ConceptScreenFiles/GeometryDashIcon.png"),
			new ImageIcon("ConceptScreenFiles/GeoDashIcon2.png"),
			new ImageIcon("ConceptScreenFiles/ifStatement.png"),
			new ImageIcon("ConceptScreenFiles/ifElseStatement.png"),
			new ImageIcon("ConceptScreenFiles/SwitchStatement.png")}; 
	
	//Array that holds the labels corresponding to the geo dash icons 
	JLabel[] geoDashIconLabelArray={new JLabel(geoDashIconArray[0]),new JLabel(geoDashIconArray[1]),
			new JLabel(geoDashIconArray[2]),new JLabel(geoDashIconArray[3]),new JLabel(geoDashIconArray[4]),};
	
	//Array that holds JPanels 
	JPanel[] panelArray= {new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel()};
	
	//Scroll pane 
	JScrollPane scrollPane = new JScrollPane(panelArray[0]);

	JLabel[] ifStatementInfoArray= {new JLabel("If statements are the first type of"
			+ " control structure we will talk about. "),
			new JLabel("If statements are like a question, but in the form of code instead. "),
			new JLabel("What if statements do is that they check if a given condition passed into"),
			new JLabel("the if statement is true or not, and if it is true,"),
			new JLabel(" the code that is below the if statement will execute. "),
			new JLabel(" If not, the code below the if statement won’t execute. "),
			new JLabel("Below is an example of an if statement in Java."), //7th element, index 6 
			new JLabel("The if statement asks if the temperature is greater than"), 
					
		    new JLabel("or higher than 28, for the part where it says (temperature>=28)."),
			
			new JLabel(" And if it is equal to or higher than 28, in other words, if the statement "),
			new JLabel("is true , it will print to the console that it is too hot."), //11th element, index 10
			
			new JLabel("And now, let’s talk about else statements."), //12th element, index 11
			new JLabel("Consider the temperature code from earlier. "),
			new JLabel("If the temperature is below or equal to 28 in the previous code, "
					+ "the program won’t output anything. "),
			new JLabel("That previous code would’ve only outputted something if "
					+ "the temperature is greater then or equal to 28"), //15th element index 14 
			new JLabel("However, adding an else statement to the code will")
			,new JLabel("allow the program to do something if the above condition"),
			new JLabel("isn't true."),
			new JLabel("In this example of an if-else statement, the else part of the code will cause"),
			new JLabel("the program to say that the temperature is just right to the console.")
	};
	
	
	JLabel[] switchStatementInfoArray= {

			new JLabel("A switch statement performs different actions based on various "
					+ "different possible values.  "), 
			new JLabel("It has a sequence of case"
					+ " statements and maybe a default case which is optional. "),
			new JLabel("It evaluates the value which is "
					+ "inserted into the brackets following the switch keyword. "),
			new JLabel("In each case label the program compares the value of "
					+ "that value with the value inside of each case label. "),
			new JLabel("If the value is the same as the value inside the case"
					+ " label the program will do what is inside the case label. "), 
			
			
			new JLabel("Here is an example of a switch statement. "), //element 6, index 5 
		    new JLabel("What this switch statement does is that if the variable number is "
		    		+ "equal to equal to 1 it will output the letter A to the console.  "), 
		    new JLabel("This is what the case 1 part does."),
		    new JLabel("You can think of it like its asking is that what the variable number "
		    		+ "is equal to. "),
		    new JLabel("Does the variable, number match this case or not."),
		    new JLabel("The same goes for all the other case statements in code. ")
		    ,new JLabel("If the variable number is equal to 2. "),
		    new JLabel("It will output the letter B to the console. ")
		    ,new JLabel("This is what the case 2 part does.")
		    ,new JLabel("If the variable number is equal to the 3 "
		    		+ "It will output the letter C to the console."),
		    new JLabel("This is what the case 3 part does. "),
		    new JLabel("Another fun fact about switch statements in Java is that"),
		    new JLabel("they only work with the data types byte, short, char and int")
		   ,new JLabel("They don't work with any other data types")
			};
	
	JLabel[] everythingTogetherArray={
			new JLabel()
	};
	
	JLabel[] levelInfoArray={
			new JLabel("The background of this page is "),
			new JLabel("taken from the level peer gynt:"),
			new JLabel("https://www.youtube.com/watch?v=Uj9YZotDFic")
	};
	
	JLabel[] miscLabelArray= {new JLabel("Concept screen"),new JLabel("")};
	
	JButton backToTitleScreen=new JButton("Back to title screen");

	
	public FSPConceptScreenGUI() {

		setSize(1350,900);
		setTitle("FSP");
		setLayout(null);
		//
		backToTitleScreen.setBounds(925,620,200,100);
		backToTitleScreen.addActionListener(this);		
		add(backToTitleScreen);

		////loadSwitchStatementInfo();
		panelArray[1].setBounds(130,20,950,90);
		panelArray[1].setBackground(Color.WHITE);
		miscLabelArray[0].setFont(new Font("Calibri", Font.PLAIN, 27));
		panelArray[1].add(miscLabelArray[0]);
		add(panelArray[1]);
		
		//Add geo dash images 
		geoDashBackgroundLabel.setBounds(0,-20,1350,900);
		add(geoDashBackgroundLabel);
	
		for (int counter=0; counter<=1; counter++) {
		geoDashIconLabelArray[counter].setBounds(880+(counter*220),420,200,200);
		add(geoDashIconLabelArray[counter],0); 
		}
	
		
		
		//This is where the images are added to the scroll pane 
		panelArray[0].setLayout(null);
		panelArray[0].setPreferredSize(new Dimension(800,2300));
		
		geoDashIconLabelArray[2].setBounds(70,170,350,245);
		panelArray[0].add(geoDashIconLabelArray[2]);
		
		geoDashIconLabelArray[3].setBounds(70,550,350,245);
		panelArray[0].add(geoDashIconLabelArray[3]);	
		
		geoDashIconLabelArray[4].setBounds(70,1150,350,245);
		panelArray[0].add(geoDashIconLabelArray[4]);	
		
		//--------------------------------------------------------------------
		
		//This is where the jlabels from the ifStatementInfoArray are added to the scroll pane
		for (int counter=0; counter<ifStatementInfoArray.length; counter++) {
			
			if (counter<=6) {
				
				ifStatementInfoArray[counter].setBounds(60,-65+(counter*23),700,200);
				panelArray[0].add(ifStatementInfoArray[counter],0);
			}
			
			else if (counter>=7&&counter<=10) {
				
				ifStatementInfoArray[counter].setBounds(60,90+(counter*23),700,200);
				panelArray[0].add(ifStatementInfoArray[counter],0);
			}
			
			else if (counter>=11&&counter<=14) {
				
				ifStatementInfoArray[counter].setBounds(60,130+(counter*23),700,200);
				panelArray[0].add(ifStatementInfoArray[counter],0);
			}
			
			else 
			{
				ifStatementInfoArray[counter].setBounds(60,310+(counter*23),700,200);
				panelArray[0].add(ifStatementInfoArray[counter],0);
			}

		}
		
		//This is where the jlabels from the switchStatementInfoArray are added to the scroll pane
		for (int counter=0; counter<switchStatementInfoArray.length; counter++) {
			
			if (counter<=5) {
				switchStatementInfoArray[counter].setBounds(70,900+(counter*23),700,200);
				panelArray[0].add(switchStatementInfoArray[counter],0);
			}
			
			else {
				switchStatementInfoArray[counter].setBounds(70,1200+(counter*23),700,200);
				panelArray[0].add(switchStatementInfoArray[counter],0);
			}

		}	
		
		//This is where the jlabels from the everythingTogetherArray are added to the scroll pane 
		for (int counter=0; counter<=1; counter++) {
			//everythingTogetherArray[counter].setBounds(880+(counter*220),420,200,200);
			///panelArray[0].add(everythingTogetherArray[counter],0);
		}

		scrollPane.setBounds(100,150,800,600);
		add(scrollPane);
		
		//
		
		
		setVisible(true);
			
	}
	
	private void playSong() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Clip musicClip;
		AudioInputStream musicStream;
		musicStream = AudioSystem.getAudioInputStream(new File("ConceptScreenFiles/ElectromanTwo.wav").getAbsoluteFile());
		musicClip = AudioSystem.getClip();
		musicClip.open(musicStream);
		musicClip.loop(Clip.LOOP_CONTINUOUSLY);

		// Code source: https://www.geeksforgeeks.org/play-audio-file-using-java/

	}
	

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
		
	}
}