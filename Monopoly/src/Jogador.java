import java.util.ArrayList;

/**
 * Essa classe será usada para representar os jogadores do Monopoly e conter suas informações
 * Seus atributos serão nome, cpf, email, foto, id, dinheiro, cartas (array) e peça
 */
public class Jogador {
    private static final int DINHEIRO_INICIAL = 5000;   //Quantidade de dinheiro inicial de cada jogador
    private String nome;        //Nome do jogador
    private String cpf;         //CPF do jogador
    private String email;       //Email do jogador
    private String foto;        //String que guarda o caminho para a foto do jogador
    private int dinheiro;       //Quantidade de dinheiro que um jogador possui
    private int id;       //Númedo de identificação de um jogador (ID)
    private static int numJogadores = 0;    //Número de jogadores inicializados
    private ArrayList<Carta> cartas;    //Array que armazenará as cartas do jogador
    private Peca peca;          //Peça que representa o jogador no tabuleiro
    private int nEstacoes;     //Número de estações que esse jogador possui

    //Construtor
    public Jogador(String nome, String cpf, String email, String foto, Peca peca) {
        this.nome = nome;
        this.cpf= cpf;
        this.email = email;
        this.foto = foto;
        this.dinheiro = DINHEIRO_INICIAL;   
        this.id = numJogadores++;           //ID atribuído com base no número de jogadores inicializados
        this.peca = peca;
        this.cartas = new ArrayList<Carta>();
        this.nEstacoes = 0;
    }

    //Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }

    public int getId() {
        return id;
    }

    public Peca getPeca() {
        return peca;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public int getNEstacoes() {
        return nEstacoes;
    }

    public void setNEstacoes(int nEstacoes) {
        this.nEstacoes = nEstacoes;
    }

    
    /**
     * Método que define como as informações do jogador serão exibidas
     */
    @Override       //Indicador de que este método sobrescreve o método "toString" que já existe na superclasse
    public String toString() {
        String out = "";
        out += "Nome: " + nome + "\n";
        out += "CPF: " + cpf + "\n";
        out += "Email: " + email + "\n";
        out += "Foto: " + foto + "\n";
        out += "ID: " + id + "\n";
        out += "Dinheiro atual: " + dinheiro + "\n";
        out += peca.toString();
        out += "Cartas do jogador:\n";

        if (cartas.size() > 0)
            for (Carta carta : cartas) 
                out += carta.getDescricao() + "\n";
        
        else
            out += "O jogador ainda não possui nenhuma carta\n";

        return out;
    }


    /**
     * Método utilizado para saber se o jogador tem o dinheiro necessário para comprar algo
     * @param valor Número inteiro que representa o valor da compra que o jogador pretende realizar
     * @return True, se o jogador tem dinheiro para comprar; ou false, caso contrário
     */
    public boolean temDinheiro(int valor) {
        return (dinheiro >= valor) ? true : false;
    }


    /**
     * Método para retirar do dinheiro do jogador o valor gasto
     * @param preco Valor gasto pelo jogador em determinada situação
     * @return
     */
    public void debitarSaldo(int preco) {
        this.dinheiro -= preco;
    }   


    /**
     * Método utilizado para adicionar à mão do jogador uma carta
     * @param carta Carta que será adicionada ao jogador
     * @return True, se é possível adicionar a carta; ou false, caso contrário
     */
    public boolean adicionaCarta(Carta carta) {
        return cartas.add(carta);
    }


    /**
     * Método utilizado para remover da mão do jogador uma carta
     * @param carta Carta que será removida do jogador
     * @return True, se é possível remover a carta; ou false, caso contrário
     */
    public boolean removeCarta(Carta carta) {
        return cartas.remove(carta);
    }


     /**
     * Método utilizado pelo jogador para comprar uma propriedade
     * @param propriedade Objeto da classe Propriedade que representa uma instância dela
     * @throws DinheiroInsuficienteException Se o saldo do jogador for insuficiente para comprar a propriedade
     */
    public void compra(Propriedade propriedade) throws DinheiroInsuficienteException {
        int preco = propriedade.getPreco();
        if (!temDinheiro(preco)) {
            throw new DinheiroInsuficienteException("Saldo insuficiente para comprar a propriedade: " + propriedade.getNome());
        }
        debitarSaldo(preco);
        adicionaCarta(propriedade);
    }


    /**
     * Método para ver se o jogador faliu (condição de derrota)
     * @return True, se o jogador está sem dinheiro; ou false, caso contrário
     */
    public boolean faliu() {
        return (dinheiro == 0) ? true : false;
    }
}
