/**
 *Essa classe modelará como serão os terrenos do jogo
 * Herda da Super Classe Propriedade
 */
public class Terreno extends Propriedade {
    private int numCasas;           //Número de casas que estão em um terreno
    private int valorCasa;    //Quanto custa para colocar uma casa no terreno
    private int valorHotel;   //Quanto custa para colocar um hotel no terreno
    private boolean temHotel;       //Booleano que indica se hpa um hotel no terreno ou não

    //Construtor
    public Terreno(int id, String nome, int preco, Jogador proprietario, double aluguel, int valorCasa, int valorHotel) {
        super(id, nome, preco, proprietario, aluguel);
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
    public double calcularAluguel() {
        return (this.getAluguel() + (valorCasa / 2) * numCasas) + (temHotel ? 400 : 0);
    }


    /**
     * Método para realizar a compra de uma casa em um terreno 
     * @return True, se a compra pôde ser feita; ou false, caso contrário
     */
    public boolean comprarCasa() {
        if (this.getProprietario().temDinheiro(valorCasa) && numCasas < 4){
            numCasas++;
            this.getProprietario().setDinheiro(this.getProprietario().getDinheiro() - valorCasa);
            return true;
        }

        return false;
    }


    /**
     * Método para realizar a compra de uma hotel em um terreno 
     * @return True, se a compra pôde ser feita; ou false, caso contrário
     */
    public boolean comprarHotel() {
        if (this.getProprietario().temDinheiro(valorHotel) && numCasas == 4 && temHotel == false){
            temHotel = true;
            this.getProprietario().setDinheiro(this.getProprietario().getDinheiro() - valorHotel);
            return true;
        }

        return false;
    }
}
