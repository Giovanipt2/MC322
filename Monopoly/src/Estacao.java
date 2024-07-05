/**
 * Essa classe modelará como serão as estações do jogo
 * Herda da Super Classe Propriedade
 */
public class Estacao extends Propriedade {
    private int tarifa;     //Usado para calcular o aluguel 

    //Construtor
    public Estacao(int id, String descricao, TipoCarta tipo, String nome, int preco, int aluguel) {
        super(id, descricao, tipo, nome, preco, aluguel);
        this.tarifa = 1;
    }

    //Getters e setters
    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa() {
        //Tarifa será calculada com base no número de estações possuídas pelo dono
        this.tarifa = this.getDono().getNEstacoes();
    }


    /**
     * Retorna o valor do aluguel dessa estação
     * @return O valor do aluguel da estação
     */
    @Override
    public int calcularAluguel() {
        return this.getAluguel() * tarifa;
    }
}
