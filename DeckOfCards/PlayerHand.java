package DeckOfCards;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * A players hand of cards
 * @author Nathan Breunig
 *
 */
public class PlayerHand implements Iterable<Card>{
    private ArrayList<Card> hand;

    /**
     * Constructs a PlayerHand
     */
    public PlayerHand(){
        hand = new ArrayList<Card>();
    }

    /**
     * Checks to see if a certain card is in this PlayerHand
     * @param card Card to check if contained
     * @param suitMatters if true suits of cards must match, otherwise just rank
     * @return true if card is in the PlayerHand
     */
    public boolean contains(Card card, boolean suitMatters){
        if (suitMatters){
            for (Card c : hand){
                if (c.equals(card)){
                    return true;
                }
            }
            return false;
        }else {
            for (Card c : hand){
                if (c.abbreviation().equals(card.abbreviation())){
                    return true;
                }
            }
            return false;
        }
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
     * Removes a certain card from the deck
     * @param card Card to remove
     * @param suitMatters if true suits of cards must match, otherwise just rank
     * @return True if a card was removed
     */
    public boolean remove(Card card, boolean suitMatters){
        if (suitMatters){
            for (int i = 0; i < hand.size(); i++){
                if (hand.get(i).equals(card)){
                    hand.remove(i);
                    return true;
                }
            }
            return false;
        }else {
            boolean removed = false;
            for (int i = 0 ; i < hand.size(); i++){
                for (int j = 0; j < hand.size(); j++){
                    if (hand.get(j).abbreviation().equals(card.abbreviation())){
                        hand.remove(j);
                        removed = true;
                        break;
                    }
                }
            }
            return removed;
        }
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
        String string = "[";
        for (int i = 0; i < hand.size(); i++){
            if (i == hand.size() - 1){
                string += hand.get(i).abbreviation() + "]";
            }else {
                string += hand.get(i).abbreviation() + ", ";
            }
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
