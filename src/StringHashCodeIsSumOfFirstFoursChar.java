public class StringHashCodeIsSumOfFirstFoursChar {

    private String name;

    public StringHashCodeIsSumOfFirstFoursChar(String name) {
        this.name = name;
    }
    @Override
    public int hashCode() {
        char[] charArrayOfName = name.toCharArray();
        int sumOfFirstFoursChar = charArrayOfName[0] + charArrayOfName[1] + charArrayOfName[2] + charArrayOfName[3];
        return sumOfFirstFoursChar;
    }
    @Override
    public String toString() {
        return name;

    }
}