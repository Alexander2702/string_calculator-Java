public class LogicStrAndNum {

    static String result;

    public static void calcExp(String firstStr, String operation, int number){
        switch (operation) {
            case "*" -> result = Multiplication.mult(firstStr, number);
            case "/" -> {
                try{
                    result = Division.divis(firstStr, number);
                }catch (ArithmeticException e){
                    System.out.println("деление на ноль запрещено!!!");
                    return;
                }
            }
            default -> throw new IllegalArgumentException("Не верный знак операции");
        }
        if (result.length() > 40) {
            String rez = result.substring(0, 40);
            System.out.println("\""+rez+ "..."+"\"");
        }else {
            System.out.println("\""+result+"\"");
        }
    }
}
