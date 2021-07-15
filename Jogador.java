import java.util.Scanner;

public class Jogador {
    private char jogador = 'X';
    Mapa mapa;

    public Jogador(Mapa mapa){
        this.mapa = mapa;
    }

    public boolean jogar(Scanner teclado){
        int linha = 0, coluna = 0;
        boolean jogadaValida = false;

        do{
            System.out.print("Digite a linha: ");
            linha = teclado.nextInt();
            System.out.print("Digite a coluna: ");
            coluna = teclado.nextInt();

            jogadaValida = mapa.jogar(linha, coluna, jogador);

            if(!jogadaValida){
                System.out.println("Jogada inválida!");
            }

        }while(!jogadaValida);

        return mapa.verificarGanhador(jogador);
    }
    
}
