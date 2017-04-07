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
class Ponto {
    float x;
    float y;
    private float w;

    public Ponto() {
        super();
    }
    
   

    public Ponto(float x, float y) {
        super();
        this.x = x;
        this.y = y;
        this.w = 1;
    }
    
    
    
    public Ponto(float[][] mat){
		this.x = mat[0][0];
		this.y = mat[0][1];
		this.w = mat[0][2];
	}
    
    public Ponto(float x, float y, float w){
		this.x = x;
		this.y = y;
		this.w = w;
	}

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    
    public float[][] getMat() {
		float[][] out = new float[1][3];
		out[0][0] = x;
		out[0][1] = y;
		out[0][2] = w;
		return out;
	}

    @Override
    public String toString() {
        return "Ponto{" + "x=" + x + ", y=" + y + '}';
    }
    
    
}
