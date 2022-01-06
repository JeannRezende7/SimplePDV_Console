import java.io.IOException;
import java.util.Scanner;

public class PDV {

    public static void main(String[] args) throws InterruptedException, IOException {
        int opcao;
        Scanner in = new Scanner(System.in);
        ControleProduto controle = new ControleProduto();
        System.out.println("-----------------------------");
        System.out.println("Seja Bem Vindo!!!");
        System.out.println("Pressione Enter para iniciar o PDV");
        System.out.println("-----------------------------");
        in.nextLine();
        do {
            System.out.println("-----------------------------");
            System.out.println("---------PDV Console---------");
            System.out.println("-----------------------------");
            System.out.println("1 - Incluir produto");
            System.out.println("2 - Consultar produto");
            System.out.println("3 - Listagem de produtos");
            System.out.println("4 - Vendas por período - detalhado");
            System.out.println("5 - Realizar venda");
            System.out.println("0 - Sair");
            System.out.print("Digite a Opção desejada: ");
            opcao = in.nextInt();
            in.nextLine();

            switch (opcao) {
                case 1:
                    controle.cadastrarproduto();
                    controle.VoltarMenu();
                    break;

                case 2:
                    controle.consultarproduto();
                    controle.VoltarMenu();

                    break;

                case 3:
                    controle.listaProdutos();
                    controle.Media();
                    controle.VoltarMenu();

                    break;

                case 4:
                    controle.listarvendas();
                    controle.VoltarMenu();

                    break;

                case 5:
                    controle.vender();
                    controle.VoltarMenu();

                    break;

            }

        } while (opcao != 0);
        System.out.println("Finalizando o Programa!");
        in.close();
    }
}
