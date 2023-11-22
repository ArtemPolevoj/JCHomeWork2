package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '*';
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static char[][] field;
    private static final int fieldSize = 5;
    private static final int WIN_COUNT = 4;

    public static void main(String[] args) {

        Finish finish = new Finish();
        Ai ai = new Ai(finish, DOT_HUMAN, DOT_EMPTY, DOT_AI, WIN_COUNT);

        System.out.println("-----КРЕСТИКИ НОЛИКИ-----");
        do {
            System.out.print("Введите уровень игры (l - легкий, h - тяжёлый): ");
            String level = scanner.next();
            initialize();
            printField();
            while (true) {
                System.out.println("Ваш ход");
                humanTurn();
                printField();
                if (finish.checkWin(field, DOT_HUMAN, WIN_COUNT)) {
                    System.out.println("Вы победили!");
                    break;
                }
                if (finish.checkDraw(field, DOT_EMPTY)) {
                    System.out.println("Ничья");
                    break;
                }

                System.out.println("Ход компьютера");
                if (level.equals("l")) {
                    aiTurn();
                } else {
                    field = ai.getRun(field);
                }
                printField();
                if (finish.checkWin(field, DOT_AI, WIN_COUNT)) {
                    System.out.println("Победил компьютер!");
                    break;
                }
                if (finish.checkDraw(field, DOT_EMPTY)) {
                    System.out.println("Ничья");
                    break;
                }
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
        } while (scanner.next().equalsIgnoreCase("Y"));
    }

    /**
     * Инициализация игрового поля
     */
    static void initialize() {
        field = new char[fieldSize][fieldSize];
        for (int y = 0; y < fieldSize; y++) {
            for (int x = 0; x < fieldSize; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    /**
     * Печать текущего состояния игрового поля
     */
    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSize; i++) {
            System.out.print("-" + (i + 1));
        }
        System.out.println("-x");

        for (int y = 0; y < fieldSize; y++) {
            System.out.print(y + 1 + "|");
            for (int x = 0; x < fieldSize; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < fieldSize * 2 + 2; i++) {
            if (i == 0) {
                System.out.print(("y"));
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
    }

    /**
     * Ход игрока (человека)
     */
    static void humanTurn() {
        int x;
        int y;
        do {
            System.out.print("Введите координаты хода X и Y (от 1 до 3)\nчерез пробел: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while (!isCellValid(x, y) || isCellEmpty(x, y));
        field[y][x] = DOT_HUMAN;
    }

    /**
     * Ход игрока (компьютера)
     */
    static void aiTurn() {
        int x;
        int y;
        do {
            x = random.nextInt(fieldSize);
            y = random.nextInt(fieldSize);
        }
        while (isCellEmpty(x, y));
        field[y][x] = DOT_AI;
    }

    /**
     * Проверка, является ли ячейка игрового поля пустой
     *
     * @param x координата x
     * @param y координата y
     * @return результат проверки
     */
    static boolean isCellEmpty(int x, int y) {
        return field[y][x] != DOT_EMPTY;
    }

    /**
     * Проверка доступности ячейки игрового поля
     *
     * @param x координата x
     * @param y координата y
     * @return результат проверки
     */
    static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSize && y >= 0 && y < fieldSize;
    }
}