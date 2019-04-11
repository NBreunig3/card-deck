# card-deck
A Java library used to simulate a 52 card playing deck by Nathan Breunig.
### Features
  - Basic shuffling/removing/adding
  - Dealing
  - Various Customization: Joker use, editing of suit tie breaker values, ace high or low, and changing values of face cards
  - Generic methods used in data structures: contains, frequency, sort, toString, clear, etc. 
  - Much more!
## Version 1.03
### Additions/Changes: 
  - Deck no longer sorts on instantiation
  - Added "equals(Object)"" method to Card
  - Added "set(int, Card)" method to Deck
  - Added "equals(Object)" method to Deck
  - Card "toString()" method has changed behavior. Ex. "4 of Hearts"
  - Changed Card's "abbreviation()" method to "nameOfCard()"
  - Removed a variety of "contains(String)" and "remove(String)" methods to force use of type "contains(Card)" for example.
  - Some Card method signatures have been changed. New Signature: "value()" and "suitValue()"
  - Added a reset method for Deck. (See code comments)
  - Added an "addAllHands()" method to add all cards in all player hands back into the deck
  - "removeRandom()" now returns a Card object
  - Miscellaneous method signature changes
  
### Download
JAR File: [v1.03](http://bit.ly/2Z1NG6h)