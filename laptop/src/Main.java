//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        Laptop laptop=new Laptop();
        laptop.setLogo("MAC");

        Processsor proc=new Processsor();
        proc.setGeneration("Pro");
        proc.setGigabytes(111111111);
        laptop.setProcesssor(proc);


        RAM ram=new RAM();
        ram.setSize(22222);
        ram.setGeneration("1st");

        laptop.setRam(ram);

        HardDrive hd=new HardDrive();
        hd.setSize(778988);
        hd.setType("high");
        laptop.setHardDrive(hd);

        System.out.println(laptop);


        Laptop laptop2=new Laptop();
        laptop2.setLogo("MAC");

        Processsor proc2=new Processsor();
        proc2.setGeneration("Pro222");
        proc2.setGigabytes(2423);
        laptop2.setProcesssor(proc2);


        RAM ram2=new RAM();
        ram2.setSize(22222);
        ram2.setGeneration("1st");

        laptop2.setRam(ram2);

        HardDrive hd2=new HardDrive();
        hd2.setSize(778988);
        hd2.setType("high");
        laptop2.setHardDrive(hd2);

        System.out.println(laptop2);


    }
}