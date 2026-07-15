package org.example;

import java.util.Comparator;

public class SortByAge implements Comparator<Emp> {

    @Override
    public int compare(Emp o1, Emp o2) {
        return o1.getAge()-o2.getAge();
    }
}
