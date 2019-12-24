package kiev.prog;

public class SizeGroupException extends Exception {
    private int size;

    public SizeGroupException(String message, int size) {
        super(message);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "SizeGroupException {" +
                "size=" + size +
                '}';
    }
}