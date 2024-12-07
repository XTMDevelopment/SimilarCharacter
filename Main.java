import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Calculation> list = new ArrayList<>();
        list.add(new StupidSimilarity());
        list.add(new SimpleCharacterMatch());
        list.add(new NaiveSharedCharacters());

        list.add(new LongestCommonSubsequence());
        list.add(new JaccardSimilarity());
        list.add(new CosineSimilarity());
        list.add(new JaroWinklerSimilarity());

        String str1 = "Indonesian Developer";
        String str2 = "Indonesain deevloper";

        System.out.printf("\"%s\" / \"%s\"%n", str1, str2);
        for (Calculation calculation : list) {
            System.out.printf("%s: %.2f%n", calculation.getClass().getName(), calculation.similarity(str1, str2));
        }
    }
}
