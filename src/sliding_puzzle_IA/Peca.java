package sliding_puzzle_IA;

/**
 * Classe que representa uma pe�a do jogo
 * @author Ivan Josiel
 *
 */
public class Peca {
	int posicaoAtualX;
	int posicaoAtualY;
	int posicaoFinalX;
	int posicaoFinalY;
	int distancia;
	
	public Peca(int posicaoAtualX, int posicaoAtualY, int posicaoFinalX, int posicaoFinalY) {
		super();
		this.posicaoAtualX = posicaoAtualX;
		this.posicaoAtualY = posicaoAtualY;
		this.posicaoFinalX = posicaoFinalX;
		this.posicaoFinalY = posicaoFinalY;
		this.distancia = getDistancia();
	}
	
	/**
	 * Retorna a distancia manhattan entre a posi��o atual e a posi��o final da pe�a
	 */
	public int getDistancia() {
		return getDistanciaManhattan();
	}

	private int getDistanciaManhattan() {
		return projecaoLinhaX() + projecaoLinhaY();
	}
	
	/**
	 * Retorna o comprimento da projec��o da linha no eixo X
	 */
	private int projecaoLinhaX() {
		return Math.abs(posicaoFinalX - posicaoAtualX);
	}
	
	/**
	 * Retorna o comprimento da projec��o da linha no eixo Y
	 */
	private int projecaoLinhaY() {
		return Math.abs(posicaoFinalY - posicaoAtualY);
	}
	
	

}
