/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabmalopes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author rh4nyel
 */
public class Painel extends JPanel {
    
    private static final long serialVersionUID = 1L;
    private int maxX;
    private int maxY;
    private int centerX;
    private int centerY;
    private float pixelSize;
    private float maxRx = 50.0f;
    private float maxRy =30.0f;
    private List<Geometria> geometrias = new ArrayList<>();
    private Color color;
    private float Dx;
    private float Dy;

    public void setColor(Color color) {
        this.color = color;
    }

    public List<Geometria> getGeometrias() {
        return geometrias;
    }

    public void setDx(float Dx) {
        this.Dx = Dx;
    }
    
    public void setDy(float Dy){
        this.Dy = Dy;
    }
    


    
    public void addGeometria(Geometria geometria)
    {
        geometrias.add(geometria);
        repaint();
    }
    
    private void init()
    {
        maxX = this.getWidth();
        maxY = this.getHeight();
        centerX = maxX/2;
        centerY = maxY/2;
        float pixelWidth = maxRx/maxX;
        float pixelHeight = maxRy/maxY;
        pixelSize = Math.max(pixelWidth, pixelHeight);


        
    }
    
    /**
     *
     * @param graphics
     */
    @Override
    public void paint(Graphics graphics)
    {
        super.paint(graphics);
        init();
        graphics.setColor(color);
        setBackground(Color.BLACK);
        //drawLinha(graphics, -100, 0, 100, 0); //horizontal
        //drawLinha(graphics, 0, -100, 0, 100); //vertical
        drawGeometrias(graphics);
        //repaint();
    }
    
    public void aplicaRotacao(Geometria ret1)
    {
        Ponto base = pontoMedio(ret1);
        float[][] T1 = Transformacoes.matTrans(-base.x, -base.y);
	float[][] T2 = Transformacoes.matRot(Dx);
        float[][] T3 = Transformacoes.matTrans(base.x, base.y);
	float[][] Tf = Transformacoes.matComp(Transformacoes.matComp(T1, T2), T3);
        Transformacoes.composicao(ret1, Tf);
	Transformacoes.rotacao(ret1, 2);
        repaint();
    }
    
    public void aplicaTranslacao(Geometria ret1){
        Ponto base = pontoMedio(ret1);
        float[][] T1 = Transformacoes.matTrans(-base.x, -base.y);
		float[][] T2 = Transformacoes.matRot(30); //grau de rotacao
		float[][] T3 = Transformacoes.matTrans(base.x, base.y);
		float[][] Tf = Transformacoes.matComp(Transformacoes.matComp(T1, T2), T3);
                Transformacoes.composicao(ret1, Tf);
                Transformacoes.translacao(ret1, Dx, Dy);
                repaint();
                
        
    }
    
    public void aplicaComposicao(Geometria ret1){

		Ponto base = pontoMedio(ret1);

		float[][] T1 = Transformacoes.matTrans(-base.x, -base.y);
		float[][] T2 = Transformacoes.matRot(30); //grau de rotacao
		float[][] T3 = Transformacoes.matTrans(base.x, base.y);
		float[][] Tf = Transformacoes.matComp(Transformacoes.matComp(T1, T2), T3);

		Transformacoes.composicao(ret1, Tf);
		Transformacoes.rotacao(ret1, 2);

		 Transformacoes.translacao(ret1, -1, 0);
		
		Geometria ret2 = geometrias.get(2);
		Transformacoes.rotacao(ret2, 2);
    }
    
    public void aplicaEscala(Geometria ret1){
        Ponto base = pontoMedio(ret1);
        
        
		float[][] T1 = Transformacoes.matTrans(-base.x, -base.y);
		float[][] T2 = Transformacoes.matRot(30); //grau de rotacao
		float[][] T3 = Transformacoes.matTrans(base.x, base.y);
                float[][] T5 = Transformacoes.matEsc(Dx, Dy);
		float[][] Tf = Transformacoes.matComp(Transformacoes.matComp(T1, T2), T3);
                Transformacoes.composicao(ret1, Tf);
                Transformacoes.escala(ret1, Dx, Dy);
                repaint();

        
    }
    
    public void aplicaZoom(Geometria ret1)
    {
         Ponto base = pontoMedio(ret1);
        
        
		float[][] T1 = Transformacoes.matTrans(-base.x, -base.y);
		float[][] T2 = Transformacoes.matRot(30); //grau de rotacao
		float[][] T3 = Transformacoes.matTrans(base.x, base.y);
                float[][] T5 = Transformacoes.matEsc(Dx, Dy);
		float[][] Tf = Transformacoes.matComp(Transformacoes.matComp(T1, T2), T3);
                Transformacoes.composicao(ret1, Tf);
                Transformacoes.escala(ret1, Dx, Dy);
                repaint();
    }
    
    
    
    private Ponto pontoMedio(Geometria geom) {
		Ponto ponto = new Ponto();
		for (Ponto p : geom.getPontos()) {
			ponto.x = ponto.x + p.x;
			ponto.y = ponto.y + p.y;
		}
		ponto.x = ponto.x / geom.getPontos().size();
		ponto.y = ponto.y / geom.getPontos().size();
		return ponto;
	}
    
    int ix(float x)
    {
        return centerX + Math.round(x/pixelSize);
    }
    
      int iy(float y)
    {
        return centerY - Math.round(y/pixelSize);
    }

    private void drawLinha(Graphics graphics, Ponto p1, Ponto p2) {
        //System.out.println(p1.getX() + " " + p1.getY() + " " + p2.getX() + " " + p2.getY());
        graphics.drawLine(ix(p1.getX()), iy(p1.getY()), ix(p2.getX()), iy(p2.getY()));
    }

    private void drawGeometrias(Graphics graphics) {
        for(Geometria geometria: geometrias )
        {
            drawGeometria(graphics, geometria);
            //aplicaComposicao(geometria);
        }
         
    }

    private void drawGeometria(Graphics graphics, Geometria geometria) {
       
        
        
        /*for(int i=0; i<geometria.getNroPontos(); i+=2)
        {
            Ponto p1 = geometria.getPontos().get(i);
            Ponto p2 = geometria.getPontos().get(i+1);
            //System.out.println("p1-> "+p1 + "  p2->" + p2);
            drawLinha(graphics, p1, p2);
           
        }*/
       // Ponto p1 = new Ponto(100f, -3f);
       // Ponto p2 = new Ponto(-4f, 3f);
       //Ponto p1 = geometria.getPontos().get(0);
       //Ponto p2 = geometria.getPontos().get(1);
       
       Ponto p1 = new Ponto();
       Ponto p2 = new Ponto();
       for(int i=0; i<geometria.getNroPontos(); i+=2)
       {
          //System.out.println(i);
           p1 = geometria.getPontos().get(i);
            p2 = geometria.getPontos().get(i+1);
            drawLinha(graphics, p1, p2);

       }

       // System.out.println(p1);
        //System.out.println(p2);

    }

    private void drawLinha(Graphics graphics, float x1, float y1, float x2, float y2) {
        graphics.drawLine(ix(x1), iy(y1), ix(x2), iy(y2));
    }
    
    
}
