package com.epam.mjc;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectionService {

    public List<Integer> filterEvenNumbers(List<Integer> list) {
        return list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
    }

    public List<String> toUpperCaseCollection(List<String> list) {
        return list.stream().map(value -> value.toUpperCase()).collect(Collectors.toList());
    }

    public Optional<Integer> findMax(List<Integer> list) {
        Integer max = list
            .stream()
            .mapToInt(v -> v)
            .max().orElseThrow(NoSuchElementException::new);
    return Optional.of(max);
    }

    public Optional<Integer> findMin(List<List<Integer>> list) {

        List<Integer> flat = list.stream().flatMap(l -> l.stream()).collect(Collectors.toList());
        Integer min = flat
            .stream()
            .mapToInt(v -> v)
            .min().orElseThrow(NoSuchElementException::new);
        return Optional.of(min);    }

    public Integer sum(List<Integer> list) {
        Integer summarised = list.stream().reduce(0, (a, b) -> a+b);
        return summarised;
    }
}
