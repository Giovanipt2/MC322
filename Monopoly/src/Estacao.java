/**
 * Essa classe modelará como serão as estações do jogo
 * Herda da Super Classe Propriedade
 */
public class Estacao extends Propriedade {

    //Construtor
    public Estacao(int id, String nome, int preco, Jogador proprietario, double aluguel) {
        super(id, nome, preco, proprietario, aluguel);
    }

    /**
     * Retorna o valor do aluguel dessa estação
     * @return O valor do aluguel da estação
     */
    @Override
    public double calcularAluguel() {
        return this.getAluguel();
    }
}
