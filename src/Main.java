import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your ID");
        int userId = scanner.nextInt();
        System.out.println("1. Get balance.\n2. Take money.\n3. Put money.");
        SomeAction action = new SomeAction();
        switch (scanner.nextInt()) {
            case 1: action.getBalance(userId);
            break;
            case 2:
                int takeSum = scanner.nextInt();
                action.takeMoney(userId, takeSum);
            break;
            case 3:
                int putSum = scanner.nextInt();
                action.putMoney(userId, putSum);
            break;
            default: break;
        }
    }
}
