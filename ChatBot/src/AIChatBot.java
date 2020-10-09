import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.BadLocationException;

public class AIChatBot {

	private final int WIDTH = 500, HEIGHT = 600, TEXTBOX_SIZE = 360;
	
	private boolean enter = false;
	
	private JTextArea displayArea;
	private JTextArea typeArea;
	
	boolean temp = false;
	
	private String name = "";
	
	private String[] compAnswers = {"Great!", "Thats not good...", "Really? I can't believe it!",
			"Cool, so what do you like to do?", "Why would you say such a thing?", "What???",
			"Really. I've never really thought about that actually.", "Nice! So whats your favorite color?",
			"No way! I love that too!", "That is disgusting.", "Ok... So what is your favorite food?",
			"Sorry could you repeat that?", "Ohhh ok I got it now.", "Cool."};
	
	public AIChatBot() {
		
		JPanel panel = new JPanel();
		
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);
		
		panel.setBorder(BorderFactory.createTitledBorder("Artificial Intelligence Chat Bot"));
		
		displayArea = new JTextArea();
		displayArea.setEditable(false);
	
		typeArea = new JTextArea();
		typeArea.setEditable(true);
		
		typeArea.addKeyListener(new KeyListener() {
			
			public void keyTyped (KeyEvent e) {
				
				if (e.getKeyChar() == '\n') {
					
					sendReceive();
					
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});

		JButton sendButton = new JButton("send");
		sendButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				sendReceive();
				
			}
		
			
		});
		
		JScrollPane scroll = new JScrollPane (displayArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		scroll.setPreferredSize(new Dimension(WIDTH,TEXTBOX_SIZE));
		panel.add(scroll);
		
		panel.add(typeArea);
		
		JPanel tempPanel = new JPanel();
		tempPanel.add(sendButton);
		panel.add(tempPanel);
		//panel.add(displayArea);
		
		JFrame frame = new JFrame();
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		//frame.setResizable(false);
		frame.setVisible(true);
	//	panel.setFocusable(true);
		
		displayArea.setText("\n Hello and welcome to the first ever AI chat bot, start chatting!"
				+ "\n First, what is your name?");
		
		

		run();
		
	}
	
	public void sendReceive() {
		
		if (!temp && !typeArea.getText().trim().equals("")) {
			
			
			name = typeArea.getText().trim();
			displayArea.setText(displayArea.getText()+"\n\n"+name+": "+typeArea.getText().trim());
			temp = true;
			enter = true;
			typeArea.setText("");
			
			
		} else if (!typeArea.getText().trim().equals("")) {
		
			displayArea.setText(displayArea.getText()+"\n\n"+name+": "+typeArea.getText().trim());
			enter = true;
		
			typeArea.setText("");
			
		}
		
		
	}
	
	public void run() {
		
		while (true) {
			
			if (enter) {
				
				try {Thread.sleep(500);}
				catch (InterruptedException e) {}
				int randInt = (int) (Math.random()*compAnswers.length);
				displayArea.setText(displayArea.getText()+"\n\n   ChatBot: "+compAnswers[randInt]);
				enter = false;
			}
			
			try {Thread.sleep(50);} 
			catch (InterruptedException e) {}
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new AIChatBot();

	}

}
