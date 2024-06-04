
import java.util.InputMismatchException;
import java.util.Scanner;

public class AnalisandoCandidatos {
    public static void main(String[] args) {
        analisarCandidato();
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
