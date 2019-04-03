package de.thro.inf.prg3.a02;

public interface TestInterface {
  void testFunc(String s);
}

interface Intf {
  default void method() {
    System.out.println("lul");
  }

  void method2();

  static void method3() {

  }
}