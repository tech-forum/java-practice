package com.amb.sample.stream;

class SampleTest1<T> {

    public static void main(String[] args) {

        SampleTest1 sampleTest1 = new SampleTest1();
        //todo 1: Print a String using the print function.
        sampleTest1.print("String");

        //todo 2: Print a instance of MyObject using the print function.
        sampleTest1.print(new MyObject("MyObject"));

        //todo 3: Print the sum of two numbers
        sampleTest1.print(sampleTest1.add(10, 5));
    }

    public void print(T t) {
        System.out.println("printing: " + t.toString());
    }

    public <T extends Number> Number add(T t1, T t2) {
        return t1.intValue() + t2.intValue();
    }

    public static class MyObject {

        private String attribute1;

        public MyObject(String attribute1) {
            this.attribute1 = attribute1;
        }

    }
}