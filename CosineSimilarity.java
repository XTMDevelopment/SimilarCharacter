import java.util.HashMap;
import java.util.Map;

public class CosineSimilarity implements Calculation {

    @Override
    public double similarity(String s1, String s2) {
        Map<Character, Integer> freq1 = getFrequencyMap(s1);
        Map<Character, Integer> freq2 = getFrequencyMap(s2);

        double dotProduct = 0;
        double magnitude1 = 0;
        double magnitude2 = 0;

        for (char key : freq1.keySet()) {
            int freqInStr1 = freq1.getOrDefault(key, 0);
            int freqInStr2 = freq2.getOrDefault(key, 0);

            dotProduct += freqInStr1 * freqInStr2;
            magnitude1 += freqInStr1 * freqInStr1;
        }

        for (int freq : freq2.values()) {
            magnitude2 += freq * freq;
        }

        return (dotProduct / (Math.sqrt(magnitude1) * Math.sqrt(magnitude2))) * 100;
    }

    private Map<Character, Integer> getFrequencyMap(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : str.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        return freqMap;
    }
}
