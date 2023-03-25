import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин");
        String login = scanner.nextLine();
        if (!check(login)) {
            System.out.println("Можно использовать только латинские буквы, цифры и _");
            return;
        }

        System.out.println("Введите пароль");
        String password = scanner.nextLine();
        if (!check(password)) {
            System.out.println("Можно использовать только латинские буквы, цифры и _");
            return;
        }
        if (password.length() > 19) {
            System.out.println("Слишком длинный пароль-должно быть меньше 20 символов ");
            return;
        }
        System.out.println("Повторите пароль");
        String confirmPassword = scanner.nextLine();

        try {
            authentication(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Слишком длинный логин");
        } catch (WrongPasswordException e) {
            System.out.println("Пароли не совпадают");
        }


    }

    public static boolean check(String a) {
        for (int i = 0; i < a.length(); i++) {
            char b = a.charAt(i);
            if (b == '_' || b >= 'a' && b <= 'z' || b >= 'A' && b <= 'Z'||b>='0' && b<='9') {
                return true;
            }
        }
        return false;
    }

    public static void authentication(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {


        if (login.length() > 20) {
            throw new WrongLoginException();

        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }

    }
}