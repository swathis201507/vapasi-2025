public class HardDrive {

    private int size;
    private String type;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "HardDrive{" +
                "size=" + size +
                ", type='" + type + '\'' +
                '}';
    }
}
