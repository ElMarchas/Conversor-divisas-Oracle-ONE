# Conversor de monedas

Conversor de monedas sencillo con 8 divisas para jugar

> - 1 USD
> - 2 ARS
> - 3 BOB
> - 4 BRL
> - 5 CLP
> - 6 COP
> - 7 MXN
> - 8 VES

Todo se maneja mediante la terminal de comandos.
El valor de las divisas se obtienen a travez de la api brindada por [exchangerate-api](https://www.exchangerate-api.com/).
Para manipular el json recibido de la API se utilizo la libreria Gson para manipular las key y obtener los valores de las divisas que estaban anidados dentro de un objeto.
