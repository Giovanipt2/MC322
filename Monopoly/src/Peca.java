/**
 * Classe responsável por armazenar as informações das peças do jogo
 * Seus atributos serão cor e posição
 */
public class Peca {
    private String cor;     //Cor da peça
    private int posicao;    //Posição da peça no tabuleiro

    //Construtor
    public Peca(String cor) {
        this.cor = cor;
        this.posicao = 0; // Por padrão, a posição inicial é 0 (início)
    }

    //Getters e setters
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    /**
     * Método que define como as informações da peça serão exibidas
     */
    @Override
    public String toString() {
        return "A peça é da cor " + cor + " e está na posição " + posicao + "\n";
    }
}
