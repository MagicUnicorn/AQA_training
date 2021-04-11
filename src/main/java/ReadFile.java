import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class ReadFile {
    public static Map<String, Integer> sortByValue(final Map<String, Integer> wordCounts) {

        return wordCounts.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public static void main(String args[]) throws IOException {
        final Map<String, Integer> myMap = new HashMap<String, Integer>();
        String path = new File("").getAbsolutePath() + "./src/main/resources/Task4";
        Paths.get(System.getProperty("user.dir")).resolve("src").resolve("main").resolve("resources").resolve("Task4");
        List<String> stringList = Files.readAllLines(Paths.get(path));
        stringList.forEach(newLine -> {
            newLine = newLine.replaceAll(",", "");
            newLine = newLine.replaceAll("[.]", "");
            String[] words = newLine.split(" ");
            //System.out.println(Arrays.toString(words));
            for (String str : words) {
                if (str.length() == 0) {
                    continue;
                }

                if (myMap.containsKey(str)) {
                    Integer count = myMap.get(str);
                    myMap.put(str, count + 1);
                } else {
                    myMap.put(str, 1);
                }
            }
        });
        final Map<String, Integer> sortedByCount = sortByValue(myMap);
        int count = 0;
        for (Map.Entry<String, Integer> entry: sortedByCount.entrySet()) {
            if(count==5){
                break;
            }
            System.out.println(entry.getKey()+":"+entry.getValue());
            count+=1;
        }
    }
}
