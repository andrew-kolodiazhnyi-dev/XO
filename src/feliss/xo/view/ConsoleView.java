package feliss.xo.view;

import feliss.xo.controllers.CurrentMoveController;
import feliss.xo.controllers.MoveController;
import feliss.xo.controllers.WinnerController;
import feliss.xo.model.Field;
import feliss.xo.model.Figure;
import feliss.xo.model.Game;
import feliss.xo.model.exceptions.AlreadyOccupiedException;
import feliss.xo.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final WinnerController winnerController = new WinnerController();

    private final MoveController moveController = new MoveController();

    public void show(final Game game) {
        System.out.format("Game name: %s\n", game.getName());
        final Field field = game.getField();
        for (int i = 0; i < field.getSize(); i++) {
            if (i != 0) {
                printSeparator();
            }
            printLine(field, i);
        }
    }


    public boolean move(final Game game) {
        final Field field = game.getField();

        final Figure winner = winnerController.getWinner(field);
        if (winner != null) {
            System.out.println();
            System.out.format("Winner is: %s\n", winner);
            return false;
        }
        final Figure currentFigure = currentMoveController.currentMove(field);
        if (currentFigure == null) {
            System.out.println();
            System.out.println("No winner");
            return false;
        }
        System.out.format("Please enter move point for: %s\n", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(field, currentFigure, point);
        } catch (AlreadyOccupiedException | InvalidPointException e) {
            System.out.println("Point is invalid");
        }
        return true;
    }

    private Point askPoint() {
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    private int askCoordinate(final String cordinateName) {
        System.out.format("Please input %s:", cordinateName);
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (final InputMismatchException e) {
            System.out.println("ololo");
            return askCoordinate(cordinateName);
        }

    }

    private void printLine(final Field field, final int i) {
        for (int j = 0; j < field.getSize(); j++) {
            if (j != 0) {
                System.out.print("|");
            }
            System.out.print(" ");
            final Figure figure;
            try {
                figure = field.getFigure(new Point(j, i));
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
        }
        System.out.println();
    }

    private void printSeparator() {
        System.out.println("~~~~~~~~");
    }

}
