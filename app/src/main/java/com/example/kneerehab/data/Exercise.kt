
package com.example.kneerehab.data

import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class Exercise(
    val id: Int,
    val injuryId: Int,
    val name: String,
    val description: String
) {

    val videoUrl: String
        get() {
            val search = URLEncoder.encode(
                "$name fisioterapia demonstração",
                StandardCharsets.UTF_8.toString()
            )

            return "https://www.youtube.com/results?search_query=$search"
        }
}

val exercises = listOf(

    // Tendinopatia patelar
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
        id = 9,
        injuryId = 1,
        name = "Ponte de glúteos",
        description = "Elevar o quadril com os pés apoiados no chão, trabalhando os músculos dos glúteos."
    ),

    Exercise(
        id = 10,
        injuryId = 1,
        name = "Abdução de quadril deitado",
        description = "Deitado de lado, elevar a perna de cima lentamente para fortalecer a musculatura lateral do quadril."
    ),

    // Condromalácia patelar
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
        id = 11,
        injuryId = 2,
        name = "Abdução de quadril",
        description = "Elevar a perna lateralmente para trabalhar a musculatura do quadril."
    ),

    Exercise(
        id = 12,
        injuryId = 2,
        name = "Contração isométrica do quadríceps",
        description = "Contrair a musculatura anterior da coxa mantendo o joelho estendido."
    ),

    // Lesão do LCA
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
        id = 13,
        injuryId = 3,
        name = "Ponte de glúteos",
        description = "Elevar o quadril mantendo os pés apoiados no chão."
    ),

    Exercise(
        id = 14,
        injuryId = 3,
        name = "Elevação de perna estendida",
        description = "Elevar a perna mantendo o joelho estendido e retornar lentamente."
    ),

    // Lesão de menisco
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
    ),

    Exercise(
        id = 15,
        injuryId = 4,
        name = "Ponte de glúteos",
        description = "Elevar o quadril com os pés apoiados no chão, mantendo o movimento controlado."
    ),

    Exercise(
        id = 16,
        injuryId = 4,
        name = "Abdução de quadril",
        description = "Elevar a perna lateralmente para fortalecer os músculos do quadril."
    )
)
