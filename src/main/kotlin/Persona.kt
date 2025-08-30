import java.time.LocalDate

open class Persona(
    var nombre: String,
    var edad: Int,
    var sexo: Char
) {
    var esMayor: Boolean

    init {
        esMayor = edad >= 18
    }

    fun getAñoNacimiento(): Int {
        val añoActual = LocalDate.now().year
        return añoActual - edad
    }

    override fun toString(): String {
        return """
            Datos de la Persona
            -------------------------
            Nombre : $nombre
            Edad : $edad
            Sexo : $sexo
            EsMayor: $esMayor
            Año de nacimiento: ${getAñoNacimiento()}
            -------------------------
        """.trimIndent()
    }
}



class Docente(
    nombre: String,
    edad: Int,
    sexo: Char,
    var especialidad: String,
    var aniosExperiencia: Int
) : Persona(nombre, edad, sexo) {

    fun esDocenteSenior(): Boolean {
        return aniosExperiencia >= 10
    }

    fun mostrarExperiencia(): String {
        return if (esDocenteSenior()) "Docente senior con mucha experiencia"
        else "Docente en desarrollo"
    }

    override fun toString(): String {
        return """
            Datos del Docente
            -------------------------
            Nombre : $nombre
            Edad : $edad
            Sexo : $sexo
            EsMayor: $esMayor
            Especialidad: $especialidad
            Años de experiencia: $aniosExperiencia
            ${mostrarExperiencia()}
            -------------------------
        """.trimIndent()
    }
}


class Estudiante(
    nombre: String,
    edad: Int,
    sexo: Char,
    var carrera: String,
    var anioIngreso: Int,
    var anioActual: Int = LocalDate.now().year
) : Persona(nombre, edad, sexo) {

    fun calcularAniosEstudio(): Int {
        return anioActual - anioIngreso
    }

    fun estaEnUltimosAnios(): Boolean {
        return calcularAniosEstudio() >= 4
    }

    override fun toString(): String {
        return """
            Datos del Estudiante
            -------------------------
            Nombre : $nombre
            Edad : $edad
            Sexo : $sexo
            EsMayor: $esMayor
            Carrera: $carrera
            Años estudiando: ${calcularAniosEstudio()}
            ¿Está en últimos años?: ${if (estaEnUltimosAnios()) "Sí" else "No"}
            -------------------------
        """.trimIndent()
    }
}

fun main() {
    val docente1 = Docente("Marta", 45, 'F', "Matemáticas", 12)
    val estudiante1 = Estudiante("Carlos", 21, 'M', "Ingeniería", 2019)

    println(docente1)
    println(estudiante1)
}
