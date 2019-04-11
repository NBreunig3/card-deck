package DeckOfCards;
import java.util.*;

/**
 * A standard deck of playing cards with various useful methods
 * @author Nathan Breunig
 * @version 1.03
 */
public class Deck implements Iterable<Card>{
    private ArrayList<Card> myDeck = new ArrayList<Card>();
    private ArrayList<PlayerHand> hands = new ArrayList<PlayerHand>();
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
        jokerValue = 0;
        heartValue = 1;
        spadeValue = 2;
        clubValue = 3;
        diamondValue = 4;
        jackValue = 11;
        queenValue = 12;
        kingValue = 13;

        if (highAce){
            aceValue = 14;
        }else{
            aceValue = 1;
        }
        reset();
    }

    /**
     * Alternate constructor that sets the value of the Ace and face cards
     * @param jokers Add two jokers to the deck
     */
    public Deck(boolean jokers, int aceValue, int jackValue, int queenValue, int kingValue) {
        useJokers = jokers;
        jokerValue = 0;
        heartValue = 1;
        spadeValue = 2;
        clubValue = 3;
        diamondValue = 4;
        this.aceValue = aceValue;
        this.jackValue = jackValue;
        this.queenValue = queenValue;
        this.kingValue = kingValue;

        reset();
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
        jokerValue = 0;
        jackValue = 11;
        queenValue = 12;
        kingValue = 13;

        if (highAce) {
            aceValue = 14;
        } else {
            aceValue = 1;
        }
        reset();
    }

    /**
     * An Iterator for the Deck
     */
    private class Iterator implements java.util.Iterator<Card> {
        private int currentIndex = -1;

        @Override
        public boolean hasNext() {
            return currentIndex < myDeck.size() - 1;
        }

        @Override
        public Card next() {
            if (!hasNext()){
                throw new NoSuchElementException("");
            }
            currentIndex++;
            return myDeck.get(currentIndex);
        }
    }

    /**
     * Method to get the Deck iterator
     * @return an iterator
     */
    public Iterator iterator(){
        return new Iterator();
    }

    /**
     * Sorts the deck based on each cards value
     */
    public void sort(){
        Collections.sort(myDeck);
    }

    public boolean isEmpty(){
        return myDeck.isEmpty();
    }

    /**
     * Resets the deck back to the standard 52-cards and clears all PlayerHands
     */
    public void reset(){
        myDeck.clear();
        hands.clear();

        myDeck.add(new Card(this,"2", "Club"));
        myDeck.add(new Card(this,"2", "Diamond"));
        myDeck.add(new Card(this,"2", "Heart"));
        myDeck.add(new Card(this,"2", "Spade"));

        myDeck.add(new Card(this,"3", "Club"));
        myDeck.add(new Card(this,"3", "Diamond"));
        myDeck.add(new Card(this,"3", "Heart"));
        myDeck.add(new Card(this,"3", "Spade"));

        myDeck.add(new Card(this,"4", "Club"));
        myDeck.add(new Card(this,"4", "Diamond"));
        myDeck.add(new Card(this,"4", "Heart"));
        myDeck.add(new Card(this,"4", "Spade"));

        myDeck.add(new Card(this,"5", "Club"));
        myDeck.add(new Card(this,"5", "Diamond"));
        myDeck.add(new Card(this,"5", "Heart"));
        myDeck.add(new Card(this,"5", "Spade"));

        myDeck.add(new Card(this,"6", "Club"));
        myDeck.add(new Card(this,"6", "Diamond"));
        myDeck.add(new Card(this,"6", "Heart"));
        myDeck.add(new Card(this,"6", "Spade"));

        myDeck.add(new Card(this,"7", "Club"));
        myDeck.add(new Card(this,"7", "Diamond"));
        myDeck.add(new Card(this,"7", "Heart"));
        myDeck.add(new Card(this,"7", "Spade"));

        myDeck.add(new Card(this,"8", "Club"));
        myDeck.add(new Card(this,"8", "Diamond"));
        myDeck.add(new Card(this,"8", "Heart"));
        myDeck.add(new Card(this,"8", "Spade"));

        myDeck.add(new Card(this,"9", "Club"));
        myDeck.add(new Card(this,"9", "Diamond"));
        myDeck.add(new Card(this,"9", "Heart"));
        myDeck.add(new Card(this,"9", "Spade"));

        myDeck.add(new Card(this,"10", "Club"));
        myDeck.add(new Card(this,"10", "Diamond"));
        myDeck.add(new Card(this,"10", "Heart"));
        myDeck.add(new Card(this,"10", "Spade"));

        myDeck.add(new Card(this,"Jack", "Club"));
        myDeck.add(new Card(this,"Jack", "Diamond"));
        myDeck.add(new Card(this,"Jack", "Heart"));
        myDeck.add(new Card(this,"Jack", "Spade"));

        myDeck.add(new Card(this,"Queen", "Club"));
        myDeck.add(new Card(this,"Queen", "Diamond"));
        myDeck.add(new Card(this,"Queen", "Heart"));
        myDeck.add(new Card(this,"Queen", "Spade"));

        myDeck.add(new Card(this,"King", "Club"));
        myDeck.add(new Card(this,"King", "Diamond"));
        myDeck.add(new Card(this,"King", "Heart"));
        myDeck.add(new Card(this,"King", "Spade"));

        myDeck.add(new Card(this,"Ace", "Club"));
        myDeck.add(new Card(this,"Ace", "Diamond"));
        myDeck.add(new Card(this,"Ace", "Heart"));
        myDeck.add(new Card(this,"Ace", "Spade"));

        if (useJokers){
            myDeck.add(new Card(this, "Joker", ""));
            myDeck.add(new Card(this, "Joker", ""));
        }
        sort();
    }

    /**
     * Will shuffle/scramble the order of cards in the deck
     */
    public void shuffle() {
        int randNum = 0;
        Random rand = new Random();

        for (int i = 0; i < myDeck.size(); i++){
            randNum = rand.nextInt(myDeck.size());
            //Swap
            Card crd1 = myDeck.get(randNum);
            Card crd2 = myDeck.get(i);
            myDeck.set(i, crd1);
            myDeck.set(randNum, crd2);
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
     * Sets a given index to a card
     * @param index index to set
     * @param card card to place at said index
     */
    public void set(int index, Card card){
       if (index >= 0 && index < size()){
           myDeck.set(index, card);
       }else {
           throw new IndexOutOfBoundsException(index + " is out of bounds. ");
       }
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
     * @param index The index in which to insert the card at
     * @param card The card to add
     */
    public boolean add(int index, Card card){
        if (index >= 0 && index < myDeck.size()){
            myDeck.add(index, card);
            return true;
        }
        return false;
    }

    /**
     * Adds a card to the beginning of the deck
     * @param card The card to add
     */
    public void addFirst(Card card){
        myDeck.add(0, card);
    }

    /**
     * Adds all cards from a PlayerHand
     * @param playerHand A PlayerHand object
     * @return true if anything was added
     */
    public boolean addAll(PlayerHand playerHand){
        if (playerHand.isEmpty()){
            return false;
        }
        for (Card c : playerHand){
            myDeck.add(c);
        }
        return true;
    }

    /**
     * Adds all cards from an ArrayList of Cards
     * @param arr an ArrayList
     * @return true if anything was added
     */
    public boolean addAll(List<Card> arr){
        if (arr.isEmpty()){
            return false;
        }
        for (Card c : arr){
            myDeck.add(c);
        }
        return true;
    }

    /**
     * Adds all cards from an ArrayList of Cards
     * @param arr an ArrayList
     * @return true if anything was added
     */
    public boolean addAllHands(List<PlayerHand> arr){
        if (arr.isEmpty()){
            return false;
        }
        for (PlayerHand p : arr){
            for (Card c : p){
                myDeck.add(c);
            }
        }
        return true;
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
     * @return A card object
     */
    public Card getNext() {
        if (myDeck.size() != 0) {
            return myDeck.get(0);
        } else {
            throw new Error("Can't pull more cards than there are in the deck");
        }
    }

    /**
     * Gets a card from the deck at a certain position
     * @param index The index to remove at
     * @return A card object
     */
    public Card get(int index){
        if (index < myDeck.size() && index >= 0){
            return myDeck.get(index);
        }
        throw new IndexOutOfBoundsException("Index out of bounds" + index);
    }

    /**
     * Looks to see if a certain suit is still in the deck
     * @param suit A suit as a string. Ex. "Heart", "Club", "Spade", "Diamond".
     * @return True if said suit is in deck
     */
    public boolean containsSuit(String suit){
        for (int i = 0; i < myDeck.size(); i++){
            if (myDeck.get(i).suit().equals(suit)){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks to see if a certain card is in the deck
     * @param card Card object
     * @param suitMatters If true, both the rank and suit of the card will have to match to return true
     * @return true if the deck contains said card
     */
    public boolean contains(Card card, boolean suitMatters){
        if (suitMatters){
            for (int i = 0; i < myDeck.size(); i++){
                if (myDeck.get(i).equals(card)){
                    return true;
                }
            }
            return false;
        }else {
            for (int i = 0; i < myDeck.size(); i++){
                if (myDeck.get(i).nameOfCard().equals(card.nameOfCard())){
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Gets the number of cards in the deck
     * @return Number of cards in deck
     */
    public int size(){
        return myDeck.size();
    }

    /**
     * Counts how many times a card appears in the deck. (Suit doesn't matter)
     * @param card Card object to remove (Suit doesn't matter)
     * @return The frequency of a certain card in the deck
     */
    public int cardFrequency(Card card){
        int counter = 0;
        for(int i = 0; i < myDeck.size(); i++){
            if (myDeck.get(i).nameOfCard().equals(card.nameOfCard())){
                counter++;
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
    public ArrayList<PlayerHand> deal(boolean alternating, int numOfPlayers, int numOfCards) {
        hands.clear();
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
        return hands;
    }

    /**
     * Deals out all remaining cards in the deck, even if the players will have uneven amounts
     * @param players Number of players to deal to
     */
    public ArrayList<PlayerHand> dealAll(int players){
        hands.clear();
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
        return hands;
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
     * Gets an ArrayList of all current PlayerHands
     * @return an ArrayList of all PlayerHands
     */
    public ArrayList<PlayerHand> getPlayerHands(){
        return hands;
    }

    /**
     * Clears all players hands
     */
    public void clearPlayerHands(){
        hands.clear();
    }
    
    /**
    * Removes all of the cards from deck
    */
    public void clear(){
        myDeck.clear();
    }

    /**
     * Removes the first card from the deck
     * @return The card burned
     */
    public boolean burnCard(){
        if (!myDeck.isEmpty()){
            myDeck.remove(0);
            return true;
        }
        return false;
    }

    /**
     * Removes the next X number of cards from the front of the deck (index 0)
     * @param numOfCards How many cards to remove
     */
    public void removeMore(int numOfCards){
        if (numOfCards <= myDeck.size() && numOfCards > 0){
            for (int i = 0; i < numOfCards; i++){
                myDeck.remove(0);
            }
        }
    }

    /**
     * Removes a certain card from the deck
     * @param card The card to remove
     * @return True if a card was removed
     */
    public boolean remove(Card card, boolean suitMatters){
        if (suitMatters){
            for (int i = 0; i < myDeck.size(); i++){
                if (myDeck.get(i).equals(card)){
                    myDeck.remove(i);
                    return true;
                }
            }
            return false;
        }else {
            boolean removed = false;
            int toRemove = cardFrequency(card);
            while (toRemove > 0){
                for (int i = 0; i < myDeck.size(); i++){
                    if (myDeck.get(i).nameOfCard().equals(card.nameOfCard())){
                        myDeck.remove(i);
                        removed = true;
                        break;
                    }
                }
                toRemove--;
            }
            return removed;
        }
    }

    /**
     * Removes a card from the deck based on its position
     * @param index Index of card to remove
     */
    public Card remove(int index){
        if (index >= 0 && index < myDeck.size()){
            return myDeck.remove(index);
        }else {
            throw new NoSuchElementException("Card does not exist");
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
    public void setAceHigh(boolean acesHigh){
        this.acesHigh = acesHigh;
    }

    /**
     * Returns a simple string to visualize deck
     * @return String of cards
     */
    public String toString(){
        String temp = "[";
        for (int i = 0; i < myDeck.size(); i++){
            if (i == myDeck.size() - 1){
                temp += myDeck.get(i).nameOfCard() + "]";
            }else {
                temp += myDeck.get(i).nameOfCard() + ", ";
            }
        }
        return temp;
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Deck)){
            return false;
        }else {
            Deck other = (Deck)o;
            if (myDeck.equals(other.myDeck)){
                return true;
            }else{
                return false;
            }
        }
    }

    /**
     * Gets the number of current player hands
     * @return number of player hands
     */
    public int getNumberOfHands(){
        return hands.size();
    }

    /**
     * Sets the integer value for the ace card. Default value is 1
     * @param aceValue integer value
     */
    public void setAceValue(int aceValue){
        this.aceValue = aceValue;
    }

    /**
     * Gets the value of the ace card
     * @return integer value
     */
    public int getAceValue(){
        return aceValue;
    }

    /**
     * Sets the integer value for the jack card. Default value is 11
     * @param jackValue integer value
     */
    public void setJackValue(int jackValue){
        this.jackValue = jackValue;
    }

    /**
     * Gets the value of the jack card
     * @return integer value
     */
    public int getJackValue(){
        return jackValue;
    }

    /**
     * Sets the integer value of the queen car
     * @param queenValue integer value
     */
    public void setQueenValue(int queenValue){
        this.queenValue = queenValue;
    }

    /**
     * Gets the value of the queen card
     * @return integer value
     */
    public int getQueenValue(){
        return queenValue;
    }

    /**
     * Sets the value of the king card
     * @param kingValue integer value
     */
    public void setKingValue(int kingValue){
        this.kingValue = kingValue;
    }

    /**
     * Gets the value of the king card
     * @return integer value
     */
    public int getKingValue(){return kingValue;}
}