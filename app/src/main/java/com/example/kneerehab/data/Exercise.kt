
package com.example.kneerehab.data

data class Exercise(
    val id: Int,
    val injuryId: Int,
    val name: String,
    val description: String
)

val exercises = listOf(

    Exercise(
        id = 1,
        injuryId = 1,
        name = "Contração isométrica do quadríceps",
        description = "Contrair os músculos da parte anterior da coxa mantendo a perna estendida."
    ),

    Exercise(
        id = 2,
        injuryId = 1,
        name = "Elevação de perna estendida",
        description = "Elevar uma perna mantendo o joelho estendido e retornar lentamente."
    ),

    Exercise(
        id = 3,
        injuryId = 2,
        name = "Elevação de perna estendida",
        description = "Exercício de fortalecimento dos músculos da coxa com a perna estendida."
    ),

    Exercise(
        id = 4,
        injuryId = 2,
        name = "Ponte de glúteos",
        description = "Elevar o quadril enquanto mantém os pés apoiados no chão."
    ),

    Exercise(
        id = 5,
        injuryId = 3,
        name = "Contração isométrica do quadríceps",
        description = "Ativar a musculatura anterior da coxa sem movimentar o joelho."
    ),

    Exercise(
        id = 6,
        injuryId = 3,
        name = "Abdução de quadril",
        description = "Elevar a perna lateralmente para trabalhar a musculatura do quadril."
    ),

    Exercise(
        id = 7,
        injuryId = 4,
        name = "Contração isométrica do quadríceps",
        description = "Contrair o quadríceps mantendo a perna estendida."
    ),

    Exercise(
        id = 8,
        injuryId = 4,
        name = "Elevação de perna estendida",
        description = "Elevar a perna lentamente mantendo o joelho estendido."
    )
)
