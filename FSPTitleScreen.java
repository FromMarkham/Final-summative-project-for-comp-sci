
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

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

public class FSPTitleScreen extends JFrame implements ActionListener{
	
	
	JButton conceptScreenButton=new JButton("Concept screen");
	JButton interactiveActivityScreenButton=new JButton("Interactive activity screen");
	JButton quizScreenButton=new JButton("Quiz screen");

	
	JLabel aboutProgramFirst=new JLabel("This is not your average programming lesson-it is ");
	JLabel aboutProgramSecond=new JLabel("themed after the legendary video game Geometry Dash!");
	
	JLabel titleScreenTitle=new JLabel("Chapter 5: If/Else statements and switch statements");
	
	ImageIcon geoDashBackground=new ImageIcon("GeoDashbackground.png");
	JLabel geoDashBackgroundLabel=new JLabel(geoDashBackground);
	
	//An array of type ImageIcon that holds all the little pictures of things from geometry dash that will be dotted all over the screen
	ImageIcon[] geoDashIconArray={new ImageIcon("TitleScreenFiles/GeometryDashIcon1.png")
			,new ImageIcon("TitleScreenFiles/GeometryDashIcon2.png"),
					new ImageIcon("TitleScreenFiles/GeometryDashIcon3.png"),
					new ImageIcon("TitleScreenFiles/GeometryDashIcon4.png"),
					new ImageIcon("TitleScreenFiles/GeometryDashIcon5.png"),
					new ImageIcon("TitleScreenFiles/GeometryDashIcon6.png"),
					new ImageIcon("TitleScreenFiles/GeometryDashIcon7.png")};
	
	//An array of type JLabel, where every JLabel object in the array accepts an object of type ImageIcon from the other array above
	JLabel[] geoDashIconLabelArray= {new JLabel(geoDashIconArray[0])
									,new JLabel(geoDashIconArray[1])
									,new JLabel(geoDashIconArray[2])
									,new JLabel(geoDashIconArray[3])
									,new JLabel(geoDashIconArray[4])
									,new JLabel(geoDashIconArray[5])
									,new JLabel(geoDashIconArray[6])};
	
	
	
	JPanel aboutProgramPanel=new JPanel();
	
	JPanel titlePanel=new JPanel();
	
	public void addGeoDashIcons() {
		for (int counter=0; counter<=6; counter++) {
			
			if (counter<=1) {
				geoDashIconLabelArray[counter].setBounds((775*counter)+10,0,200,200);
				add(geoDashIconLabelArray[counter]);	
			}
			
			else if (counter>=2&&counter<4) {
				geoDashIconLabelArray[counter].setBounds((750*counter)-1475,250,200,200);
				add(geoDashIconLabelArray[counter]);
			}
			
			else if (counter==5) {
				geoDashIconLabelArray[counter].setBounds((270*counter)-1000,250,250,200);
			add(geoDashIconLabelArray[counter]);
			}
			else 
				geoDashIconLabelArray[counter].setBounds((270*counter)-1000,500,250,200);
				add(geoDashIconLabelArray[counter]);
		}
		
	}

	
	public FSPTitleScreen() {
		
		try {
			playSong();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setSize(1000,700);
		setTitle("FSP");
		setLayout(null);
		
		
		//Buttons 
		conceptScreenButton.setBounds(200,400,200,200);
		conceptScreenButton.addActionListener(this);
		add(conceptScreenButton);
		
		interactiveActivityScreenButton.setBounds(230,120,200,200);
		interactiveActivityScreenButton.addActionListener(this);
		add(interactiveActivityScreenButton);
		
		quizScreenButton.setBounds(570,120,200,200);
		quizScreenButton.addActionListener(this);
		add(quizScreenButton);
		
		addGeoDashIcons();
		//https://stackoverflow.com/questions/26340137/order-of-components-in-a-jpanel-java
		
		aboutProgramPanel.setBounds(425,350,400,200);
		aboutProgramPanel.setBackground(Color.WHITE);
		add(aboutProgramPanel,0);
		
		titlePanel.setBounds(100,15,750,100);
		titlePanel.setBackground(Color.WHITE);
		add(titlePanel,0);
		
		geoDashBackgroundLabel.setBounds(0,-20,1000,700); //should be 1000,700
		add(geoDashBackgroundLabel);
		
		aboutProgramFirst.setBounds(450,100,500,700);//
		aboutProgramPanel.add(aboutProgramFirst);
		
		aboutProgramSecond.setBounds(450,115,500,700);//
		aboutProgramPanel.add(aboutProgramSecond);
		
		titleScreenTitle.setBounds(450,115,500,700);
		
		titleScreenTitle.setFont(new Font("Calibri", Font.PLAIN, 27));
		titlePanel.add(titleScreenTitle);
		
		setVisible(true);
		
	}
	
	
	private void playSong() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Clip musicClip;
		AudioInputStream musicStream;
		musicStream = AudioSystem.getAudioInputStream(new File("TitleScreenFiles/TitleScreenMusic.wav").getAbsoluteFile());
		musicClip = AudioSystem.getClip();
		musicClip.open(musicStream);
		musicClip.loop(Clip.LOOP_CONTINUOUSLY);

		// Code source: https://www.geeksforgeeks.org/play-audio-file-using-java/

	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
		if (event.getSource()==conceptScreenButton) {
			
			setVisible(false);
			new FSPConceptScreenGUI(); //problem here
			
		}
		
		else if (event.getSource()==interactiveActivityScreenButton) {
			
			setVisible(false);
			new FSPInteractiveActivityScreenGUI();
		
		}
		
		else if (event.getSource()==quizScreenButton) {
			
			setVisible(false);
			new FSPQuizScreenGUI();
			
		}
		
	}
	

	
}
