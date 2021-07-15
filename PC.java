public class PC {
    private char jogador = 'O';
    Mapa mapa;

    public PC(Mapa mapa){
        //referencia o objeto que está sendo executado no momento
        this.mapa = mapa;
    }

    public boolean jogar(){
        int linha = 0, coluna = 0;

        do{
            linha = mapa.sortear(0, 3);
            coluna = mapa.sortear(0, 3);

        }while(!mapa.jogar(linha, coluna, jogador));

        System.out.println("PC: [" + linha + ", " + coluna + "];");

        return mapa.verificarGanhador(jogador);
    }
    
}
