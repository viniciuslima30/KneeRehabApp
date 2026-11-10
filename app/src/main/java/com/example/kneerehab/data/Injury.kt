
package com.example.kneerehab.data

data class Injury(
    val id: Int,
    val name: String,
    val description: String,
    val symptoms: List<String>
)

val injuries = listOf(
    Injury(
        id = 1,
        name = "Tendinopatia patelar",
        description = "É uma condição que afeta o tendão patelar, localizado abaixo da patela. Está frequentemente associada à sobrecarga repetitiva.",
        symptoms = listOf(
            "Dor abaixo da patela",
            "Desconforto ao saltar",
            "Dor durante agachamentos"
        )
    ),
    Injury(
        id = 2,
        name = "Condromalácia patelar",
        description = "É uma alteração na cartilagem localizada na parte posterior da patela.",
        symptoms = listOf(
            "Dor na região anterior do joelho",
            "Desconforto ao subir escadas",
            "Dor após ficar muito tempo sentado"
        )
    ),
    Injury(
        id = 3,
        name = "Lesão do LCA",
        description = "É uma lesão do ligamento cruzado anterior, estrutura responsável por ajudar na estabilidade do joelho.",
        symptoms = listOf(
            "Sensação de instabilidade",
            "Inchaço no joelho",
            "Dor após torções"
        )
    ),
    Injury(
        id = 4,
        name = "Lesão de menisco",
        description = "É uma lesão em uma das estruturas de fibrocartilagem que ajudam a distribuir as cargas dentro do joelho.",
        symptoms = listOf(
            "Dor na lateral ou parte interna do joelho",
            "Inchaço",
            "Dificuldade para movimentar o joelho"
        )
    )
)
