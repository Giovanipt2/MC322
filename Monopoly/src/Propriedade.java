/**
 * Essa classe será usada como base para todos os tipos de propriedades do jogo
 * Seus atributos serão nome, preço e valor do aluguel
 * Herda da superclasse Carta
 */
public class Propriedade extends Carta{
    private String nome;        //String que representa o nome da propriedade 
    private int preco;          //Valor de compra da propriedade
    private int aluguel;         //Valor do aluguel base da propriedade
    private Jogador dono;       //Instância da classe jogador que possui tal carta

    // Construtor
    public Propriedade(int id, String descricao, TipoCarta tipo, String nome, int preco, int aluguel) {
        super(id, descricao, tipo);
        this.nome = nome;
        this.preco = preco;
        this.aluguel = aluguel;
        this.dono = null;
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

    public int getAluguel() {
        return aluguel;
    }

    public void setAluguel(int aluguel) {
        this.aluguel = aluguel;
    }

    public Jogador getDono() {
        return dono;
    }

    public void setDono(Jogador dono) {
        this.dono = dono;
    }

    
    /**
     * Retorna o valor do aluguel base da propriedade em questão
     * @return O valor do aluguel base da propriedade
     */
    public int calcularAluguel() {
        return this.aluguel;
    }


    /**
     * Método para verificar se determinada propriedade possui um dono
     * @return Verdadeiro, se já possui proprietário; ou false, caso contrário
     */
    public boolean temDono() {
        return (dono != null) ? true : false;
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

