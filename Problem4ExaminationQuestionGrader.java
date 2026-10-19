import java.util.*;

abstract class ExamQuestion {
    protected final String text, correct, student;
    protected final double points;
    ExamQuestion(String text, String correct, String student, double points) {
        this.text = text; this.correct = correct; this.student = student; this.points = points;
    }
    public abstract double score();
    public abstract String type();
}
class MCQQuestion extends ExamQuestion {
    MCQQuestion(String t, String c, String s, double p) { super(t,c,s,p); }
    public double score() { return student.equals(correct) ? points : 0; }
    public String type() { return "MCQ"; }
}
class TrueFalseQuestion extends ExamQuestion {
    TrueFalseQuestion(String t, String c, String s, double p) { super(t,c,s,p); }
    public double score() { return student.equals(correct) ? points : 0; }
    public String type() { return "TF"; }
}
class EssayQuestion extends ExamQuestion {
    EssayQuestion(String t, String c, String s, double p) { super(t,c,s,p); }
    public double score() {
        String answer = student.toLowerCase(Locale.ROOT);
        int found = 0;
        for (String keyword : correct.split(",")) {
            String k = keyword.trim().toLowerCase(Locale.ROOT);
            if (!k.isEmpty() && answer.contains(k)) found++;
        }
        if (found >= 2) return points * 0.75;
        if (found == 1) return points * 0.50;
        return 0;
    }
    public String type() { return "ESSAY"; }
}
public class Problem4ExaminationQuestionGrader {
    // Parses whitespace-separated tokens while preserving text inside double quotes.
    private static List<String> parse(String line) {
        List<String> out = new ArrayList<>();
        java.util.regex.Matcher m = java.util.regex.Pattern.compile("\"([^\"]*)\"|(\\S+)").matcher(line);
        while (m.find()) out.add(m.group(1) != null ? m.group(1) : m.group(2));
        return out;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<ExamQuestion> questions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> p = parse(sc.nextLine().trim());
            String type = p.get(0), text = p.get(1), correct = p.get(2), student = p.get(3);
            double points = Double.parseDouble(p.get(4));
            switch (type) {
                case "MCQ": questions.add(new MCQQuestion(text, correct, student, points)); break;
                case "TF": questions.add(new TrueFalseQuestion(text, correct, student, points)); break;
                case "ESSAY": questions.add(new EssayQuestion(text, correct, student, points)); break;
                default: throw new IllegalArgumentException("Unknown question type: " + type);
            }
        }
        double total = 0;
        for (ExamQuestion q : questions) {
            double score = q.score();
            total += score;
            System.out.printf("%s: %.2f%n", q.type(), score);
        }
        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}
