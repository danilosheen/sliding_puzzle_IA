package sliding_puzzle_IA;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe para representa��o dos movimentos de uma pe�a no jogo
 * 
 * @author Ivan Josiel
 *
 */
public class Acao {
	public static final int MOVER_PARA_CIMA = 0;
	public static final int MOVER_PARA_BAIXO = 1;
	public static final int MOVER_PARA_ESQUERDA = 2;
	public static final int MOVER_PARA_DIREITA = 3;

	Peca pecaMovimentada;

	public List<Integer> getAcoesPossiveis(Estado estado) {
		List<Integer> movimentos = new ArrayList<>();

		if (isPermitidoMovimento(MOVER_PARA_CIMA, estado))
			movimentos.add(MOVER_PARA_CIMA);
		if (isPermitidoMovimento(MOVER_PARA_BAIXO, estado))
			movimentos.add(MOVER_PARA_BAIXO);
		if (isPermitidoMovimento(MOVER_PARA_ESQUERDA, estado))
			movimentos.add(MOVER_PARA_ESQUERDA);
		if (isPermitidoMovimento(MOVER_PARA_DIREITA, estado))
			movimentos.add(MOVER_PARA_DIREITA);

		return movimentos;
	}

	/**
	 * Indica se � poss�vel realizar determinado tipo de movimento no estado recebido
	 * 
	 * @param tipoMovimento int que indica o tipo de movimento a ser realizado
	 * @param estado Estado atual
	 * @return boolean indicando a possibilidade do movimento
	 */
	public boolean isPermitidoMovimento(int tipoMovimento, Estado estado) {
		boolean resultado = false;
		switch (tipoMovimento) {
		case MOVER_PARA_CIMA:
			resultado = isPermitidoMovimentoParaCima(estado);
			break;
		case MOVER_PARA_BAIXO:
			resultado = isPermitidoMovimentoParaBaixo(estado);
			break;
		case MOVER_PARA_ESQUERDA:
			resultado = isPermitidoMovimentoParaEsquerda(estado);
			break;
		default:
			resultado = isPermitidoMovimentoParaDireita(estado);
			break;
		}

		return resultado;
	}

	private boolean isPermitidoMovimentoParaCima(Estado estado) {
		return estado.pecas[pecaMovimentada.posicaoAtualX][pecaMovimentada.posicaoAtualY + 1] != null;
	}

	private boolean isPermitidoMovimentoParaBaixo(Estado estado) {
		return estado.pecas[pecaMovimentada.posicaoAtualX][pecaMovimentada.posicaoAtualY - 1] != null;
	}

	private boolean isPermitidoMovimentoParaEsquerda(Estado estado) {
		return estado.pecas[pecaMovimentada.posicaoAtualX - 1][pecaMovimentada.posicaoAtualY] != null;
	}

	private boolean isPermitidoMovimentoParaDireita(Estado estado) {
		return estado.pecas[pecaMovimentada.posicaoAtualX + 1][pecaMovimentada.posicaoAtualY + 1] != null;
	}

}