import java.io.File
import java.io.PrintStream
import java.nio.charset.StandardCharsets
import javax.xml.bind.JAXBContext
import javax.xml.bind.Unmarshaller

fun main() {
    // Устанавливаем UTF-8 для корректного отображения кириллицы в консоли Windows
    System.setOut(PrintStream(System.out, true, StandardCharsets.UTF_8))
    System.setProperty("file.encoding", "UTF-8")
    
    val xmlFile = File("c:\\Users\\cepra\\Downloads\\Telegram Desktop\\students.xml")
    
    try {
        // Создаем JAXB контекст для класса Students
        val jaxbContext = JAXBContext.newInstance(Students::class.java)
        
        // Создаем unmarshaller для преобразования XML в объекты
        val unmarshaller: Unmarshaller = jaxbContext.createUnmarshaller()
        
        // Читаем XML файл и преобразуем в объект Students
        val students = unmarshaller.unmarshal(xmlFile) as Students
        
        // Выводим весь полученный класс
        println("=== Все студенты ===")
        println(students)
        println("\n=== Детальная информация ===")
        students.student.forEachIndexed { index, student ->
            println("\nСтудент ${index + 1}:")
            println("  Имя: ${student.firstName}")
            println("  Фамилия: ${student.secondName}")
            println("  Возраст: ${student.age}")
            println("  Хобби: ${student.hobbies}")
        }
    } catch (e: Exception) {
        println("Ошибка при чтении XML файла: ${e.message}")
        e.printStackTrace()
    }
}

