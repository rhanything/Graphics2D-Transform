/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabmalopes;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author rh4nyel
 */
public class Geometria {
    
    private List<Ponto> pontos = new ArrayList<>();
    //private List<Aresta> atestas = new ArrayList<>();
    private String id;
    private Integer nroPontos;
    
    public static Geometria build(float[] X, float[] Y, String pid) throws IOException {
        Geometria geometria = new Geometria();
        geometria.setId(pid);
        geometria.setNroPontos(X.length);
        
        for(int i=0; i<geometria.getNroPontos(); i++)
        {
            Ponto ponto = new Ponto(X[i], Y[i]);
            geometria.getPontos().add(ponto);
        }
        
        return geometria;
    }

    public List<Ponto> getPontos() {
        return pontos;
    }

   /* public List<Aresta> getAtestas() {
        return atestas;
    }*/

    public String getId() {
        return id;
    }
    
    public Integer getNroPontos(){
        return nroPontos;
    }
    
    public void setNroPontos(int nroPontos){
        this.nroPontos = nroPontos;
    }

    public void setPontos(List<Ponto> pontos) {
        this.pontos = pontos;
    }

  /*  public void setAtestas(List<Aresta> atestas) {
        this.atestas = atestas;
    }*/

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Geometria{" + "pontos=" + pontos + ", id=" + id + '}';
    }

    
    
    
    
}
