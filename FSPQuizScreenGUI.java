
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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class FSPQuizScreenGUI extends JFrame implements ActionListener{
	
	JLabel quizScreenTitle=new JLabel("Quiz Screen");
	
	
	
	ImageIcon geoDashBackground=new ImageIcon("GeoDashbackground.png");
	JLabel geoDashBackgroundLabel=new JLabel(geoDashBackground);
	
	JPanel[] panels = {new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel()
			,new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),
			};
	
	
	JPanel[] questionPanels= {new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),
							  new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel()};
	
	ImageIcon spaceInvadersBackground=new ImageIcon("spaceInvaders.png");
	JLabel spaceInvaders=new JLabel(spaceInvadersBackground);
	
	ImageIcon[] questionImageIcons={new ImageIcon("QuizScreenFiles/question3Option1.png"),
									new ImageIcon("QuizScreenFiles/question3Option2.png"),
									new ImageIcon("QuizScreenFiles/question5Label.png"),
									new ImageIcon("QuizScreenFiles/switchStatementQuestion.png"),
									new ImageIcon("QuizScreenFiles/a.png"),
									new ImageIcon("QuizScreenFiles/b.png")};
	
	JLabel[] questionImageLabels= {new JLabel(questionImageIcons[0]),new JLabel(questionImageIcons[1]),
			new JLabel(questionImageIcons[2]),new JLabel(questionImageIcons[3]),
			new JLabel(questionImageIcons[4]),new JLabel(questionImageIcons[5])};
	

	
	JPanel aboutProgramPanel=new JPanel();
	JButton backToTitleScreen=new JButton("Back to title screen");
	
	JButton SubmitButton=new JButton("Submit");
	

	
	JPanel levelinfopanel=new JPanel();
	JLabel[] levelInfoLabelArray= {new JLabel("This background is"),new JLabel("from the level Space Invaders:")
			,new JLabel("youtube.com/watch?v=YKIEY-53L6s")};
	
	private JRadioButton[][] quizButtonArray = new JRadioButton[8][3];
	
	String[][] optionArray= {
	 {"To ask a question","To execute some code only if a certain condition is true"
		 ,"To execute some code under any condition"} //question 1 
	 
	,{"To execute some code if the condition within the previous if statement is false",
		"To execute some code if the condition within the previous if statement is true",
		"To execute some code placed within the else statement"} //question 2 
	
	,{"a","b","All of the above"} //Nahhh these prev 2 options finna be pictures question 3 
	
	,{"It finds out if x is equal to 5","It finds out if x is not equal to 4","It tells you the value of x"} //question 4
	
	,{"A statement in the form of code that acts like a switch","Something that turns the code on or off",
		"Something that can execute different blocks of code"
		+ " based on the values of a variable"
			} ////question 5
	
	,{"No, switch statements only let you pass in byte, short, char and int",
			
			"Yes, switch statements let you pass in values of any data type ",
			
			"Yes, but switch statements only let you pass in values of type string and double"}  //question 6	
	
	,{"Specifies a possible value for the expression being evaluated in the switch statement"
		,"A label that contains a variable inside of it "
		,"Something in the form of code that is analagous to a real-life briefcase"} //question 7
		
	
	,{"Excellent","Average","Good job"}	  //question 8 
};
	
	
	String[] correctAnswer= {"To execute some code only if a certain condition is true",
			"To execute some code if the condition within the previous if statement is false",
			"All of the above",
			"It finds out if x is equal to 5",
			"Something that allows you to execute different blocks of code"
					+ " based on the one or more values of a variable or expression.",
					"No, switch statements only let you pass in byte, short, char and int",
					"Specifies a possible value for the expression being evaluated in the switch statement",
					"Excellent"};
	
    public void initialiseRadioButtonArray() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 3; col++) {
            	quizButtonArray[row][col] = new JRadioButton(optionArray[row][col]); //optionArray[row][col]
            }
        }
    }

    
	public static String[] quizAnswers = new String[8];
	public static String[] quizResult = new String[8];
	
	ImageIcon[] geoDashIconArray={
			 new ImageIcon("QuizScreenFiles/manySpikes2.png")
			,new ImageIcon("QuizScreenFiles/yellowDome.png")
			,new ImageIcon("QuizScreenFiles/portal.png")
			,new ImageIcon("QuizScreenFiles/greenCircle.png")
			,new ImageIcon("QuizScreenFiles/spike.png")
			,new ImageIcon("QuizScreenFiles/blueCircle.png")
			,new ImageIcon("QuizScreenFiles/spikes.png")
			,new ImageIcon("QuizScreenFiles/arrow.png")
			,new ImageIcon("QuizScreenFiles/spikedRectangle.png")
			,new ImageIcon("QuizScreenFiles/geoDashCube.png")
			,new ImageIcon("QuizScreenFiles/manySpikes.png")};
	
	JLabel[] geoDashIconLabelArray={
			new JLabel(geoDashIconArray[0]),new JLabel(geoDashIconArray[1]),new JLabel(geoDashIconArray[2])
			,new JLabel(geoDashIconArray[3]),new JLabel(geoDashIconArray[4]),new JLabel(geoDashIconArray[5])
			,new JLabel(geoDashIconArray[6]),new JLabel(geoDashIconArray[7]),new JLabel(geoDashIconArray[8]),
			new JLabel(geoDashIconArray[9]),new JLabel(geoDashIconArray[10])};

	JScrollPane scrollPane = new JScrollPane(panels[6]);

	JLabel[] questionArrayLabel= {new JLabel("What's the purpose of an if statement?") //question 1 
								 ,new JLabel("What does the else block do?") //question 2 
								 ,new JLabel("Which if-else statement determines if a person is can vote (give min. age of 18)") //Options will be pictures question 3 
								
								 ,new JLabel("What does the following code do?") //after here, the questions are about switch statements //question 4
								 ,new JLabel("What's a switch statement?") //question 5
							
								 ,new JLabel("Can you pass in a double or string into a switch statement?") //question 6
								 ,new JLabel("What's a case label?") //question 7 
								 ,new JLabel("Given char mark='A', what will this switch statement output?")}; //question 8 



static int correctAnswerCount;

int answerCountDisplay;

    public int checkAnswers() {
    
        for (int row = 0; row < quizButtonArray.length; row++) {
        	
            for (int col = 0; col < quizButtonArray[row].length; col++) {
            	
                if (quizButtonArray[row][col].isSelected() && quizButtonArray[row][col].getText().equals(correctAnswer[row])) {
                	correctAnswerCount+=1;

                }
            }

        }
        return correctAnswerCount;
    }
	

    
	
	public FSPQuizScreenGUI() {
		initialiseRadioButtonArray() ;
		backToTitleScreen.setBounds(625,570,200,100);
		backToTitleScreen.addActionListener(this);
		add(backToTitleScreen);
		
		setSize(1000,700);
		setTitle("FSP");
		setLayout(null);
		
		//
		panels[6].setLayout(null);
		panels[6].setPreferredSize(new Dimension(1000,2300));
	
		quizScreenTitle.setFont(new Font("Calibri", Font.PLAIN, 27));
		panels[4].setBounds(100,15,750,80);
		panels[4].setBackground(Color.WHITE);
		panels[4].add(quizScreenTitle);
		add(panels[4]);
		//
		
		SubmitButton.setBounds(425,570,200,100);
		SubmitButton.addActionListener(this);
		add(SubmitButton);
		//
		fillRadioButtonArray();
		
		levelinfopanel.setBounds(125,570,250,75);
		for (int counter=0; counter<=2; counter++) {
			levelinfopanel.add(levelInfoLabelArray[counter]);
		}
		add(levelinfopanel);
		
		//geoDashIconLabelArray
		for (int counter=0; counter<=10;counter++) {
			if (counter<=2) {
				
				geoDashIconLabelArray[counter].setBounds((counter*200)+100,100,125,125);
				add(geoDashIconLabelArray[counter]);
			}
			
			else if (counter>=3&&counter<=6) {
				geoDashIconLabelArray[counter].setBounds((counter*200)-500,250,125,125);
				add(geoDashIconLabelArray[counter]);
			}
			
			else {
				geoDashIconLabelArray[counter].setBounds((counter*200)-1300,500,125,125);
				add(geoDashIconLabelArray[counter]);
			}
			
		}

		

		geoDashBackgroundLabel.setBounds(0,-20,1000,140);
		add(geoDashBackgroundLabel);
		
		spaceInvaders.setBounds(0,-20,1000,700);
		add(spaceInvaders);
		
		
		scrollPane.setBounds(50,110,900,450);
		add(scrollPane);
		
		
		
		setVisible(true);
		
	}
	
	public void fillRadioButtonArray() {

        for (int row = 0; row <8; row++) {
        	questionPanels[row].setBounds(90,(150*row),750,20);
        	questionPanels[row].setBackground(Color.WHITE);
        	questionPanels[row].add(questionArrayLabel[row]);
        	panels[6].add(questionPanels[row]);
        
                for (int column = 0; column < 3; column++) {
                	
                	
                	quizButtonArray[row][column].setBounds(90,((30*column)+(row*150))+25,690,50);
                	panels[6].add(quizButtonArray[row][column]); 
                    
                
        	}
        	

        	}
        
        questionImageLabels[2].setBounds(340,274,500,500);
        panels[6].add(questionImageLabels[2]);
        
        questionImageLabels[3].setBounds(250,1045,500,500);
        panels[6].add(questionImageLabels[3]);
        
        questionImageLabels[0].setBounds(280,250,300,270); //for the question that asks which one of the if statements is the one seeing if someone is old enough to vote 
        panels[6].add(questionImageLabels[0]);
        
        
        questionImageLabels[1].setBounds(640,270,250,240); //for the question that asks which one of the if statements is the one seeing if someone is old enough to vote 
        panels[6].add(questionImageLabels[1]);
        
        
        
        //Put an a on the images for one of the question
        questionImageLabels[4].setBounds(435,325,40,30);
        panels[6].add(questionImageLabels[4],0);
        
        //Put a b on one of the images for one of the question
        questionImageLabels[5].setBounds(758,328,40,35); 
        panels[6].add(questionImageLabels[5],0);

        }

	//public void addQuestions() {
		
	//	for (int counter=0; counter<=9; counter++) {
	//		questionPanels[counter].setBounds(getBounds());
			
	//	}
	//}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource()==backToTitleScreen) {
			setVisible(false);
			new FSPTitleScreen();
		}
		
		else {
			 answerCountDisplay=checkAnswers();
				JOptionPane.showMessageDialog(null,"You got"+answerCountDisplay+"out of 8 questions correct:");
		}
	}

	
}
