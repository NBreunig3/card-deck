package DeckOfCards;

/**
 * A card with a face value and suit
 *
 * @author Nathan Breunig
 */
public class Card implements Comparable<Card> {
    private String strCard;
    private String suit;
    private Deck cardDeck;

    /**
     * Constructs a card with a face value and a suit
     * @param card     Card as string. Ex. ("5", "10", "Jack", "King")
     * @param cardSuit Suit as String
     */
    public Card(Deck deck, String card, String cardSuit) {
        strCard = card;
        suit = cardSuit;
        cardDeck = deck;
    }

    /**
     * Method to determine how Card's should be ordered.
     * By number and then suit
     *
     * @param card card to compare to
     * @return positive integer if this is greater than parameter card
     */
    @Override
    public int compareTo(Card card) {
        if (this.value() < card.value()) {
            return -1;
        } else if (this.value() > card.value()) {
            return 1;
        } else {
            if (cardDeck.getHeartValue() == 0 && cardDeck.getSpadeValue() == 0 && cardDeck.getDiamondValue() == 0 && cardDeck.getClubValue() == 0) {
                return 0;
            } else { //else suits matter
                if (this.suitValue() > card.suitValue()) {
                    return 1;
                } else if (this.suitValue() < card.suitValue()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }

    /**
     * Will get the face value of a card
     *
     * @return value of card
     */
    public int value() {
        if (strCard.equals("Jack")) {
            return cardDeck.getJackValue();
        } else if (strCard.equals("Queen")) {
            return cardDeck.getQueenValue();
        } else if (strCard.equals("King")) {
            return cardDeck.getKingValue();
        } else if (strCard.equals("Joker")) {
            return cardDeck.getJokerValue();
        } else if (strCard.equals("Ace")) {
            return cardDeck.getAceValue();
        } else {
            return Integer.parseInt(strCard);
        }
    }

    /**
     * Gets the value of the suit of the current card
     *
     * @return integer value
     */
    public int suitValue() {
        if (suit.equals("Heart")) {
            return cardDeck.getHeartValue();
        } else if (suit.equals("Club")) {
            return cardDeck.getClubValue();
        } else if (suit.equals("Diamond")) {
            return cardDeck.getDiamondValue();
        } else if (suit.equals("Spade")) {
            return cardDeck.getSpadeValue();
        }
        return -1;
    }

    /**
     * Will get the suit of a card
     *
     * @return Card suit as string
     */
    public String suit() {
        return suit;
    }

    /**
     * Gets the Card as its value abbreviated.
     * Ex. "4", "7", "K", "A", etc.
     *
     * @return rank as string
     */
    public String abbreviation() {
        if (strCard.equals("Ace")) {
           return "A";
        } else if (strCard.equals("Jack")) {
            return "J";
        } else if (strCard.equals("Queen")) {
            return "Q";
        } else if (strCard.equals("King")) {
            return "K";
        } else if (strCard.equals("Joker")){
            return "J";
        } else {
            return strCard;
        }
    }

    /**
     * Gets the string of a card object
     *
     * @return The card as a string
     */
    public String toString() {
        if (!suit.isEmpty()){
            if (strCard.equals("Ace")){
                return "Ace of " + suit + "s";
            }else if (strCard.equals("11")) {
                return "Jack of " + suit + "s";
            } else if (strCard.equals("12")) {
                return "Queen of " + suit + "s";
            } else if (strCard.equals("13")) {
                return "King + of " + suit + "s";
            } else {
                return strCard + " of " + suit + "s";
            }
        }else {
            return strCard;
        }
    }

    /**
     * Method to determine equality between Card objects
     *
     * @param o Object to compare to
     * @return true if the object in the parameter is equal to this card
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Card)) {
            return false;
        }
        Card that = (Card) o;
        if (this.strCard.equals(that.strCard) && this.suit.equals(that.suit)) {
            return true;
        } else {
            return false;
        }
    }
}
