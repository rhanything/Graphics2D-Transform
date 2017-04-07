/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabmalopes;

/**
 *
 * @author rh4nyel
 */
public class Aresta {
    private int p1, p2;

    public Aresta(int p1, int p2) {
        super();
        this.p1 = p1;
        this.p2 = p2;
    }

    public Aresta() {
        super();
    }
    
    
    
    

    public int getP1() {
        return p1;
    }

    public void setP1(int p1) {
        this.p1 = p1;
    }

    public int getP2() {
        return p2;
    }

    public void setP2(int p2) {
        this.p2 = p2;
    }

    @Override
    public String toString() {
        return "Aresta{" + "p1=" + p1 + ", p2=" + p2 + '}';
    }
    
    
    
}
