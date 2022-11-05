## Factory

Queremos montar uma lanchonete, onde vários sanduíches diferentes podem ser feitos. Um sanduíche
básico contém: duas fatias de pão, uma fatia de queijo, uma fatia de presunto e salada (estrutura
base de qualquer sanduíche). No entanto, existem variações do sanduíche básico de acordo com os
tipos diferentes de ingredientes (veja o quadro).

Tendo o código para o sanduíche base, aplique o padrão de projeto Factory Method para que os
sanduíches abaixo possam ser feitos na nossa lanchonete.

|            |           | Juazeiro | Crato | Barbalha |
|:----------:|:---------:|:--------:|:-----:|:--------:|
| **Pão**    | Integral  |    x     |       |          |
|            | Francês   |          |   x   |          |
|            | Bola      |          |       |    x     |
| ---------- | --------- | -------- | ----- | -------- |
| **Queijo** | Prato     |    x     |       |          |
|            | Mussarela |          |   x   |          |
|            | Cheddar   |          |       |    x     |
| ---------- | --------- | -------- | ----- | -------- |
|**Presunto**| Frango    |    x     |   x   |          |
|            | Peru      |          |       |    x     |
| ---------- | --------- | -------- | ----- | -------- |
| **Salada** |Com verdura|          |   x   |          |
|            |Sem verdura|    x     |       |    x     |
