![desafio_tabela_fipe](https://github.com/MateusPerpetuo/DesafioTabelaFipe/assets/129229556/b5288eec-1639-41c0-a3fe-6dafcc3730d5)
![Static Badge](https://img.shields.io/badge/v.17%20-%20gray?logo=oracle&logoColor=white&label=Java&labelColor=%23f89820&color=%235382a1%20)

# #DesafioAlura - Consultar a Tabela FIPE

O principal objtetivo dessa desafio era que o aluno coloca-se em pratica a utilização de listas, coleções de dados, funções lambdas, streams e consumo de API, como visto no curso.

A tabela FIPE é a principal referência no mercado brasileiro para preços médios de veículos novos, usados e seminovos, incluindo carros, motos, caminhões e ônibus. Podendo ser consultada [nesse site](https://veiculos.fipe.org.br/).

Para realização do desafio foi necessario o consumo de uma API, documentada [nesse link](https://deividfortuna.github.io/fipe/).


## 🔨 Regras do desafio

- O objetivo do projeto é ter um fluxo similar ao que é feito no site, porém com algumas melhorias.
- Criare um projeto Spring com linha de comando, utilizando a classe Scanner para fazer interações com o usuário via terminal.
- Solicitar que o usuário digite o tipo de veículo desejado (carro, caminhão ou moto).
- Feito isso, listaremos todas as marcas daquele tipo de veículo, solicitando que o usuário escolha uma marca pelo código.
- Após essa escolha, listaremos todos os modelos de veículos daquela marca.
- Solicitaremos que o usuário digite um trecho do modelo que ele quer visualizar, por exemplo **PALIO**.
- Listaremos apenas os modelos que tiverem a palavra **PALIO** no nome.
- Usuário escolherá um modelo específico pelo código e, diferente do site, já listaremos as avaliações para **TODOS** os anos disponíveis daquele modelo, retornando uma lista.

## 🎬 Imagens e Como Usar

- Inicio da aplicação.

   ![image](https://github.com/MateusPerpetuo/DesafioTabelaFipe/assets/129229556/0b170ef0-23f6-4e81-9f2f-b827f2a7668a)

- Após digitar o seguimento que se queira pesquisar, sera retornado uma lista com todas as marcas dentro da categoria. Para continuar devemos digitar o código da marca que quermos consultar.


   ![image](https://github.com/MateusPerpetuo/DesafioTabelaFipe/assets/129229556/45068e9e-6c6d-4727-a352-dbb7dddc31c1)

- Como exitem Marcas com um vasto portifólio de modelos, coloquei uma pesquisa por nome para filtrar a lista (que em alguns casos chegou a mais de 5000 itens). Basta digitar uma parte do nome do modelo, que a aplicação vai mostrar uma lista apenas com itens correspondentes.

   ![image](https://github.com/MateusPerpetuo/DesafioTabelaFipe/assets/129229556/0b2e69ad-0c15-4a06-878f-e24f149b1670)


- Por fim, ao digitar o código do modelo, será exibido ao usuario uma lista com informações e os valores tabelados de todos os anos disponiveis para o modelo escolhido.

   ![image](https://github.com/MateusPerpetuo/DesafioTabelaFipe/assets/129229556/cf426ed9-fcd3-4daa-967e-2874bbc6a97e)

  
   ![image](https://github.com/MateusPerpetuo/DesafioTabelaFipe/assets/129229556/985c37e4-5668-4d02-aeeb-4bd2b4006e70)




