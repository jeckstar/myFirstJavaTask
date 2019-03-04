import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        System.out.println(arrayGoodsList.contains(o2));
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
        System.out.println(arrayGoodsList.remove(o1) + " " + arrayGoodsList.size());

    }

    @Test
    public void removeShouldDeleteThePreviouslyAddedObject() {
        final String persisted = new String("123");
        final String toAddAndRemove = new String("456");
        final List <String> subject = new ArrayGoodsList<String>();
        subject.add(persisted);
        subject.add(toAddAndRemove);
        assertTrue(subject.remove(toAddAndRemove));
        assertEquals(1, subject.size());
        assertFalse(subject.contains(toAddAndRemove));
        for (String s: subject) {
            System.out.println(s);
        }
    }

    @Test
    public void addTest() {
        final String o1 = new String("0");
        final String o2 = new String("1");
        final String o3 = new String("2");
        final String o4 = new String("3");
        final String o5 = new String("4");
        final String o6 = new String("5");
        final String o7 = new String("6");
        final String o8 = new String("7");
        final String o9 = new String("8");
        final String o10 = new String("9");
        final String o11 = new String("10");
        final String o12 = new String("11");


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
        arrayGoodsList.add(o10);
        arrayGoodsList.add(o11);
        arrayGoodsList.add(o12);

        for (int i = 0; i < arrayGoodsList.size(); i++) {
            System.out.println(arrayGoodsList.get(i));
        }

    }

    @Test
    public void setTest() {
        final Object o1 = new Object();
        final Object o2 = new Object();

        final ArrayGoodsList arrayGoodsList = new ArrayGoodsList();
        arrayGoodsList.add(o1);
        System.out.println(arrayGoodsList.set(0, o2));

    }

    @Test
    public void addElementByIndex() {
        final String o0 = new String("0");
        final String o1 = new String("1");
        final String o2 = new String("2");
        final String o3 = new String("3");
        final String o4 = new String("4");
        final String o5 = new String("5");
        final String o6 = new String("6");
        final String o7 = new String("7");
        final String o8 = new String("8");
        final String o9 = new String("9");
        final ArrayGoodsList arrayGoodsList = new ArrayGoodsList();
        arrayGoodsList.add(o0);
        arrayGoodsList.add(o1);
        arrayGoodsList.add(o2);
        arrayGoodsList.add(0, o3);
        arrayGoodsList.add(o4);
        arrayGoodsList.add(o5);
        arrayGoodsList.add(o6);
        arrayGoodsList.add(o7);
        arrayGoodsList.add(o8);
        arrayGoodsList.add(o9);


        System.out.println(arrayGoodsList.size());
        System.out.println(" ");
        for (int i = 0; i < arrayGoodsList.size(); i++) {
            System.out.println((i) + " " + arrayGoodsList.get(i));
        }

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void assertThatGetWillThrowIndexOutOfBoundsExceptionIfTooBigElementWasRequested() {
        new ArrayGoodsList().get(11);
    }

    @Test
    public void assertThatAddToInappropriateIndexWillThrowIndexOutOfBoundsException() {
        final ArrayList<Object> objects = new ArrayList<>();
        objects.add(1, new Object());
    }

    @Test
    public void indexOfTest() {
        final Object o1 = new Object();
        final Object o2 = new Object();
        final Object o3 = new Object();
        final Object o4 = new Object();
        final Object o5 = new Object();
        final Object o6 = new Object();

        final ArrayGoodsList arrayGoodsList = new ArrayGoodsList();
        arrayGoodsList.add(o1);
        arrayGoodsList.add(o2);
        arrayGoodsList.add(o3);
        arrayGoodsList.add(o4);
        arrayGoodsList.add(o5);

        System.out.println(arrayGoodsList.indexOf(o6));


    }

    @Test
    public void addAllTestByIndex() {
        final String o1 = new String("0");
        final String o2 = new String("1");
        final String o3 = new String("2");
        final String o4 = new String("3");
        final String o5 = new String("4");
        final String o6 = new String("5");
        final String o7 = new String("6");
        final String o8 = new String("7");

        final ArrayGoodsList arrayGoodsList = new ArrayGoodsList();
        arrayGoodsList.add(o1);
        arrayGoodsList.add(o2);
        arrayGoodsList.add(o3);
        arrayGoodsList.add(o4);
        arrayGoodsList.add(o5);
        arrayGoodsList.add(o6);
        arrayGoodsList.add(o7);
        arrayGoodsList.add(o8);


        final String o05 = new String("11");
        final String o06 = new String("11");
        final String o07 = new String("11");
        final String o08 = new String("11");

        final ArrayList arrayGoodsList2 = new ArrayList();
        arrayGoodsList2.add(o05);
        arrayGoodsList2.add(o06);
        arrayGoodsList2.add(o07);
        arrayGoodsList2.add(o08);

        arrayGoodsList.addAll(6, arrayGoodsList2);

        for (int i = 0; i < arrayGoodsList.size(); i++) {
            System.out.println(arrayGoodsList.get(i));
        }
        System.out.println();
        System.out.println(arrayGoodsList.size());
    }

    @Test
    public void toArrayTest() {
        List<String> arrayGoodsList = new ArrayGoodsList<String>();
        arrayGoodsList.add("new element in array number 0");
        arrayGoodsList.add("new element in array number 1");
        arrayGoodsList.add("element number 2 - if myArray.length>size the next must be \"null\"");
        String[] myArray = {"0", "1", "2", "3", "4", "5"};
        //String [] myArray = {"0","1"};

        String[] newArray = arrayGoodsList.toArray(myArray);
        for (int i = 0; i < newArray.length; i++) {
            System.out.println(newArray[i]);
        }
    }


    @Test
    public void systemArrayCopyTest() {
        String[] sourceArray = new String[5];
        int sourceIndex = 1;
        String[] destArray = new String[10];
        int destIndex = 2;
        int length = sourceArray.length - sourceIndex;
        justFillArrays(sourceArray, destArray);
        String[] expected = {"dest0", "dest1", "source1", "source2", "source3", "source4", "dest6", "dest7", "dest8", "dest9"};
        System.arraycopy(sourceArray, sourceIndex, destArray, destIndex, length);
        assertArrayEquals(expected, destArray);
    }

    private void justFillArrays(String[] sourceArray, String[] destArray) {
        for (int i = 0; i < sourceArray.length; i++) {
            sourceArray[i] = "source" + i;
        }
        for (int i = 0; i < destArray.length; i++) {
            destArray[i] = "dest" + i;
        }
    }

    @Test
    public void retainAllTest() {
        final String o1 = new String("0");
        final String o2 = new String("1");
        final String o3 = new String("2");
        final String o4 = new String("3");
        final String o5 = new String("4");
        final String o6 = new String("5");
        final String o7 = new String("6");
        final String o8 = new String("7");

        final ArrayGoodsList<String> arrayGoodsList = new ArrayGoodsList<>();
        arrayGoodsList.add(o1);
        arrayGoodsList.add(o2);
        arrayGoodsList.add(o3);
        arrayGoodsList.add(o4);
        arrayGoodsList.add(o5);
        arrayGoodsList.add(o6);
        arrayGoodsList.add(o7);
        arrayGoodsList.add(o8);

        final ArrayList<String> arrayGoodsList2 = new ArrayList<>();
        arrayGoodsList2.add(o5);
        arrayGoodsList2.add(o6);
        arrayGoodsList2.add(o7);
        arrayGoodsList2.add(o8);

        assertTrue(arrayGoodsList.retainAll(arrayGoodsList2));

        for (int i = 0; i < arrayGoodsList.size(); i++) {
            System.out.println(arrayGoodsList.get(i));
        }

        assertTrue(arrayGoodsList.contains(o5));
        assertTrue(arrayGoodsList.contains(o6));
        assertTrue(arrayGoodsList.contains(o8));
        assertEquals(4, arrayGoodsList.size());
    }

    @Test
    public void removeElementTest() {
        final String o1 = new String("0");
        final String o2 = new String("1");
        final String o3 = new String("2");
        final String o4 = new String("3");
        final String o5 = new String("4");
        final String o6 = new String("5");
        final String o7 = new String("6");
        final String o8 = new String("7");

        final ArrayGoodsList arrayGoodsList = new ArrayGoodsList();
        arrayGoodsList.add(o1);
        arrayGoodsList.add(o2);
        arrayGoodsList.add(o3);
        arrayGoodsList.add(o4);
        arrayGoodsList.add(o5);
        arrayGoodsList.add(o6);
        arrayGoodsList.add(o7);
        arrayGoodsList.add(o8);

        arrayGoodsList.remove(6);
        for (int i = 0; i < arrayGoodsList.size(); i++) {
            System.out.println(arrayGoodsList.get(i));

        }
        System.out.println(" ");
        System.out.println(arrayGoodsList.size());
    }

    @Test
    public void addAllTest() {
        final ArrayGoodsList subject = new ArrayGoodsList();
        for (int i = 0; i < 10; i++) {
            subject.add(String.valueOf(i));
        }
        subject.addAll(5, Arrays.asList(String.valueOf(10), String.valueOf(11), String.valueOf(12)));
        final List<String> expected = Stream.of(0, 1, 2, 3, 4, 10, 11, 12, 5, 6, 7, 8, 9).map(String::valueOf).collect(Collectors.toList());
        System.out.println(Arrays.toString(subject.toArray()));
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), subject.get(i));
        }
    }

    @Test
    public void lastIndexOf_shouldReturn2_ifStringWasAddedToTheStartAndToTheEnd() {
        final ArrayGoodsList arrayGoodsList = new ArrayGoodsList();
        arrayGoodsList.add("a");
        arrayGoodsList.add("b");
        arrayGoodsList.add("a");
        assertEquals(2, arrayGoodsList.lastIndexOf("a"));
    }

    @Test
    public void lastIndexOf() {
        final Object o1 = new Object();
        final Object o2 = new Object();
        final Object o3 = new Object();
        final Object o4 = new Object();
        final Object o5 = new Object();
        final ArrayGoodsList arrayGoodsList = new ArrayGoodsList();
        arrayGoodsList.addAll(Arrays.asList(o1, o3, o2, o3, o4, o5));
        assertEquals(3, arrayGoodsList.lastIndexOf(o3));
    }

    @Test
    public void remove_verifyRemoveWorksCorrectlyWithSingleRemoveInTheMiddle() {
        final ArrayGoodsList arrayGoodsList = new ArrayGoodsList();
        for (int i = 1; i < 6; i++) {
            arrayGoodsList.add(String.valueOf(i));
        }
        arrayGoodsList.remove("3");
        for (int i = 1; i < 6; i++) {
            if (i != 3) {
                assertTrue(arrayGoodsList.contains(String.valueOf(i)));
            }
        }
    }

    @Test
    public void contacontainsAllTest() {
        final String o1 = new String("0");
        final String o2 = new String("1");
        final String o3 = new String("2");
        final String o4 = new String("3");
        final String o5 = new String("4");
        final String o6 = new String("5");
        final String o7 = new String("6");
        final String o8 = new String("7");

        final ArrayGoodsList arrayGoodsList = new ArrayGoodsList();
        arrayGoodsList.add(o1);
        arrayGoodsList.add(o2);
        arrayGoodsList.add(o3);
        arrayGoodsList.add(o4);
        arrayGoodsList.add(o5);
        arrayGoodsList.add(o6);
        arrayGoodsList.add(o7);
        arrayGoodsList.add(o8);


        final ArrayGoodsList arrayGoodsList2 = new ArrayGoodsList();

        arrayGoodsList2.add(o5);
        arrayGoodsList2.add(o6);
        arrayGoodsList2.add(o7);
        arrayGoodsList2.add(o8);
        arrayGoodsList.containsAll(arrayGoodsList2);

    }

    @Test
    public void theIteratorShouldReturnNextElementOfGoodsList() {
        final String o1 = new String("0");
        final String o2 = new String("1");
        final String o3 = new String("2");
        final String o4 = new String("3");
        final String o5 = new String("4");
        final String o6 = new String("5");
        final String o7 = new String("6");
        final String o8 = new String("7");

        final ArrayGoodsList arrayGoodsList = new ArrayGoodsList();
       /* arrayGoodsList.add(o1);
        arrayGoodsList.add(o2);
        arrayGoodsList.add(o3);
        arrayGoodsList.add(o4);
        arrayGoodsList.add(o5);
        arrayGoodsList.add(o6);
        arrayGoodsList.add(o7);
        arrayGoodsList.add(o8); */

        Iterator iterator = arrayGoodsList.iterator();

        // while (iterator.hasNext()) {
        System.out.println(iterator.next());
        // }
    }

    @Test
    public void iterator_verifySequenceAdequacy() {
        final List<Object> plainList = Arrays.asList(new Object(), new Object(), new Object(), new Object(), new Object());
        final ArrayGoodsList testSubject = new ArrayGoodsList();
        testSubject.addAll(plainList);
        final Iterator iterator = testSubject.iterator();
        for (int i = 0; iterator.hasNext(); i++) {
            assertEquals(plainList.get(i), iterator.next());
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_verifyNoSuchElementException_ifListIsEmpty() {
        final ArrayGoodsList testSubject = new ArrayGoodsList();
        final Iterator iterator = testSubject.iterator();
        iterator.next();
    }

    @Test
    public void iterator_verifyRemoveWillDeleteSecondElement() {
        final Object o1 = new Object();
        final Object o2 = new Object();
        final Object o3 = new Object();
        final Object o4 = new Object();
        final Object o5 = new Object();
        final List<Object> plainList = Arrays.asList(o1, o2, o3, o4, o5);
        final ArrayGoodsList testSubject = new ArrayGoodsList();
        testSubject.addAll(plainList);
        final Iterator iterator = testSubject.iterator();
        iterator.next();
        iterator.next();
        iterator.remove();
        assertEquals(4, testSubject.size());
        assertFalse(testSubject.contains(o3));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void iterator_verifyConcurrentModificationException() {
        final ArrayList<Object> objects = new ArrayList<>();
        objects.add(new Object());
        objects.add(new Object());
        objects.add(new Object());
        objects.add(new Object());
        objects.add(new Object());
        final Iterator<Object> iterator = objects.iterator();
        iterator.next();
        final Iterator<Object> iterator1 = objects.iterator();
        iterator1.next();
        iterator.remove();
        iterator1.next();
    }

    private static class TestEntry {
        private final String text;

        private TestEntry(String text) {
            this.text = text;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TestEntry testEntry = (TestEntry) o;
            return Objects.equals(text, testEntry.text);
        }

        @Override
        public int hashCode() {
            return Objects.hash(text);
        }

        @Override
        public String toString() {
            return "TestEntry{" +
                    "text='" + text + '\'' +
                    '}';
        }
    }

}