
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

        while (candidatos_Selecionados<5 && candidato_Atual < candidatos.length){
            String candidato = candidatos[candidato_Atual];
            double valor_Pretendido = ValorPretendido();
            System.out.println("O valor pretendido do candidato: "+candidato+" é: R$"+valor_Pretendido);
            
            if(valor_Pretendido <=2000){
                System.out.println("Candidato selecionado.");
                candidatos_Selecionados+=1;
            }
            candidato_Atual+=1;
        }
        System.out.println();
    }

    static double ValorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
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