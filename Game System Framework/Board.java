package GameSystemFramework;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int height, width;
    private List<ArrayList<Tile>> tiles;

    public Board(int height, int width) {
        this.height = height;
        this.width = width;
        initializeTiles(height, width);
    }

    public void initializeTiles(int height, int width) {
        tiles = new ArrayList<>(width);
        for (int i = 0; i < width; i++) {
            tiles.add(new ArrayList<>(height));
            for (int j = 0; j < height; j++) (tiles.get(i)).add(new Tile());
        }
    }

    public Object getTile(int x, int y) {
        return tiles.get(x - 1).get(y - 1);
    }

    public void addUnits(Unit unit, int x, int y) {
        Tile tile = tiles.get(x - 1).get(y - 1);
        tile.addUnit(unit);

    }

    public void removeUnits(Unit unit, int x, int y) {
        Tile tile = tiles.get(x - 1).get(y - 1);
        tile.removeUnit(unit);
    }

    public List<Unit> getUnits(int x, int y) {
        return tiles.get(x - 1).get(y - 1).getUnits();
    }


}
