import java.util.*;
import java.util.function.UnaryOperator;

public class ArrayGoodsList implements List {
    public static final int DEFAULT_LENGTH = 10;
    private Object[] innerArray;
    private int size;
    private static final int EXPAND_MODIFIER = 2;

    public ArrayGoodsList() {
        innerArray = new Object[DEFAULT_LENGTH];
        size = 0;
    }

    public ArrayGoodsList(int i) {
        innerArray = new Object[i];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Object o1 : innerArray) {
            if (o.equals(o1)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object [] a = new Object[size];
        System.arraycopy(innerArray, 0, a, 0, a.length);
        return a;
    }

    @Override
    public boolean add(Object o) {
        if (size != innerArray.length) {
            innerArray[size++] = o;
        } else {
            expandArrayIfNeeded();
            innerArray[size] = o;
            size++;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < innerArray.length; i++) {
            if (o.equals(innerArray[i])) {
                innerArray[i] = null;
                size--;
                for (int j = i + 1; j < innerArray.length; j++) {
                    innerArray[i] = innerArray[j];
                    i++;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        for (Object o : c) {
            add(o);
        }
        return !c.isEmpty();
    }

    @Override
    public boolean addAll(int index, Collection c) {
        checkThatIndexIsInAcceptableRange(index);
        size += c.size();
        expandArrayIfNeeded();
        int elementToAdd = c.size();
        int newPositionOfElement = size - 1;
        for (int i = newPositionOfElement; i > index - 1; i--) {
            innerArray[i] = innerArray[i - elementToAdd];
        }
        for (int i = 0; i < elementToAdd; i++) {
            for (Object o : c) {
                innerArray[index + i] = o;
                i++;
            }
        }
        return !c.isEmpty();
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            innerArray[i] = null;
            size = 0;
        }
    }

    @Override
    public Object get(int index) {
        checkThatIndexIsInAcceptableRange(index);
        return innerArray[index];
    }

    @Override
    public Object set(int index, Object element) {
        checkThatIndexIsInAcceptableRange(index);
        Object o = innerArray[index];
        innerArray[index] = element;
        return o;
    }

    private void checkThatIndexIsInAcceptableRange(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void add(int index, Object element) {
        checkThatIndexIsInAcceptableRange(index);
        size++;
        expandArrayIfNeeded();
        for (int i = size; i > index; i--) {
            innerArray[i] = innerArray[i - 1];
        }
        innerArray[index] = element;
    }

    private void expandArrayIfNeeded() {
        if (size > innerArray.length) {
            Object [] temporaryList = new Object[innerArray.length * EXPAND_MODIFIER];
            for (int i = 0; i < innerArray.length; i++) {
                temporaryList[i] = innerArray[i];
            }
            innerArray = temporaryList;
        }
    }

    @Override
    public Object remove(int index) {
        checkThatIndexIsInAcceptableRange(index);
        Object o = innerArray[index];
        innerArray[index] = null;
        for (int i = index; i < size; i++) {
            innerArray[index] = innerArray[index + 1];
        }
        size--;
        return o;
    }

    @Override
    public int indexOf(Object o) {

        for (int i = 0; i < innerArray.length; i++) {
            if (o.equals(innerArray[i]))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = 0; i < innerArray.length; i++) {
            if (o.equals(innerArray[i]) && i < size)
                return ++i;
        }
        return -1;
    }

    @Override
    public boolean retainAll(Collection c) {
        Object [] temporaryList = new Object[size];
        int indexOfRelist = 0;
        size = 0;
        for (Object o : c) {
            if (contains(o)) {
                temporaryList[indexOfRelist] = o;
                size++;
                indexOfRelist++;
            }
        }
        innerArray = temporaryList;
        return !isEmpty();

    }

    @Override
    public boolean removeAll(Collection c) {
        for (Object o : c) {
            remove(o);
        }
        return !c.isEmpty();
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    @Override
    public Object[] toArray(Object[] a) {

        return new Object[0];
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
