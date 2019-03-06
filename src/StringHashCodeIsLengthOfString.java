import java.util.Objects;

public class StringHashCodeIsLengthOfString {

    private String name;

    public StringHashCodeIsLengthOfString(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name.length();
    }
    @Override
    public String toString() {
        return name;

    }


}
