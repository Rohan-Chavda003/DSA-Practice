package arrayandhashing;

import java.util.HashSet;

public class IsValidSudoku {
    /*
    idea : track values for each types row, col , box for box if you cant think its formula
            think why is this used i/3 * 3 + j/ 3
            How to track - 1) use boolean[ current row or col or box ][current value] diff for each one
                            2) use array of sets of char
     */

    public boolean isValidSudokuArr(char[][] board) {
        boolean[][] vertical = new boolean[9][9];
        boolean[][] horizontal = new boolean[9][9];
        boolean[][] box = new boolean[9][9];
        for(int i = 0 ; i< board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                int currNum = board[i][j] -'0' -1;
                int currBox = (i/3) *3 + (j/3);
                if(board[i][j] != '.'){
                    if(horizontal[i][currNum] == false)
                        horizontal[i][currNum] = true;
                    else
                        return false;

                    if(vertical[j][currNum] == false)
                        vertical[j][currNum] = true;
                    else
                        return false;

                    if(box[currBox][currNum] == false)
                        box[currBox][currNum] = true;
                    else
                        return false;

                }

            }
        }
        return true;
    }


    public boolean isValidSudokuSet(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    continue;
                }

                char value = board[r][c];
                int boxIndex = (r / 3) * 3 + (c / 3);

                if (rows[r].contains(value) || cols[c].contains(value) || boxes[boxIndex].contains(value)) {
                    return false;
                }

                rows[r].add(value);
                cols[c].add(value);
                boxes[boxIndex].add(value);
            }
        }

        return true;
    }
}
