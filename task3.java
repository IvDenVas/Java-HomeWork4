import java.util.Scanner;
import java.util.Stack;

public class task3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите выражение ипользуя положительные однозначные числа (пробелы не важны!):");
        String inputFromUser = scan.nextLine().replace(" ", "");
        System.out.println(infixToPostfix(inputFromUser));
        String otvet = infixToPostfix(inputFromUser);
        result(otvet);
        System.out.println("Хотите отменить последнее действие (оператор)? y - да: ");
        String inputFromUserAfetr = scan.nextLine();
        scan.close();
        if (inputFromUserAfetr.equals("y")) {
            String s = "";
            for (int i = 0; i < inputFromUser.toCharArray().length - 2; i++) {
                s += inputFromUser.toCharArray()[i];
            }
            result(infixToPostfix(s));
            System.out.println("Программа завершена.");
        } else {
            System.out.println("Программа завершена.");
        }
    }

    public static void result(String str) {
        var exp = str.split(" ");
        int res = 0;

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < exp.length; i++) {

            if (isDigit(exp[i])) {
                st.push(Integer.parseInt(exp[i]));
            } else {
                switch (exp[i]) {
                    case "+":
                        res = st.pop() + st.pop();
                        st.push(res);
                        break;
                    case "-":
                        res = -st.pop() + st.pop();
                        st.push(res);
                        break;
                    case "*":
                        res = st.pop() * st.pop();
                        st.push(res);
                        break;
                    case "/":
                        int x = st.pop();
                        int y = st.pop();
                        if (x == 0) {
                            System.out.println("На ноль делить нельзя!");
                        } else {
                            res = y / x;
                            st.push(res);
                            break;
                        }
                    default:
                        break;
                }
            }
        }
        System.out.print("Результат выражения равен: ");
        System.out.printf("%d\n", st.pop());
    }

    public static String infixToPostfix (String text) {
        Stack<String> stack = new Stack<>();
        String postfix = "";

        for (var i : text.split("")) {
            if (isDigit(i)) {
                postfix += Integer.parseInt(i);
                postfix += " ";
            } else {
                while (!stack.isEmpty() && prec(i) >= prec(stack.peek())) {
                    postfix += stack.pop();
                    postfix += " ";
                }
                stack.add(i);
            }
        }

        while (!stack.isEmpty()) {
            postfix += stack.pop();
            postfix += " ";
        }
        return postfix;
    }
    
    public static int prec(String string) {
        if (string == "*" || string == "/") {
            return 3;
        }
        if (string == "-" || string == "+") {
            return 4;
        }
        return Integer.MAX_VALUE;
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
