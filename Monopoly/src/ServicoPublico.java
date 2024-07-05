/**
 * Essa classe modelará como serão os serviços públicos do jogo
 * Herda da Super Classe Propriedade
 */
public class ServicoPublico extends Propriedade {
    //Usado para calcular aluguel com base no número tirado no dado
    private int multiplicador;

    //Construtor
    public ServicoPublico(int id, String descricao, TipoCarta tipo, String nome, int preco, int aluguel) {
        super(id, descricao, tipo, nome, preco, aluguel);
        this.multiplicador = 1;
    }

    //Getters e setters
    public int getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }


    /**
     * Calcula o valor do aluguel desse serviço público com base no número dos dados
     * @return O valor do aluguel do serviço público
     */
    @Override
    public int calcularAluguel() {
        return this.getAluguel()  * multiplicador;
    }
}
