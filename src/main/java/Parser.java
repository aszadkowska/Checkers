/**
 * Created by Fabian on 13.06.2017.
 */
public class Parser {

    private static int size = 8;

    static String parse(String init, String move){
        int[][] initPosition = getMatrix(init);
        int[][] movePosition = getMatrix(move);
        displayMatrix(initPosition);
        System.out.printf("\n");
        displayMatrix(movePosition);

        int normalMove = countChecker(initPosition, movePosition);
        if (normalMove == 0){
            return  normalMove(initPosition, movePosition);
        } else {
            return fightMove(initPosition, movePosition, normalMove);
        }
    }

    private static String normalMove(int[][] init, int[][] move){
        String firstPos = "";
        String secoundPos = "";

        for (int c = 0; c < size; c++) {
            for (int r = 0; r < size; r++) {
                if (init[r][c] != move[r][c]){
                    if (init[r][c] == 0 && move[r][c] == 1){
                        secoundPos = getPosition(r,c);
                    } else if (init[r][c] == 0 && move[r][c] == 2) {
                        secoundPos = getPosition(r, c);
                    } else if (init[r][c] == 1 && move[r][c] == 0){
                        firstPos = getPosition(r,c);
                    } else if (init[r][c] == 2 && move[r][c] == 0) {
                        firstPos = getPosition(r,c);
                    }
                }
            }
        }
        return firstPos + ":" + secoundPos;
    }

    private static String fightMove(int[][] init, int[][] move, int win){
        String firstPos = "";
        String secoundPos = "";

        for (int c = 0; c < size; c++) {
            for (int r = 0; r < size; r++) {
                if (init[r][c] != move[r][c] && init[r][c] == win || move[r][c] == win ) {
                    if (init[r][c] == 0 && move[r][c] == 1) {
                        secoundPos = getPosition(r, c);
                    } else if (init[r][c] == 0 && move[r][c] == 2) {
                        secoundPos = getPosition(r, c);
                    } else if (init[r][c] == 1 && move[r][c] == 0) {
                        firstPos = getPosition(r, c);
                    } else if (init[r][c] == 2 && move[r][c] == 0) {
                        firstPos = getPosition(r, c);
                    }
                }
            }
        }
        return firstPos + ":" + secoundPos;
    }

    private static int[][] getMatrix(String positions){

        int[][] tab = new int[8][8];
        int i = 0;
        String[] splited = positions.split(",");

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                tab[r][c] = Integer.parseInt(splited[i]);
                i++;
            }
        }

        return tab;
    }

    private static int countChecker(int[][] init, int[][] move){
        int white = 0;
        int black = 0;

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (init[c][r] == 1)
                    white += 1;
                if (init[c][r] == 2)
                    black += 1;
                if (move[c][r] == 1)
                    white += 1;
                if (move[c][r] == 2)
                    black += 1;
            }
        }

        return white == black ? 0 : white > black ? 1 : 2;
    }

    private static void displayMatrix(int[][] tab) {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                System.out.print(String.valueOf(tab[r][c]) + " ");
            }
            System.out.println();
        }
    }

    private static String getPosition(int row, int col){
        String pos = "";
        switch (col){
            case 0:
                pos = "a";
                break;
            case 1:
                pos = "b";
                break;
            case 2:
                pos = "c";
                break;
            case 3:
                pos = "d";
                break;
            case 4:
                pos = "e";
                break;
            case 5:
                pos = "f";
                break;
            case 6:
                pos = "g";
                break;
            case 7:
                pos = "h";
                break;
            default:
                pos = "a";
                break;
        }

        pos += String.valueOf(8-row);
        return pos;
    }
}
