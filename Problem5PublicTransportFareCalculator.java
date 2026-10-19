import java.util.*;

abstract class Transport {
    protected final double distance;
    Transport(double distance) { this.distance = distance; }
    public abstract double fare();
    public abstract String type();
}
class Bus extends Transport {
    Bus(double distance) { super(distance); }
    public double fare() { return Math.min(2 + 0.10 * distance, 10); }
    public String type() { return "BUS"; }
}
class Train extends Transport {
    Train(double distance) { super(distance); }
    public double fare() { return 3 + 0.15 * distance; }
    public String type() { return "TRAIN"; }
}
class Metro extends Transport {
    private final double peakHourFactor;
    Metro(double distance, double factor) { super(distance); peakHourFactor = factor; }
    public double fare() { return (1.50 + 0.20 * distance) * peakHourFactor; }
    public String type() { return "METRO"; }
}
public class Problem5PublicTransportFareCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Transport> journeys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            double distance = Double.parseDouble(p[1]);
            switch (p[0]) {
                case "BUS": journeys.add(new Bus(distance)); break;
                case "TRAIN": journeys.add(new Train(distance)); break;
                case "METRO": journeys.add(new Metro(distance, Double.parseDouble(p[2]))); break;
                default: throw new IllegalArgumentException("Unknown transport type: " + p[0]);
            }
        }
        double total = 0;
        for (Transport t : journeys) {
            double fare = t.fare();
            total += fare;
            System.out.printf("%s: %.2f%n", t.type(), fare);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
