package it.polimi.ingsw.server.model.commonGoalCards;

import it.polimi.ingsw.server.model.Game;
import it.polimi.ingsw.server.model.Shelf;
import it.polimi.ingsw.server.model.tiles.Tile;
import it.polimi.ingsw.server.model.tiles.TileType;
import org.junit.Assert;
import org.junit.Test;

public class CommonGoalCard_4Test {
    @Test
    public void four_5() {
        int[][] matrix = new int[][]{
                {0, 5, 5, 6, 0},
                {5, 5, 5, 5, 0},
                {3, 3, 3, 0, 1},
                {5, 0, 2, 2, 1},
                {5, 0, 2, 2, 3},
                {0, 3, 3, 2, 0}
        };
        CommonGoalCard_4 goal = new CommonGoalCard_4(4);
        Shelf s = convert_to_shelf(matrix);

        int points;
        points = goal.check_objective(s);
        Assert.assertEquals(8, points);
        points = goal.check_objective(s);
        Assert.assertEquals(0, points);
    }

    @Test
    public void six_5() {
        int[][] matrix = new int[][]{
                {0, 5, 5, 5, 0},
                {5, 5, 5, 5, 0},
                {3, 3, 3, 0, 1},
                {5, 0, 1, 0, 1},
                {5, 0, 0, 2, 3},
                {0, 3, 3, 2, 0}
        };
        CommonGoalCard_4 goal = new CommonGoalCard_4(4);
        Shelf s = convert_to_shelf(matrix);

        int points;
        points = goal.check_objective(s);
        Assert.assertEquals(8, points);
        points = goal.check_objective(s);
        Assert.assertEquals(0, points);
    }

    @Test
    public void four_0() {
        int[][] matrix = new int[][]{
                {0, 5, 5, 6, 0},
                {5, 5, 5, 5, 0},
                {3, 3, 3, 0, 1},
                {5, 0, 0, 0, 1},
                {5, 0, 0, 2, 3},
                {0, 3, 3, 2, 0}
        };
        CommonGoalCard_4 goal = new CommonGoalCard_4(4);
        Shelf s = convert_to_shelf(matrix);

        int points;
        for (int i = 8; i >= 0; i -= 2) {
            points = goal.check_objective(s);
            Assert.assertEquals(0, points);
        }
    }

    Shelf convert_to_shelf(int[][] matrix) {
        Shelf s = new Shelf("Test");
        Tile[][] slots = new Tile[Game.SHELF_ROWS][Game.SHELF_COLS];

        for (int i = 0; i < Game.SHELF_ROWS; i++) {
            for (int j = 0; j < Game.SHELF_COLS; j++) {
                slots[i][j] = new Tile(TileType.toEnum(matrix[i][j] + 1));
            }
        }

        s.setMatrix(slots);

        return s;
    }
}