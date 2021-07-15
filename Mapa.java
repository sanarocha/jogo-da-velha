public class Mapa {
    char[][] mapa = new char[3][3];

    public int sortear(int inicio, int fim){
        return (int) ((Math.random() * fim) - inicio);
    }

    public void limpar(){
        for(int contLinha = 0; contLinha < 3; contLinha++){
            for(int contColuna = 0; contColuna < 3; contColuna++){
                mapa[contLinha][contColuna] = ' ';
            }
        }
    }

    public void desenhar(int jogada){
        System.out.println("-------------");
        System.out.println("| "+ mapa[0][0] + " | " + mapa[0][1] + " | "+ mapa[0][2] +" |");
        System.out.println("-------------");
        System.out.println("| "+ mapa[1][0] + " | " + mapa[1][1] + " | "+ mapa[1][2] +" |");
        System.out.println("-------------");
        System.out.println("| "+ mapa[2][0] + " | " + mapa[2][1] + " | "+ mapa[2][2] +" |");
        System.out.println("-------------");
        System.out.println("Jogada: " + jogada);
    }

    public boolean jogar(int linha, int coluna, char jogador){
        if((linha < 0 || linha > 2) || (coluna < 0 || coluna > 2)){
            return false;
        }

        if(mapa[linha][coluna] != ' '){
            return false;
        }

        mapa[linha][coluna] = jogador;
        return true;
    }

    public boolean verificarGanhador(char jogador){
        for(int contLinha = 0; contLinha < 3; contLinha++){
            int contAcertos = 0;

            for(int contColuna = 0; contColuna < 3; contColuna++){
                if(mapa[contLinha][contColuna] == jogador){
                    contAcertos++;
                }
            }
            if(contAcertos == 3){
                return true;
            }
        }

        for(int contColuna = 0; contColuna < 3; contColuna++){
            int contAcertos = 0;

            for(int contLinha = 0; contLinha < 3; contLinha++){
                if(mapa[contLinha][contColuna] == jogador){
                    contAcertos++;
                }
            }
            if(contAcertos == 3){
                return true;
            }
        }

        int contAcertos1 = 0;
        int contAcertos2 = 0;

        for(int cont = 0, contReverso = 2; cont < 3; cont++, contReverso--){
            if(mapa[cont][cont] == jogador){
                contAcertos1++;
            }

            if(mapa[cont][contReverso] == jogador){
                contAcertos2++;
            }

            if(contAcertos1 == 3 || contAcertos2 == 3){
                return true;
            }
        }
        return false;
    }
    
}
