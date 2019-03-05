import java.util.*;

public class UnmodifiableList<T> implements List<T> {

    private final List<T> unmodifiablePart;
    private final List<T> modifiablePart;

    public UnmodifiableList(List<T> unmodifiablePart, List<T> modifiablePart) {
        this.unmodifiablePart = unmodifiablePart;
        this.modifiablePart = modifiablePart;
    }

    @Override
    public int size() {
        return unmodifiablePart.size() + modifiablePart.size();
    }

    @Override
    public boolean isEmpty() {
        return size() != 0;
    }

    @Override
    public boolean contains(Object o) {
        return unmodifiablePart.contains(o) || modifiablePart.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object [] arrayToReturn = new Object[unmodifiablePart.size() + modifiablePart.size()];
        System.arraycopy(unmodifiablePart.toArray(), 0, arrayToReturn, 0, unmodifiablePart.size());
        System.arraycopy(modifiablePart.toArray(), 0, arrayToReturn, unmodifiablePart.size(), modifiablePart.size());
        return arrayToReturn;
    }

    @Override
    public <E> E[] toArray(E[] a) {
        int size = unmodifiablePart.size()+modifiablePart.size();
        if (size > a.length) {
            return (E[]) Arrays.copyOf(new Object [size], size, a.getClass());
        }
        System.arraycopy(unmodifiablePart.toArray(), 0, a, 0, unmodifiablePart.size());
        System.arraycopy(modifiablePart.toArray(), 0, a, unmodifiablePart.size(), modifiablePart.size());
        if (size < a.length) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean add(T t) {
        return modifiablePart.add(t);
    }

    @Override
    public boolean remove(Object o) {
        return modifiablePart.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o1 : c) {
            if (!contains(o1)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
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
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
