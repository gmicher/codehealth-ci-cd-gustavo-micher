import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double resultado = 0;
        char operacao;

        System.out.println("===== CALCULADORA AVANÇADA =====");
        System.out.print("Quantos números deseja usar na operação? ");
        int quantidade = scanner.nextInt();

        if (quantidade < 1) {
            System.out.println("Quantidade inválida!");
            scanner.close();
            return;
        }

        System.out.print("Digite o primeiro número: ");
        resultado = scanner.nextDouble();

        for (int i = 1; i < quantidade; i++) {
            System.out.print("Digite o operador (+, -, *, /, ^, r): ");
            operacao = scanner.next().charAt(0);

            System.out.print("Digite o próximo número: ");
            double num = scanner.nextDouble();

            switch (operacao) {
                case '+':
                    resultado += num;
                    break;
                case '-':
                    resultado -= num;
                    break;
                case '*':
                    resultado *= num;
                    break;
                case '/':
                    if (num == 0) {
                        System.out.println("Erro: divisão por zero!");
                        scanner.close();
                        return;
                    }
                    resultado /= num;
                    break;
                case '^':
                    resultado = Math.pow(resultado, num);
                    break;
                case 'r':
                    if (num == 0) {
                        System.out.println("Erro: raiz de índice zero!");
                        scanner.close();
                        return;
                    }
                    // cálculo da raiz n-ésima: raiz(num) = resultado^(1/num)
                    resultado = Math.pow(resultado, 1.0 / num);
                    break;
                default:
                    System.out.println("Operador inválido!");
                    scanner.close();
                    return;
            }
        }

        System.out.println("Resultado final: " + resultado);
        System.out.println("================================");
        scanner.close();
    }
}
