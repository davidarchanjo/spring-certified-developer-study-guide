package io.davidarchanjo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("programmingLanguageComp")
public class ProgrammingLanguage {
    private String preferredLanguage;
    private List<String> name = new LinkedList<>();
    private Map<String, Integer> releaseYear = new HashMap<>();

    public ProgrammingLanguage() {
        this.preferredLanguage = "Java";
        this.name.add("Java");
        this.name.add("JavaScript");
        this.name.add("Python");
        this.name.add(".NET");

        this.releaseYear.put(name.get(0), 1996);
        this.releaseYear.put(name.get(1), 1995);
        this.releaseYear.put(name.get(2), 1991);
        this.releaseYear.put(name.get(3), 2002);
    }
}