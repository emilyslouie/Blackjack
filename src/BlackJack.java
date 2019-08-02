import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// ^^ imports the swing, sound and awt parts from the library

public class BlackJack
{
	/*
	 * Name: Emily Louie
	 * 
	 * Program Summary: The main class that contains the GUI components and uses
	 * functions and procedures from the Hand and Card_table class to create the
	 * Blackjack game.
	 */

	static Clip clip; // creates the music clip

	/**
	 * Main class that runs the program
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException // The main that runs the program.
	{

		JFrame jframe = new JFrame("Blackjack"); // Creates the JFrame.
		jframe.setSize(1000, 4000); // Sets the size of the JFrame.
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Tells the JFrame to close when you close it.
		JPanel jpanel = new JPanel(new GridBagLayout()); // Sets up the JPanel which uses GridBagLayout.
		Image image = ImageIO.read(BlackJack.class.getResourceAsStream("1450903809.jpg"));
		JLabel background = new JLabel(new ImageIcon(image)); // Sets the background image as a JLabel.
		jframe.setContentPane(background); // Sets the background image into the JFrame.
		jframe.setLayout(new GridBagLayout()); // Sets the JFrame's layout.
		jframe.add(jpanel); // Adds the panel to the JFrame.
		create_start_panel(jpanel, jframe); // Brings in the procedure that launches the start panel.
		jframe.setVisible(true); // Makes the JFrame visible.
	}

	/**
	 * Method that creates the start panel Pre: Takes the jpanel, and jframe and
	 * puts it into the GUI Post: Creates the start panel with the menu – the exit
	 * button, play button, title, and mute/unmute
	 */
	private static void create_start_panel(JPanel jpanel, JFrame jframe) // Procedure that creates the start panel,
																			// takes in the parameter of a jpanel and a
																			// jframe.
	{
		JButton soundOn = new JButton("Mute"); // Creates the mute button and locates it to the top right corner of the
												// panel.
		GridBagConstraints k = new GridBagConstraints();
		k.gridx = 4;
		k.gridy = 0;
		k.anchor = GridBagConstraints.LINE_END;
		k.insets = new Insets(0, 0, 75, 0);
		soundOn.setBounds(500, 478, 70, 70);
		jpanel.add(soundOn, k);
		/*
		 * Try and catch method that tries to open the audio clip and catches it if
		 * there is a problem.
		 */
		try // Tries to get the audio clip and catches if there is a problem.
		{
			clip = AudioSystem.getClip();
		}
		catch (LineUnavailableException e2)
		{
			e2.printStackTrace();
		}
		try // Tries to open the clip and catches it if something goes wrong.
		{
			clip.open(AudioSystem.getAudioInputStream(
					new BufferedInputStream(BlackJack.class.getResourceAsStream("Jazz Background Music.wav"))));
		}
		catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1)
		{
			e1.printStackTrace();
		}
		/*
		 * Try and catch method that tries to loop the music repeatedly, and catches an
		 * exception if there is an issue.
		 */
		try // Loops the clip and tells it to start.
		{
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		/*
		 * Method that listens for a button click, and will subsequently mute or unmute
		 * the music and change the label of the button.
		 */
		soundOn.addActionListener(new ActionListener() // If the mute button is clicked, it will stop the music and then
														// become a unmute button and so on.
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					if (clip.isActive())
					{
						clip.stop();
						soundOn.setText("Unmute");
					}
					else
					{
						clip.start();
						clip.loop(Clip.LOOP_CONTINUOUSLY);
						soundOn.setText("Mute");
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});

		/*
		 * Creates the labels on the menu Creates the play button and the exit button
		 */

		JLabel label = new JLabel("Blackjack"); // Sets the title of the game in the centre of the panel.
		label.setFont(new Font("Verdana", Font.BOLD, 50));
		GridBagConstraints a = new GridBagConstraints();
		a.gridx = 2;
		a.gridy = 1;
		a.gridwidth = 3;
		a.insets = new Insets(0, 0, 50, 0);
		a.fill = GridBagConstraints.HORIZONTAL;
		jpanel.add(label, a);

		JButton yes = new JButton("Play"); // Sets up a button called play under the title to the most left side.
		GridBagConstraints b = new GridBagConstraints();
		b.gridx = 2;
		b.gridy = 11;
		b.anchor = GridBagConstraints.LINE_START;
		b.fill = GridBagConstraints.HORIZONTAL;
		jpanel.add(yes, b);
		JButton exit = new JButton("Exit"); // Sets up a button called exit under the title to the right of the play
											// button.
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 4;
		c.gridy = 11;
		c.anchor = GridBagConstraints.LINE_END;
		jpanel.add(exit, c);

		// Creates the listener for the play button.

		yes.addActionListener(new ActionListener() // If they click the play button, it will hide the play, exit, and
													// label, then launch the other method that shows the play panel.
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (yes.isEnabled())
				{
					yes.setVisible(false);
					exit.setVisible(false);
					label.setVisible(false);
					create_play_panel(jpanel);
				}
			}
		});

		// Creates the listener for the exit button.

		exit.addActionListener(new ActionListener() // If exit is clicked, then it'll hide the jframe and terminate the
													// program.
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (exit.isEnabled())
				{
					jframe.setVisible(false);
					System.exit(0);
				}
			}
		});
	}

	/**
	 * Method that creates the play panel for the game where everything happens.
	 * Pre: Takes a jpanel. Post: Panel is displayed with game on it.
	 */
	private static void create_play_panel(JPanel jpanel) // Procedure that creates the play panel.
	{

		// Creates the card and table classes

		Hand playerHand; // Creates the player hand
		Hand dealerHand; // Creates the dealer hand
		CardTable table; // Creates the card table

		/*
		 * Creates the InputStream, font and stylized font variables. Tries to create
		 * the font, and catches it if there is an error.
		 */

		InputStream is = null;
		Font font = null;
		Font stylized = null;
		try
		{
			is = new BufferedInputStream(BlackJack.class.getResourceAsStream("CARDS.TTF"));
			font = Font.createFont(Font.TRUETYPE_FONT, is);
			stylized = font.deriveFont(Font.PLAIN, 100);
		}
		catch (FontFormatException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		// Initializes the player and dealer hands and the card table.

		playerHand = new Hand("Player");
		dealerHand = new Hand("Dealer");
		table = new CardTable(playerHand, dealerHand);

		// Creates the label of your hand which is in the top left corner

		JLabel your_hand = new JLabel("Your hand:");
		your_hand.setFont(new Font("Verdana", Font.ITALIC, 15));
		GridBagConstraints a = new GridBagConstraints();
		a.gridx = 1;
		a.gridy = 1;
		a.insets = new Insets(0, 0, 10, 0);
		a.fill = GridBagConstraints.HORIZONTAL;
		jpanel.add(your_hand, a);

		// Creates the label of your total which is put in the top right corner.

		JLabel your_total = new JLabel("Your total: " + 0);
		your_total.setFont(new Font("Verdana", Font.BOLD, 15));
		GridBagConstraints b = new GridBagConstraints();
		b.gridx = 3;
		b.gridy = 1;
		b.insets = new Insets(0, 0, 10, 0);
		b.fill = GridBagConstraints.HORIZONTAL;
		jpanel.add(your_total, b);

		// Creates the label that will hold the cards in your hand.

		JLabel your_cards = new JLabel("");
		your_cards.setFont(stylized);
		GridBagConstraints e = new GridBagConstraints();
		e.gridx = 1;
		e.gridy = 2;
		e.anchor = GridBagConstraints.LINE_START;
		e.gridwidth = 2;
		e.insets = new Insets(25, 0, 50, 0);
		e.fill = GridBagConstraints.HORIZONTAL;
		jpanel.add(your_cards, e);

		// Creates the label for "dealer's hand"

		JLabel dealer_hand = new JLabel("Dealer's hand: ");
		dealer_hand.setFont(new Font("Verdana", Font.ITALIC, 15));
		GridBagConstraints f = new GridBagConstraints();
		f.gridx = 1;
		f.gridy = 7;
		f.insets = new Insets(10, 0, 10, 300);
		f.fill = GridBagConstraints.HORIZONTAL;
		jpanel.add(dealer_hand, f);

		// Sets the label for dealer's total as "?"

		JLabel dealer_total = new JLabel("Dealer's total: ?");
		dealer_total.setFont(new Font("Verdana", Font.BOLD, 15));
		GridBagConstraints g = new GridBagConstraints();
		g.gridx = 3;
		g.gridy = 7;
		g.insets = new Insets(10, 0, 10, 0);
		g.fill = GridBagConstraints.HORIZONTAL;
		jpanel.add(dealer_total, g);

		// Sets the label for the dealer's cards

		JLabel dealer_cards = new JLabel("");
		dealer_cards.setFont(stylized);
		GridBagConstraints h = new GridBagConstraints();
		h.gridx = 1;
		h.gridy = 8;
		h.anchor = GridBagConstraints.LINE_START;
		h.gridwidth = 2;
		h.insets = new Insets(25, 0, 150, 0);
		h.fill = GridBagConstraints.HORIZONTAL;
		jpanel.add(dealer_cards, h);

		// Button to play again which is hidden at the start

		JButton play_again = new JButton("Play Again");
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 13;
		c.anchor = GridBagConstraints.LINE_START;
		jpanel.add(play_again, c);
		play_again.setVisible(false);

		// Label for the ending statement and makes it invisible.

		JLabel ending_statement = new JLabel("you win");
		ending_statement.setFont(new Font("Verdana", Font.BOLD, 15));
		GridBagConstraints j = new GridBagConstraints();
		j.gridx = 2;
		j.gridy = 13;
		j.anchor = GridBagConstraints.LINE_START;
		jpanel.add(ending_statement, j);
		ending_statement.setVisible(false);

		// Creates the button that is labeled "hit"

		JButton hit = new JButton("Hit");
		GridBagConstraints i = new GridBagConstraints();
		i.gridx = 3;
		i.gridy = 13;
		i.anchor = GridBagConstraints.LINE_END;
		jpanel.add(hit, i);

		// Creates the button that is labeled "stay"

		JButton stay = new JButton("Stay");
		GridBagConstraints d = new GridBagConstraints();
		d.gridx = 4;
		d.gridy = 13;
		d.anchor = GridBagConstraints.LINE_START;
		jpanel.add(stay, d);
		// Creates the dealing sequence which deals a card to the user, updates the
		// cards displayed in the label, deals to the dealer, updates, and does it so
		// there are two cards per player.
		// Uses functions from the card table to deal
		table.deal_card_to_player();
		your_cards.setText(playerHand.displayable_cards());
		table.deal_card_to_dealer();
		dealer_cards.setText(dealerHand.hide_first_card());
		table.deal_card_to_player();
		your_cards.setText(playerHand.displayable_cards());
		table.deal_card_to_dealer();
		dealer_cards.setText(dealerHand.hide_first_card());
		// Updates your total hand value using the hand value function in the hand class
		your_total.setText("Your total: " + playerHand.hand_value());
		// Allows you to click the "hit" button to get another card.
		hit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// If it's clicked, the card table will give the user another card, update the
				// hand label, the hand value.
				if (hit.isEnabled())
				{
					table.deal_card_to_player();
					your_cards.setText(playerHand.displayable_cards());
					your_total.setText("Your total: " + playerHand.hand_value());

					// If the player has busted (using function from hand class), it
					// will show the dealer's cards, their total, hide the hit and
					// stay buttons, and show the play again and ending statement.
					if (playerHand.has_player_busted())
					{
						dealer_cards.setText(dealerHand.displayable_cards());
						dealer_total.setText("Dealer total: " + dealerHand.hand_value());
						hit.setVisible(false);
						play_again.setVisible(true);
						stay.setVisible(false);
						ending_statement.setText("You busted. You lose.");
						ending_statement.setVisible(true);
					}
				}
			}
		});
		// Allows you to hit the stay button
		stay.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// If it is clicked, the hit and stay button will disappear, the play again
				// button will show up.
				if (stay.isEnabled())
				{
					hit.setVisible(false);
					play_again.setVisible(true);
					stay.setVisible(false);
					// It'll show the dealer's cards and total.
					dealer_cards.setText(dealerHand.displayable_cards());
					dealer_total.setText("Dealer total: " + dealerHand.hand_value());
					// If their total is less than 17, they will automatically be given a card until
					// their total is 17 or above. It'll update their hand and total value.
					while (dealerHand.hand_value() < 17)
					{
						table.deal_card_to_dealer();
						dealer_cards.setText(dealerHand.displayable_cards());
						dealer_total.setText("Dealer total: " + dealerHand.hand_value());
					}
					// If the dealer has busted, it will show their hand and total, show the ending
					// statement.
					if (dealerHand.has_player_busted())
					{
						dealer_cards.setText(dealerHand.displayable_cards());
						dealer_total.setText("Dealer total: " + dealerHand.hand_value());
						ending_statement.setText("The dealer busted. You win!");
						ending_statement.setVisible(true);
					}
					// If the player has a higher total than the dealer, then it'll show the
					// dealer's cards, and total, and the ending statement.
					else if (playerHand.hand_value() > dealerHand.hand_value())
					{
						dealer_cards.setText(dealerHand.displayable_cards());
						dealer_total.setText("Dealer total: " + dealerHand.hand_value());
						ending_statement.setText("Your hand was larger than the dealer's. You win!");
						ending_statement.setVisible(true);
					}
					// If the player has a lower total than the dealer, then it'll show the dealer's
					// cards, and total, and the ending statement.
					else if (playerHand.hand_value() < dealerHand.hand_value())
					{
						dealer_cards.setText(dealerHand.displayable_cards());
						dealer_total.setText("Dealer total: " + dealerHand.hand_value());
						ending_statement.setText("The dealer's hand was larger than yours. You lose.");
						ending_statement.setVisible(true);
					}
					// If the player has the same total as the dealer, then it'll show the dealer's
					// cards, and total, and the ending statement.
					else
					{
						dealer_cards.setText(dealerHand.displayable_cards());
						dealer_total.setText("Dealer total: " + dealerHand.hand_value());
						ending_statement.setText("You got the same total as the dealer. It's a draw.");
						ending_statement.setVisible(true);
					}
				}
			}
		});
		// Allows the play again button to perform an action.
		play_again.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// If it's clicked, it will reset all of the labels, hide the ending
				// statement and play again button, and then create a new play panel.
				if (play_again.isEnabled())
				{
					your_cards.setText("");
					your_total.setText("");
					dealer_cards.setText("");
					dealer_total.setText("");
					ending_statement.setText("");
					ending_statement.setVisible(false);
					play_again.setVisible(false);
					create_play_panel(jpanel);
				}
			}
		});
	};
}
