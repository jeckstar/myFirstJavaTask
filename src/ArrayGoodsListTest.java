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
        final List<String> subject = new ArrayGoodsList<String>();
        subject.add(persisted);
        subject.add(toAddAndRemove);
        assertTrue(subject.remove(toAddAndRemove));
        assertEquals(1, subject.size());
        assertFalse(subject.contains(toAddAndRemove));
        for (String s : subject) {
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
        final String o13 = new String("12");


        final CopyOnWriteGoodsList<String> arrayGoodsList = new CopyOnWriteGoodsList<>();
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
        arrayGoodsList.add(o13);

        for (int i = 0; i < arrayGoodsList.size(); i++) {
            System.out.println(arrayGoodsList.get(i));
        }
        System.out.println(" ");
        System.out.println(arrayGoodsList.size());

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

        final CopyOnWriteGoodsList<String> arrayGoodsList = new CopyOnWriteGoodsList<>();
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

        final CopyOnWriteGoodsList<String> arrayGoodsList2 = new CopyOnWriteGoodsList<>();
        arrayGoodsList2.add(o05);
        arrayGoodsList2.add(o06);
        arrayGoodsList2.add(o07);
        arrayGoodsList2.add(o08);

        arrayGoodsList.addAll(arrayGoodsList2);

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
        final CopyOnWriteGoodsList<String> subject = new CopyOnWriteGoodsList<>();
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

    @Test
    public void iterator_verifyConcurrentModificationException() {
        final CopyOnWriteGoodsList<String> objects = new CopyOnWriteGoodsList<>();
        objects.add("1");
        objects.add("3");
        objects.add("4");
        objects.add("5");
        objects.add("6");
        final Iterator<Object> iterator = objects.iterator();
        assertEquals("1", iterator.next());
        objects.remove("3");
        assertEquals("3", iterator.next());
        assertEquals("4", iterator.next());
        assertEquals("5", iterator.next());
        assertEquals("6", iterator.next());

    }

    @Test
    public void iterator_verifyClearRemovesAllElements() {
        final CopyOnWriteGoodsList<String> objects = new CopyOnWriteGoodsList<>();
        objects.add("1");
        objects.add("3");
        objects.clear();
        assertFalse(objects.contains("1"));
        assertFalse(objects.contains("3"));
    }

    @Test
    public void containsAll_verifyFalse_ifNotAllElementsAreContainedInTheCollection() {
        final CopyOnWriteGoodsList<String> objects = new CopyOnWriteGoodsList<>();
        objects.add("1");
        objects.add("2");
        objects.add("3");
        final CopyOnWriteGoodsList<Object> toCompare = new CopyOnWriteGoodsList<>();
        toCompare.add("2");
        toCompare.add("3");
        toCompare.add("4");
        assertFalse(objects.containsAll(toCompare));
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

    @Test
    public void UnmodifiableListToArrayTest() {
        ArrayList<Integer> unmodList = new ArrayList<>();
        unmodList.add(1);
        unmodList.add(1);
        unmodList.add(4);
        ArrayList<Integer> modList = new ArrayList<>();
        modList.add(4);
        modList.add(0);
        modList.add(6);
        modList.add(4);
        modList.add(8);
        UnmodifiableList<Integer> testList = new UnmodifiableList<>(unmodList, modList);
        //Integer[] bigArray = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27};
        //Integer[] smallArray = {11, 12, 13, 14, 15, 26, 27, 28, 29, 30};
        ArrayList<Integer> reteinList = new ArrayList<>();
        reteinList.add(1);
        reteinList.add(2);
        reteinList.add(3);
        reteinList.add(4);
        reteinList.add(5);
        reteinList.add(9);
        //testList.clear();
        System.out.println(testList.lastIndexOf(1));
        System.out.println(" ");
        //final Object[] integers = testList.toArray(smallArray);
        for (int i = 0; i < testList.size(); i++) {
            System.out.println(testList.get(i));
        }
    }

    @Test
    public void retainAllInArrayList() {
        final List<Integer> objects = new ArrayList<>();
        objects.add(1);
        objects.add(1);
        objects.add(1);
        objects.add(1);
        final List<Integer> objects2 = new ArrayList<>();
        objects2.add(1);
        objects.retainAll(objects2);
        for (int i = 0; i < objects.size(); i++) {
            System.out.println(objects.get(i));
        }

    }

    @Test
    public void unmodifiableIteratorTest() {
        ArrayList<String> unmodList = new ArrayList<>();
        unmodList.add("0");
        unmodList.add("1");
        unmodList.add("2");
        ArrayList<String> modList = new ArrayList<>();
        modList.add("3");
        modList.add("4");
        modList.add("5");
        modList.add("6");
        modList.add("7");
        UnmodifiableList<String> testList = new UnmodifiableList<>(unmodList, modList);

        Iterator<String> iterator = testList.iterator();


        assertEquals("0", iterator.next());
        assertEquals("1", iterator.next());
        assertEquals("2", iterator.next());
        assertEquals("3", iterator.next());
        assertEquals("4", iterator.next());
        assertEquals("5", iterator.next());
        assertEquals("6", iterator.next());
        assertEquals("7", iterator.next());
    }

    @Test
    public void setByIndex_verifyThatItemWillBeReSet_ifAnItemWasReplacedByEqualOne() {
        final String s1 = "1";
        final String s2 = "2";
        final String s3 = "3";
        final String s4 = "4";
        final String s5 = "5";
        final UnmodifiableList<String> strings = new UnmodifiableList<>(
                new ArrayList<>(Arrays.asList(s1, s2)),
                new ArrayList<>(Arrays.asList(s3, s4, s5))
        );
        final String actual = strings.set(1, s2);
        assertEquals(s2, actual);
    }

    @Test(expected = PartiallySupportedOperationException.class)
    public void remove_verifyThatExceptionWasThrown_ifRemoveIsConcernedWithUnmodifiablePart() {
        final String s1 = "1";
        final String s2 = "2";
        final String s3 = "3";
        final String s4 = "4";
        final String s5 = "5";
        final UnmodifiableList<String> strings = new UnmodifiableList<>(
                new ArrayList<>(Arrays.asList(s1, s2)),
                new ArrayList<>(Arrays.asList(s3, s4, s5))
        );
        strings.remove("1");

    }

    @Test(expected = PartiallySupportedOperationException.class)
    public void addAllByIndex() {
        final String s1 = "1";
        final String s2 = "2";
        final String s3 = "3";
        final String s4 = "4";
        final String s5 = "5";
        final UnmodifiableList<String> strings = new UnmodifiableList<>(
                new ArrayList<>(Arrays.asList(s1, s2)),
                new ArrayList<>(Arrays.asList(s3, s4, s5))
        );
        ArrayList<String> addList = new ArrayList<>();
        addList.add("2");
        addList.add("4");
        addList.add("5");
        addList.add("6");
        addList.add("7");
        strings.addAll(1, addList);
    }

    @Test(expected = PartiallySupportedOperationException.class)
    public void removeAllElementOfCollection() {
        final String s1 = "1";
        final String s2 = "2";
        final String s3 = "3";
        final String s4 = "4";
        final String s5 = "5";
        final UnmodifiableList<String> strings = new UnmodifiableList<>(
                new ArrayList<>(Arrays.asList(s1, s2)),
                new ArrayList<>(Arrays.asList(s3, s4, s5))
        );
        ArrayList<String> removeList = new ArrayList<>();
        removeList.add("2");
        removeList.add("5");
        strings.removeAll(removeList);
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }
    }

    @Test
    public void hashMapTest() {
        StringHashCodeIsLengthOfString goods1 = new StringHashCodeIsLengthOfString("Iphone");
        StringHashCodeIsLengthOfString goods2 = new StringHashCodeIsLengthOfString("Samsung");
        StringHashCodeIsLengthOfString goods3 = new StringHashCodeIsLengthOfString("Philips");
        StringHashCodeIsLengthOfString goods4 = new StringHashCodeIsLengthOfString("Sony");
        StringHashCodeIsLengthOfString goods5 = new StringHashCodeIsLengthOfString("Lg");
        StringHashCodeIsLengthOfString goods6 = new StringHashCodeIsLengthOfString("Nokia");
        StringHashCodeIsLengthOfString goods7 = new StringHashCodeIsLengthOfString("Meizu");
        StringHashCodeIsLengthOfString goods8 = new StringHashCodeIsLengthOfString("Huawei");
        Map<StringHashCodeIsLengthOfString, StringHashCodeIsLengthOfString> hashCodeIsLength = new HashMap<>();
        hashCodeIsLength.put(goods1, goods1);
        hashCodeIsLength.put(goods2, goods2);
        hashCodeIsLength.put(goods3, goods3);
        hashCodeIsLength.put(goods4, goods4);
        hashCodeIsLength.put(goods5, goods5);
        hashCodeIsLength.put(goods6, goods6);
        hashCodeIsLength.put(goods7, goods7);
        hashCodeIsLength.put(goods8, goods8);
        for (Map.Entry<StringHashCodeIsLengthOfString, StringHashCodeIsLengthOfString> entry : hashCodeIsLength.entrySet()) {
            StringHashCodeIsLengthOfString key = entry.getKey();
            StringHashCodeIsLengthOfString value = entry.getValue();
            System.out.println(key + " " + value);
        }
        System.out.println(" ");
        Map<StringHashCodeIsLengthOfString, StringHashCodeIsLengthOfString> hashCodeIsLengthLinkedHasMap = new LinkedHashMap<>();
        hashCodeIsLengthLinkedHasMap.put(goods1, goods1);
        hashCodeIsLengthLinkedHasMap.put(goods2, goods2);
        hashCodeIsLengthLinkedHasMap.put(goods3, goods3);
        hashCodeIsLengthLinkedHasMap.put(goods4, goods4);
        hashCodeIsLengthLinkedHasMap.put(goods5, goods5);
        hashCodeIsLengthLinkedHasMap.put(goods6, goods6);
        hashCodeIsLengthLinkedHasMap.put(goods7, goods7);
        hashCodeIsLengthLinkedHasMap.put(goods8, goods8);
        for (Map.Entry<StringHashCodeIsLengthOfString, StringHashCodeIsLengthOfString> entry : hashCodeIsLengthLinkedHasMap.entrySet()) {
            StringHashCodeIsLengthOfString key = entry.getKey();
            StringHashCodeIsLengthOfString value = entry.getValue();
            System.out.println(key + " " + value);
        }
    }

    @Test
    public void hashLinkedMapTest() {
        StringHashCodeIsSumOfFirstFoursChar sumOfChar1 = new StringHashCodeIsSumOfFirstFoursChar("AKM74");
        StringHashCodeIsSumOfFirstFoursChar sumOfChar2 = new StringHashCodeIsSumOfFirstFoursChar("PM");
        StringHashCodeIsSumOfFirstFoursChar sumOfChar3 = new StringHashCodeIsSumOfFirstFoursChar("AK74U");
        StringHashCodeIsSumOfFirstFoursChar sumOfChar4 = new StringHashCodeIsSumOfFirstFoursChar("Uzi");
        StringHashCodeIsSumOfFirstFoursChar sumOfChar5 = new StringHashCodeIsSumOfFirstFoursChar("Fort12");
        StringHashCodeIsSumOfFirstFoursChar sumOfChar6 = new StringHashCodeIsSumOfFirstFoursChar("AK47");
        StringHashCodeIsSumOfFirstFoursChar sumOfChar7 = new StringHashCodeIsSumOfFirstFoursChar("Flaber");
        StringHashCodeIsSumOfFirstFoursChar sumOfChar8 = new StringHashCodeIsSumOfFirstFoursChar("DIgle");
        Map<StringHashCodeIsSumOfFirstFoursChar, StringHashCodeIsSumOfFirstFoursChar> hashCodeIsSum4FirstChar = new HashMap<>();
        hashCodeIsSum4FirstChar.put(sumOfChar1, sumOfChar1);
        hashCodeIsSum4FirstChar.put(sumOfChar2, sumOfChar2);
        hashCodeIsSum4FirstChar.put(sumOfChar3, sumOfChar3);
        hashCodeIsSum4FirstChar.put(sumOfChar4, sumOfChar4);
        hashCodeIsSum4FirstChar.put(sumOfChar5, sumOfChar5);
        hashCodeIsSum4FirstChar.put(sumOfChar6, sumOfChar6);
        hashCodeIsSum4FirstChar.put(sumOfChar7, sumOfChar7);
        hashCodeIsSum4FirstChar.put(sumOfChar8, sumOfChar8);
        for (Map.Entry<StringHashCodeIsSumOfFirstFoursChar, StringHashCodeIsSumOfFirstFoursChar> entry : hashCodeIsSum4FirstChar.entrySet()) {
            StringHashCodeIsSumOfFirstFoursChar key = entry.getKey();
            StringHashCodeIsSumOfFirstFoursChar value = entry.getValue();
            System.out.println(key + " " + value);
        }
        System.out.println(" ");
        Map<StringHashCodeIsSumOfFirstFoursChar, StringHashCodeIsSumOfFirstFoursChar> hashCodeIsSum4FirstCharLinkedHasMap = new LinkedHashMap<>();
        hashCodeIsSum4FirstCharLinkedHasMap.put(sumOfChar1, sumOfChar1);
        hashCodeIsSum4FirstCharLinkedHasMap.put(sumOfChar2, sumOfChar2);
        hashCodeIsSum4FirstCharLinkedHasMap.put(sumOfChar3, sumOfChar3);
        hashCodeIsSum4FirstCharLinkedHasMap.put(sumOfChar4, sumOfChar4);
        hashCodeIsSum4FirstCharLinkedHasMap.put(sumOfChar5, sumOfChar5);
        hashCodeIsSum4FirstCharLinkedHasMap.put(sumOfChar6, sumOfChar6);
        hashCodeIsSum4FirstCharLinkedHasMap.put(sumOfChar7, sumOfChar7);
        hashCodeIsSum4FirstCharLinkedHasMap.put(sumOfChar8, sumOfChar8);
        for (Map.Entry<StringHashCodeIsSumOfFirstFoursChar, StringHashCodeIsSumOfFirstFoursChar> entry : hashCodeIsSum4FirstCharLinkedHasMap.entrySet()) {
            StringHashCodeIsSumOfFirstFoursChar key = entry.getKey();
            StringHashCodeIsSumOfFirstFoursChar value = entry.getValue();
            System.out.println(key + " " + value);
        }
    }
}
