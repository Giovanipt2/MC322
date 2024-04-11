/**
 * Essa classe será usada como base para todos os tipos de propriedades do jogo
 * Seus atributos serão id, nome, proprietário e preço
 */
public class Propriedade {
    private int id;       //ID (número de identificação da propriedade)
    private String nome;        //String que representa o nome da propriedade 
    private int preco;          //Valor de compra da propriedade
    private Jogador proprietario;  //Jogador que é o dono atual de tal propriedade
    private double aluguel;         //Valor do aluguel base da propriedade

    // Construtor
    public Propriedade(int id, String nome, int preco, Jogador proprietario, double aluguel) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.proprietario = proprietario;
        this.aluguel = aluguel;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public Jogador getProprietario() {
        return proprietario;
    }

    public void setProprietario(Jogador proprietario) {
        this.proprietario = proprietario;
    }

    public double getAluguel() {
        return aluguel;
    }

    public void setAluguel(double aluguel) {
        this.aluguel = aluguel;
    }


    /**
     * Retorna o valor do aluguel base da propriedade em questão
     * @return O valor do aluguel base da propriedade
     */
    public double calcularAluguel() {
        return aluguel;
    }

    
}

