## Getting Started

Refine  o  código  elaborado  para a  questão  1 com  o  objetivo  de  aplicar  o  padrão  de
projeto Abstract Factory. Para tanto, faz-se necessário:

- Definir  uma  interface SanduichesIngredientFactory com  os  respectivos  métodos  de criação
(Factory Methods);
- Defina uma interface para cada tipo de produto: PãoIF, por exemplo.
- Criar as fábricas concretas que devem implementar a interface definida.
    - `SanduichesIngredienteFactoryJuazeiro`
    - `SanduichesIngredienteFactoryBarbalha`
    - `SanduichesIngredienteFactoryCrato`
- Os Factory Methods devem ser implementados nas respectivas fábricas;
- Modifique  o  método  para  montagem  do  sanduiche,  para  que  o  mesmo  passe  a receber como parâmetro a fábrica específica.
- Com as alterações sugeridas a Lanchonete será a responsável por criar o sanduiche e terá, por composição, uma fábrica de sanduiches.
- Modifique, ainda, a classe principal, main, para que as modificações sejam refletidas.
