import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class AnalisandoCandidatos {
    public static void main(String[] args) {
        selecionarCandidato();
    }

    static void selecionarCandidato(){
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};
        int candidatos_Selecionados = 0;
        int candidato_Atual = 0;
        ArrayList<String> lista_Selecionados = new ArrayList<>();

        while (candidatos_Selecionados<5 && candidato_Atual < candidatos.length){
            String candidato = candidatos[candidato_Atual];
            double valor_Pretendido = ValorPretendido();
            System.out.println("O valor pretendido do candidato: "+candidato+" é: R$"+valor_Pretendido);

            if(valor_Pretendido <=2000){
                System.out.println("Candidato selecionado.");
                System.out.println();
                candidatos_Selecionados+=1;
                lista_Selecionados.add(candidato);
            }
            candidato_Atual+=1;
        }
        imprimirSelecionados(lista_Selecionados);
        fazerLigacao(lista_Selecionados);


    }

    static double ValorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    static void imprimirSelecionados(ArrayList<String> candidatos){
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento...");
        System.out.println();
        System.out.println("Aqui segue a lista de todos os selecionados: ");

        for(int indice = 0; indice<candidatos.size();indice++){
            System.out.println("O candidato na posição "+(indice+1)+" é o candidato "+ candidatos.get(indice));
            System.out.println();
        }
        //Forma abrevida de iteração for each:
        for(String candidatoSelecionado : candidatos){
            System.out.println( "O candidato selecionado foi: "+candidatoSelecionado);
            System.out.println("-----------");
        }
    }

    static int ligacao(){
        return ThreadLocalRandom.current().nextInt(0,2);
    }

    static void fazerLigacao(ArrayList<String> candidatos){
        int contador = 0;
        int tentativas = 0;
        while (contador< candidatos.size()){
            for(int i=0;i<3;i++){
                int resultadoLigacao = ligacao();
                tentativas+=1;

                if(resultadoLigacao == 0){
                    if(tentativas==3){
                        System.out.println("N ão foi possível contatar o candidato "+candidatos.get(contador));
                        System.out.println("Passando para o próximo...");
                        tentativas=0;
                        System.out.println();
                        break;
                    }
                }
                else {
                    System.out.println("Candidato "+candidatos.get(contador)+" atendeu depois de "+tentativas+" tentativas.");
                    tentativas=0;
                    break;
                }
            }contador+=1;

        }System.out.println("PROCESSO FINALIZADO.");
    }
    static void analisarCandidato(){
        Scanner scanner = new Scanner(System.in);
        try {
            int salario_Base = 2000;
            System.out.println("Qual o salário pretendido?: ");
            double salario_Pretendido = scanner.nextDouble();

            if (salario_Pretendido < salario_Base) {
                System.out.println("Ligar para candidato.");
            } else if (salario_Pretendido == salario_Base) {
                System.out.println("Ligando para oferecer uma contra-proposta.");
            } else {
                System.out.println("Aguardando resultado de demais candidatos.");
            }
        }catch (InputMismatchException inputMismatchException){
            System.out.println("Valor indevido encontrado.");
            System.out.println("Por favor insira um valor válido(numérico).");
            inputMismatchException.printStackTrace();
        }
        scanner.close();
    }
}