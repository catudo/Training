import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SimplifyPath {

  public static String solution(String path) {
    Deque<String> stack = new LinkedList<>();
    Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
    for (String dir : path.split("/")) {
      if (dir.equals("..") && !stack.isEmpty()) stack.pop();
      else if (!skip.contains(dir)) stack.push(dir);
    }
    String res = "";
    for (String dir : stack) res = "/" + dir + res;
    return res.isEmpty() ? "/" : res;
  }

  public static void main(String[] args) {
    System.out.println(solution("/home/"));
    System.out.println(solution("/home//foo/"));
    System.out.println(solution("/home/user/Documents/../Pictures"));

  }

}
