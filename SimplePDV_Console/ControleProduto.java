import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import static java.util.Comparator.comparing;

public class ControleProduto {

    Scanner in = new Scanner(System.in);
    Calendar c = Calendar.getInstance();
    List<CadastroProduto> produtos = new ArrayList<>();
    List<ItemVenda> vendas = new ArrayList<>();

    public void listaProdutos() {
        if (produtos.size() == 0) {
            System.out.println("Não existem Produtos Cadastrados!");

        } else {
            System.out.println("-----------------------------");
            System.out.println("----Relatório de Produtos----");
            System.out.println("-----------------------------");
            produtos.forEach((p) -> {
                System.out.println("Codigo: " + p.getCodigo());
                System.out.println("Nome: " + p.getNome());
                System.out.println("Preço: " + p.getValor());
                System.out.println("Quantidade em Estoque: " + p.getEstoque());

                System.out.println("-----------------------------");
            });
            System.out.println("----------- Medias ----------");
            System.out.println("-----------------------------");
            double maiorvalor = produtos.stream()
                    .max(comparing(CadastroProduto::getValor))
                    .get()
                    .getValor();
            double menorvalor = produtos.stream()
                    .min(comparing(CadastroProduto::getValor))
                    .get()
                    .getValor();

            System.out.println("O Maior Valor dos produtos é: " + maiorvalor);
            System.out.println("O Menor Valor dos produtos é: " + menorvalor);

        }
    }

    public void Media() {
        double vlproduto = 0;
        double totalproduto = 0;
        double media = 0;

        for (CadastroProduto cp : produtos) {
            vlproduto = cp.getValor();
            totalproduto = vlproduto + totalproduto;
            media = totalproduto / produtos.size();
        }
        System.out.println("O Total de Produtos é: " + produtos.size());
        System.out.println("A média dos valores dos produtos é: " + media);

    }

    public void vender() {
        try {

            if (produtos.size() == 0) {
                System.out.println("Não existem Produtos Cadastrados para fazer uma Venda!");
            } else {
                System.out.println("-----------------------------");
                System.out.println("-------Realizar Venda--------");
                System.out.println("-----------------------------");
                ItemVenda iv = new ItemVenda();
                System.out.print("Digite o dia da Venda:");
                iv.setDia(in.nextInt());
                System.out.print("Digite o Código do Produto: ");
                int codigoprodutovenda;
                codigoprodutovenda = in.nextInt();
                produtos.forEach((p) -> {
                    if (codigoprodutovenda == p.getCodigo()) {

                        System.out.println("Nome do Produto: " + p.getNome());
                        System.out.println("Preço do Produto: " + p.getValor());
                        System.out.print("Digite a quantidade a ser vendida: ");
                        iv.setQuantidadeVenda(in.nextDouble());
                        p.setEstoque(p.getEstoque() - iv.getQuantidadeVenda());
                        iv.setProdutoVenda(p.getNome());
                        iv.setPrecovenda(p.getValor() * iv.getQuantidadeVenda());
                        iv.setData(c.getTime());
                        iv.setVlunitario(p.getValor());
                        vendas.add(iv);
                        System.out.println("Venda Realizada com Sucesso! ");
                        System.out.println("Valor da Venda Total: " + iv.getPrecovenda());
                        in.nextLine();
                    }

                });

            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Foi Inserido uma informação inválida,Tente novamente");
            in.nextLine();
        }
    }

    public void listarvendas() {
        try {
            if (vendas.size() == 0) {
                System.out.println("Não existem Vendas Realizadas!");

            } else {
                System.out.println("-----------------------------");
                System.out.println("-Relatório de Vendas por Dia-");
                System.out.println("-----------------------------");
                System.out.println("Informe o dia da venda: ");
                double dia = in.nextInt();
                for (ItemVenda p : vendas) {
                    if (p.getDia() == dia) {

                        System.out.println("Nome do Produto: " + p.getProdutoVenda());
                        System.out.println("Data: " + p.getData());
                        System.out.println("Quantidade Vendida: " + p.getQuantidadeVenda());
                        System.out.println("Preço Unitário: " + p.getVlunitario());
                        System.out.println("Valor da Venda: " + p.getPrecovenda());
                        System.out.println("-----------------------------");
                    }
                }

                System.out.println("----------- Medias ----------");
                System.out.println("-----------------------------");
                double vlvenda = 0;
                double totalvenda = 0;
                double media = 0;

                int contador = 0;
                for (ItemVenda cp : vendas) {
                    if (cp.getDia() == dia) {
                        vlvenda = cp.getPrecovenda();
                        totalvenda = vlvenda + totalvenda;
                        contador = contador + 1;
                        media = totalvenda / vendas.size();
                    }
                }

                System.out.println("O Valor Total de vendas é: " + totalvenda);
                System.out.println("O numero Total de Venda  é: " + contador);
                System.out.println("O valor médio das Vendas é: " + media);
                in.nextLine();
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Foi Inserido uma informação inválida,Tente novamente");
            in.nextLine();
        }
    }

    public void consultarproduto() {
        try {
            if (produtos.size() == 0) {
                System.out.println("Não existem Produtos Cadastrados para fazer uma venda!");
            } else {
                System.out.println("-----------------------------");
                System.out.println("-----Consulta de Produto-----");
                System.out.println("-----------------------------");
                System.out.print("Digite o Código do Produto: ");
                int codigoproduto;
                codigoproduto = in.nextInt();
                produtos.forEach((p) -> {
                    if (codigoproduto == p.getCodigo()) {
                        System.out.println("Código: " + p.getCodigo());
                        System.out.println("Nome: " + p.getNome());
                        System.out.println("Estoque Atual: " + p.getEstoque());
                        System.out.println("Preço: " + p.getValor());

                    } else {
                        System.out.println("Produto não encontrado!");

                    }
                });
                in.nextLine();
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Foi Inserido uma informação inválida,Tente novamente");
            in.nextLine();
        }
    }

    public void cadastrarproduto() {
        System.out.println("-----------------------------");
        System.out.println("-----Cadastro de Produto-----");
        System.out.println("-----------------------------");
        CadastroProduto produto = new CadastroProduto();
        try {
            System.out.print("Digite o Código do produto: ");
            produto.setCodigo(in.nextInt());
            System.out.print("Digite o Nome do produto: ");
            produto.setNome(in.next());
            System.out.print("Digite o Preço do produto: ");
            produto.setValor(in.nextDouble());
            System.out.print("Digite a quantidade em estoque do produto: ");
            produto.setEstoque(in.nextDouble());
            produtos.add(produto);
            produto = new CadastroProduto();
            System.out.println("Produto Cadastrado com sucesso!");
            in.nextLine();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Foi Inserido uma informação inválida,Tente novamente");
            in.nextLine();
        }
    }

    public void VoltarMenu() {
        System.out.println("Pressione ENTER para voltar ao menu.");
        in.nextLine();
    }

}
