package io.davidarchanjo;

import java.util.Comparator;
import java.util.stream.Stream;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
class ToDo {
    int id;
    String task;

    @Builder
    public ToDo(int id, String task) {
        this.id = id;
        this.task = task;
    }
    
    public void copy(ToDo o) {
        this.id = o.getId();
        this.task = o.getTask();        
    }
}

@SpringBootApplication
public class SpringConditionalApplication {

    public static void main(String[] args) {
        // SpringApplication.run(SpringConditionalApplication.class, args);
        // int[] arr = { 4, 1, 56, 5, 7, 17, 69, 10, 3, 2, 11, 15, 8, 9, 0, 12 };
        // int temp;

        // array sorting
        // for (int i = 1; i < arr.length; i++) {
        //     for (int j = i; j > 0; j--) {
        //         if (arr[j - 1] > arr[j]) {
        //             temp = arr[j - 1];
        //             arr[j - 1] = arr[j];
        //             arr[j] = temp;
        //         }
        //     }
        // }
        // System.out.println(Arrays.toString(arr));

        // array reverse-sorting
        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = i; j < arr.length; j++) {
        //         if (arr[i] < arr[j]) {
        //             temp = arr[i];
        //             arr[i] = arr[j];
        //             arr[j] = temp;
        //         }
        //     }
        // }
        // System.out.println(Arrays.toString(arr));

        // string reversing
        // char[] arr = "Hello World!".toCharArray();
        // char[] rev = new char[arr.length];
        // for (int i = arr.length - 1; i >= 0; i--) {
        //     rev[(arr.length - i) -1] = arr[i];
        // }
        // System.out.println(String.valueOf(rev));

        // CHANLEGE:
        // Given a string, return the "reversed" string where all characters that are not a letter stay in
        // the same place, and only the letters reverse their positions.
        // String[] arr = /*"ab-cd"*/ "a-bC-dEf=ghlj!!" /*"z<*zj"*/.split("");
        // List<String> letters = new ArrayList<>();
        // List<Integer> indexMatches = new ArrayList<>();
        // for (int i = arr.length - 1; i >= 0; i--) {
        //     if (arr[i].matches("[a-zA-Z]")) {
        //         letters.add(arr[i]);
        //     }
        // }
        // letters.forEach(o -> {
        //     int inicialIndex = indexMatches.stream()
        //         .mapToInt(v -> v)
        //         .max()
        //         .orElse(-1) + 1;
        //     for (int i = inicialIndex; i < arr.length; i++) {
        //         if (arr[i].matches("[a-zA-Z]")) {
        //             arr[i] = o;
        //             indexMatches.add(i);
        //             break;
        //         }
        //     }
        // });
        // System.out.println(String.join("", arr));

        // CHANLEGE:
        // Given an array of integers, a lucky integer is the one which has a frequency
        // (how many times an element occurs within the array) in the array equal to its value.
        // Return a lucky integer in the array. If there are multiple lucky integers return the largest of them.
        // If there is no lucky integer return -1.
        // int[] arr = /*{2, 2, 3, 4}*/ {1, 2, 2, 3, 3, 3} /*{2, 2, 2, 3, 3}*/ /*{5}*/;
        // Map<Integer, Integer> numbers = new HashMap<>();
        // for (int i = 0; i < arr.length; i++) {
        //     if (!numbers.containsKey(arr[i])) {
        //         numbers.put(arr[i], 0);
        //         for (int j = 0; j < arr.length; j++) {
        //             if (arr[i] == arr[j]) {
        //                 numbers.put(arr[i], numbers.get(arr[i]) + 1);
        //             }
        //         }
        //     }
        // }
        // int result = numbers.entrySet().stream()
        //     .filter(o -> o.getKey().equals(o.getValue()))
        //     .map(o -> o.getKey())
        //     .mapToInt(v -> v)
        //     .max()
        //     .orElse(-1);
        // System.out.println(result);

        // Pattern pattern = Pattern.compile("\\d{3,}");
        // Matcher matcher = pattern.matcher("12");
        // while (matcher.find()) {
        //     System.out.printf("'%s' ", matcher.group());
        // }
        // System.out.println();

        // ToDo td1 = ToDo.builder().id(1).task("foo").build();
        // ToDo td2 = ToDo.builder().id(1).task("bar").build();
        // ToDo td3 = Arrays.asList(td1, td2).stream()
        //     .limit(1)
        //     .map(o -> {
        //         o.setTask(o.getTask() + o.getId());
        //         return o;
        //     })
        //     .collect(Collector.of(ToDo::new, (c, e) ->  c.copy(e), (c1, c2) -> c1));
        //     // .collect(Collector.of(AddressResponse::new, (c, e) -> BeanUtils.copyProperties(e, c), (c1, c2) -> c1)))
        // System.out.println(td3);

        Integer max = Stream.of(5,6,21,2,0,3,4,561,7, 89)
            .max(Comparator.comparing(Integer::valueOf))
            .get();
        System.out.println(max);

    }

}

// support@turing.com