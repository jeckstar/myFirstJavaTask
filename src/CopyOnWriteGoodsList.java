import java.lang.reflect.Array;
import java.util.*;

public class CopyOnWriteGoodsList<E> implements List<E> {
    public static final int DEFAULT_LENGTH = 10;
    public static final int NO_INDEX = -1;
    private E[] innerArray;
    private int size;
    private static final int EXPAND_MODIFIER = 2;

    public CopyOnWriteGoodsList() {
        innerArray = (E[]) new Object[DEFAULT_LENGTH];
        size = 0;
    }

    public CopyOnWriteGoodsList(int i) {
        innerArray = (E[]) new Object[i];
        size = 0;
    }

   // private E[] getArray() { return innerArray; }
    private void setArray(E[] a) {
        innerArray = a;
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
    public boolean add(E o) {
        expandArrayIfNeeded();
        innerArray[size++] = o;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        E[] newArray = (E[]) new Object[size];
        System.arraycopy(innerArray, 0, newArray, 0, size);
        for (int i = 0; i < newArray.length; i++) {
            if (o.equals(newArray[i])) {
                System.arraycopy(newArray, i + 1, newArray, i, --size - i);
                setArray(newArray);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        E[] cArray = (E[]) c.toArray();
        E[] newArray = (E[]) new Object[size+cArray.length];
        System.arraycopy(innerArray, 0, newArray, 0, size);
        System.arraycopy(cArray, 0, newArray, size, cArray.length);
        setArray(newArray);
        size+=cArray.length;
        return !c.isEmpty();
    }

    @Override
    public boolean addAll(int index, Collection c) {
        checkThatIndexIsInAcceptableRange(index);
        size += c.size();
        E[] newArray = (E[]) new Object[size];//временный массив
        Object[] arrayOfElementsToAdd = c.toArray(); //массив элементов для добавления
        int lastElements = size - index - c.size(); //кол-во элементов после индекса
        System.arraycopy(innerArray, 0, newArray, 0, index); // копируем элементы из нашего массива по индекс
        System.arraycopy(innerArray, index, newArray, size - lastElements, lastElements); // сдвигаем последние елементы
        System.arraycopy(arrayOfElementsToAdd, 0, newArray, index, c.size()); //добавляем элементы новой коллекции в масив
        setArray(newArray);
        return !c.isEmpty();
    }

    @Override
    public void clear() {
        size = 0;
        setArray((E[]) new Object[0]);
    }

    @Override
    public E get(int index) {
        checkThatIndexIsInAcceptableRange(index);
        return innerArray[index];
    }

    @Override
    public E set(int index, E element) {
        checkThatIndexIsInAcceptableRange(index);
        E[] newArray = (E[]) new Object[size];
        System.arraycopy(innerArray, 0, newArray, 0, size);
        E o = newArray[index];
        newArray[index] = element;
        setArray(newArray);
        return o;
    }

    private void checkThatIndexIsInAcceptableRange(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is " + index + ", and size is " + size);
        }
    }

    @Override
    public void add(int index, E element) {
        checkThatIndexIsInAcceptableRange(index);
        size++;
        E[] newArray = (E[]) new Object[size];
        System.arraycopy(innerArray, 0, newArray, 0, index);
        newArray[index] = element;
        System.arraycopy(innerArray, index , newArray, index + 1, size - index - 1);
        setArray(newArray);
    }

    private void expandArrayIfNeeded() {
        if (size >= innerArray.length) {
            E[] temporaryList = (E[]) new Object[innerArray.length * EXPAND_MODIFIER];
            for (int i = 0; i < innerArray.length; i++) {
                temporaryList[i] = innerArray[i];
            }
            setArray(temporaryList);
        }
    }

    @Override
    public E remove(int index) {
        checkThatIndexIsInAcceptableRange(index);
        E[] newArray = (E[]) new Object[size];
        System.arraycopy(innerArray, 0, newArray, 0, size);
        E o = newArray[index];
        newArray[index] = null;
        size--;
        int lengthOfElement = size - index;
        System.arraycopy(newArray, ++index, newArray, --index, lengthOfElement);
        setArray(newArray);
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
        final int sizeBeforeRetain = size; // для проверки изменения
        final List<E> temporaryList = new CopyOnWriteGoodsList<>();
        for (Object o : c) {
            final int indexOf = indexOf(o);
            if (indexOf != -1) {
                temporaryList.add(get(indexOf));
            }
        }
        E[] temporaryArray = (E[]) temporaryList.toArray();
        size = temporaryArray.length;
        setArray(temporaryArray);
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
        for (Object o1 : c) {
            if (!contains(o1)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray() {
        Object[] a = new Object[size];
        System.arraycopy(innerArray, 0, a, 0, a.length);
        return a;
    }

    public <T> T[] toArray(T[] a) {
        if (size > a.length) {
            return (T[]) Arrays.copyOf(innerArray, size, a.getClass());
        }
        System.arraycopy(innerArray, 0, a, 0, size);
        if (size < a.length) {
            a[size] = null;
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


    private class GoodsIterator implements Iterator<E> {
        private int indexOfNextElement;
        private E[] array = CopyOnWriteGoodsList.this.innerArray;
        private final int size = CopyOnWriteGoodsList.this.size;

        @Override
        public boolean hasNext() {
            return indexOfNextElement != size;
        }

        @Override
        public E next() {
            int index = indexOfNextElement;
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            indexOfNextElement = index + 1;
            return array[index];
        }

        @Override
        public void remove() {
            int index = indexOfNextElement;
            if (index != size && index < size) {
                CopyOnWriteGoodsList.this.remove(index);
            }
        }
    }

    private class CopyOnWriteIterator implements Iterator<E> {

        private int indexOfNextElement;
        private E[] iteratorArray = (E[]) CopyOnWriteGoodsList.this.toArray();
        private int iteratorArraySize = size;

        @Override
        public boolean hasNext() {
            return indexOfNextElement != iteratorArraySize;
        }

        @Override
        public E next() {
            int index = indexOfNextElement;
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            //if (index != size && index < size)
            indexOfNextElement = index + 1;
            return iteratorArray[index];
        }
    }
}
