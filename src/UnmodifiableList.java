import java.util.*;

public class UnmodifiableList<T> implements List<T> {

    private final List<T> unmodifiablePart;
    private final List<T> modifiablePart;

    public UnmodifiableList(List<T> unmodifiablePart, List<T> modifiablePart) {
        this.unmodifiablePart = unmodifiablePart;
        this.modifiablePart = modifiablePart;
    }

    private void checkThatIndexIsInAcceptableRange(final int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index is " + index + ", and size is " + size());
        }
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
    public Object[] toArray() {
        Object[] arrayToReturn = new Object[unmodifiablePart.size() + modifiablePart.size()];
        System.arraycopy(unmodifiablePart.toArray(), 0, arrayToReturn, 0, unmodifiablePart.size());
        System.arraycopy(modifiablePart.toArray(), 0, arrayToReturn, unmodifiablePart.size(), modifiablePart.size());
        return arrayToReturn;
    }

    @Override
    public <E> E[] toArray(E[] a) {
        int size = unmodifiablePart.size() + modifiablePart.size();
        if (size > a.length) {
            return (E[]) Arrays.copyOf(new Object[size], size, a.getClass());
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
        return modifiablePart.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        checkThatIndexIsInAcceptableRange(index);
        return modifiablePart.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return modifiablePart.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (Object o : unmodifiablePart) {
            if (!c.contains(o)) {
                throw new PartiallySupportedOperationException();
            }
        }
        return modifiablePart.retainAll(c);
    }

    @Override
    public void clear() {
        if (!unmodifiablePart.isEmpty()) {
            throw new PartiallySupportedOperationException();
        }
        modifiablePart.clear();
    }

    @Override
    public T get(int index) {
        checkThatIndexIsInAcceptableRange(index);
        if (index < unmodifiablePart.size()) {
            return unmodifiablePart.get(index);
        }
        return modifiablePart.get(index - unmodifiablePart.size());
    }

    @Override
    public T set(int index, T element) {
        checkThatIndexIsInAcceptableRange(index);
        if (index < unmodifiablePart.size()) {
            throw new PartiallySupportedOperationException();
        }
        return modifiablePart.set(index - unmodifiablePart.size(), element);
    }

    @Override
    public void add(int index, T element) {
        checkThatIndexIsInAcceptableRange(index);
        if (index < unmodifiablePart.size()) {
            throw new PartiallySupportedOperationException();
        }
        modifiablePart.add(index - unmodifiablePart.size(), element);
    }

    @Override
    public T remove(int index) {
        checkThatIndexIsInAcceptableRange(index);
        if (index < unmodifiablePart.size()) {
            throw new PartiallySupportedOperationException();
        }
        return modifiablePart.remove(index - unmodifiablePart.size());

    }

    @Override
    public int indexOf(Object o) {
        final int indexInUnmod = unmodifiablePart.indexOf(o);
        if (indexInUnmod != -1) {
            return indexInUnmod;
        }
        final int indexInMod = modifiablePart.indexOf(o);
        if (indexInMod != -1) {
            return indexInMod + unmodifiablePart.size();
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        final int indexInMod = modifiablePart.lastIndexOf(o);
        if (indexInMod != -1) {
            return indexInMod + unmodifiablePart.size();
        }
        final int indexInUnmod = unmodifiablePart.lastIndexOf(o);
        if (indexInUnmod != -1) {
            return indexInUnmod;
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new InnerIterator();
    }

    private class InnerIterator implements Iterator<T> {
        private Iterator<T> unmodIterator = unmodifiablePart.iterator();
        private Iterator<T> modIterator = modifiablePart.iterator();

        @Override
        public boolean hasNext() {
            if (unmodIterator.hasNext()) return true;
            if (!unmodIterator.hasNext() && modIterator.hasNext()) return true;
            else return false;
        }

        @Override
        public T next() {
            if (unmodIterator.hasNext()) return unmodIterator.next();
            if (!unmodIterator.hasNext() && modIterator.hasNext()) return  modIterator.next();
            else throw new NoSuchElementException();

        }
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
