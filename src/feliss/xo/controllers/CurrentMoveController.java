package feliss.xo.controllers;

import feliss.xo.model.Field;
import feliss.xo.model.Figure;
import feliss.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field) {
        int count = 0;
        for (int i = 0; i < field.getSize(); i++) {
            count += countFiguresInTheRow(field, i);
        }
        if (count == field.getSize() * field.getSize())
            return null;

        return (count % 2 == 0) ? Figure.X : Figure.O;
    }

    private int countFiguresInTheRow(final Field field, final int row) {
        int count = 0;
        for (int i = 0; i < field.getSize(); i++) {
            try {
                if (field.getFigure(new Point(i, row)) != null) {
                    count++;
                }
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

}
