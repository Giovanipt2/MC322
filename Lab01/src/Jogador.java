/**
 * Essa classe será usada para representar os jogadores do Monopoly e conter suas informações
 * Seus atributos serão nome, cpf, email e foto
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

    //Construtor
    public Jogador(String nome, String cpf, String email, String foto) {
        this.nome = nome;
        this.cpf= cpf;
        this.email = email;
        this.foto = foto;
        this.dinheiro = DINHEIRO_INICIAL;   
        this.id = numJogadores++;           //ID atribuído com base no número de jogadores inicializados
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

    
    /**
     * Método que define como as informações do jogador serão exibidas (válido para o projeto inicial)
     */
    @Override       //Indicador de que este método sobrescreve o método "toString" que já existe na superclasse
    public String toString(){
        return "Nome: " + nome + "\n" + "CPF: " + cpf + "\n" + "Email: " + email + "\n" + "Foto: " + foto;
    }


    /**
     * Método utilizado para saber se o jogador tem o dinheiro necessário para comprar algo
     * @param valor Número inteiro que representa o valor da compra que o jogador pretende realizar
     * @return True, se o jogador tem dinheiro para comprar; ou false, caso contrário
     */
    public boolean temDinheiro(int valor) {
        return (dinheiro >= valor) ? true : false;
    }
}
