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

    public ArrayList<Propriedade> getPropriedades() {
        return propriedades;
    }


    /**
     * Método para adicionar um jogador ao array de jogadores
     * @param jogador Objeto da classe Jogador que representa uma instância dela
     * @return True, se é possível adicionar o jogador; ou false, caso contrário
     */
    public boolean adicionarJogador(Jogador jogador) {
        return jogadores.add(jogador);
    }


    /**
     * Método para remover um jogador do array de jogadores
     * @param jogador Objeto da classe Jogador que representa uma instância dela
     * @return True, se é possível remover o jogador; ou false, caso contrário
     */
    public boolean removerJogador(Jogador jogador) {
        return jogadores.remove(jogador);
    }


    /**
     * Método para adicionar uma propriedade ao array de propriedades
     * @param propriedade Objeto da classe Propriedade que representa uma instância dela
     * @return True, se é possível adicionar a propriedade; ou false, caso contrário
     */
    public boolean adicionarPropriedade(Propriedade propriedade) {
        return propriedades.add(propriedade);
    }

    
    /**
     * Método para remover uma propriedade do array de propriedades
     * @param propriedade Objeto da classe Propriedade que representa uma instância dela
     * @return True, se é possível remover a propriedade; ou false, caso contrário
     */
    public boolean removerPropriedade(Propriedade propriedade) {
        return propriedades.remove(propriedade);
    }


    /**
     * Método que define como as informações do tabuleiro serão exibidas
     */
    @Override       //Indicador de que este método sobrescreve o método "toString" que já existe na superclasse
    public String toString() {
        String out = "";
        out += "Jogadores na partida:\n";

        if (jogadores.size() > 0)
            for (Jogador jogador : jogadores)
                out += jogador.getNome() + " (" + jogador.getId() + ")\n";

        else
            out += "Ainda não há jogadores na partida\n";

        out += "Propriedades do tabuleiro:\n";

        if (propriedades.size() > 0)
            for (Propriedade propriedade : propriedades)
                out += propriedade.getNome() + " (" + propriedade.getId() + ")\n";

        else
            out += "Ainda não há propriedades no tabuleiro";
        
        return out;
    }


    /**
     * Busca por um jogador específico no tabuleiro com base em seu ID
     * @param id número inteiro que representa ID do jogador que está sendo buscado
     * @return Jogador que estava sendo procurado
     */
    public Jogador buscarJogador(int id) {
        for (Jogador jogador : jogadores) 
            if (jogador.getId() == id)
                return jogador;

        return null;    //Caso o jogador com tal ID não exista no tabuleiro
    }


    /**
     * Busca por um jogador específico no tabuleiro com base em seu ID
     * @param id número inteiro que representa ID do jogador que está sendo buscado
     * @return Jogador que estava sendo procurado
     */
    public Propriedade buscarPropriedade(int id) {
        for (Propriedade propriedade : propriedades) 
            if (propriedade.getId() == id)
                return propriedade;

        return null;    //Caso a propriedade com tal ID não exista no tabuleiro
    }
}   
