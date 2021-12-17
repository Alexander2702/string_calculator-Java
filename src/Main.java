import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static int number;
    static String operation;
    static String firstString;
    static String secondString;
    static String variableNum;

    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("Введите выражение [\"a\" + \"b\", \"a\" - \"b\", \"a\" * x, \"a\" / x] \n" +
                    "где a и b - строки выделенные двойными кавычками, x - число  от 1 до 10 включительно. Enter.\n" +
                    "Пробелы перед и после знаком операции обязательны!");

            String input = scan.nextLine();
            // ловим знак в переданной строке
                if (input.contains("+")) {
                    operation = "+";
                } else if (input.contains("-")) {
                    operation = "-";
                } else if (input.contains("*")) {
                    operation = "*";
                } else if (input.contains("/")) {
                    operation = "/";
                }else {
                    System.out.println("Вы ввели арифметическую операцию не отвечающую условию. Введите + - * /" );
                    return;
                }

            // делим строку на массив, разделитель \"
            String[] inputStr = input.split("[\"]");
            // присваиваем значения переменным строчным
            if (inputStr.length >= 4) {
                try{
                    firstString = inputStr[1];
                    secondString = inputStr[3];
                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Ошибка! Все слова должны быть в ковычках!");
                    return;
                }
                if (firstString.length() > 0 && firstString.length() <= 10 && secondString.length() > 0 && secondString.length() <= 10) {
                    // метод который выполняет сложение или вычитание
                    LogicStr.calcExp(firstString, operation, secondString);
                } else {
                    System.out.println("Вы ввели слишком длинное слово. Введите строки длинной не более 10 символов.");
                    return;
                }
                // если длина массива меньше 4, то переменные String и int
            } else {
                try {
                    firstString = inputStr[1];
                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Ошибка! Все слова должны быть в ковычках!");
                    return;
                }
                // проверка на ввод.
                try{
                    // в строке variableNum убираем лишние символы, оставляем только цифры 0-9
                    variableNum = inputStr[2].replaceAll("[^0-9]", "");
                    number = Integer.parseInt(variableNum);
                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Ошибка! ВВедите сначало слово в кавычках!");
                    return;
                }catch (NumberFormatException n){
                    System.out.println("неверный формат. Смотрите условие");
                    return;
                }

                if (number >= 0 && number <= 10 && firstString.length() > 0 && firstString.length() <= 10) {
                    //метод который выполняет умножение и деление
                    LogicStrAndNum.calcExp(firstString, operation, number);
                } else {
                    System.out.println("Вы ввели слишком большое число или слово. Введите число от 0 до 10 включительно,\n" +
                            "Введите строки длинной не более 10 символов. ");
                    return;
                }
            }
        }
    }
}