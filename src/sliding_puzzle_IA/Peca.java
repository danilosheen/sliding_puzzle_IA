package sliding_puzzle_IA;

/**
 * Classe que representa uma pe�a do jogo
 * @author Ivan Josiel
 *
 */
public class Peca {
	public int posicaoFinalX;
	public int posicaoFinalY;
	public int distancia;
	public Integer numero;
	
	public Peca(int posicaoFinalX, int posicaoFinalY, Integer numero) {
		super();
		this.posicaoFinalX = posicaoFinalX;
		this.posicaoFinalY = posicaoFinalY;
		this.numero = numero;
	}
	
	public static Peca getPecaVazia(int posicaoX, int posicaoY) {
		return new Peca(posicaoX, posicaoY, null);
	}
	
	public void setDistancia(int posAtualX, int posAtualY) {
		this.distancia = getDistancia(posAtualX, posAtualY);
	}
	
	/**
	 * Retorna a distancia manhattan entre a posi��o atual e a posi��o final da pe�a
	 */
	public int getDistancia(int posAtualX, int posAtualY) {
		return getDistanciaManhattan(posAtualX, posAtualY);
	}

	private int getDistanciaManhattan(int posAtualX, int posAtualY) {
		return projecaoLinhaX(posAtualX) + projecaoLinhaY(posAtualY);
	}
	
	/**
	 * Retorna o comprimento da projec��o da linha no eixo X
	 */
	private int projecaoLinhaX(int posicaoAtualX) {
		return Math.abs(posicaoFinalX - posicaoAtualX);
	}
	
	/**
	 * Retorna o comprimento da projec��o da linha no eixo Y
	 */
	private int projecaoLinhaY(int posicaoAtualY) {
		return Math.abs(posicaoFinalY - posicaoAtualY);
	}

	/**
	 * Informa se a pe�a est� em sua posi��o final
	 * @return
	 */
	public boolean isPecaPosicaoFinal() {
		return this.distancia != 0 ? true : false;
	}
	
	

}
