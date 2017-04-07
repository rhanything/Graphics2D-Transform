package trabmalopes;
import java.util.ArrayList;
import java.util.List;

public class Transformacoes {



	
	public static float[][] matRot(float ang) {
		ang = (float) (Math.PI * ang / 180.0);
		float[][] matTrans = {
				{(float)Math.cos(ang), (float)-Math.sin(ang), 0.0f},
				{(float)Math.sin(ang), (float) Math.cos(ang), 0.0f},
				{0.0f,   0.0f,   1.0f}
		};
		return matTrans;
	}

	
	public static float[][] matTrans(float dx, float dy) {
		float[][] matTrans = {
				{1.0f, 0.0f, 0.0f},
				{0.0f, 1.0f, 0.0f},
				{dx,   dy,   1.0f}
		};
		return matTrans;
	}

	
	public static float[][] matEsc(float sx, float sy) {
		float[][] matTrans = {
				{sx,   0.0f,  0.0f},
				{0.0f,   sy,  0.0f},
				{0.0f, 0.0f,  1.0f}
		};
		return matTrans;
	}


	public static float[][] matComp(float[][] matA, float[][] matB){
		return mult(matA, matB);
	}
	
	
	public static Ponto rotacao(Ponto ponto, float ang){
		float[][] pontoNovo = mult(ponto.getMat(), matRot(ang));
		return new Ponto(pontoNovo);
	}
	

	public static Ponto translacao(Ponto ponto, float dx, float dy){
		float[][] pontoNovo = mult(ponto.getMat(), matTrans(dx, dy));
		return new Ponto(pontoNovo);
	}
		

	public static Ponto escala(Ponto ponto, float sx, float sy){
		float[][] pontoNovo = mult(ponto.getMat(), matEsc(sx, sy));
		return new Ponto(pontoNovo);
	}
	
	
	public static Ponto composicao(Ponto ponto, float[][] matComp){
		float[][] pontoNovo = mult(ponto.getMat(), matComp);
		return new Ponto(pontoNovo);
	}
	
	
	public static void translacao(Geometria geom, float dx, float dy) {
		List<Ponto> novosPontos = new ArrayList<Ponto>();
		for(Ponto ponto: geom.getPontos()) {
			novosPontos.add(translacao(ponto, dx, dy));
                        
		}
		geom.setPontos(novosPontos);
	}

	
	public static void rotacao(Geometria geom, float ang){
		List<Ponto> novosPontos = new ArrayList<Ponto>();
		for(Ponto ponto: geom.getPontos()) {
			novosPontos.add(rotacao(ponto, ang));
		}
		geom.setPontos(novosPontos);
	}

	
	public static void escala(Geometria geom, float sx, float sy) {
		List<Ponto> novosPontos = new ArrayList<Ponto>();
		for(Ponto ponto: geom.getPontos()) {
			novosPontos.add(escala(ponto, sx, sy));
		}
		geom.setPontos(novosPontos);
	}

	
	public static void composicao(Geometria geom, float[][] matComp){
		List<Ponto> novosPontos = new ArrayList<Ponto>();
		for(Ponto ponto: geom.getPontos()) {
			novosPontos.add(composicao(ponto, matComp));
		}
		geom.setPontos(novosPontos);
	}
	

	private static float[][] mult(float[][] A, float[][] B){
		float[][] C = new float[A.length][B[0].length];
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<B[i].length; j++) {
				C[i][j] = 0.0f;
				for(int k=0; k<B.length; k++) {
					C[i][j] = C[i][j] + A[i][k] * B[k][j]; 
				}
			}
		}
		return C;
	}
	
	
	
	
}
