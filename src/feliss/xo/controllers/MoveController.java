package feliss.xo.controllers;

import feliss.xo.model.Field;
import feliss.xo.model.Figure;
import feliss.xo.model.exceptions.AlreadyOccupiedException;
import feliss.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field,
                            final Figure figure,
                            final Point point) throws AlreadyOccupiedException, InvalidPointException {

        if (field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }

        field.setFigure(point, figure);
    }

}
