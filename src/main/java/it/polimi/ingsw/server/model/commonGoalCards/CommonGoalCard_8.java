package it.polimi.ingsw.server.model.commonGoalCards;

import it.polimi.ingsw.server.model.Game;
import it.polimi.ingsw.server.model.Shelf;
import it.polimi.ingsw.server.model.tiles.TileType;

import java.util.Arrays;

public class CommonGoalCard_8 extends CommonGoalCard {
    public CommonGoalCard_8(int nPlayers) {
        super(nPlayers);
        id = 8;
        this.description = "Four lines each formed by 5 tiles of " +
                "maximum three different types. One " +
                "line can show the same or a different " +
                "combination of another line.";
    }

    @Override
    public int check_objective(Shelf s) {
        int lines, cont;
        boolean[] present;

        lines = 0;
        present = new boolean[Game.N_TYPES + 1];

        for (int i = 0; i < s.N_ROWS; i++) {
            cont = 0;

            Arrays.fill(present, false);

            for (int j = 0; j < s.N_COLS; j++) {
                if (!present[s.getTile(i, j).type.value()]) {
                    present[s.getTile(i, j).type.value()] = true;
                    cont++;
                }
            }

            if (cont <= 3 && !present[TileType.EMPTY.value()]) {
                lines++;
            }
        }

        if (lines >= 4) {
            return addPoints(s.owner);
        }
        return 0;
    }

}
