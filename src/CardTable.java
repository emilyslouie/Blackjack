
public class CardTable
{
	/*
	 * Name: Emily Louie
	 * 
	 * Program Summary: The card table class that contains all of the actions that a
	 * dealer would do in real life.
	 */
	Hand player_hand; // Brings in the player hand and dealer hand.
	Hand dealer_hand;

	/**
	 * Constructor for the card table Pre: Takes the player hand and the dealer hand
	 */
	public CardTable(Hand player_hand, Hand dealer_hand)
	{
		this.player_hand = player_hand;
		this.dealer_hand = dealer_hand;
	}

	/**
	 * Method that creates a new card Pre: Post: Creates a card
	 */
	private int create_a_new_card()
	{
		int card_not_in_any_hand = 0;
		boolean havent_dealt_new_card_to_player = true;
		// While loop that will run until it has a card that has not been
		// already dealt to the player or dealer.
		while (havent_dealt_new_card_to_player)
		{
			double randomNum = Math.random(); // Random number between 1 and 52.
			int new_card = (int) ((randomNum * 52) + 1);
			// If it is in a hand, the while loop will run again.
			if (player_hand.is_card_in_hand(new_card) || dealer_hand.is_card_in_hand(new_card))
			{

			}
			// otherwise it will make the number the new card and break out of the loop.
			else
			{
				card_not_in_any_hand = new_card;
				havent_dealt_new_card_to_player = false;
			}
		}

		return card_not_in_any_hand;
	}

	/**
	 * Method that adds the card to a player's hand Pre: Post: Player hand with an
	 * additional card
	 */
	public void deal_card_to_player() // procedure that deals a card to the player from the new card it made in the
										// previous function.
	{
		player_hand.add_card(create_a_new_card());
	}

	/**
	 * Method that adds the card to a dealer's hand Pre: Post: Dealer hand with an
	 * additional card
	 */
	public void deal_card_to_dealer()
	{
		dealer_hand.add_card(create_a_new_card()); // procedure that deals a card to the dealer from the new card it
													// made in the previous function.
	}

}
