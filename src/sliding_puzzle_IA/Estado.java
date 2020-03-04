package sliding_puzzle_IA;

import movimentos.Movimento;

/**
 * Classe que representa um estado do jogo
 * 
 * @author Ivan Josiel
 *
 */
public class Estado {
	public int distanciaTotal;
	public Movimento movimento;
	public Peca pecas[][] = new Peca[3][3];
	public Peca posicaoVazia;

	public Estado(Movimento movimento, Peca[][] pecas, Peca posicaoVazia) {
		this.movimento = movimento;
		setPecas(pecas);
		this.posicaoVazia = posicaoVazia;
		this.distanciaTotal = getDistanciaTotal();
	}

	private void setPecas(Peca[][] pecas) {
		for (int i = 0; i < pecas.length; i++) {
			this.pecas[i] = pecas[i].clone();
		}
	}
	
	/**
	 * Retorna a soma das distancias entre posi��o atual e posi��o final de cada
	 * pe�a
	 */
	public int getDistanciaTotal() {
		distanciaTotal = 0;

		for (int i = 0; i < pecas.length; i++) {
			for (int j = 0; j < pecas[i].length; j++) {
				Peca peca = pecas[i][j];
				distanciaTotal += peca != null ? peca.getDistancia(j, i) : 0;
			}
		}

		return distanciaTotal;
	}
	
	public void atualizarDistanciaTotal() {
		this.distanciaTotal = getDistanciaTotal();
	}

	/**
	 * Indica se o estado atual � igual ao estado objetivo
	 */
	public boolean isEstadoMeta() {
		return getDistanciaTotal() == 0;
	}

    public Estado clone(Movimento movimento, Estado estado) {
        return new Estado(movimento, estado.pecas, estado.posicaoVazia);
    }
}
