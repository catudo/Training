import javax.xml.transform.Source;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        String cleanString = s.replaceAll("[^A-Za-z]", "").replaceAll(" ", "").toLowerCase();
        char[] chars = cleanString.toCharArray();
        String reversedString = "";
        for (int i = chars.length-1; i >= 0; i--) {
            reversedString = reversedString + chars[i];
        }

        if (reversedString.toLowerCase().equals(cleanString) && cleanString.length() > 1) {
            return true;
        }

        return false;
    }






    public static void main(String[] args) {
        System.out.println(ValidPalindrome.isPalindrome("ab2a"));
    }

}
