package org.example;

public class Ai {
    private final Finish finish;
    private final char DOT_HUMAN;
    private final char DOT_EMPTY;
    private final char DOT_AI;
    private final  int winCount;

    public Ai(Finish finish, char dotHuman, char dotEmpty, char dotAi, int winCount) {
        this.finish = finish;
        DOT_HUMAN = dotHuman;
        DOT_EMPTY = dotEmpty;
        DOT_AI = dotAi;
        this.winCount = winCount;
    }

    public char[][] getRun(char[][] field){

        char[][] temp = field.clone();
        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field.length; x++) {
                if (field[y][x] == DOT_EMPTY){
                    field[y][x] = DOT_HUMAN;
                    if (finish.checkWin(field,DOT_HUMAN, winCount)){
                        temp[y][x] = DOT_AI;
                        return temp;
                    } else {
                        field[y][x] = DOT_EMPTY;
                    }
                }
            }
        }

        for (int y = 0; y < field.length; y++) {
            for (int x = 1; x < field.length; x++) {
                if (field[y][x - 1] == DOT_HUMAN && field[y][x] == DOT_EMPTY){
                    temp[y][x] = DOT_AI;
                    return temp;
                } else if (field[y][x] == DOT_EMPTY) {
                    temp[y][x] = DOT_AI;
                    return temp;
                }
            }
        }
        return temp;
    }
}
