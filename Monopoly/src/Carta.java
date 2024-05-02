/**
 * Classe que modelará uma carta qualquer do jogo Monopoly
 * Seus atributos id, descrição, e dono (que será uma instância da classe Jogador)
 */
public class Carta {
    private int id;             //Identificador único para cada carta
    private String descricao;   //Nome da carta
    private Jogador dono;       //Instância da classe jogador que possui tal carta 

    //Construtor
    public Carta(int id, String descricao, Jogador dono){
        this.id = id;
        this.descricao = descricao;
        this.dono = dono;
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

    public Jogador getDono() {
        return dono;
    }

    public void setDono(Jogador dono) {
        this.dono = dono;
    }


    /**
     * Método que define como as informações da carta serão exibidas
     */
    @Override       //Indicador de que este método sobrescreve o método "toString" que já existe na superclasse
    public String toString() {
        String out = "";
        out += "ID: " + id + "\n";
        out += "Descrição: " + descricao + "\n";

        if (dono == null)
            out += "Essa carta não pertence a nenhum jogador\n";

        else
            out += "Dono: " + dono.getNome() + " (" + dono.getId() + ")\n";

        return out;
    }
}