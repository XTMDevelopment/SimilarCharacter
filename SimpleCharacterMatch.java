public class SimpleCharacterMatch implements Calculation {

    @Override
    public double similarity(String s1, String s2) {
        int matches = 0;
        int minLength = Math.min(s1.length(), s2.length());

        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                matches++;
            }
        }

        int maxLength = Math.max(s1.length(), s2.length());
        return  ((double) matches / maxLength) * 100;
    }
}
