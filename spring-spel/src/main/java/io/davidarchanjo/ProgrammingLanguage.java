package io.davidarchanjo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Data
@Component
public class ProgrammingLanguage {
    private List<String> name = new LinkedList<>();
    private Map<String, Integer> releaseYear = new HashMap<>();

    public ProgrammingLanguage() {
        name.add("Java");
        name.add("JavaScript");
        name.add("Python");
        name.add(".NET");

        releaseYear.put(name.get(0), 1996);
        releaseYear.put(name.get(1), 1995);
        releaseYear.put(name.get(2), 1991);
        releaseYear.put(name.get(3), 2002);
    }
}