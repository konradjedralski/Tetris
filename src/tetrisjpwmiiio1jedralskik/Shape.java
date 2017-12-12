package tetrisjpwmiiio1jedralskik;

import java.util.Random;

public class Shape {

    enum Tetrominoes {
        NoShape, ZShape, SShape, LineShape, TShape, SquareShape, LShape, MirroredLShape
    };

    private Tetrominoes pieceShape;
    private int coords[][];
    private int[][][] coordsTable;

    public Shape() {
        coords = new int[4][2];
        setShape(Tetrominoes.NoShape);
    }

    public void setShape(Tetrominoes shape) {

        //Tablica wszystkich możliwości wartości współrzędnych kawałków Tetris
        //Jest to szablon, z którego wsyztskie elementy przyjmują wartości współrzędnych
        coordsTable = new int[][][]{
            {{0, 0}, {0, 0}, {0, 0}, {0, 0}},
            {{0, -1}, {0, 0}, {-1, 0}, {-1, 1}},
            {{0, -1}, {0, 0}, {1, 0}, {1, 1}},
            {{0, -1}, {0, 0}, {0, 1}, {0, 2}},
            {{-1, 0}, {0, 0}, {1, 0}, {0, 1}},
            {{0, 0}, {1, 0}, {0, 1}, {1, 1}},
            {{-1, -1}, {0, -1}, {0, 0}, {0, 1}},
            {{1, -1}, {0, -1}, {0, 0}, {0, 1}}
        };

        //Umieszczenie jednego wiersza współrzędnych wartości z cordsTable
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; ++j) {
                coords[i][j] = coordsTable[shape.ordinal()][i][j]; //Metoda ordinal() zwraca aktualną pozycję typu enum
            }
        }
        pieceShape = shape;
    }

    private void setX(int index, int x) {
        coords[index][0] = x;
    }

    private void setY(int index, int y) {
        coords[index][1] = y;
    }

    public int x(int index) {
        return coords[index][0];
    }

    public int y(int index) {
        return coords[index][1];
    }

    public Tetrominoes getShape() {
        return pieceShape;
    }

    //Losowanie kształtu, który ma zostać narysowany
    public void setRandomShape() {
        Random random = new Random();
        int x = Math.abs(random.nextInt()) % 7 + 1;
        Tetrominoes[] values = Tetrominoes.values();
        setShape(values[x]);
    }

    public int minX() {
        int min = coords[0][0];
        for (int i = 0; i < 4; i++) {
            min = Math.min(min, coords[i][0]);
        }
        return min;
    }

    public int minY() {
        int min = coords[0][1];
        for (int i = 0; i < 4; i++) {
            min = Math.min(min, coords[i][1]);
        }
        return min;
    }

    public Shape rotateLeft() {
        if (pieceShape == Tetrominoes.SquareShape) //Kwadrat nie musi być obracany
        {
            return this;
        }

        Shape result = new Shape();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; ++i) {
            result.setX(i, y(i));
            result.setY(i, -x(i));
        }
        return result;
    }

    public Shape rotateRight() {
        if (pieceShape == Tetrominoes.SquareShape) //Kwadrat nie musi być obracany
        {
            return this;
        }

        Shape result = new Shape();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; ++i) {
            result.setX(i, -y(i));
            result.setY(i, x(i));
        }
        return result;
    }

}
