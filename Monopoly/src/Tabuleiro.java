import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Essa classe será usada para representrar o tabuleiro do jogo
 * Seus atributos são jogadores e propriedades, dois arrays
 * Essa classe não conterá o método distribuirCartas(), haja vista que, pela lógica construída
 * e considerando que, no Monopoly, os jogadores não começam com cartas, não haveria um uso produtivo dessa função
 */
public class Tabuleiro implements Salvavel {
    private static final int TAMANHO_TABULEIRO = 20;    //Definido como 28 posições
    private static final int BONUS_POR_PASSAR_INICIO = 200;     //Quantia em dinheiro ganha ao passar pelo início
    private ArrayList<Jogador> jogadores;           //Array que armazenará os jogadores
    private ArrayList<Propriedade> propriedades;    //Array que armazenará as propriedades
    private ArrayList<CartaSorte> cartasSorte;      //Array que armazenará as cartas de sorte
    private ArrayList<Carta> posicoes;             //Array que simulará o tabuleiro como um todo

    //Construtor
    public Tabuleiro() {
        this.jogadores = new ArrayList<Jogador>();
        this.propriedades = new ArrayList<Propriedade>();
        this.cartasSorte = new ArrayList<CartaSorte>();
        this.posicoes = new ArrayList<Carta>();
    }

    //Getters e setters
    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public ArrayList<Propriedade> getPropriedades() {
        return propriedades;
    }

    public ArrayList<CartaSorte> getCartas() {
        return cartasSorte;
    }

    public ArrayList<Carta> getPosicoes() {
        return posicoes;
    }

    public int getBonus() {
        return BONUS_POR_PASSAR_INICIO;
    }

    public int getTamanho() {
        return TAMANHO_TABULEIRO;
    }
    

    /**
     * Método para adicionar um jogador ao array de jogadores
     * @param jogador Objeto da classe Jogador que representa uma instância dela
     * @return True, se é possível adicionar o jogador; ou false, caso contrário
     */
    public boolean adicionarJogador(Jogador jogador) {
        boolean adicionado = jogadores.add(jogador);
        if (adicionado) {
            try {
                salvaLog("Jogador adicionado: " + jogador.getNome() + " (" + jogador.getId() + ")");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return adicionado;
    }

    /**
     * Método para remover um jogador do array de jogadores
     * @param jogador Objeto da classe Jogador que representa uma instância dela
     * @return True, se é possível remover o jogador; ou false, caso contrário
     */
    public boolean removerJogador(Jogador jogador) {
        boolean removido = jogadores.remove(jogador);
        if (removido) {
            try {
                salvaLog("Jogador removido: " + jogador.getNome() + " (" + jogador.getId() + ")");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return removido;
    }

    /**
     * Método para adicionar uma propriedade ao array de propriedades
     * @param propriedade Objeto da classe Propriedade que representa uma instância dela
     * @return True, se é possível adicionar a propriedade; ou false, caso contrário
     */
    public boolean adicionarPropriedade(Propriedade propriedade) {
        boolean adicionado = propriedades.add(propriedade);
        if (adicionado) {
            try {
                salvaLog("Propriedade adicionada: " + propriedade.getNome() + " (" + propriedade.getId() + ")");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return adicionado;
    }

    /**
     * Método para remover uma propriedade do array de propriedades
     * @param propriedade Objeto da classe Propriedade que representa uma instância dela
     * @return True, se é possível remover a propriedade; ou false, caso contrário
     */
    public boolean removerPropriedade(Propriedade propriedade) {
        boolean removido = propriedades.remove(propriedade);
        if (removido) {
            try {
                salvaLog("Propriedade removida: " + propriedade.getNome() + " (" + propriedade.getId() + ")");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return removido;
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
     * Busca por uma propriedade específica no tabuleiro com base em seu ID
     * @param id Número inteiro que representa ID da propriedade que está sendo buscada
     * @return Propriedade que estava sendo procurada
     */
    public Propriedade buscarPropriedade(int id) {
        for (Propriedade propriedade : propriedades) 
            if (propriedade.getId() == id)
                return propriedade;

        return null;    //Caso a propriedade com tal ID não exista no tabuleiro
    }

    /**
     * Implementação do método salvaLog da interface Salvavel
     * @param acao String que descreve a ação a ser salva no log
     */
    @Override
    public void salvaLog(String acao) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {
            writer.write(acao);
            writer.newLine();
        }
    }


    /**
     * Método para inicializar o tabuleiro do jogo
     * Este método já criará tudo que for necessário para começar a jogar
     */
    public void inicializarTabuleiro() {
        //Instanciação dos jogadores que jogarão o jogo
        jogadores.add(new Jogador("Alice", "111.111.111-00", "alice@example.com", "alice.jpg", new Peca("Azul")));
        jogadores.add(new Jogador("Bob", "222.222.222-00", "bob@example.com", "bob.jpg", new Peca("Vermelho")));
        jogadores.add(new Jogador("Carol", "333.333.333-00", "carol@example.com", "carol.jpg", new Peca("Verde")));
        jogadores.add(new Jogador("David", "444.444.444-00", "david@example.com", "david.jpg", new Peca("Amarelo")));

        //Instanciação das cartas de sorte ou revés disponíveis no jogo
        cartasSorte.add(new CartaSorte(0, "Parabéns, você ganhou R$100!", TipoCarta.SORTE, "", "", 100, "", 0, ""));
        cartasSorte.add(new CartaSorte(1, "Parabéns, você ganhou R$200!", TipoCarta.SORTE, "", "", 200, "", 0, ""));
        cartasSorte.add(new CartaSorte(2, "Parabéns, você ganhou R$300!", TipoCarta.SORTE, "", "", 300, "", 0, ""));
        cartasSorte.add(new CartaSorte(4, "Ops, você perdeu R$100!", TipoCarta.REVES, "", "", -100, "", 0, ""));
        cartasSorte.add(new CartaSorte(5, "Ops, você perdeu R$100!", TipoCarta.REVES, "", "", -200, "", 0, ""));
        cartasSorte.add(new CartaSorte(6, "Ops, você perdeu R$100!", TipoCarta.REVES, "", "", -300, "", 0, ""));

        //Instanciação das estações do jogo
        propriedades.add(new Estacao(0, "Estação de metrô 1", TipoCarta.ESTACAO, "Copacabana", 200, 40));
        propriedades.add(new Estacao(1, "Estação de metrô 2", TipoCarta.ESTACAO, "Sé", 300, 60));
        propriedades.add(new Estacao(2, "Estação de metrô 3", TipoCarta.ESTACAO, "Estação da Luz", 150, 30));
        propriedades.add(new Estacao(3, "Estação de metrô 4", TipoCarta.ESTACAO, "Consolação", 400, 80));

        //Instanciação dos serviços públicos do jogo
        propriedades.add(new ServicoPublico(4, "Companhia de eletricidade", TipoCarta.SERVICOPUBLICO, "CPFL", 500, 150));
        propriedades.add(new ServicoPublico(5, "Companhia de água", TipoCarta.SERVICOPUBLICO, "DAE", 300, 60));
        propriedades.add(new ServicoPublico(6, "Companhia de trem", TipoCarta.SERVICOPUBLICO, "CPTM", 400, 100));
        propriedades.add(new ServicoPublico(7, "Companhia de coleta de lixo", TipoCarta.SERVICOPUBLICO, "CIA Lixos", 250, 50));

        //Instanciação dos terrenos do jogo
        propriedades.add(new Terreno(8, "Terreno 1", TipoCarta.TERRENO, "Saudade", 300, 60, 30, 120));
        propriedades.add(new Terreno(9, "Terreno 2", TipoCarta.TERRENO, "Faria Lima", 400, 80, 40, 160));
        propriedades.add(new Terreno(10, "Terreno 3", TipoCarta.TERRENO, "Av. Brasil", 350, 70, 35, 140));
        propriedades.add(new Terreno(11, "Terreno 4", TipoCarta.TERRENO, "Jardins", 550, 110, 55, 220));
        propriedades.add(new Terreno(12, "Terreno 5", TipoCarta.TERRENO, "Morumbi", 380, 76, 38, 152));
        propriedades.add(new Terreno(13, "Terreno 6", TipoCarta.TERRENO, "Av. Rebouças", 300, 60, 30, 120));
        propriedades.add(new Terreno(14, "Terreno 7", TipoCarta.TERRENO, "Parque Fortaleza", 250, 50, 25, 100));
        propriedades.add(new Terreno(15, "Terreno 8", TipoCarta.TERRENO, "Fazenda da Paz", 200, 40, 20, 80));

        //Instanciação das posições que faltam e preenchimento do tabuleiro
        posicoes.add(new Carta(0, "Parabéns, você passou pelo início! Receba R$200", TipoCarta.INICIO));
        posicoes.add(propriedades.get(0));
        posicoes.add(propriedades.get(4));
        posicoes.add(propriedades.get(8));
        posicoes.add(propriedades.get(9));
        posicoes.add(new Carta(1, "Pegue uma carta e descubra sua sorte!", TipoCarta.SORTE));
        posicoes.add(propriedades.get(1));
        posicoes.add(propriedades.get(5));
        posicoes.add(propriedades.get(2));
        posicoes.add(new Carta(2, "Pegue uma carta e descubra sua sorte!", TipoCarta.SORTE));
        posicoes.add(propriedades.get(10));
        posicoes.add(propriedades.get(11));
        posicoes.add(propriedades.get(12));
        posicoes.add(propriedades.get(6));
        posicoes.add(new Carta(3, "Pegue uma carta e descubra sua sorte!", TipoCarta.SORTE));
        posicoes.add(propriedades.get(3));
        posicoes.add(propriedades.get(13));
        posicoes.add(propriedades.get(14));
        posicoes.add(propriedades.get(15));
        posicoes.add(propriedades.get(7));
    }


    /**
     * Método que simula o lançamento de um dado
     * @return Um número aleatório entre 1 e 6 (dado tradicional)
     */
    public int rolarDado() {
        Random random = new Random();
        int resultado = random.nextInt(6) + 1;      //Gera um número aleatório entre 1 e 6
        try {
            salvaLog("Jogador rolou o dado e tirou: " + resultado);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }


    /**
     * Método para mover o jogador no tabuleiro
     * Se ele passar pela posição inicial, receberá dinheiro
     * @param jogador Jogador que está tendo o seu turno
     * @param numeroNoDado Número que ele tirou no dado
     */
    public void moverJogador(Jogador jogador, int numeroNoDado) {
        int posicaoAtual = jogador.getPeca().getPosicao();
        int novaPosicao = (posicaoAtual + numeroNoDado) % TAMANHO_TABULEIRO;
        
        // Verifica se o jogador passou pela posição inicial
        if (posicaoAtual + numeroNoDado > TAMANHO_TABULEIRO) {
            jogador.setDinheiro(jogador.getDinheiro() + BONUS_POR_PASSAR_INICIO);
            try {
                salvaLog(jogador.getNome() + " passou pela posição inicial e ganhou " + BONUS_POR_PASSAR_INICIO + "!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(jogador.getNome() + " passou pela posição inicial e ganhou " + BONUS_POR_PASSAR_INICIO + "!");
        }

        jogador.getPeca().setPosicao(novaPosicao);
    }


    /**
     * Método para sortear uma carta de sorte ou revés
     * @return A carta sorte ou revés que foi sorteada
     */
    public CartaSorte sortearCartaSorte() {
        Random random = new Random();
        int indice = random.nextInt(cartasSorte.size());
        CartaSorte cartaSorteada = cartasSorte.get(indice);
        try {
            salvaLog("Carta sorteada: " + cartaSorteada.getDescricao());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cartaSorteada;
    }
}
