import java.util.*;

abstract class Delivery {
    protected final double weight, distance;
    Delivery(double weight, double distance) { this.weight = weight; this.distance = distance; }
    public abstract double fee();
    public abstract String type();
}
class StandardDelivery extends Delivery {
    StandardDelivery(double w, double d) { super(w, d); }
    public double fee() { return 5 + 0.50 * weight + 0.10 * distance; }
    public String type() { return "STANDARD"; }
}
class ExpressDelivery extends Delivery {
    ExpressDelivery(double w, double d) { super(w, d); }
    public double fee() { return 15 + 1.00 * weight + 0.20 * distance; }
    public String type() { return "EXPRESS"; }
}
class InternationalDelivery extends Delivery {
    private final double customsFee;
    InternationalDelivery(double w, double d, double c) { super(w, d); customsFee = c; }
    public double fee() { return 25 + 2.00 * weight + 0.50 * distance + customsFee; }
    public String type() { return "INTERNATIONAL"; }
}
public class Problem3DeliveryFeeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Delivery> deliveries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            double w = Double.parseDouble(p[1]), d = Double.parseDouble(p[2]);
            switch (p[0]) {
                case "STANDARD": deliveries.add(new StandardDelivery(w, d)); break;
                case "EXPRESS": deliveries.add(new ExpressDelivery(w, d)); break;
                case "INTERNATIONAL": deliveries.add(new InternationalDelivery(w, d, Double.parseDouble(p[3]))); break;
                default: throw new IllegalArgumentException("Unknown delivery type: " + p[0]);
            }
        }
        double total = 0;
        for (Delivery d : deliveries) {
            double fee = d.fee();
            total += fee;
            System.out.printf("%s: %.2f%n", d.type(), fee);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
