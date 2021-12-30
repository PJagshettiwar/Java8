package diplav;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamBasics {

    private List<Integer> output;
    private Optional<Character> ans;

    public static void main(String[] args) {
        findFirstNonRepeastingChar();
    }

    //Print even number from list
    private static void printEvenNumber() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> outPut = list.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());
        System.out.println(outPut);
    }


    //Print frequency
    private static void frequency() {
        List<Integer> list = Arrays.asList(1, 1, 3, 4, 1, 6, 7, 2, 2);
        List<Integer> outPut = list.stream().
                filter(a -> a % 2 == 0).
                collect(Collectors.toList());
        System.out.println(outPut);
    }


    //  findDuplicate in Stream
    private static void findDuplicate() {
        List<Integer> list = Arrays.asList(1, 1, 3, 4, 1, 6, 7, 2, 2);
        List<Integer> output = list.stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1)
                .map(e -> e.getKey())
                .collect(Collectors.toList());

        System.out.println(output);

        List<Integer> output2 =
                 list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(e -> e.getKey())
                .collect(Collectors.toList());

        System.out.println(output2);



    }

    private static void findMax(){
        List<Integer> list = Arrays.asList(1, 8, 9, 10, 2, 3);
        //Optional<Integer> ans = list.stream().max( (o1, o2) -> o1-o2);
        Optional<Integer> ans = list.stream().max(Integer::compare);
        System.out.println(ans.get());
    }

    private static void findFirstNonRepeastingChar(){
        String str = "Java Hungry Blog Alive is Awesome";
        Optional<Character> ans = str.chars()
                .mapToObj(s -> Character.valueOf((char) s))
                .collect(Collectors.groupingBy(i -> i, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey())
                .findFirst();
       System.out.println(ans.get());
    }

    private static void sort(){
        List<Integer> list = Arrays.asList(1, 8, 9, 10, 2, 3);

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        class Pair{
            int height;
            int width;

            public String toString(){
                return ""+height+" -- "+width;
            }
        }
        List<Pair> pairList = new ArrayList<>();
        //ascending height desceding width
    }


}
