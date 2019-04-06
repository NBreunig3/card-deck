# card-deck
A Java library used to simulate a 52 card playing deck by Nathan Breunig.
## Version 1.03
### Changes in progress
  - Deck no longer sorts on instantiation
  - Added equals method for the Card object
  - Added "set(int, Card)" method to deck
  - Card "toString()" method has changed behavior. Ex. "4 of Hearts"
  - Added an "abbreviation()" method to Card
  - Removed a variety of "contains(String)" and "remove(String)" methods to force use of type "contains(Card)" for example.
  - Some Card method signatures have been changed. ("value()", and "suitValue()")
  - Added a reset method for Deck. (See javadoc)
  - Added an "addAllHands()" method to add all cards in all player hands back into the deck
  - "removeRandom()" now returns a Card object
  - Miscellaneous method signature changes
