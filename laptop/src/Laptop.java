public class Laptop {

    private String logo="MAC";
    private Processsor processsor;
    private RAM ram;
    private HardDrive hardDrive;

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Processsor getProcesssor() {
        return processsor;
    }

    public void setProcesssor(Processsor processsor) {
        this.processsor = processsor;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public HardDrive getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(HardDrive hardDrive) {
        this.hardDrive = hardDrive;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "logo='" + logo + '\'' +
                ", processsor=" + processsor +
                ", ram=" + ram +
                ", hardDrive=" + hardDrive +
                '}';
    }
}
