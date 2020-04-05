package geekbrains.com;

public class Main {
    // primitives are in stack
    // objects are in heap

    private static abstract class Animal {
        int age;

        public Animal(int age) {
            this.age = age;
        }
    }
    private static class Cat extends Animal {
        public Cat(int age) {
            super(age);
        }
        void voice() {
            System.out.println("meow");
        }
    }
    private static class Dog extends Animal {
        public Dog(int age) {
            super(age);
        }
    }

    public static void main(String[] args) {
        int[] arr = {};
        method1(1,2,3,4,5);
    }

    private static void method1(int... arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void instanceofExample() {
        Cat c = new Cat(1);
        Dog d = new Dog(2);
        Animal[] zoo = {c, d};

        for (int i = 0; i < zoo.length; i++) {
            System.out.println(zoo[i].age);
            if (zoo[i] instanceof Cat) {
                ((Cat) zoo[i]).voice();
            }
        }
    }
}
