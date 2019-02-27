import java.util.*;
import java.util.function.UnaryOperator;

public class ArrayGoodsList implements List {
    private Object[] list;
    private Object[] reList;
    private int size;
    private static final int EXPAND_MODIFIER = 2;

    public ArrayGoodsList() {
        list = new Object[10];
        size = 0;
    }

    public ArrayGoodsList(int i) {
        list = new Object[i];
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
        for (Object o1 : list) {
            if (o.equals(o1)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] a = new Object[size];
        for (int i = 0; i < size; i++) {
            a[i] = list[i];
        }
        return a;
    }

    @Override
    public boolean add(Object o) {
        if (size != list.length) {
            list[size++] = o;
        } else {
            int newSize = size * EXPAND_MODIFIER;
            reList = new Object[newSize];
            for (int i = 0; i < list.length; i++) {
                reList[i] = list[i];
            }
            list = reList;
            list[++size] = o;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < list.length; i++) {
            if (o.equals(list[i])) {
                list[i] = null;
                size--;
                for (int j = i + 1; j < list.length; j++) {
                    list[i] = list[j];
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator operator) {

    }

    @Override
    public void sort(Comparator c) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
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
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
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
