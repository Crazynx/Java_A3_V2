# Java_A3_V2
Newer and better version of the original JavA3 project. It's more object-oriented and easier to read. I have made version 2 because I was bored and wasn't happy with my experience with OOP.
![Comparison in meme format](https://i.imgur.com/dfQy39e.jpg)

# Original
The assignment is about making a 4x4 card game with OOP. The rules are simple:
- Match 2 cards
- Win the game
- Retry?

# Behind the scenes
I created the following classes:
- Game: Class that takes care of creating all the needed objects. You create an object from this class, get the scene and set it to your primaryStage. You also have to adjust a few things, such as the title, width and height etc.

- StatManager: Class that contains the reset button and score label. This class has methods like incrementScore and resetScore. Useful for controlling the score.

- CardManager: Class that takes care of the creation of cards and has methods used for initializing and resetting the game.

- Card: Class that extends the JavaFX button. Basically a JavaFX button with the option to assign a value to it. Also has methods like turnCard (used to turn the card), setUnturnable (used after the card is matched with another card).

# Changelog
- Easier to read
- Used more OOP
- Better methods
