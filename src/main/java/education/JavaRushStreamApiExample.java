package education;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaRushStreamApiExample {

    public static void main(String[] args) {
        System.out.println(compareLists(oldList, newList));
    }

    public static List<String> oldList = Arrays.asList("oldStr1", "oldStr2", "oldStr3");
    public static List<String> newList = Arrays.asList("oldStr1", "oldStr2", "newStr1");

    public static List<String> compareLists(List<String> oldList, List<String> newList){

        return newList.stream()
                .filter(n -> oldList.stream()
                        .noneMatch(o -> o.equals(n)))
                .collect(Collectors.toList());
    }

    public void testMapAndFlatMap(){
        String[] array = {"Test", "StreamApi"};
        Stream<String> streamOfArray = Arrays.stream(array);
        streamOfArray.map(s -> s.split(""))
                .flatMap(Arrays::stream).distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static List<String> split(String str){
        return Stream.of(str.split(","))
                .map (elem -> new String(elem))
                .collect(Collectors.toList());
    }

    public List<Character> splitToListOfChar(String str) {
        return str.chars()
                .mapToObj(item -> (char) item)
                .collect(Collectors.toList());
    }
}
