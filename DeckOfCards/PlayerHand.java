package DeckOfCards;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * A players hand of cards
 * @author Nathan Breunig
 *
 */
public class PlayerHand implements Iterable<Card> {
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

    public boolean contains(Card card){
        for (int i = 0; i < hand.size(); i++){
            if (hand.get(i) == (card)){
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
     * @param index The index to add it at
     * @param card The card to add
     */
    public void add(int index, Card card){
        hand.add(index, card);
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
    public boolean remove(String card){
        boolean removed = false;

        for (int i = 0; i < hand.size(); i++){
            if (hand.get(i).toString().equals(card)){
                hand.remove(i);
                removed = true;
            }
        }
        return removed;
    }

    /**
     * Removes a certain card from the deck
     * @param card Card to remove
     * @return True if a card was removed
     */
    public boolean remove(Card card){
        boolean removed = false;

        for (int i = 0; i < hand.size(); i++){
            if (hand.get(i) == card){
                hand.remove(i);
                removed = true;
            }
        }
        return removed;
    }

    /**
     * Removes a certain card (suit included)
     * @param card A card as string
     * @param suit A suit as string
     * @return
     */
    public boolean remove(String card, String suit){
        boolean removed = false;

        for (int i = 0; i < hand.size(); i++){
            if (hand.get(i).equals(card) && hand.get(i).getSuit().equals(suit)){
                hand.remove(i);
                removed = true;
            }
        }
        return removed;
    }

    /**
     * Removes a random card from the hand
     * @return A Card object
     */
    public boolean removeRandom(){
        Random rand = new Random();
        if (hand.size() > 0){
            hand.remove(rand.nextInt(hand.size()));
            return true;
        }else{
            return false;
        }
    }

    /**
     * Removes a card from the hand based on position
     * @param index Index of card in hand
     * @return
     */
    public Card remove(int index){
        if (index >= 0 && index < hand.size()){
            return hand.remove(index);
        }else{
            throw new IndexOutOfBoundsException("Card does not exist");
        }
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
     * @return Card
     */
    public Card get(int pos){
        pos -=1;
        return hand.get(pos);

    }

    /**
     * Gets the next card in a players ahnd
     * @return Next card
     */
    public Card getNext(){
        if (!hand.isEmpty()) {
            return hand.get(0);
        }
        throw new NoSuchElementException();
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

    /**
     * Checks if the hand is empty
     * @return true if empty
     */
    public boolean isEmpty(){
        return hand.isEmpty();
    }

    /**
     * Gets an iterator for PlayerHand
     * @return iterator
     */
    public Iterator iterator(){
        return new Iterator();
    }

    /**
     * An iterator for a PlayerHand
     */
    private class Iterator implements java.util.Iterator<Card> {
        private int currentIndex = -1;

        @Override
        public boolean hasNext() {
            return currentIndex < hand.size() - 1;
        }

        @Override
        public Card next() {
            if (!hasNext()){
                throw new NoSuchElementException("");
            }
            currentIndex++;
            return hand.get(currentIndex);
        }
    }
}
