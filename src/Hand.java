public class Hand
{
	/*
	 * Name: Emily Louie
	 * 
	 * Program Summary: The hand class that contains all of the actions that can be
	 * done in a hand.
	 */
	String name; // Sets a global name variable
	int[] cards = new int[12]; // Creates a global array variable
	int count = 0; // Sets a global count

	/**
	 * Constructor Pre: Name of the hand Post: Hand with a name
	 */

	public Hand(String name) // Constructor that allows you to create a hand object.
	{
		this.name = name;
	}

	/**
	 * Method that adds the cards to a displayable string Pre: Post: String with
	 * cards
	 */

	public String displayable_cards() // Function that adds cards to a string.
	{
		String result = "";
		// For loop that looks through the entire array and adds to string
		for (int i = 0; i < cards.length; i++)
		{
			if (i == 0)
			{
				result += lookup_display_card(cards[i]);
			}
			if (cards[i] != 0 && i != 0)
			{
				result += " " + lookup_display_card(cards[i]);
			}
		}
		return result;
	}

	/**
	 * Method that adds cards to a string, but skips the first one Pre: Post: String
	 * with cards but first is replaced with a joker.
	 */
	public String hide_first_card() // Function that adds cards to a string, but skips the first one in the array.
	{

		// String result = "🂠";
		String result = "?";
		// For loop that looks through the entire array and adds to string
		for (int i = 1; i < cards.length; i++)
		{

			if (cards[i] != 0)
			{
				result += " " + lookup_display_card(cards[i]);
			}
		}
		return result;
	}

	/**
	 * Method that looks up the cards in an array based on the number. one Pre:
	 * Takes the number generated between 1-52. Post: The image for the card is
	 * called based on the font.
	 */
	private String lookup_display_card(int i) // Private function that has the card that matches the corresponding
	// integer from 1-52
	{
		// String cards[] =
		// { "XXXX",
		// // @formatter:off
		// "🃁", "🃂", "🃃", "🃄", "🃅", "🃆", "🃇", "🃈", "🃉", "🃊", "🃋", "🃍", "🃎",
		// "🃑", "🃒", "🃓", "🃔",
		// "🃕", "🃖", "🃗", "🃘", "🃙", "🃚", "🃛", "🃝", "🃞", "🂱", "🂲", "🂳", "🂴",
		// "🂵", "🂶", "🂷", "🂸",
		// "🂹", "🂺", "🂻", "🂽", "🂾", "🂡", "🂢", "🂣", "🂤", "🂥", "🂦", "🂧", "🂨",
		// "🂩", "🂪", "🂫", "🂭",
		// "🂮"
		// // @formatter:on
		// };
		String cards[] =
		{ "XXXX",
				// @formatter:off
				"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
				"V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
				"q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
				// @formatter:on
		};
		return cards[i];
	}

	// testing done for cards as images
	// private ImageIcon lookup_display_card2(int i) // Private function that has
	// the card that matches the corresponding
	// // integer from 1-52
	// {
	// ArrayList<ImageIcon> deck = new ArrayList<ImageIcon>();
	// ImageIcon aC = new ImageIcon("AC.jpg");
	// deck.set(1, aC);
	// ImageIcon aD = new ImageIcon("AD.jpg");
	// deck.set(2, aD);
	// ImageIcon aH = new ImageIcon("AH.jpg");
	// deck.set(3, aH);
	// ImageIcon aS = new ImageIcon("AS.jpg");
	// deck.set(4, aS);
	// ImageIcon twoC = new ImageIcon("2C.jpg");
	// deck.set(5, twoC);
	// ImageIcon twoD = new ImageIcon("2D.jpg");
	// deck.set(6, twoD);
	// ImageIcon twoH = new ImageIcon("2H.jpg");
	// deck.set(7, twoH);
	// ImageIcon twoS = new ImageIcon("2S.jpg");
	// deck.set(8, twoS);
	// ImageIcon threeC = new ImageIcon("3C.jpg");
	// deck.set(9, threeC);
	// ImageIcon threeD = new ImageIcon("3D.jpg");
	// deck.set(10, threeD);
	// ImageIcon threeH = new ImageIcon("3H.jpg");
	// deck.set(11, threeH);
	// ImageIcon threeS = new ImageIcon("3S.jpg");
	// deck.set(12, threeS);
	// ImageIcon fourC = new ImageIcon("4C.jpg");
	// deck.set(13, fourC);
	// ImageIcon fourD = new ImageIcon("4D.jpg");
	// deck.set(14, fourD);
	// ImageIcon fourH = new ImageIcon("4H.jpg");
	// deck.set(15, fourH);
	// ImageIcon fourS = new ImageIcon("4S.jpg");
	// deck.set(16, fourS);
	// ImageIcon fiveC = new ImageIcon("5C.jpg");
	// deck.set(17, fiveC);
	// ImageIcon fiveD = new ImageIcon("5D.jpg");
	// deck.set(18, fiveD);
	// ImageIcon fiveH = new ImageIcon("5H.jpg");
	// deck.set(19, fiveH);
	// ImageIcon fiveS = new ImageIcon("5S.jpg");
	// deck.set(20, fiveS);
	// ImageIcon sixC = new ImageIcon("6C.jpg");
	// deck.set(21, sixC);
	// ImageIcon sixD = new ImageIcon("6D.jpg");
	// deck.set(22, sixD);
	// ImageIcon sixH = new ImageIcon("6H.jpg");
	// deck.set(23, sixH);
	// ImageIcon sixS = new ImageIcon("6S.jpg");
	// deck.set(24, sixS);
	// ImageIcon sevenC = new ImageIcon("7C.jpg");
	// deck.set(25, sevenC);
	// ImageIcon sevenD = new ImageIcon("7D.jpg");
	// deck.set(26, sevenD);
	// ImageIcon sevenH = new ImageIcon("7H.jpg");
	// deck.set(27, sevenH);
	// ImageIcon sevenS = new ImageIcon("7S.jpg");
	// deck.set(28, sevenS);
	// ImageIcon eightC = new ImageIcon("8C.jpg");
	// deck.set(29, eightC);
	// ImageIcon eightD = new ImageIcon("8D.jpg");
	// deck.set(30, eightD);
	// ImageIcon eightH = new ImageIcon("8H.jpg");
	// deck.set(31, eightH);
	// ImageIcon eightS = new ImageIcon("8S.jpg");
	// deck.set(32, eightS);
	// ImageIcon nineC = new ImageIcon("9C.jpg");
	// deck.set(33, nineC);
	// ImageIcon nineD = new ImageIcon("9D.jpg");
	// deck.set(34, nineD);
	// ImageIcon nineH = new ImageIcon("9H.jpg");
	// deck.set(35, nineH);
	// ImageIcon nineS = new ImageIcon("9S.jpg");
	// deck.set(36, nineS);
	// ImageIcon tenC = new ImageIcon("10C.jpg");
	// deck.set(37, tenC);
	// ImageIcon tenD = new ImageIcon("10D.jpg");
	// deck.set(38, tenD);
	// ImageIcon tenH = new ImageIcon("10H.jpg");
	// deck.set(39, tenH);
	// ImageIcon tenS = new ImageIcon("10S.jpg");
	// deck.set(40, tenS);
	// ImageIcon jackC = new ImageIcon("JC.jpg");
	// deck.set(41, jackC);
	// ImageIcon jackD = new ImageIcon("JD.jpg");
	// deck.set(42, jackD);
	// ImageIcon jackH = new ImageIcon("JH.jpg");
	// deck.set(43, jackH);
	// ImageIcon jackS = new ImageIcon("JS.jpg");
	// deck.set(44, jackS);
	// ImageIcon queenC = new ImageIcon("QC.jpg");
	// deck.set(45, queenC);
	// ImageIcon queenD = new ImageIcon("QD.jpg");
	// deck.set(46, queenD);
	// ImageIcon queenH = new ImageIcon("QH.jpg");
	// deck.set(47, queenH);
	// ImageIcon queenS = new ImageIcon("QS.jpg");
	// deck.set(48, queenS);
	// ImageIcon kingC = new ImageIcon("KC.jpg");
	// deck.set(49, kingC);
	// ImageIcon kingD = new ImageIcon("KD.jpg");
	// deck.set(50, kingD);
	// ImageIcon kingH = new ImageIcon("KH.jpg");
	// deck.set(51, kingH);
	// ImageIcon kingS = new ImageIcon("KS.jpg");
	// deck.set(52, kingS);
	// return deck.get(i);
	//
	// }

	/**
	 * Method that checks to see if the card is already in a hand Pre: Number from
	 * 1-52 Post: True or false regarding if the card is in hand
	 */

	public boolean is_card_in_hand(int card) // Function that checks to see if the card is in the array.
	{
		boolean result = false;
		for (int i = 0; i < cards.length; i++)
		{
			if (card == cards[i])
			{
				result = true;
				break;
			}
			else
			{

			}
		}
		return result;

	}

	/**
	 * Method that adds cards to the array Pre: Card Post: Array has a card added.
	 */
	public void add_card(int card) // Procedure that puts the card in the array.
	{
		cards[count++] = card;

	}

	/**
	 * Method that indicates if a hand has busted or not Pre: Post: True or false
	 * regarding if the hand is busted.
	 */
	public boolean has_player_busted() // Checks to see if the player's hand has a hand total of more than 21
	{
		boolean busted = false;
		int hand_total_value = hand_value();
		if (hand_total_value > 21)
		{
			busted = true;
		}
		return busted;
	}

	/**
	 * Method that calculates the hand value Pre: Post: Results in the total of card
	 * values.
	 */
	public int hand_value() // Function that calculates the hand total.
	{
		boolean i_saw_ace = false; // Flag set to raise if it sees an ace
		int hand_total_value = 0;
		for (int i = 0; i < cards.length; i++)
		{
			int card = cards[i];
			if (card == 0) // Stops if the value in the array is 0 which would mean there's nothing there.
			{
				break;
			}
			int remainder = card % 13;
			if (remainder == 11 || remainder == 12 || remainder == 0) // If it's a face card the remainder will be 11,12
																		// or 0 which should actually be a 10 since
																		// that's its Blackjack value.
			{
				remainder = 10;
			}
			if (remainder == 1) // If it's a remainder of 1 then it is an ace and raises the flag.
			{
				i_saw_ace = true;
			}
			hand_total_value += remainder; // adds the remainder to the hand total
		}
		if (i_saw_ace == true && hand_total_value < 12) // checks to see if the flag was raised and the total is less
														// than 12, then it will add 10 to make the value of the ace an
														// 11 rather than a 1.
		{
			hand_total_value = hand_total_value + 10;
		}
		return hand_total_value;
	}

	// Testing
	// public Hand(int... initial_cards)
	// {
	// super();
	//
	// for (int i = 0; i < initial_cards.length; i++)
	// {
	// cards[i] = initial_cards[i];
	// count++;
	// }
	// }
	// @Override
	// public String toString()
	// {
	// return "Hand [name=" + name + ", cards=" + Arrays.toString(cards) + ",
	// count=" + count + "]";
	// }

	// public static void main(String[] args)
	// {
	// Hand hand1 = new Hand(1, 14);
	// System.out.println(!hand1.has_player_busted());
	//
	// Hand hand_busted = new Hand(2, 7, 6);
	// System.out.println(!hand_busted.has_player_busted());
	//
	// System.out.println(12 == (new Hand(3, 4, 5).hand_value())); // no ace, no
	// face cards, not busted, 1 suit

	/*
	 * System.out.println(12 == hand_value(new int[] { 19, 2, 4 // no ace, no face
	 * cards, not busted, 2 suit })); System.out.println(10 == hand_value(new int[]
	 * { 19, 2, 28 // no ace, no face cards, not busted, 3 suit }));
	 * System.out.println(15 == hand_value(new int[] { 19, 2, 28, 44 // no ace, no
	 * face cards, not busted, 4 suit })); System.out.println(24 == hand_value(new
	 * int[] { 7, 8, 9 // no ace, no face cards, busted, 1 suit }));
	 * System.out.println(24 == hand_value(new int[] { 19, 9, 22 // no ace, no face
	 * cards, busted, 2 suit })); System.out.println(24 == hand_value(new int[] {
	 * 19, 9, 35 // no ace, no face cards, busted, 3 suit })); System.out.println(26
	 * == hand_value(new int[] { 19, 9, 35, 41 // no ace, no face cards, busted, 4
	 * suit })); System.out.println(20 == hand_value(new int[] { 11, 12 // no ace,
	 * face cards, not busted, 1 suit })); System.out.println(20 == hand_value(new
	 * int[] { 11, 25 // no ace, face cards, not busted, 2 suit }));
	 * System.out.println(30 == hand_value(new int[] { 11, 25, 38 // no ace, face
	 * cards, busted, 3 suit })); System.out.println(40 == hand_value(new int[] {
	 * 11, 25, 38, 51 // no ace, face cards, busted, 4 suit }));
	 * System.out.println(30 == hand_value(new int[] { 11, 12, 13 // no ace, face
	 * cards, busted, 1 suit })); System.out.println(30 == hand_value(new int[] {
	 * 11, 25, 13 // no ace, face cards, busted, 2 suit })); System.out.println(16
	 * == hand_value(new int[] { 1, 2, 3 // 1 ace, no face cards, not busted }));
	 * System.out.println(20 == hand_value(new int[] { 1, 9, 10 // 1 ace, no face
	 * cards, not busted })); System.out.println(18 == hand_value(new int[] { 1, 14,
	 * 6 // 2 ace, no face cards, not busted })); System.out.println(13 ==
	 * hand_value(new int[] { 1, 14, 27 // 3 ace, no face cards, not busted }));
	 * System.out.println(14 == hand_value(new int[] { 1, 14, 27, 40 // 4 ace, no
	 * face cards, not busted })); System.out.println(13 == hand_value(new int[] {
	 * 1, 14, 27, 40, 9 // 4 ace, no face cards, not busted }));
	 * System.out.println(21 == hand_value(new int[] { 1, 10, 11 // 1 ace, face
	 * cards, win })); System.out.println(22 == hand_value(new int[] { 1, 9, 10, 2
	 * // 1 ace, no face cards, busted })); System.out.println(21 == hand_value(new
	 * int[] { 10, 1 // 1 ace, no face cards, win })); System.out.println(21 ==
	 * hand_value(new int[] { 1, 14, 27, 40, 2, 15, 28, 41, 3, 16, 29 // 4 ace, no
	 * face cards, win })); System.out.println(14 == hand_value(new int[] { 30, 5,
	 * 31, 0, 0, 0, 0, 0, 0 // no ace, 2 face cards, not busted }));
	 * System.out.println("🂡🂢🂣🂤🂥🂦🂧🂨🂩🂪🂫🂭🂮\n" +
	 * "🂱🂲🂳🂴🂵🂶🂷🂸🂹🂺🂻🂽🂾\n" + "🃁🃂🃃🃄🃅🃆🃇🃈🃉🃊🃋🃍🃎\n" +
	 * "🃑🃒🃓🃔🃕🃖🃗🃘🃙🃚🃛🃝🃞");
	 */ }
