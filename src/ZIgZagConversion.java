public class ZIgZagConversion {

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder response = new StringBuilder();

        for (int row = 0; row < numRows; row++) {
            int increment = 2 * (numRows - 1);
            for (int i = row; i < s.length(); i += increment) {
                response.append(s.charAt(i));
                if (row > 0 && row < numRows - 1 && i + increment - 2 * row < s.length()) {
                    response.append(s.charAt(i + increment - 2 * row));
                }
            }
        }

        return response.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }
}
