import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSearchII {
    public static List<String> findWords(char[][] board, String[] words) {
        int rows = board.length;
        int cols = board[0].length;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < words.length; k++) {
                    if (dfs(board, words[k], i, j, 0)) {
                        res.add(words[k]);
                    }
                }

            }
        }

        return new HashSet<>(res).stream().toList();
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
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(WordSearchII.findWords(board, words));
    }

}
