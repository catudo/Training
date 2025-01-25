
public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board, String word, int x, int y, int index) {
        if (index == word.length()) {
            return true;
        }


        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(index)) {
            return false;
        }

        char temp = board[x][y];
        board[x][y] = '*';

        boolean found = dfs(board, word, x + 1, y, index + 1) ||
                dfs(board, word, x - 1, y, index + 1) ||
                dfs(board, word, x, y + 1, index + 1) ||
                dfs(board, word, x, y - 1, index + 1);

        board[x][y] = temp;

        return found;
    }


    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(WordSearch.exist(board, word));

        System.out.println(WordSearch.exist(board, "SEE"));
    }

}
