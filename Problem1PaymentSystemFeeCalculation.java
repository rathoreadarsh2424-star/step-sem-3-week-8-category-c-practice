import java.util.*;

abstract class Payment {
    protected final double amount;
    Payment(double amount) { this.amount = amount; }
    public abstract double finalAmount();
    public abstract String type();
}
class CardPayment extends Payment {
    CardPayment(double amount) { super(amount); }
    public double finalAmount() { return amount * 1.02; }
    public String type() { return "CARD"; }
}
class WalletPayment extends Payment {
    WalletPayment(double amount) { super(amount); }
    public double finalAmount() { return amount * 1.01; }
    public String type() { return "WALLET"; }
}
class BankTransferPayment extends Payment {
    BankTransferPayment(double amount) { super(amount); }
    public double finalAmount() { return amount; }
    public String type() { return "BANKTRANSFER"; }
}
public class Problem1PaymentSystemFeeCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Payment> payments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            double amount = Double.parseDouble(p[1]);
            switch (p[0]) {
                case "CARD": payments.add(new CardPayment(amount)); break;
                case "WALLET": payments.add(new WalletPayment(amount)); break;
                case "BANKTRANSFER": payments.add(new BankTransferPayment(amount)); break;
                default: throw new IllegalArgumentException("Unknown payment type: " + p[0]);
            }
        }
        double total = 0;
        for (Payment p : payments) {
            double adjusted = p.finalAmount();
            total += adjusted;
            System.out.printf("%s: %.2f%n", p.type(), adjusted);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
