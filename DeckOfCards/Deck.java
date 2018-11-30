package DeckOfCards;
import java.util.ArrayList;
import java.util.Random;

/**
 * A standard deck of playing cards with various useful methods
 * @author Nathan Breunig
 * @version 1.01
 */
public class Deck {
    private ArrayList<Card> myDeck = new ArrayList<Card>();
    private final ArrayList<Card> deck = new ArrayList<Card>();
    private ArrayList<PlayerHand> hands = new ArrayList<PlayerHand>();
    private Random rand = new Random();
    private int randNum;
    private boolean acesHigh, useJokers;
    private int jokerValue, heartValue, spadeValue, clubValue, diamondValue;
    private int aceValue, jackValue, queenValue, kingValue;

    /**
     * Basic constructor to set ace high, and to see if the deck should contain two joker cards
     * @param highAce Does the Ace card have high or low value?
     * @param jokers Add two joker cards to the deck?
     */
    public Deck(boolean highAce, boolean jokers) {
        acesHigh = highAce;
        useJokers = jokers;
        heartValue = 4;
        diamondValue = 3;
        clubValue = 2;
        spadeValue = 1;

        if (highAce){
            aceValue = 14;
        }else{
            aceValue = 1;
        }
        resetDeck();
        shuffle();
    }

    /**
     * Alternate constructor that sets the value of the Ace and face cards
     * @param jokers Add two jokers to the deck
     */
    public Deck(boolean jokers, int aceValue, int jackValue, int queenValue, int kingValue) {
        useJokers = jokers;
        heartValue = 4;
        diamondValue = 3;
        clubValue = 2;
        spadeValue = 1;
        this.aceValue = aceValue;
        this.jackValue = jackValue;
        this.queenValue = queenValue;
        this.kingValue = kingValue;

        resetDeck();
        shuffle();
    }

    /**
     * Alternate Constructor with options to set suit values
     * @param highAce Does the Ace card have high or low value?
     * @param jokers Jokers Add two joker cards to the deck?
     * @param heartSuitValue Set the value of a heart
     * @param spadeSuitValue Set the value of a spade
     * @param clubSuitValue Set the value of a club
     * @param diamondSuitValue Set the value of a diamond
     */
    public Deck(boolean highAce, boolean jokers, int heartSuitValue, int spadeSuitValue, int clubSuitValue, int diamondSuitValue ) {
        acesHigh = highAce;
        useJokers = jokers;
        heartValue = heartSuitValue;
        clubValue = clubSuitValue;
        spadeValue = spadeSuitValue;
        diamondValue = diamondSuitValue;

        if (highAce){
            aceValue = 14;
        }else{
            aceValue = 1;
        }
        resetDeck();
        shuffle();
    }


    private void resetDeck() {
        deck.clear();
        myDeck.clear();
        hands.clear();

        deck.add(new Card(this,"2", "Club"));
        deck.add(new Card(this,"2", "Diamond"));
        deck.add(new Card(this,"2", "Heart"));
        deck.add(new Card(this,"2", "Spade"));

        deck.add(new Card(this,"3", "Club"));
        deck.add(new Card(this,"3", "Diamond"));
        deck.add(new Card(this,"3", "Heart"));
        deck.add(new Card(this,"3", "Spade"));

        deck.add(new Card(this,"4", "Club"));
        deck.add(new Card(this,"4", "Diamond"));
        deck.add(new Card(this,"4", "Heart"));
        deck.add(new Card(this,"4", "Spade"));

        deck.add(new Card(this,"5", "Club"));
        deck.add(new Card(this,"5", "Diamond"));
        deck.add(new Card(this,"5", "Heart"));
        deck.add(new Card(this,"5", "Spade"));

        deck.add(new Card(this,"6", "Club"));
        deck.add(new Card(this,"6", "Diamond"));
        deck.add(new Card(this,"6", "Heart"));
        deck.add(new Card(this,"6", "Spade"));

        deck.add(new Card(this,"7", "Club"));
        deck.add(new Card(this,"7", "Diamond"));
        deck.add(new Card(this,"7", "Heart"));
        deck.add(new Card(this,"7", "Spade"));

        deck.add(new Card(this,"8", "Club"));
        deck.add(new Card(this,"8", "Diamond"));
        deck.add(new Card(this,"8", "Heart"));
        deck.add(new Card(this,"8", "Spade"));

        deck.add(new Card(this,"9", "Club"));
        deck.add(new Card(this,"9", "Diamond"));
        deck.add(new Card(this,"9", "Heart"));
        deck.add(new Card(this,"9", "Spade"));

        deck.add(new Card(this,"10", "Club"));
        deck.add(new Card(this,"10", "Diamond"));
        deck.add(new Card(this,"10", "Heart"));
        deck.add(new Card(this,"10", "Spade"));

        deck.add(new Card(this,"J", "Club"));
        deck.add(new Card(this,"J", "Diamond"));
        deck.add(new Card(this,"J", "Heart"));
        deck.add(new Card(this,"J", "Spade"));

        deck.add(new Card(this,"Q", "Club"));
        deck.add(new Card(this,"Q", "Diamond"));
        deck.add(new Card(this,"Q", "Heart"));
        deck.add(new Card(this,"Q", "Spade"));

        deck.add(new Card(this,"K", "Club"));
        deck.add(new Card(this,"K", "Diamond"));
        deck.add(new Card(this,"K", "Heart"));
        deck.add(new Card(this,"K", "Spade"));

        deck.add(new Card(this,"A", "Club"));
        deck.add(new Card(this,"A", "Diamond"));
        deck.add(new Card(this,"A", "Heart"));
        deck.add(new Card(this,"A", "Spade"));

        if (useJokers){
            deck.add(new Card(this, "Joker", ""));
            deck.add(new Card(this, "Joker", ""));
        }
    }

    /**
     * Will shuffle/scramble the order of cards in the deck
     */
    public void shuffle() {
        resetDeck();
        randNum = 0;
        int size = deck.size();

        for (int i = 1; i <= size; i++) {
            if (deck.size() == 1) {
                randNum = 0;
            } else if (deck.size() > 1) {
                randNum = rand.nextInt(deck.size());
            }
            myDeck.add(deck.remove(randNum));
        }
    }

    public void setJokerValue(int value){
        jokerValue = value;
    }

    public int getJokerValue(){
        return jokerValue;
    }

    public int getHeartValue(){
        return heartValue;
    }

    public void setHeartValue(int value){
        heartValue = value;
    }

    public int getSpadeValue(){
        return spadeValue;
    }

    public void setSpadeValue(int value){
        spadeValue = value;
    }

    public int getDiamondValue(){
        return diamondValue;
    }

    public void setDiamondValue(int value){
        diamondValue = value;
    }

    public int getClubValue(){
        return clubValue;
    }

    public void setClubValue(int value){
        clubValue = value;
    }

    /**
     * Adds a card to the end of the deck
     * @param card The card to add
     */
    public void add(Card card){
        myDeck.add(card);
    }

    /**
     * Adds a card to the deck
     * @param position The position in which to insert the card at
     * @param card The card to add
     */
    public void add(int position, Card card){
        if (position >= 1 && position <= myDeck.size()){
            position -=1;
            myDeck.add(position, card);
        }
    }

    /**
     * Adds a card to the beginning of the deck
     * @param card The card to add
     */
    public void addFirst(Card card){
        myDeck.add(0, card);
    }

    /**
     * Gets the next X numbers of cards from the deck and puts them into an ArrayList
     * @param numOfCards Number of cards to put into array
     * @param removeCards Remove the cards from the deck?
     * @return An ArrayList of card objects
     */
    public ArrayList<Card> getCards(int numOfCards, boolean removeCards) {
        ArrayList<Card> playerCards = new ArrayList<Card>();

        if (removeCards){
            if (numOfCards <= myDeck.size()) {
                for (int i = 1; i <= numOfCards; i++) {
                    playerCards.add(myDeck.remove(0));
                }
            } else {
                throw new Error("Can't pull more cards than there are in the deck");
            }
        }else if(!removeCards){
            if (numOfCards <= myDeck.size()) {
                for (int i = 0; i < numOfCards; i++) {
                    playerCards.add(myDeck.get(i));
                }
            } else {
                throw new Error("Can't pull more cards than there are in the deck");
            }
        }
        return playerCards;
    }

    /**
     * Gets the next card from the deck
     * @param removeCard Remove the card from the deck?
     * @return A card object
     */
    public Card getNextCard(boolean removeCard) {
        Card card = new Card();

        if (removeCard){
            if (myDeck.size() != 0) {
                card = myDeck.remove(0);
            } else {
                throw new Error("Can't pull more cards than there are in the deck");
            }
        }else if(!removeCard){
            if (myDeck.size() != 0) {
                card = myDeck.get(0);
            } else {
                throw new Error("Can't pull more cards than there are in the deck");
            }
        }
        return card;
    }

    /**
     * Gets a card from the deck at a certain position
     * @param cardNum The card number to remove (first, second, etc)
     * @param removeCard Remove the card from the deck?
     * @return A card object
     */
    public Card getCard(int cardNum, boolean removeCard){
        Card card = new Card();
        cardNum -=1;

        if (removeCard){
            if (cardNum < myDeck.size() && cardNum >= 0){
                card = myDeck.remove(cardNum);
            }
        }else if (!removeCard){
            if (cardNum < myDeck.size() && cardNum >= 0){
                card = myDeck.get(cardNum);
            }
        }
        return card;
    }

    /**
     * Looks to see if a certain card exists in the deck (suit doesn't matter)
     * @param card A Card as a string to search for
     * @return True if found in deck
     */
    public boolean contains(String card){
        boolean exist = false;

        for (int i = 0; i < myDeck.size(); i++){
            if (myDeck.get(i).toString().equals(card)){
                exist = true;
            }
        }
        return exist;
    }

    /**
     * Looks to see if a certain suit is still in the deck
     * @param suit A suit as a string
     * @return True if said suit is in deck
     */
    public boolean containsSuit(String suit){
        for (int i = 0; i < myDeck.size(); i++){
            if (myDeck.get(i).getSuit().equals(suit)){
                return true;
            }
        }
        return false;
    }

    /**
     * Looks to see if a certain card is in the deck
     * @param card A Card as a string
     * @param suit The suit of the card
     * @return True if found in deck
     */
    public boolean contains(String card, String suit){
        boolean exist = false;

        for (int i = 0; i < myDeck.size(); i++){
            if (myDeck.get(i).toString().equals(card) && myDeck.get(i).getSuit().equals(suit)){
                exist = true;
            }
        }
        return exist;
    }

    /**
     * Creates an ArrayList with all of the cards currently in the deck
     * @return An ArrayList of card objects
     */
    public ArrayList<Card> getDeck(){
        ArrayList<Card> deck = new ArrayList<>();

        for (int i = 0; i < myDeck.size(); i++){
            deck.add(myDeck.get(i));
        }

        return deck;
    }

    /**
     * Gets the number of cards in the deck
     * @return Number of cards in deck
     */
    public int getSize(){
        return myDeck.size();
    }

    /**
     * Counts how many times a card appears in the deck
     * @return The frequency of a certain card in the deck
     */
    public int cardFrequency(String card){
        int counter = 0;

        for(int i = 0; i < myDeck.size(); i++){
            if (myDeck.get(i).toString().equals(card)){
                counter += 1;
            }
        }
        return counter;
    }

    /**
     * "Deals" X cards to X players
     * NOTE: Use method getPlayerHand to get the delt cards
     * @param alternating deal cards in an alternating way?
     * @param numOfPlayers number of players to deal to
     * @param numOfCards number of cards to give to each player
     */
    public void deal(boolean alternating, int numOfPlayers, int numOfCards) {
        int totalCards = numOfCards * numOfPlayers;

        for (int i = 0; i < numOfPlayers; i++){
            hands.add(new PlayerHand());
        }

        if (!alternating){
            if (totalCards <= myDeck.size()) {
                for (int p = 0; p < numOfPlayers; p++) {
                    for (int c = 0; c < numOfCards; c++) {
                        hands.get(p).add(myDeck.remove(0));
                    }
                }
            } else {
                throw new Error("Can't pull more cards than there are in the deck");
            }
        }else{
            if (totalCards <= myDeck.size()){
                for (int c = 0; c < numOfCards; c++){
                    for (int p = 0; p < numOfPlayers; p++){
                        hands.get(p).add(myDeck.remove(0));
                    }
                }
            }else{
                throw new Error("Can't pull more cards than there are in the deck");
            }
        }
    }

    /**
     * Deals out all remaining cards in the deck, even if the players will have uneven amounts
     * @param players Number of players to deal to
     */
    public void dealAll(int players){
        int p = 1;

        for (int i = 1; i <= players; i++){
            hands.add(new PlayerHand());
        }

        while (!myDeck.isEmpty()){
            hands.get(p - 1).add(myDeck.remove(0));
            p += 1;

            if (p > players){
                p = 1;
            }
        }
    }

    /**
     * Gets all of the cards in a players hand
     * @param player Which players hand
     * @return A PlayerHand object
     */
      public PlayerHand getPlayerHand(int player){
        player -=1;

        if (player < hands.size() && player > -1){
            return hands.get(player);
        }else{
            throw new Error("Player " + player + " does not exist");
        }
    }
    
    /**
    * Removes all of the cards from deck
    */
    public void clear(){
        myDeck.clear();
    }

    /**
     * Removes the next X number of cards
     * @param numOfCards How many cards to remove
     */
    public void removeCards(int numOfCards){
        if (numOfCards <= myDeck.size() && numOfCards > 0){
            for (int i = 1; i <= numOfCards; i++){
                myDeck.remove(0);
            }
        }else{
            throw new Error("Can't remove more cards than there are in deck");
        }
    }

    /**
     * Removes ALL cards of a certain value (no matter suit)
     * @param card The card(s) as a string to remove
     */
    public Card removeCard(String card){
        for (int i = 0; i < myDeck.size(); i++){
            if (myDeck.get(i).toString().equals(card)){
                return myDeck.remove(i);
            }
        }
        return null;
    }

    /**
     * Removes a card with a certain suit
     * @param card The card as a string to remove
     * @param suit The suit as a string to remove
     */
    public Card removeCard(String card, String suit) {
        for (int i = 0; i < myDeck.size(); i++) {
            if (myDeck.get(i).toString().equals(card) && myDeck.get(i).getSuit().equals(suit)) {
                return myDeck.remove(i);
            }
        }
        return null;
    }

    /**
     * Removes a card from the deck based on its position
     * @param cardNum The card to remove (first, second, etc)
     */
    public Card removeCard(int cardNum){
        cardNum -=1;
        if (cardNum >= 0 && cardNum < myDeck.size()){
            return myDeck.remove(cardNum);
        }else {
            throw new Error("Card does not exist");
        }
    }

    /**
     * Removes a random card from the deck
     * @return A Card object
     */
    public Card removeRandom(){
        Random rand = new Random();
        if (myDeck.size() > 0){
            return myDeck.remove(rand.nextInt(myDeck.size()));
        }else{
            throw new Error("Deck is empty");
        }
    }

    /**
     * @return A true boolean if aces are high
     */
    public boolean isAceHigh(){
        return acesHigh;
    }

    /**
     * Sets ace high or low
     * @param acesHigh True for high, false for low
     */
    public void setAcesHigh(boolean acesHigh){
        this.acesHigh = acesHigh;
    }

    /**
     * Returns a simple string to visualize deck
     * @return String of cards
     */
    public String toString(){
        String temp = "";

        if (myDeck.size() == 0){
            throw new Error("Deck is empty. Needs to be shuffled");
        }else{
            for (int i = 0; i < myDeck.size(); i++){
                temp += myDeck.get(i) + " ";
            }
        }
        return temp;
    }

    /**
     * Gets the number of current player hands
     * @return number of player hands
     */
    public int getNumberOfHands(){
        return hands.size();
    }

    public void setAceValue(int aceValue){
        this.aceValue = aceValue;
    }

    public int getAceValue(){
        return aceValue;
    }

    public void setJackValue(int jackValue){
        this.jackValue = jackValue;
    }

    public int getJackValue(){
        return jackValue;
    }

    public void setQueenValue(int queenValue){
        this.queenValue = queenValue;
    }

    public int getQueenValue(){
        return queenValue;
    }

    public void setKingValue(int kingValue){
        this.kingValue = kingValue;
    }

    public int getKingValue(){return kingValue;}

    /**
     * A card with a face value and suit
     */
    private class Card {
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

    /**
     * A players hand of cards
     */
    private class PlayerHand {
        private ArrayList<Card> hand;

        /**
         * Constructs a PlayerHand
         */
        public PlayerHand(){
            hand = new ArrayList<Card>();
        }

        /**
         * Checking if a certain card (no matter suit) is in the hand
         * @param card A card as string
         * @return True if card is in hand, false otherwise
         */
        public boolean contains(String card){
            for (int i = 0; i < hand.size(); i++){
                if (hand.get(i).equals(card)){
                    return true;
                }
            }
            return false;
        }

        /**
         * Checking if a certain card (suit included) is in the hand
         * @param card A card as string
         * @param suit A suit as string
         * @return True if card is in hand, false otherwise
         */
        public boolean contains(String card, String suit){
            for (int i = 0; i < hand.size(); i++){
                if (hand.get(i).equals(card) && hand.get(i).getSuit().equals(suit)){
                    return true;
                }
            }
            return false;
        }

        /**
         * Adds a card to the players hand
         * @param card A Card object
         */
        public void add(Card card) {
            hand.add(card);
        }

        /**
         * Adds a card to the players hand
         * @param pos The position to add it at (Ex. 1)
         * @param card The card to add
         */
        public void add(int pos, Card card){
            pos-=1;
            hand.add(pos, card);
        }

        /**
         * Adds a card to the front of the hand
         * @param card The card to add
         */
        public void addFirst(Card card) {
            hand.add(0, card);
        }

        /**
         * Removes ALL cards of a certain value (no matter suit)
         * @param card A card as a string
         * @return A Card object
         */
        public Card remove(String card){
            for (int i = 0; i < hand.size(); i++){
                if (hand.get(i).toString().equals(card)){
                    return hand.remove(i);
                }
            }
            return null;
        }

        /**
         * Removes a certain card (suit included)
         * @param card A card as string
         * @param suit A suit as string
         * @return
         */
        public Card remove(String card, String suit){
            for (int i = 0; i < hand.size(); i++){
                if (hand.get(i).equals(card) && hand.get(i).getSuit().equals(suit)){
                    return hand.remove(i);
                }
            }
            return null;
        }

        /**
         * Removes a random card from the hand
         * @return A Card object
         */
        public Card removeRandom(){
            Random rand = new Random();
            if (hand.size() > 0){
                return hand.remove(rand.nextInt(hand.size()));
            }else{
                throw new Error("No cards in hand");
            }
        }

        /**
         * Removes a card from the hand based on position
         * @param pos Position of card in hand
         * @return
         */
        public Card remove(int pos){
            pos -= 1;
            return hand.remove(pos);
        }

        /**
         * Gets the size of the hand
         * @return Size of hand as integer
         */
        public int getSize(){
            return hand.size();
        }

        /**
         * Gets a card from the hand based on position
         * @param pos Position of card in hand
         * @return
         */
        public Card get(int pos, boolean remove){
            if (remove){
                pos -=1;
                return hand.remove(pos);
            }else{
                pos -=1;
                return hand.get(pos);
            }
        }

        public Card get(int pos){
            pos-=1;
            return hand.get(pos);
        }

        public Card getNext(boolean remove){
            if (remove){
                return hand.remove(0);
            }else{
                return hand.get(0);
            }
        }

        /**
         * Returns a simple string to visualize hand
         * @return String of cards
         */
        public String toString(){
            String string = "";

            for (int i = 0; i < hand.size(); i++){
                string += hand.get(i) + " ";
            }

            return string;
        }

        /**
         * Clears player hand
         */
        public void clear(){
            hand.clear();
        }
    }
}