package DeckOfCards;

import java.util.ArrayList;
import java.util.Random;

/**
 * A players hand of cards
 * @author Nathan Breunig
 *
 */
public class PlayerHand {
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
    public void add(int pos,Card card){
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
