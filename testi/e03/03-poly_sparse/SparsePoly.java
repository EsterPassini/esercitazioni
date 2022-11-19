import java.util.LinkedList;
import java.util.List;
public class SparsePoly{
    /*private class Monomio{
        int degree;
        int coeff;
    }
    public Monomio(int degree, int coeff){
        this.degree=degree;
        this.coeff=coeff;
    }*/

    //è immutabile

    //OVERVIEW: Le istanze di questa classe rappresentano polinomi sparsi a una variabile
    //          con grado non negativo. Un polinomio tipico è: c0x^d0 + ... + cnx^dn
    private record Monomio(int degree,int coeff){
        public Monomio(int degree, int coeff){
            if (degree<0)
                throw new NegativeExponentException("Il grado non può essere negativo"); //non controllata: la può prevenire il programmatore
        }

        public String toString( ){
            return coeff + "x^" + degree;
        }

    }    
}

    //CAMPI
    List <Monomio> terms;
    //AF(terms) = terms[0].coeff*x^terms[0].degree +...+ terms[n].coeff*x^terms[n].degree
    //            if n==0 => 0
    //RI(terms) = terms[i].degree >=0
    //&& terms dev'essere ordinata per grado
    //&& tutti gli elementi di terms devono essere Monomi


    //COSTRUTTORI
    //EFFECTS: Costruisce il polinomio da zero
    public SparsePoly(){
        terms = new LinkedList<>();
    }
    //EFFECTS: Costruisce il polinomio coeff*x^degree
    //         Solleva un'eccezione di tipo NegativeExponentException se degree < 0
    public SparsePoly(int coeff, int degree){
        this();
        if (coeff!=0) terms.add(new Monomio(degree,coeff));
    }
    //METODI
    //Restituisce il grado del polinomio
    public int degree(){
        if (terms.size()==0) return -1;
        return terms.get(terms.size()-1).degree;
    }

    //EFFECTS: restituisce l'indice del monomio il cui grado è degree
    //         altrimenti -IP -1

    //divido per 2 shiftando di uno, in questo modo non rischio
    // che un numero diventato negativo con la somma (caso overflow) rimanga negativo con la divisione
    private int findByDegree(int degree){
        int min = 0, max = terms.size()-1;
        while (min<max){
            int mid = (min+max) >>> 1; 
            int midDegree = terms.get(mid).degree;
            if (midDegree > degree) min = mid + 1;
            else if (midDegree < degree) max= mid-1;
            else{ // valori uguali
                return mid;
            }
        }
        return -(min+1);

    }

    //REQUIRES: deg >= 0
    //EFFECYS: restituisce il coef relartivo a x^deg
    public int coeffByDegree(){

        return 0;
    }

    //REQUIRES: other non null
    //EFFECTS: Restituisce this + other
    public SparsePoly sum(SparsePoly other){

    }

    public SparsePoly mul(SparsePoly ){
        
    }
