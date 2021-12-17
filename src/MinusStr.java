public class MinusStr {
    public static String minus(String str1, String str2){

        boolean cb = str1.contains(str2);
        if (cb) {
            int a = str1.length() - str2.length();
            return str1.substring(0, a);
        } else {
            return str1;
        }
    }
}
