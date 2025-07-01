public class Processsor {

    private String generation;
    private int gigabytes;

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public int getGigabytes() {
        return gigabytes;
    }

    public void setGigabytes(int gigabytes) {
        this.gigabytes = gigabytes;
    }

    @Override
    public String toString() {
        return "Processsor{" +
                "generation='" + generation + '\'' +
                ", gigabytes=" + gigabytes +
                '}';
    }
}
