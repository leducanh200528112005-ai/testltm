package code.generated;

import java.util.*;

public class WS_CharacterService_UdWFoW6q {
    static int countVowels(String w) {
        int c = 0;
        for (char ch : w.toLowerCase().toCharArray())
            if ("aeiou".indexOf(ch) >= 0) c++;
        return c;
    }
    public static void main(String[] args) {
        String studentCode = "B23DCCN025";
        String qCode = "UdWFoW6q";

        try {
            SoapCharacterService port = new CharacterService().getSoapCharacterServicePort();
            List<String> words = port.requestStringArray(studentCode, qCode);
            System.out.println("Data: " + words);

            Map<Integer, List<String>> byVowels = new TreeMap<>(Comparator.reverseOrder());
            for (String w : words)
                byVowels.computeIfAbsent(countVowels(w), k -> new ArrayList<>()).add(w);

            List<String> result = new ArrayList<>();
            for (List<String> g : byVowels.values()) {
                Collections.sort(g);
                result.add(String.join(",", g));
            }
            System.out.println("Result: " + result);

            port.submitCharacterStringArray(studentCode, qCode, result);
            System.out.println("Submitted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
