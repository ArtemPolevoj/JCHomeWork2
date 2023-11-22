package org.example;

public class Finish {
    public boolean checkWin(char[][] field, char dot, int winCount) {
        int temp;
        int fieldSize = field.length;

        if (winCount < 1 || winCount > fieldSize) {
            return false;
        }

        // Проверка по горизонталям

        for (char[] chars : field) {
            temp = 1;
            for (int x = 1; x < fieldSize; x++) {
                if (chars[x - 1] == chars[x] && chars[x] == dot) {
                    temp++;
                }
            }
            if (temp == winCount) return true;
        }

        // Проверка по вертикалям

        for (int x = 0; x < fieldSize; x++) {
            temp = 1;
            for (int y = 1; y < fieldSize; y++) {
                if (field[y - 1][x] == field[y][x] && field[y][x] == dot) {
                    temp++;
                }
            }
            if (temp == winCount) return true;
        }

        // Проверка по диагоналям слева сверху направо вниз

        for (int k = 0; k <= (fieldSize - winCount); k++) {
            temp = 1;
            for (int y = k + 1, x = 1; y < fieldSize; y++, x++) {
                if (field[y - 1][x - 1] == field[y][x] && field[y][x] == dot) {
                    temp++;
                }
            }
            if (temp == winCount) return true;
        }
        // Чтобы снова не проверять главную диагональ
        // начинаем с 1

        for (int k = 1; k <= (fieldSize - winCount); k++) {
            temp = 1;
            for (int y = 1, x = k + 1; x < fieldSize; y++, x++) {
                if (field[y - 1][x - 1] == field[y][x] && field[y][x] == dot) {
                    temp++;
                }
            }
            if (temp == winCount) return true;
        }

        // Проверка по диагоналям справа сверху налево вниз
        for (int i = 0; i <= (fieldSize - winCount); i++) {
            temp = 1;
            for (int y = i + 1, x = fieldSize - 1; y < fieldSize; y++, x--) {
                if (field[y - 1][x] == field[y][x - 1] && field[y][x - 1] == dot) {
                    temp++;
                }
            }
            if (temp == winCount) return true;
        }

        // Чтобы снова не проверять главную диагональ
        // начинаем с 1

        for (int i = 1; i <= (fieldSize - winCount); i++) {
            temp = 1;
            for (int y = 1, x = fieldSize - 1 - i; x > 0; y++, x--) {
                if (field[y - 1][x] == field[y][x - 1] && field[y][x - 1] == dot) {
                    temp++;
                }
            }
            if (temp == winCount) return true;
        }
        return false;
    }

    public boolean checkDraw(char[][] field, char dot) {
        for (char[] chars : field) {
            for (int x = 0; x < field.length; x++) {
                if (chars[x] == dot)
                    return false;
            }
        }
        return true;
    }
}
