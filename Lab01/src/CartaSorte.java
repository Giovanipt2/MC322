/**
 * Essa classe conterá as informações das cartas de sorte/revés de um jogo Monopoly
 * Seus atributos id, descrição, movimento, efeito, valor, ação, tempo, restrição
 */

public class CartaSorte{
    private int id;             //Identificador único para cada carta
    private String descricao;   //Nome da carta
    private String movimento;   //Para as que dão alguma instrução de movimentação
    private String efeito;      //Atributo que diz se o efeito é positivo, negativo ou neutro
    private int valor;          //Para cartas que envolvem dinheiro
    private String acao;        //Para cartas que têm um efeito único e específico
    private int tempo;          //Para cartas com tempo ou condição de ativação
    private String restricao;   //Para cartas que possuem restrições de uso

    //Construtor
    public CartaSorte(int id, String descricao, String movimento, String efeito, int valor, String acao, int tempo, String restricao) {
        this.id = id;
        this.descricao = descricao;
        this.movimento = movimento;
        this.efeito = efeito;
        this.valor = valor;
        this.acao = acao;
        this.tempo = tempo;
        this.restricao = restricao;
    }

    //Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMovimento() {
        return movimento;
    }

    public void setMovimento(String movimento) {
        this.movimento = movimento;
    }

    public String getEfeito() {
        return efeito;
    }

    public void setEfeito(String efeito) {
        this.efeito = efeito;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public String getRestricao() {
        return restricao;
    }

    public void setRestricao(String restricao) {
        this.restricao = restricao;
    }



}