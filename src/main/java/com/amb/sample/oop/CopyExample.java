package com.amb.sample.oop;

import com.amb.sample.model.Employee;
import lombok.Builder;
import lombok.Data;

import java.util.*;

public class CopyExample {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        strList.add("AAA");
        strList.add("BBB");
        System.out.println("Original list: " + strList);
        List<String> clonedList = new ArrayList<>(strList);
        strList.add("EEE");
        System.out.println("Cloned list: " + clonedList);

        HashMap<String, String> map = new HashMap<>();
        map.put("K1", "V1");
        System.out.println("map: " + map);
        HashMap<String, String> clonedMa = (HashMap<String, String>) map.clone();
        System.out.println("cloned map: " + clonedMa);

        clonedMa.put("K2", "V2");
        System.out.println("cloned map1: " + map);

        Employee e1 = Employee.builder().id(1).build();
        Employee e2 = Employee.builder().id(1).build();
        Employee e3 = e1;

        if (e1 == e3) {
            System.out.println(" e1==e3 true" );
        }

        if (e1 != e2) {
            System.out.println(" e1==e2 false" );
        }

        if (e1.equals(e2)) {
            System.out.println(" e1==e2 true" );
        }

        EmpHashCode em1 = new EmpHashCode(1);
        EmpHashCode em2 = new EmpHashCode(2);
        EmpHashCode em3 = new EmpHashCode(1);
        EmpHashCode em4 = em1;
        EmpHashCode em5 = new EmpHashCode(1, "EM1");
        System.out.println("em1: " + em1.hashCode() + " em2:" + em2.hashCode()
                + " em3: " + em3.hashCode() + " em4: " + em4.hashCode() + " em5: " + em5.hashCode());

        Map<EmpHashCode, String> map1 = new HashMap<>();
        map1.put(em1, "EM1");
        map1.put(em2, "EM2");
        map1.put(em3, "EM3");
        map1.put(null, "NULL");
        System.out.println("map1: " + map1.keySet());
    }

    @Data
    @Builder
    static class EmpHashCode {
        int id;
        String name;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EmpHashCode that = (EmpHashCode) o;
            return id == that.id && Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        EmpHashCode(int id) {
            this.id = id;
        }
        EmpHashCode(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
