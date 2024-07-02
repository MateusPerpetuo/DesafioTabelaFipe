package be.com.alura.TabelaFipe.model;

public class Data{
    private String codigo;
    private String nome;

    public Data() {
    }

    @Override
    public String toString() {
        return "Codigo do veículo: " + codigo  +
                "  ---   Marca: " + nome ;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
}

