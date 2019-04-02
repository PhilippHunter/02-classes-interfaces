package de.thro.inf.prg3.a02;

import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable {

  private Element head;
  private int size;

  public SimpleListImpl() {
    head = null;
  }

  // TODO: Implement the required methods.
  @Override
  public void add(Object item) {
    size++;

    if (head == null) {
      head = new Element(item);
      return;
    }

    Element current = this.head;
    while (current.next != null) {
      current = current.next;
    }
    current.next = new Element(item);
  }

  /*Interface implementations*/
  @Override
  public int size() {
    return size;
  }

  @Override
  public SimpleList filter(SimpleFilter filter) {
    SimpleListImpl sl = new SimpleListImpl();
    for (Object o : this) {
      if (filter.include(o)) sl.add(o);
    }
    return sl;
  }

  @Override
  public Iterator iterator() {
    return new SimpleIteratorImpl();
  }

  class SimpleIteratorImpl implements Iterator {
    private Element current = head;

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public Object next() {
      Object tmp = current.item;
      current = current.next;
      return tmp;
    }
  }

  private static class Element {
    private Object item;
    private Element next;

    public Element(Object item) {
      this.item = item;
    }
  }
}

class Program {
  public static void main(String[] args) {
    SimpleListImpl myTestList = new SimpleListImpl();

    myTestList.add(1);
    myTestList.add(100);
    myTestList.add(new Ob(1,"lel"));

    for(Object obj : myTestList) {
     System.out.println(obj.toString());
    }
  }
}

class Ob {
  private int number;
  private String text;

  public Ob(int Number, String Text) {
    this.number = Number;
    this.text = Text;
  }

  @Override
  public String toString() {
    return this.number + " " + this.text;
  }
}