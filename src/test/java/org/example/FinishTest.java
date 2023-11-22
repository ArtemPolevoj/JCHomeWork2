package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinishTest {
    char[][] field;
    int fieldSize = 5;
    int winCount = 4;

    @BeforeEach
    void setField() {
        int shift = 88; // для получения корректного символа
        field = new char[fieldSize][fieldSize];
        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field.length; x++) {
                field[y][x] = (char) ((y + x) + shift);
            }
        }
    }

    @Test
    void checkWinHorizontalTrue() {
        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field.length; x++) {
                if (y == field.length - 1) {
                    field[y][x] = 't';
                }
            }
        }
        assertTrue(new Finish().checkWin(field, 't', fieldSize));
    }

    @Test
    void checkWinVerticalTrue() {
        for (int x = 0; x < field.length; x++) {
            for (int y = 0; y < field.length; y++) {
                if (x == field.length - 1) {
                    field[y][x] = 't';
                }
            }
        }
        assertTrue(new Finish().checkWin(field, 't', fieldSize));
    }

    @Test
    void checkWinDiagonalLeftTrue() {
        for (int y = 0, x = 0; y < field.length; y++, x++) {
            field[y][x] = 't';
        }
        assertTrue(new Finish().checkWin(field, 't', fieldSize));
    }

    @Test
    void checkWinDiagonalRightTrue() {
        for (int y = 0, x = field.length - 1; y < field.length; y++, x--) {
            field[y][x] = 't';
        }
        assertTrue(new Finish().checkWin(field, 't', fieldSize));
    }

    @Test
    void checkWinFalse() {
        for (int x = 0; x < field.length; x++) {
            for (int y = 0; y < field.length; y++) {
                if (y < field.length - 1 && x < field.length - 1) {
                    field[y][x] = 't';
                } else if (x == field.length - 1 && y != field.length - 1) {
                    field[y][x] = 'x';
                } else if (y == field.length - 1 && x % 2 == 0) {
                    field[y][x] = 'z';
                } else {
                    field[y][x] = 'k';
                }
            }
        }
        field[0][field.length - 2] = 'x';
        field[0][field.length - 1] = 't';
        assertFalse(new Finish().checkWin(field, 't', fieldSize));
    }

    @Test
    void checkDrawTrue() {
        for (int x = 0; x < field.length; x++) {
            for (int y = 0; y < field.length; y++) {
                field[y][x] = 't';
            }
        }
        assertTrue(new Finish().checkDraw(field, '*'));
    }

    @Test
    void checkDrawFalse() {
        for (int x = 0; x < field.length; x++) {
            for (int y = 0; y < field.length; y++) {
                field[y][x] = 't';
            }
        }
        field[0][0] = '*';
        assertFalse(new Finish().checkDraw(field, '*'));
    }

    @Test
    void checkWinHorizontalCount_1True() {
        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field.length; x++) {
                if (y == field.length - 1 && x > 0) {
                    field[y][x] = 't';
                }
            }
        }
        assertTrue(new Finish().checkWin(field, 't', winCount));
    }

    @Test
    void checkWinVerticalCount_1True() {
        for (int x = 0; x < field.length; x++) {
            for (int y = 0; y < field.length; y++) {
                if (x == field.length - 1 && y > 0) {
                    field[y][x] = 't';
                }
            }
        }
        assertTrue(new Finish().checkWin(field, 't', winCount));
    }

    @Test
    void checkWinDiagonalLeftCount_1True() {
        for (int y = 0, x = 0; y < field.length; y++, x++) {
            if (y > 0) {
                field[y][x] = 't';
            }
        }
        assertTrue(new Finish().checkWin(field, 't', winCount));
    }

    @Test
    void checkWinDiagonalRightCount_1True() {
        for (int y = 0, x = field.length - 1; y < field.length; y++, x--) {
            if (y > 0) {
                field[y][x] = 't';
            }
        }
        assertTrue(new Finish().checkWin(field, 't', winCount));
    }

    @Test
    void checkWinDiagonalLeftY1True() {
        for (int y = 1, x = 0; y < field.length; y++, x++) {
            field[y][x] = 't';
        }
        assertTrue(new Finish().checkWin(field, 't', winCount));
    }

    @Test
    void checkWinDiagonalLeftX1True() {
        for (int y = 0, x = 1; x < field.length; y++, x++) {
            field[y][x] = 't';
        }
        assertTrue(new Finish().checkWin(field, 't', winCount));
    }

    @Test
    void checkWinDiagonalRightY_1True() {
        for (int y = 1, x = field.length - 1; y < field.length; y++, x--) {
            field[y][x] = 't';
        }
        assertTrue(new Finish().checkWin(field, 't', winCount));
    }

    @Test
    void checkWinDiagonalRightX_1True() {
        for (int y = 0, x = field.length - 2; x >= 0; y++, x--) {
            field[y][x] = 't';
        }
        assertTrue(new Finish().checkWin(field, 't', winCount));
    }
}