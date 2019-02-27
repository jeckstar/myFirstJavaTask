import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayGoodsListTest {

    @Test
    public void containsShouldReturnTrueIfTheElementAtTheSecondPositionIsPresent() {
        final Object o1 = new Object();
        final Object o2 = new Object();
        final Object o3 = new Object();
        final ArrayGoodsList arrayGoodsList = new ArrayGoodsList();
        arrayGoodsList.add(o1);
        arrayGoodsList.add(o2);
        arrayGoodsList.add(o3);
        assertTrue(arrayGoodsList.contains(o2));
    }

    @Test
    public void containsShouldReturnFalseIfTheElementWasNotAddedToTheCollection() {
        final Object o1 = new Object();
        final Object o2 = new Object();
        final Object o3 = new Object();
        final ArrayGoodsList arrayGoodsList = new ArrayGoodsList();
        arrayGoodsList.add(o1);
        arrayGoodsList.add(o2);
        assertFalse(arrayGoodsList.contains(o3));
        System.out.println(arrayGoodsList.remove(o1)+" "+arrayGoodsList.size());

    }

    @Test
    public void removeShouldDeleteThePreviouslyAddedObject() {
        final Object persisted = new Object();
        final Object toAddAndRemove = new Object();
        final ArrayGoodsList subject = new ArrayGoodsList();
        subject.add(persisted);
        subject.add(toAddAndRemove);
        assertTrue(subject.remove(toAddAndRemove));
        assertEquals(1, subject.size());
        assertFalse(subject.contains(toAddAndRemove));
    }
    @Test
    public void addTest() {
        final Object o1 = new Object();
        final Object o2 = new Object();
        final Object o3 = new Object();
        final Object o4 = new Object();
        final Object o5 = new Object();
        final Object o6 = new Object();
        final Object o7 = new Object();
        final Object o8 = new Object();
        final Object o9 = new Object();
        final Object o10 = new Object();
        final Object o11 = new Object();
        final Object o12 = new Object();
        final ArrayGoodsList arrayGoodsList = new ArrayGoodsList();
        arrayGoodsList.add(o1);
        arrayGoodsList.add(o2);
        arrayGoodsList.add(o3);
        arrayGoodsList.add(o4);
        arrayGoodsList.add(o5);
        arrayGoodsList.add(o6);
        arrayGoodsList.add(o7);
        arrayGoodsList.add(o8);
        arrayGoodsList.add(o9);
        arrayGoodsList.add(o9);
        arrayGoodsList.add(o10);
        arrayGoodsList.add(o11);
        arrayGoodsList.add(o12);
    }
}