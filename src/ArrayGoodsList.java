import java.util.*;
import java.util.function.UnaryOperator;

public class ArrayGoodsList implements List {
    private Object[] goodsList;
    private Object[] reList;
    private int size;
    private static final int EXPAND_MODIFIER = 2;

    public ArrayGoodsList() {
        goodsList = new Object[10];
        size = 0;
    }

    public ArrayGoodsList(int i) {
        goodsList = new Object[i];
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
        for (Object o1 : goodsList) {
            if (o.equals(o1)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] a = new Object[size];
        for (int i = 0; i < size(); i++) {
            a[i] = goodsList[i];
        }
        return a;
    }

    @Override
    public boolean add(Object o) {
        if (size != goodsList.length) {
            goodsList[size++] = o;
        } else {
            expandArrayIfNeeded();
            goodsList[size] = o;
            size++;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < goodsList.length; i++) {
            if (o.equals(goodsList[i])) {
                goodsList[i] = null;
                size--;
                for (int j = i + 1; j < goodsList.length; j++) {
                    goodsList[i] = goodsList[j];
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
            goodsList[i] = goodsList[i - elementToAdd];
        }
        for (int i = 0; i < elementToAdd; i++) {
            for (Object o : c) {
                goodsList[index + i] = o;
                i++;
            }
        }
        return !c.isEmpty();
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            goodsList[i] = null;
            size = 0;
        }
    }

    @Override
    public Object get(int index) {
        checkThatIndexIsInAcceptableRange(index);
        return goodsList[index];
    }

    @Override
    public Object set(int index, Object element) {
        checkThatIndexIsInAcceptableRange(index);
        Object o = goodsList[index];
        goodsList[index] = element;
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
            goodsList[i] = goodsList[i - 1];
        }
        goodsList[index] = element;
    }

    private void expandArrayIfNeeded() {
        if (size > goodsList.length) {
            reList = new Object[goodsList.length * EXPAND_MODIFIER];
            for (int i = 0; i < goodsList.length; i++) {
                reList[i] = goodsList[i];
            }
            goodsList = reList;
        }
    }

    @Override
    public Object remove(int index) {
        checkThatIndexIsInAcceptableRange(index);
        Object o = goodsList[index];
        goodsList[index] = null;
        for (int i = index; i < size; i++) {
            goodsList[index] = goodsList[index + 1];
        }
        size--;
        return o;
    }

    @Override
    public int indexOf(Object o) {

        for (int i = 0; i < goodsList.length; i++) {
            if (o.equals(goodsList[i]))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = 0; i < goodsList.length; i++) {
            if (o.equals(goodsList[i]) && i < size)
                return ++i;
        }
        return -1;
    }

    @Override
    public boolean retainAll(Collection c) {
        reList = new Object[size];
        int indexOfRelist = 0;
        size = 0;
        for (Object o : c) {
            if (contains(o)) {
                reList[indexOfRelist] = o;
                size++;
                indexOfRelist++;
            }
        }
        goodsList = reList;
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
