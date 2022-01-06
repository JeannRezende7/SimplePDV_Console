import java.util.Date;

public class ItemVenda {
    Date data;
    int dia;
    Double quantidadeVenda, precovenda, vlunitario;
    String produtoVenda;

    public Double getVlunitario() {
        return vlunitario;
    }

    public void setVlunitario(Double vlunitario) {
        this.vlunitario = vlunitario;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getQuantidadeVenda() {
        return quantidadeVenda;
    }

    public void setQuantidadeVenda(Double quantidadeVenda) {
        this.quantidadeVenda = quantidadeVenda;
    }

    public String getProdutoVenda() {
        return produtoVenda;
    }

    public void setProdutoVenda(String produtoVenda) {
        this.produtoVenda = produtoVenda;
    }

    public Double getPrecovenda() {
        return precovenda;
    }

    public void setPrecovenda(Double precovenda) {
        this.precovenda = precovenda;
    }

}
