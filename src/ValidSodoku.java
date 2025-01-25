import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidSodoku {

    public static boolean isValidSudoku(char[][] board) {

        boolean valid = false;

        valid = validSubBoard(board,false);
        if (valid) {
            for (int i = 0; i < board.length; i=i+3) {
                for (int j = 0; j < board[0].length; j=j+3) {
                    valid = validSubBoard(createSubmatrix(board,i,j,3,3), true);
                    if (!valid) {
                        return false;
                    }

                }
            }


        }



        return valid;

    }

    public static char[][] createSubmatrix(char[][] original, int startRow, int startCol, int rows, int cols) {
        return Arrays.stream(original, startRow, startRow + rows)
                .map(row -> Arrays.copyOfRange(row, startCol, startCol + cols))
                .toArray(char[][]::new);
    }

    public static boolean validSubBoard(char[][] board, boolean isSubMatrix) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> columns = new ArrayList<>();
        List<Integer> subMatrixNumbers = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char charRow = board[i][j];
                char charColumn = board[j][i];

                if (charRow != '.') {
                    int row = Integer.parseInt(String.valueOf(charRow));
                    if (!rows.contains(row)) {
                        rows.add(row);
                        if (isSubMatrix && !subMatrixNumbers.contains(row)) {
                            subMatrixNumbers.add(row);

                        } else if (isSubMatrix && subMatrixNumbers.contains(row)) {
                            return false;
                        }


                    } else {
                        return false;
                    }

                }

                if (charColumn != '.') {
                    int column = Integer.parseInt(String.valueOf(charColumn));
                    if (!columns.contains(column)) {
                        columns.add(column);
                    } else {
                        return false;
                    }

                }

                if (j == board[i].length - 1) {
                    columns.clear();
                    rows.clear();
                }




            }
        }


        return true;
    }

    public static void main(String[] args) {
        System.out.println(ValidSodoku.isValidSudoku(new char[][]{
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}
        }));
    }


}
