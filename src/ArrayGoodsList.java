import java.util.*;
import java.util.function.UnaryOperator;

public class ArrayGoodsList implements List {
    public static final int DEFAULT_LENGTH = 10;
    public static final int NO_INDEX = -1;
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
        Object[] a = new Object[size];
        System.arraycopy(innerArray, 0, a, 0, a.length);
        return a;
    }

    @Override
    public boolean add(Object o) {
        expandArrayIfNeeded();
        innerArray[size++] = o;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < innerArray.length; i++) {
            if (o.equals(innerArray[i])) {
                size--;
                int shift = i;
                System.arraycopy(innerArray, ++shift, innerArray, --shift, size - i);
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
        Object[] arrayOfElementsToAdd = c.toArray();
        Object[] arrayOfLastElements = new Object[size - index - c.size()];
        System.arraycopy(innerArray, index, arrayOfLastElements, 0, arrayOfLastElements.length);
        System.arraycopy(arrayOfElementsToAdd, 0, innerArray, index, c.size());
        System.arraycopy(arrayOfLastElements, 0, innerArray, size - arrayOfLastElements.length, arrayOfLastElements.length);
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
        int indexToRemove = index + 1;
        System.arraycopy(innerArray, index, innerArray, indexToRemove, size - index);
        innerArray[index] = element;
    }

    private void expandArrayIfNeeded() {
        if (size >= innerArray.length) {
            Object[] temporaryList = new Object[innerArray.length * EXPAND_MODIFIER];
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
        size--;
        int lengthOfElement = size - index;
        System.arraycopy(innerArray, ++index, innerArray, --index, lengthOfElement);

       /* for (int i = index; i < size; i++) {
            innerArray[index] = innerArray[index + 1];
        }
        */

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
        for (int i = size - 1; i >= 0; i--) {
            if (o.equals(innerArray[i]))
                return i;
        }
        return NO_INDEX;
    }

    @Override
    public boolean retainAll(Collection c) {
        Object[] temporaryList = new Object[size];
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
        for (Object o1 : innerArray) {
            if (c.contains(o1)) {
                return true;
            }
        }
        return false;
    }
    public Object[] toArray(Object[] a) {
        System.arraycopy(innerArray, 0, a, 0, a.length);
        return a;
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
    public Iterator iterator() {
        return new GoodsIterator();
    }
    private class GoodsIterator implements Iterator {
        private int indexOfNextElement;

        @Override
        public boolean hasNext() {
            return indexOfNextElement != size;
        }

        @Override
        public Object next() {
            int index = indexOfNextElement;
            if(!hasNext()){
                return new NoSuchElementException();
            }
            //if (index != size && index < size)
            indexOfNextElement = index + 1;
            return innerArray[index];
        }

        @Override
        public void remove() {
            int index = indexOfNextElement;
            if (index != size && index < size) {
                ArrayGoodsList.this.remove(index);
            }
        }
    }
}
