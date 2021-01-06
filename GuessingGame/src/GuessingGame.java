import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	private int numberOfTries;
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		int guess = Integer.parseInt(guessText);
		try {
			if(guess < theNumber)
				message = guess + " is too low. Try again.";
			else if(guess > theNumber)
				message = guess + " is too high. Try again";
			else {
				message = guess + " is correct. You win! Let's play again!";
				newGame();
			}
		} catch (Exception e) {
			message = "Enter a whole number between 1 and 100:";
		} finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();	
		}
		
	}
	
	public void newGame() {
		theNumber = (int) (Math.random() * 100 + 1);
		numberOfTries = 0;
	}
	public GuessingGame() {
		setForeground(new Color(240, 240, 240));
		setFont(null);
		setBackground(new Color(240, 240, 240));
		setAutoRequestFocus(false);
		getContentPane().setForeground(new Color(0, 0, 0));
		getContentPane().setBackground(new Color(240, 240, 240));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thy's Hi-Lo Guessing Game");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(164, 42, 456, 42);
		getContentPane().add(lblNewLabel);
		
		txtGuess = new JTextField();
		txtGuess.setBounds(436, 216, 91, 28);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Guess a number between 1 and 100:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(63, 212, 338, 33);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Guess !");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(359, 363, 98, 28);
		getContentPane().add(btnNewButton);
		
		lblOutput = new JLabel("Enter a number above and click Guess !");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOutput.setBounds(243, 470, 306, 28);
		getContentPane().add(lblOutput);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Thy's Hi-Lo Guessing Game");
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);

	}
}
