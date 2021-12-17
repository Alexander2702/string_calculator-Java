public class LogicStr {

    static String result;

    public static void calcExp(String firstStr1, String operation, String secondStr1) {

        switch (operation) {
            case "+" -> result = SummaStr.sum(firstStr1, secondStr1);
            case "-" -> result = MinusStr.minus(firstStr1, secondStr1);
            default -> throw new IllegalArgumentException("Не верный знак операции");
        }
            System.out.println("\"" + result + "\"");
    }
}