package de.thro.inf.prg3.a02;

public class TestClass implements TestInterface {
  public void testFunc(String s) {
    System.out.println(s);
  }
}

class TestClass2 {
  //anonymous class
  TestInterface test = new TestInterface() {
    @Override
    public void testFunc(String s) {
      System.out.println(s);
    }
  };
}
