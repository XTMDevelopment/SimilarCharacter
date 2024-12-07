public class JaroWinklerSimilarity implements Calculation {

    @Override
    public double similarity(String s1, String s2) {
        double jaro = jaroSimilarity(s1, s2);
        int prefixLength = commonPrefixLength(s1, s2, 4);
        return (jaro + (0.1 * prefixLength * (1 - jaro))) * 100;
    }

    private double jaroSimilarity(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();

        if (s1Len == 0 && s2Len == 0) return 1;

        int matchDistance = Math.max(s1Len, s2Len) / 2 - 1;

        boolean[] s1Matches = new boolean[s1Len];
        boolean[] s2Matches = new boolean[s2Len];

        int matches = 0;
        for (int i = 0; i < s1Len; i++) {
            int start = Math.max(0, i - matchDistance);
            int end = Math.min(i + matchDistance + 1, s2Len);

            for (int j = start; j < end; j++) {
                if (s2Matches[j]) continue;
                if (s1.charAt(i) != s2.charAt(j)) continue;
                s1Matches[i] = true;
                s2Matches[j] = true;
                matches++;
                break;
            }
        }

        if (matches == 0) return 0;

        int transpositions = 0;
        int k = 0;
        for (int i = 0; i < s1Len; i++) {
            if (!s1Matches[i]) continue;
            while (!s2Matches[k]) k++;
            if (s1.charAt(i) != s2.charAt(k)) transpositions++;
            k++;
        }

        transpositions /= 2;

        return ((double) matches / s1Len + (double) matches / s2Len +
                (double) (matches - transpositions) / matches) / 3;
    }

    private int commonPrefixLength(String s1, String s2, int maxPrefixLength) {
        int n = Math.min(Math.min(s1.length(), s2.length()), maxPrefixLength);
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return i;
            }
        }
        return n;
    }
}
