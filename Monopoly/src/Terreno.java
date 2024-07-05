/**
 * Essa classe modelará como serão os terrenos do jogo
 * Seus atributos são: número de casas, valor da casa, valor do hotel e se tem hotel no terreno
 * Herda da Super Classe Propriedade
 */
public class Terreno extends Propriedade {
    private int numCasas;           //Número de casas que estão em um terreno
    private int valorCasa;    //Quanto custa para colocar uma casa no terreno
    private int valorHotel;   //Quanto custa para colocar um hotel no terreno
    private boolean temHotel;       //Booleano que indica se hpa um hotel no terreno ou não

    //Construtor
    public Terreno(int id, String descricao, TipoCarta tipo, String nome, int preco, int aluguel, int valorCasa, int valorHotel) {
        super(id, descricao, tipo, nome, preco, aluguel);
        this.numCasas = 0;      //O número de casas nos terrenos começa sendo 0
        this.valorCasa = valorCasa;
        this.valorHotel = valorHotel;
        this.temHotel = false;
    }

    //Getters e setters
    public int getNumCasas() {
        return numCasas;
    }

    public void setNumCasas(int numCasas) {
        this.numCasas = numCasas;
    }

    public int getValorCasa() {
        return valorCasa;
    }

    public int getValorHotel() {
        return valorHotel;
    }

    public boolean getTemHotel() {
        return temHotel;
    }

    public void setTemHotel(boolean temHotel) {
        this.temHotel = temHotel;
    }

    /**
     * Retorna o valor do aluguel do terreno com base no número de casas ou se tem hotel
     * @return O valor do aluguel base do terreno
     */
    @Override
    public int calcularAluguel() {
        return (this.getAluguel() + (valorCasa / 2) * numCasas) + (temHotel ? 400 : 0);
    }


    /**
     * Método para realizar a compra de uma casa em um terreno 
     * @return True, se a compra pôde ser feita; ou false, caso contrário
     */
    public boolean comprarCasa() {
        if (this.getDono().temDinheiro(valorCasa) && numCasas < 4){
            numCasas++;
            this.getDono().setDinheiro(this.getDono().getDinheiro() - valorCasa);
            return true;
        }

        return false;
    }


    /**
     * Método para realizar a compra de uma hotel em um terreno 
     * @return True, se a compra pôde ser feita; ou false, caso contrário
     */
    public boolean comprarHotel() {
        if (this.getDono().temDinheiro(valorHotel) && numCasas == 4 && temHotel == false){
            temHotel = true;
            this.getDono().setDinheiro(this.getDono().getDinheiro() - valorHotel);
            return true;
        }

        return false;
    }


    /**
     * Método que define como as informações de um terreno serão exibidas
     */
    @Override       //Indicador de que este método sobrescreve o método "toString" que já existe na superclasse
    public String toString() {
        String out = "";
        out += super.toString();
        out += "Número de casas: " + numCasas + "\n";
        out += "Valor para construir uma casa: " + valorCasa + "\n";
        out += "Valor para construir um hotel: " + valorHotel + "\n";
        
        if (temHotel) 
            out += "Há um hotel neste terreno";

        else
            out += "Não há um hotel neste terreno";
        

        return out;
    }
}
