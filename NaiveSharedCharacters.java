public class NaiveSharedCharacters implements Calculation {

    @Override
    public double similarity(String s1, String s2) {
        int matches = 0;

        for (char c : s1.toCharArray()) {
            if (s2.indexOf(c) != -1) {
                matches++;
            }
        }

        int maxLength = Math.max(s1.length(), s2.length());
        return  ((double) matches / maxLength) * 100;
    }
}
