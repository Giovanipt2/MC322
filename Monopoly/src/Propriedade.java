/**
 * Essa classe será usada como base para todos os tipos de propriedades do jogo
 * Seus atributos serão nome, preço e valor do aluguel
 * Herda da superclasse Carta
 */
public class Propriedade extends Carta{
    private String nome;        //String que representa o nome da propriedade 
    private int preco;          //Valor de compra da propriedade
    private double aluguel;         //Valor do aluguel base da propriedade

    // Construtor
    public Propriedade(int id, String descricao, Jogador dono, String nome, int preco, Jogador proprietario, double aluguel) {
        super(id, descricao, dono);
        this.nome = nome;
        this.preco = preco;
        this.aluguel = aluguel;
    }

    // Getters e setters
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

    
    /**
     * Método que define como as informações de uma propriedade serão exibidas
     */
    @Override       //Indicador de que este método sobrescreve o método "toString" que já existe na superclasse
    public String toString() {
        String out = "";
        out += super.toString();
        out += "Nome: " + nome + "\n";
        out += "Preço: " + preco + "\n";
        out += "Valor do aluguel: " + aluguel + "\n";

        return out;
    }
}

