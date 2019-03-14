# Battleship!!

This project was developed to show a simple implementation of the classic Battleship game. The
game is run in the console/terminal and each player takes turns shooting missiles where there they
think their opponents battleships are located. 

`Position of battleships` The position of each battleship is randomly selected and the start of each
game. The positions are placed on a 5x5 grid and for simplicity, a battleship takes only one spot
on the grid. A total of three battleships are placed on each players board. 

`Board Display` At the start of each turn, players are shown their current battle grid. If a player
has already attacked a poistion in the grid, it will display a "*" for a miss and a "X" for any
sunk battleship. Otherwise a "-" will be displayed to simulate open water/position.  

`Attack` Each player takes turns attacking their opponents battle grid. The game prompts the user
to enter the row & column for which they want to attack. If an attack was successful the console
will display a message stating the a battleship was hit and sunk. Otherwise, a miss message will
be displayed. After, the program switches to the other players turn.

`Victory` Once a player successfully destroys all three battleships, a victory message will be
displayed and the game will end. 


`DESIGN GOALS` This program utilizes the State Pattern.  The interface "GameState" sets the implementation
methods for concrete classes. The "GameStateContext" controls the flow of the game by creating instances
of the concrete "Player" and "Start" classes. Through this, simplicity is achieved in the "Main" class.
When the program runs, the main method it only needs to create one instance of the "GameStateContext", intialize the
start of the game, and use a while loop on the "shoot" method within it to run through the game. The
GameStateContext class seamlessly switches States between players after the game initializes. I also
added robustness to the code by adding InputMismatch Exceptions and ensuring that a players integer
input does not go out of the bounds of the grid. 


# How to compile the project

We use Apache Maven to compile and run this project. 

You need to install Apache Maven (https://maven.apache.org/)  on your system. 

Type on the command line: 

```bash
mvn clean compile
```

# How to create a binary runnable package 


```bash
mvn clean compile assembly:single
```


# How to run


```bash
java -classpath target/Example-1-1.0-SNAPSHOT-jar-with-dependencies.jar edu.bu.met.cs665.Main
```

or


```bash
run.sh 
```

# Using Findbugs 

To see bug detail using the Findbugs GUI, use the following command "mvn findbugs:gui"

Or you can create a XML report by using  


```bash
mvn findbugs:gui 
```

or 


```bash
mvn findbugs:findbugs
```

# Run Checkstyle 

CheckStyle code styling configuration files are in config/ directory. Maven checkstyle plugin is set to use google code style. 
You can change it to other styles like sun checkstyle. 

To analyze this example using CheckStyle run 

```bash
mvn checkstyle:check
```

This will generate a report in XML format


```bash
target/checkstyle-checker.xml
target/checkstyle-result.xml
```

and the following command will generate a report in HTML format that you can open it using a Web browser. 

```bash
mvn checkstyle:checkstyle
```

```bash
target/site/checkstyle.html
```
