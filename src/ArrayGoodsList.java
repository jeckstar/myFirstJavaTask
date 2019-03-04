import java.lang.reflect.Array;
import java.util.*;
import java.util.function.UnaryOperator;

public class ArrayGoodsList<T> implements List<T> {
    public static final int DEFAULT_LENGTH = 10;
    public static final int NO_INDEX = -1;
    private T[] innerArray;
    private int size;
    private static final int EXPAND_MODIFIER = 2;

    public ArrayGoodsList() {
        innerArray = (T[]) new Object[DEFAULT_LENGTH];
        size = 0;
    }

    public ArrayGoodsList(int i) {
        innerArray = (T[]) new Object[i];
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
    public boolean add(T o) {
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
    public boolean addAll(Collection<? extends T> c) {
        for (T o : c) {
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
    public T get(int index) {
        checkThatIndexIsInAcceptableRange(index);
        return innerArray[index];
    }

    @Override
    public T set(int index, T element) {
        checkThatIndexIsInAcceptableRange(index);
        T o = innerArray[index];
        innerArray[index] = element;
        return o;
    }

    private void checkThatIndexIsInAcceptableRange(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is " + index + ", and size is " + size);
        }
    }

    @Override
    public void add(int index, T element) {
        checkThatIndexIsInAcceptableRange(index);
        size++;
        expandArrayIfNeeded();
        int indexToRemove = index + 1;
        System.arraycopy(innerArray, index, innerArray, indexToRemove, size - index);
        innerArray[index] = element;
    }

    private void expandArrayIfNeeded() {
        if (size >= innerArray.length) {
            T [] temporaryList = (T[]) new Object[innerArray.length * EXPAND_MODIFIER];
            for (int i = 0; i < innerArray.length; i++) {
                temporaryList[i] = innerArray[i];
            }
            innerArray = temporaryList;
        }
    }

    @Override
    public T remove(int index) {
        checkThatIndexIsInAcceptableRange(index);
        T o = innerArray[index];
        innerArray[index] = null;
        size--;
        int lengthOfElement = size - index;
        System.arraycopy(innerArray, ++index, innerArray, --index, lengthOfElement);
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
    public boolean retainAll(final Collection c) {
        final int sizeBeforeRetain = size;
        final List<T> temporaryList = new ArrayGoodsList<>();
        for (Object o : c) {
            final int indexOf = indexOf(o);
            if (indexOf != -1) {
                temporaryList.add(get(indexOf));
            }
        }
        clear();
        addAll(temporaryList);
        return size != sizeBeforeRetain;
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

    @Override
    public Object[] toArray() {
        Object[] a = new Object[size];
        System.arraycopy(innerArray, 0, a, 0, a.length);
        return a;
    }

    public <T> T[] toArray(T [] a) {
        if (size >a.length){
            return (T[]) Arrays.copyOf(innerArray, size, a.getClass());
        }
        System.arraycopy(innerArray, 0, a, 0, size);
        if (size < a.length){
            a[size]=null;
        }
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
            if (!hasNext()) {
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
