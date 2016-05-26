package feliss.xo;

import feliss.xo.model.Field;
import feliss.xo.model.Figure;
import feliss.xo.model.Game;
import feliss.xo.model.Player;
import feliss.xo.view.ConsoleView;

public class XOCLI {

    public static void main(String[] args) {
        final String name1 = "Andrey";
        final String name2 = "Lucy";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game gameXO = new Game(players, new Field(3), "XO");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXO);
        while (consoleView.move(gameXO)){
            consoleView.show(gameXO);
        }
    }
}
