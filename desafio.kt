enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String) 

data class ConteudoEducacional(val nome: String, val duracao: Int)

open class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    open fun matricular(usuarios: List<Usuario>) {
        inscritos.addAll(usuarios)
        // for (usuario in usuarios) { println("- ${usuario.nome} matriculada(o) na formação $nome.") }
    }
    
    open fun listarInscritos() {
        if (inscritos.isEmpty()) {
            println("Não há inscritos na formação $nome.")
        } else {
            println("Inscritos na formação $nome:")
            for (inscrito in inscritos) {
                println("- ${inscrito.nome}")
            }
        }
    }
    
    open fun listarDisciplinas() {
        if (conteudos.isEmpty()) {
            println("Não há disciplinas na formação $nome.")
        } else {
            println("Disciplinas da formação $nome:")
            for (disciplina in conteudos) {
                println("- ${disciplina.nome}")
            }
        }
    }
}

fun main() {
    val usuario1 = Usuario("Eduardo")
    val usuario2 = Usuario("Maria")
    
    val discilplinaBase = ConteudoEducacional("Introdução à OOP", 60)
    val disciplina1 = ConteudoEducacional("Introdução ao Kotlin", 60)
    val disciplina2 = ConteudoEducacional("Kotlin Intermediário", 180)
    val disciplina3 = ConteudoEducacional("Kotlin para Poucos", 360)
    val disciplina4 = ConteudoEducacional("Introdução ao Java", 200)
    val disciplina5 = ConteudoEducacional("Java Intermediário", 380)
    val disciplina6 = ConteudoEducacional("Super Java", 500)

    val formacao1 = Formacao("Básico de OOP", listOf(discilplinaBase), Nivel.BASICO)
    val formacao2 = Formacao("Kotlin", listOf(disciplina1, disciplina2, disciplina3), Nivel.INTERMEDIARIO)
    val formacao3 = Formacao("Java", listOf(disciplina4, disciplina5, disciplina6), Nivel.AVANCADO)
    
    val formacoes = listOf(formacao1, formacao2, formacao3)
    
	//    println("Matrículas:")
    formacao1.matricular(listOf(usuario1, usuario2))
    formacao2.matricular(listOf(usuario1))
    
    println("Formações:") 
    for (formacao in formacoes) {
        print("Nome da Formação: ${formacao.nome} ")
        println("(Nível: ${formacao.nivel})")
        formacao.listarDisciplinas()
        formacao.listarInscritos()
        println() 
    }

}
