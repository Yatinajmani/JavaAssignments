package com.ttn.assignment.feb_22_collection;

import java.util.*;

/**
 * Print the elements of an array in the decreasing frequency if 2 numbers have same frequency then print the one
 * which came first.
 */
public class Exercise6 {
    public static void main(String[] args) {
        Integer integer[] = {6, 565, 6, 8, 12, 6, 23, 12, 4, 99, 8};
        List<CustomMap> customMapList = new ArrayList<>();
        for (int i = 0; i < integer.length; i++) {
//          Checking whether the element is already there in the list or not.
            if (!customMapList.contains(new CustomMap(integer[i]))) {
//              adding element to list if does not exist
                customMapList.add(new CustomMap(1, integer[i], i));
            } else {
//              Updating value of frequency if element exist.
                CustomMap c = customMapList.get(customMapList
                        .indexOf(new CustomMap(integer[i])));
                c.setFrequency(c.getFrequency() + 1);
            }
        }
//      Sorting list using custom made CustomMapComparator
        customMapList.sort(new CustomMapComparator());
        System.out.println("Original Array : ");
        for (Integer integer1 : integer) {
            System.out.print(integer1 + ",");
        }
        System.out.println();
        System.out.println("Sorted Array : ");
        for (CustomMap customMap : customMapList) {
            System.out.println(customMap);
        }
    }
}

/**
 * CustomMap class is used to store the element as key, frequency of element, position at which the element
 * occurred.In this equals and hashCode methods of Object class has been overridden to make element as unique
 * entry.
 */
class CustomMap {
    private Integer frequency;
    private Integer position;
    private Integer key;

    Integer getPosition() {
        return position;
    }

    Integer getFrequency() {
        return frequency;
    }

    void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public CustomMap(Integer key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomMap customMap = (CustomMap) o;
        return Objects.equals(key, customMap.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    CustomMap(Integer frequency, Integer key, Integer position) {
        this.frequency = frequency;
        this.position = position;
        this.key = key;
    }

    @Override
    public String toString() {
        return "key = " + key +
                ",  Frequency = " + frequency;
    }
}

/**
 * CustomMapComparator class implements Comparator and is used to sort the element of CustomMapList on the basis
 * of frequency of elements and positioning.
 */
class CustomMapComparator implements Comparator<CustomMap> {

    @Override
    public int compare(CustomMap o1, CustomMap o2) {
        if (o2.getFrequency().compareTo(o1.getFrequency()) != 0)
            return o2.getFrequency().compareTo(o1.getFrequency());
        else
            return o1.getPosition().compareTo(o2.getPosition());
    }
}