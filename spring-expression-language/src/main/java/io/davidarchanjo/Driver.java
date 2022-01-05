package io.davidarchanjo;

import org.springframework.stereotype.Component;

interface Drivable {
}

@Component
class Bmw implements Drivable {
}

@Component
class Mercedes implements Drivable {
}

public class Driver {
    private Drivable drivable;

    public Driver(Drivable drivable) {
        this.drivable = drivable;
    }
}