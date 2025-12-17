import javax.xml.bind.annotation.*

@XmlRootElement(name = "students")
@XmlAccessorType(XmlAccessType.FIELD)
data class Students(
    @XmlElement(name = "student")
    var student: List<Student> = mutableListOf()
) {
    // JAXB требует конструктор без параметров
    constructor() : this(mutableListOf())
    
    override fun toString(): String {
        return "Students(student=${student.joinToString("\n  ", "[\n  ", "\n]")})"
    }
}

@XmlAccessorType(XmlAccessType.FIELD)
data class Student(
    @XmlElement(name = "firstName")
    var firstName: String = "",
    
    @XmlElement(name = "secondName")
    var secondName: String = "",
    
    @XmlElement(name = "age")
    var age: Int = 0,
    
    @XmlElement(name = "hobbies")
    var hobbies: Hobbies? = null
) {
    // JAXB требует конструктор без параметров
    constructor() : this("", "", 0, null)
    
    override fun toString(): String {
        return "Student(firstName='$firstName', secondName='$secondName', age=$age, hobbies=$hobbies)"
    }
}

@XmlAccessorType(XmlAccessType.FIELD)
data class Hobbies(
    @XmlElement(name = "hobby")
    var hobby: List<String> = mutableListOf()
) {
    // JAXB требует конструктор без параметров
    constructor() : this(mutableListOf())
    
    override fun toString(): String {
        return hobby.joinToString(", ", "[", "]")
    }
}

