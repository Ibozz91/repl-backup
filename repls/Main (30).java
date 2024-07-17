import java.io.*;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) throws IOException {
    FileWriter WileFriter = new FileWriter("nqueens.txt");
    WileFriter.write("");
    System.out.println(nQueens(new ArrayList<Integer[]>(), 8, WileFriter));
  }

  public static int nQueens(ArrayList<Integer[]> pieces, int n, FileWriter fw) throws IOException {
    int increment = 0;
    for (int i = 0; i < n; i++) {
      boolean b = true;
      for (int ii = 0; ii < pieces.size(); ii++) {
        if (intersects(pieces.get(ii), new Integer[] { i, pieces.size() })) {
          b = false;
        }
      }
      if (b) {
        if (pieces.size() == n - 1) {
          String[][] board = new String[n][n];
          for (int iii = 0; iii < n; iii++) {
            for (int iv = 0; iv < n; iv++) {
              board[iii][iv] = "_";
            }
          }
          for (int v = 0; v < pieces.size(); v++) {
            board[pieces.get(v)[0]][pieces.get(v)[1]] = "Q";
          }
          board[i][n - 1] = "Q";
          for (String[] s : board) {
            for (String t : s) {
              fw.append(t + " ");
            }
            fw.append("\n");
          }
          fw.append("\n");
          return 1;
        } else {
          ArrayList<Integer[]> pieces2 = new ArrayList<Integer[]>();
          pieces2.addAll(pieces);
          pieces2.add(new Integer[] { i, pieces.size() });
          increment += nQueens(pieces2, n, fw);
        }
      }
    }
    return increment;
  }

  public static boolean intersects(Integer[] fromhere, Integer[] tohere) {
    // same x, dif y
    if (fromhere[0] == tohere[0] && fromhere[1] != tohere[1]) {
      return true;
    }
    // dif x, same y
    else if (fromhere[1] == tohere[1] && fromhere[0] != tohere[0]) {
      return true;
    }
    // same direction x and y
    else if (tohere[0] - fromhere[0] == tohere[1] - fromhere[1] && tohere[0] != fromhere[0]) {
      return true;
    }
    // x is the opposite direction as y
    else if (tohere[0] - fromhere[0] == fromhere[1] - tohere[1] && tohere[0] != fromhere[0]) {
      return true;
    }
    return false;
  }
}