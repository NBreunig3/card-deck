package DeckOfCards;

/**
 * A card with a face value and suit
 * @author Nathan Breunig
 * @version 1.3.2
 */
public class Card {
    private String strCard;
    private String suit;
    private Deck cardDeck;

    public Card(){}

    /**
     * Constructs a card with a face value and a suit
     * @param card Card as string
     * @param cardSuit Suit as String
     */
    public Card(Deck deck, String card, String cardSuit){
        strCard = card;
        suit = cardSuit;
        cardDeck = deck;
    }

    /**
     * Will get the face value of a card
     * @return value of card
     */
    public int getValue() {
        int value = 0;

        if (strCard.equals("J")) {
            value = cardDeck.getJackValue();
        }else if (strCard.equals("Q")) {
            value = cardDeck.getQueenValue();
        }else if (strCard.equals("K")) {
            value = cardDeck.getKingValue();
        }else if (strCard.equals("Joker")){
            value = cardDeck.getJokerValue();
        }
        else if (strCard.equals("A")) {
           value = cardDeck.getAceValue();
        }else{
            value = Integer.parseInt(strCard);
        }
        return value;
    }

    public int getSuitValue(){
        int value = 0;

        if (suit.equals("Heart")){
            value = cardDeck.getHeartValue();
        }else if (suit.equals("Club")){
            value = cardDeck.getClubValue();
        }else if (suit.equals("Diamond")){
            value = cardDeck.getDiamondValue();
        }else if (suit.equals("Spade")){
            value = cardDeck.getSpadeValue();
        }
        return value;
    }

    /**
     * Will get the suit of a card
     * @return Card suit as string
     */
    public String getSuit(){
        return suit;
    }


    /**
     * Gets the string of a card object
     * @return The card as a string
     */
    public String toString(){

        if (cardDeck.isAceHigh()) {
            if (strCard.equals("14")) {
                return "A";
            }
        } else {
             if (strCard.equals("1")){
                return "A";
            }
        }
        if (strCard.equals("11")) {
            return "J";
        }else if (strCard.equals("12")) {
            return "Q";
        }else if (strCard.equals("13")) {
            return "K";
        } else{
            return String.valueOf(strCard);
        }
    }
}
