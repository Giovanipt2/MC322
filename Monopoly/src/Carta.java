/**
 * Classe que modelará uma carta qualquer do jogo Monopoly
 * Seus atributos id, descrição, e dono (que será uma instância da classe Jogador)
 */
public class Carta {
    private int id;             //Identificador único para cada carta
    private String descricao;   //Nome da carta
    private TipoCarta tipo;     //Enumeração que indica qual é o tipo da carta

    //Construtor
    public Carta(int id, String descricao, TipoCarta tipo){
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    //Getters e setters
    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoCarta getTipo() {
        return tipo;
    }


    /**
     * Método que define como as informações da carta serão exibidas
     */
    @Override       //Indicador de que este método sobrescreve o método "toString" que já existe na superclasse
    public String toString() {
        String out = "";
        out += "ID: " + id + "\n";
        out += "Descrição: " + descricao + "\n";

        return out;
    }
}