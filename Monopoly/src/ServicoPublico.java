/**
 * Essa classe modelará como serão os serviços públicos do jogo
 * Herda da Super Classe Propriedade
 */
public class ServicoPublico extends Propriedade {

    //Construtor
    public ServicoPublico(int id, String descricao, Jogador dono, String nome, int preco, Jogador proprietario, double aluguel) {
        super(id, descricao, dono, nome, preco, proprietario, aluguel);
    }

    /**
     * Calcula o valor do aluguel desse serviço público com base no número dos dados
     * @return O valor do aluguel do serviço público
     */
    public double calcularAluguel(int dados) {
        return this.getAluguel()  * dados;
    }
}
