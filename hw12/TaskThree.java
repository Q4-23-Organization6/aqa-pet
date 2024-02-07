import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskThree {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("orange");
        words.add("Orange");
        words.add("red");
        words.add("white");
        words.add("blue");
        words.add("RED");
        words.add("blue");
        words.add("white");

        Map<String, Integer> wordMap = wordCount (words);

        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            System.out.println("Word: " + entry.getKey() + ", Frequency: " + entry.getValue());
        }
    }

    public static Map<String, Integer> wordCount (List<String> words) {
        Map<String, Integer> wordMap = new HashMap<>();

        for (String word : words) {
            wordMap.merge(word, 1, Integer::sum);
        }

        return wordMap;
    }
}
