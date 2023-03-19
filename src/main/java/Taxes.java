import java.util.Scanner;

public class Taxes {
    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarnings(int earnings) {
        int tax = (earnings) * 6 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static String text(int a, int b) {
        return ("Ваш налог составит:" + a + " рублей" + "\n" +
                "Налог на другой системе:" + b + " рублей" + "\n" +
                "Экономия:" + (b - a) + " рублей");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;
        int spendings = 0;
        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1 Добавить новые доходы");
            System.out.println("2 Добавить новые расходы");
            System.out.println("3 Выбрать систему налогооблажения");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расходов:");
                    String moneySp = scanner.nextLine();
                    int expenses = Integer.parseInt(moneySp);
                    spendings += expenses;
                    break;
                case 3:
                    int taxEMS = taxEarningsMinusSpendings(earnings, spendings);
                    int taxE = taxEarnings(earnings);
                    if (taxEMS > taxE) {
                        System.out.println("Мы советуем вам УСН доходы - налог 6% от доходов;");
                        System.out.println(text(taxE, taxEMS));
                    } else {
                        System.out.println("Мы советуем вам УСН доходы минус расходы - налог 15% от разницы доходов и расходов.");
                        System.out.println(text(taxEMS, taxE));
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
        System.out.println("Программа завершена!");
    }
}
