package org.example;

import java.util.Collections;
import java.util.List;

public class Grocery {

    public Vegetable getTomatoes() {
        return null;
    }

    public Vegetable getOnions() throws OutOfStockException {
        System.out.println("Hellooo");
        return null;
    }

    public List<Vegetable> suggestOptions(VeggieType option) {
        return Collections.emptyList();
    }
}
