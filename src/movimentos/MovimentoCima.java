package movimentos;

import sliding_puzzle_IA.Estado;
import sliding_puzzle_IA.No;
import sliding_puzzle_IA.Peca;

public class MovimentoCima extends MovimentoImp implements Movimento {

	@Override
	public No mover(No noAtual) {
		Estado estadoMovimentado = noAtual.estado.clone(this, noAtual.estado);
		setPosicoes(noAtual.estado);
		
		setEspacoVazio(posX, posY-1, estadoMovimentado);
		Peca pecaMovimentada = noAtual.estado.pecas[posY-1][posX];
		setNovaPosicaoPecaMovimentada(posX, posY, estadoMovimentado, pecaMovimentada);
		estadoMovimentado.atualizarDistanciaTotal();
		
		return getNovoNo(noAtual, estadoMovimentado);
	}

	@Override
	public boolean isPermitidoMovimento(Estado estado) {
		return estado.posicaoVazia.posicaoFinalY - 1 >= 0;
	}
	
	@Override
	public boolean isMovimentoValido(Estado estado) {		
		return !(estado.movimento instanceof MovimentoBaixo);
	}
	
	@Override
	public boolean isPossivelMovimento(Estado estado) {
		Peca livre = estado.posicaoVazia;
		return estado.pecas[livre.posicaoFinalY-1][livre.posicaoFinalX].isPecaPosicaoFinal();
	}
	
	@Override
	public String toString() {
		return "Movimento para cima";
	}
}
