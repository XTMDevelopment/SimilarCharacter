import java.util.Objects;

public class StupidSimilarity implements Calculation {

    @Override
    public double similarity(String s1, String s2) {
        if (Objects.equals(s1, s2)) {
            return 100.0;
        }
        return 0.0;
    }
}
