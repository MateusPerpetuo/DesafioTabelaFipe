package be.com.alura.TabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Vehicle(
        @JsonAlias("Modelo") String model,
        @JsonAlias("Marca") String brand,
        @JsonAlias("AnoModelo") Integer year,
        @JsonAlias("Valor") String Price,
        @JsonAlias("Combustivel") String fuelType
) {

    @Override
    public String toString() {
        return "\nInformações do Veículo"
                + "\nMODELO - " + model
                + ", MARCA - " + brand
                + ", ANO -" + year
                + ", COMBUSTIVEL - " + fuelType
                + "\nValor avaliado: " + Price;
    }
}
