/**
 * Classe respons ́avel por armazenar as informa ̧c ̃oes das pe ̧cas do jogo
 * Seus atributos serão cor e posição
 */
public class Peca {
    private String cor;     //Cor da peça
    private int posicao;    //Posição da peça no tabuleiro

    //Construtor
    public Peca(String cor, int posicao) {
        this.cor = cor;
        this.posicao = posicao;
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
    @Override       //Indicador de que este método sobrescreve o método "toString" que já existe na superclasse
    public String toString() {
        String out = "";
        out += "A peça é da cor " + cor + " e está na posção " + posicao + "\n";
 
        return out;
    }

    
}
