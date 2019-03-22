package task_threads.file_byte_reader;

public class ValueOfString {
    private byte aByte;
    private int count;

    public ValueOfString(byte aByte, int count) {
        this.aByte = aByte;
        this.count = count;
    }

    public byte getaByte(){
        return aByte;
    }

    public int getCount() {
        return count;
    }


    @Override
    public String toString() {
        return "Byte " + this.aByte + " повторяеться " + this.count;
    }
}
