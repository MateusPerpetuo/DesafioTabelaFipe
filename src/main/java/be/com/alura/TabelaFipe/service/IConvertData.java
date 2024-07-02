package be.com.alura.TabelaFipe.service;

public interface IConvertData {
    <T> T getData(String json, Class<T> classe);
}
