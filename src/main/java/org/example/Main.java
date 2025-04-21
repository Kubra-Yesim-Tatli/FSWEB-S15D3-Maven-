package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static List<Employee> findDuplicates(List<Employee> list) {
        Set<Employee> seen = new HashSet<>();
        Set<Employee> duplicates = new LinkedHashSet<>();
        for (Employee e : list) {
            if (e == null) continue;
            if (!seen.add(e)) {
                duplicates.add(e);
            }
        }
        return new LinkedList<>(duplicates);
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Employee> uniqueMap = new LinkedHashMap<>();
        for (Employee e : list) {
            if (e == null) continue;
            countMap.put(e.getId(), countMap.getOrDefault(e.getId(), 0) + 1);
            uniqueMap.putIfAbsent(e.getId(), e);
        }

        Map<Integer, Employee> result = new LinkedHashMap<>();
        for (Map.Entry<Integer, Employee> entry : uniqueMap.entrySet()) {
            if (countMap.get(entry.getKey()) >= 1) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        Map<Employee, Integer> countMap = new LinkedHashMap<>();
        for (Employee e : list) {
            if (e == null) continue;
            countMap.put(e, countMap.getOrDefault(e, 0) + 1);
        }

        List<Employee> result = new LinkedList<>();
        for (Map.Entry<Employee, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
