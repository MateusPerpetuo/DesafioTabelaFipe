package be.com.alura.TabelaFipe.main;

import be.com.alura.TabelaFipe.model.Data;
import be.com.alura.TabelaFipe.service.ApiConsumer;
import be.com.alura.TabelaFipe.service.ConvertData;

import java.util.Comparator;
import java.util.Scanner;

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

        while (true) {
            if (option.toLowerCase().contains("car")) {
                adress = BASE_URL + "carros/marcas";
                option = " Carros";
                break;
            } else if (option.toLowerCase().contains("mot")) {
                adress = BASE_URL + "motos/marcas";
                option = " Motos";
                break;
            } else if (option.toLowerCase().contains("camin")) {
                adress = BASE_URL + "caminhoes/marcas";
                option = " Caminhões";
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
        // checking the user input


        // getting the api return and convertin the json to a list of a class
        var json = apiConsumer.getData(adress);
        var marcas = convertData.getList(json, Data.class);


        // show the list of the vehicles models
        System.out.println(menuVehicleModels);

        marcas.stream()
                .sorted(Comparator.comparing(data -> Integer.parseInt(data.getCodigo())))
                .forEach(System.out::println);


        System.out.println("Digite o código da marca do veículo a ser consultado: ");

        int carBrandCod = scan.nextInt();
        scan.nextLine();




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

    private final String menuVehicleModels = String.format("""
                
                --- Lista das marcas de %n ---

                """, option);
}
