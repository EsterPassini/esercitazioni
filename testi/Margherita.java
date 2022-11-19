package testi;

public class Margherita {
    private int numPetali;
    private String colore;

    public Margherita(String colore){
        numPetali = (int) ((Math.random() * 99) + 1);
        this.colore = colore;
    }

    public Margherita(){
        this.numPetali = (int) ((Math.random() * 99) + 1);
        this.colore = "bianco";
    }

    public boolean AmaNonAma(){

        boolean verdetto = (this.numPetali%2 != 0);
        numPetali = 0;
        return verdetto;
    }

    public static void main(String[] args) {
        Margherita m1 = new Margherita();
        Margherita m2 = new Margherita("verde");

        System.out.println("Mi ama? m1 risponde: " + m1.AmaNonAma());
        System.out.println("Mi ama? m2 risponde: " + m2.AmaNonAma());
    }
}
