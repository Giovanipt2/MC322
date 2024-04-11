import java.util.ArrayList;

/**
 * Essa classe será usada para representrar o tabuleiro do jogo
 * Seus atributos são jogadores e propriedades, dois arrays
 */
public class Tabuleiro {
    private ArrayList<Jogador> jogadores;           //Array que armazenará os jogadores
    private ArrayList<Propriedade> propriedades;    //Array que armazenará as propriedades

    //Construtor
    public Tabuleiro() {
        this.jogadores = new ArrayList<Jogador>();
        this.propriedades = new ArrayList<Propriedade>();
    }

    //Getters e setters
    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public ArrayList<Propriedade> getPropriedades() {
        return propriedades;
    }

    public void setPropriedades(ArrayList<Propriedade> propriedades) {
        this.propriedades = propriedades;
    }


    /**
     * Método para adicionar um jogador ao array de jogadores
     * @param jogador Objeto da classe Jogador que representa uma instância dela
     * @return True, se é possível adicionar o jogador; false, caso contrário
     */
    public boolean adicionarJogador(Jogador jogador) {
        return jogadores.add(jogador);
    }


    /**
     * Método para remover um jogador do array de jogadores
     * @param jogador Objeto da classe Jogador que representa uma instância dela
     * @return True, se é possível remover o jogador; false, caso contrário
     */
    public boolean removerJogador(Jogador jogador) {
        return jogadores.remove(jogador);
    }


    /**
     * Método para adicionar uma propriedade ao array de propriedades
     * @param propriedade Objeto da classe Propriedade que representa uma instância dela
     * @return True, se é possível adicionar a propriedade; false, caso contrário
     */
    public boolean adicionarPropriedade(Propriedade propriedade) {
        return propriedades.add(propriedade);
    }

    
    /**
     * Método para remover uma propriedade do array de propriedades
     * @param propriedade Objeto da classe Propriedade que representa uma instância dela
     * @return True, se é possível remover a propriedade; false, caso contrário
     */
    public boolean removerPropriedade(Propriedade propriedade) {
        return propriedades.remove(propriedade);
    }


}
