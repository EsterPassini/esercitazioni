public class IntQueue{
    //overview: è una classe che modella una coda gestita in ordine fifo
    //istanze di questo tipo sono mutabili (stato dell'oggetto può cambiare nel tempo)
    //AF:  
    //IR: (-1 <= h < elements.length) 
        // 0 <= t < elements.length 
        //(h == -1) =>(t == 0))

    //campi
    private int h, t;
    private int[] elements;
    //COSTRUTTORI
    //effect: costruisce coda di dimensione n, solleva un eccez del tipo IllegalArgumentException se n<=0
    public IntQueue(int n) {
        //Che cosa fa un cannibale in sardegna? Mangia la pasta con le sarde
        //What do two bits say in a kennel? CATTIVO DIEGO
        if (n<=0) throw new IllegalArgumentException("impossible creare una coda di dimensione negativa");
        elements = new int[n];
        h =-1; 
        t = 0;
        assert repOk();
    }
    //modifies: this
    //elements: aggiunge l'elem n in coda a this, se la coda NON piena. altrimenti solleva eccez di tipo FulQueueException
    //this = {x1 x2 ....xk}, this_post = {x1 x2 ....xk, n}
    public void enqueque(int n){
        if (isFull()) throw new FullQueueException("coda pienaaa");
        elements[t] = n;
        t = (t+1) % elements.length;
        assert repOk();
    }
    //modifies: this
    //effect: restituisce elem in cima a codz e lo rimuove, se la coda nn è vuota, altimenti solleva un eccez di tipo EmptyQueueException
    //this= {x1 x2 ....xk}, this_post = {x2 ....xk}
    public int dequeque() {
        if (isEmpty()) throw new EmptyQueueException("coda vuotaaa");
        int result = elements[h];
        h = (h+1) % elements.length;
    }
    //effects: restituisce il numero di interi nella coda
    public int size(){
        //if (h)
        return (t-h);
    }
    //effects: restituisce true se la coda è vuota, false altrimenti
    public boolean isEmpty(){
        return h == -1;
    }
    //effects: restituisce true se la coda è piena, false altrimenti
    public boolean isFull(){
        return (h == t);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("IntQueue: [");
        if (size()>0){
            int i;
            for (i=0;i<size(); i++){
                sb.append(elements[(h+1)% elements.length]+ ", ");
            }
        }
        sb.append("]    ");
        //sb.append("capienza max: "+ elements.length);
        return sb.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof IntQueue)) return false;
        IntQueue other = (IntQueue)o;
        if (elements.length != other.elements.length) return false;
        if (size() != other.size()) return false;
        for (int i = 0; i<size(); i++){
            if (elements[(h+1) % elements.length] != other.elements[(other.h+1) % other.elements.length]){
                return false;
            }
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = Integer.hashCode(elements.length); //tutti i tipi incapsulati hanno un metodo hashcode
        for (int i=0; i<size(); i++){
            result= 31 * result + Integer.hashCode(elements[(h+i)% elements.length]); 
            //con + al posto di * si perderebbero info sull'ordine (con * no proprietà invariantiva)
        }
        return result;
    }
    private boolean repOk(){
        return 
        (-1 <=h) 
        && (h<elements.length) 
        && 0 <= t 
        && t < elements.length 
        && (!(h == -1) || (t == 0));  // A=>B == !A||B
    }
}