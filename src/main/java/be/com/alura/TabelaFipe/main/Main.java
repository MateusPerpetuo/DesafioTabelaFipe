package be.com.alura.TabelaFipe.main;


import be.com.alura.TabelaFipe.model.CarModels;
import be.com.alura.TabelaFipe.model.Data;
import be.com.alura.TabelaFipe.model.Vehicle;
import be.com.alura.TabelaFipe.service.ApiConsumer;
import be.com.alura.TabelaFipe.service.ConvertData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    Scanner scan = new Scanner(System.in);
    private final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/";
    private ApiConsumer apiConsumer = new ApiConsumer();
    private ConvertData convertData = new ConvertData();
    String option;

    public void showMenu(){
        System.out.println(starterMenu);
        System.out.println(menuVehicle);

        option = scan.nextLine();
        String adress;

        while (true) { // checking the user input
            if (option.toLowerCase().contains("car")) {
                adress = BASE_URL + "carros/marcas";
                option = "Carros";
                break;
            } else if (option.toLowerCase().contains("mot")) {
                adress = BASE_URL + "motos/marcas";
                option = "Motos";
                break;
            } else if (option.toLowerCase().contains("camin")) {
                adress = BASE_URL + "caminhoes/marcas";
                option = "Caminhões";
                break;
            } else {
                System.out.println("""
            Termo de Pesquisa Inválido!"
            
            Suas opções são:
                Carro
                Moto
                Caminhão:
            
            Por favor digite um termo válido:\s
            """);
            }
            option = scan.nextLine();
        }

        // getting the api return and converting the json to a list of a class
        var json = apiConsumer.getData(adress);
        var marcas = convertData.getList(json, Data.class);

        // show the list of the vehicles models
        System.out.println("\n--- Lista das marcas de " + option +" ---\n");

        marcas.stream()
                .sorted(Comparator.comparing(data -> Integer.parseInt(data.getCodigo())))
                .forEach(System.out::println);

        // askin to the api about car models
        System.out.println("\nDigite o código da marca do veículo a ser consultado: ");
        String vehicleCode = scan.nextLine();
        adress = adress + "/" + vehicleCode + "/modelos";

        // getting the api return and converting the json to a list of car models
        json = apiConsumer.getData(adress);
        var carModelsList =  convertData.getData(json, CarModels.class);

        System.out.println("\n--- Lista dos CarModels dessa Marca ---\n");


        carModelsList.modelos().stream()
                .sorted(Comparator.comparing(data -> Integer.parseInt(data.getCodigo())))
                .forEach(System.out::println);

        System.out.println("\n Digite o nome do carro a ser consultado: ");
        var vehicleName = scan.nextLine();

        List<Data> modelsFilter =  carModelsList.modelos().stream()
                .filter(m -> m.getNome().toLowerCase().contains(vehicleName.toLowerCase()))
                .sorted(Comparator.comparing(data -> Integer.parseInt(data.getCodigo())))
                .collect(Collectors.toList());

        System.out.println("\n--- Lista de Modelos filtrados ---\n");
        modelsFilter.forEach(System.out::println);

        // askin to the api about car models
        System.out.println("\nPor favor digite o código do modelo para buscar os valores de avaliaçao: ");
        vehicleCode = scan.nextLine();

        // getting the api return and converting the json to a list cars years
        adress =  adress + "/" + vehicleCode + "/anos";
        json = json = apiConsumer.getData(adress);

        List<Data> years = convertData.getList(json, Data.class);
        List<Vehicle> vehicleList = new ArrayList<>();

        // Loop to get ans show the car prices
        for (int i = 0; i< years.size(); i++){
            var adressYear = adress + "/" + years.get(i).getCodigo();
            json = apiConsumer.getData(adressYear);
            Vehicle vehicle = convertData.getData(json, Vehicle.class);
            vehicleList.add(vehicle);
        }
        System.out.println("\n--- Lista dos veículos filtrados com avaliações por ano ---");
        vehicleList.forEach(System.out::println);

    }

    // menu Strings variables
    private final String starterMenu = """
                
                       \n--- BEM-VINDO ---
                
                Ao consultor de preços da tabela FIPE
                """;

    private final String menuVehicle = """
                *** OPÇÕES DE CONSULTA ***
               \s
                Carro
                Moto
                Caminhão
               \s
                Digite uma das opçõe para consultar:\s
               \s""";

}
