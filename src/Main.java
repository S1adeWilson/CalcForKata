import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
            String task = scanner.nextLine();
            System.out.println(calc(task));

    }
    public static String calc(String task){
        String res = null;
        String[] taskArr;
        taskArr = task.split(" ");
        String firstNum = taskArr[0];
        String secondNum = taskArr[2];
        char operator = taskArr[1].charAt(0);

        //Проверка ввода, вызов операции вычисления
        if (Character.isDigit(firstNum.charAt(0)) && Character.isDigit(secondNum.charAt(0))){
            int a = Integer.parseInt(firstNum);
            int b = Integer.parseInt(secondNum);
            if (a>10 || b>10)
                throw new InputMismatchException("Неверный формат ввода");
            else res = String.valueOf((operations(a, b, operator)));
        }

        else if (Character.isLetter(firstNum.charAt(0)) && Character.isLetter(secondNum.charAt(0)))
            res=(arToRoman(operations(romToArabic(firstNum),romToArabic(secondNum),operator)));
        else throw new InputMismatchException("Неверный формат ввода данных");

        return res;
    }


    //Расчёт в арабских цифрах
    private static int operations(int first, int second,char operator) {
        int res = 0;
        switch (operator) {
            case '+' -> res = first + second;
            case '-' -> res = first - second;
            case '*' -> res = first * second;
            case '/' -> res = first/ second;
            default ->  throw new IllegalArgumentException("Неверный знак операции");

        }
        return res;
    }



    //Конвертация из римских в арабские.
    private static int romToArabic (String num) {

        String[] romanOneTen = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int resToArabic = 0;
        for (int i = 0; i < romanOneTen.length; i++) {
            if (num.equals(romanOneTen[i]))
                resToArabic = i;
        }
        if (resToArabic > 0)
            return resToArabic;
        else
            throw new InputMismatchException("Неверный формат ввода данных");

    }


    //Конвертация из арабских в римские для результата
    private static String arToRoman(int num){
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        if (num>0)
            return roman[num];
        else throw new InputMismatchException("Неверный формат ввода данных");
    }
}


