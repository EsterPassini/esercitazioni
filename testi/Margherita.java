package testi;

public class Margherita {
    //OVERVIEW: Le istanze di questa classe rappresentano delle margherite di tutti i colori, 
    //gli oggetti di questo tipo sono mutabili

    //CAMPI
    private int numPetali;
    private String colore;

    //IR: colore != null
    //    numPetali >= 0

    //AF: AF(numPetali, colore) =
    //    una margherita tale che:
    //    this.colore == colore && this.numPetali == numPetali

//COSTRUTTORI

    //EFFECTS: genera un istanza margherita del colore passato in imput
    public Margherita(String colore){
        numPetali = (int) ((Math.random() * 99) + 1);
        this.colore = colore;
    }

    //EFFECTS: genera un istanza margherita di colore bianco
    public Margherita(){
        this.numPetali = (int) ((Math.random() * 99) + 1);
        this.colore = "bianco";
    }

    //EFFECTS: genera un istanza margherita del colore, e dal numero di petali passati in imput se il numPetali è >=0,
    //          se numPetali<0 solleva un eccezione del tipo IllegalArgumentException
    public Margherita(int numPetali, String colore){
        if (this.numPetali < 0) {
            throw new IllegalArgumentException();
        }

        this.numPetali = numPetali;
        this.colore = colore;
    }

    @Override
    public String toString(){
        return ("margherita "+ this.colore + " di " + this.numPetali + " petali");
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Margherita)) return false;
        Margherita other = (Margherita)o;

        return (other.colore == this.colore && other.numPetali == this.numPetali);
    }

//OSSERVATIVI

    public String getcolore(){
        return this.colore;
    }

    public int getNumPetali(){
        return this.numPetali;
    }

//MODIFICATORI
    //EFFECTS: ritorna il risultato di un m'ama non m'ama fatto con this.margherita
    //         di this.margherita viene modificato il numero di petali, viene posto a zero.
    //         se this.margherita ha 0 petali viene sollevata un eccezione del tipo ZeroPetalsException
    //MODIFIES: this
    public boolean amaNonAma(){

        if (this.numPetali == 0) {
            throw new ZeroPetalsException("impossibile fare m'amaNonm'ama con 0 petali");
        }

        boolean verdetto = (this.numPetali%2 != 0);
        numPetali = 0;
        return verdetto;
    }

    public static void main(String[] args) {
        Margherita m1 = new Margherita();
        Margherita m2 = new Margherita("verde");

        System.out.println("num petali m1: " + m1.getNumPetali());
        System.out.println("colore m1: " + m1.getcolore());
        System.out.println(m2.toString());

        System.out.println("Mi ama? m1 risponde: " + m1.amaNonAma());
        System.out.println("Mi ama? m2 risponde: " + m2.amaNonAma());

        System.out.println("num petali m1: " + m1.getNumPetali());

        Margherita m3 = new Margherita(0, "rosa");
        System.out.println("Mi ama? m3 risponde: " + m3.amaNonAma());
    }
}
