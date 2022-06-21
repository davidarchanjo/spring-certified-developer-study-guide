package io.davidarchanjo.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class User {
    private String name;
    private Integer id;
}

@RestController
@RequestMapping("api")
public class DemoController {

    @GetMapping("{name}/{id}")
    public String get(User user) {
        return "get " + user;
    }

    @GetMapping(params = "name")
    public String getx(User user) {
        return "get " + user;
    }

    @PostMapping
    public String post() {
        return "post";
    }

    @PutMapping
    public String put() {
        return "put";
    }

    @DeleteMapping
    public String delete() {
        return "delete";
    }

    @RequestMapping(value = "/foos", headers = { "key1=val1", "key2=val2" }, method = GET)
    public String getFoosWithHeader(@RequestParam String val) {
        return "Get some Foos with Header";
    }

    @RequestMapping(value = "/foos", headers = "Accept=application/json", method = GET)
    public String getFoosAsJsonFromBrowser() {
        return "Get some Foos with Header Old";
    }

    @RequestMapping(value = "/foos/{id:[\\d]+}", method = GET)
    public String getFoosBySimplePathWithPathVariable(@PathVariable String id) {
        return "Get a specific Foo with id=" + id;
    }

    @RequestMapping(value = "/bars", params = "id", method = GET)
    public String getBarBySimplePathWithExplicitRequestParam(@RequestParam long id) {
        return "Get a specific Bar with id=" + id;
    }

}