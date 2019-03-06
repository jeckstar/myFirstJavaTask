import java.util.Objects;

public class MyString {

    private String name;

    public MyString(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name.length();
    }

    public int hashCode1() {
        char[] charArrayOfName = name.toCharArray();
        int sumOfFirstFoursChar = charArrayOfName[1]+charArrayOfName[1]+charArrayOfName[2]+charArrayOfName[3];
        return sumOfFirstFoursChar;
    }

}
