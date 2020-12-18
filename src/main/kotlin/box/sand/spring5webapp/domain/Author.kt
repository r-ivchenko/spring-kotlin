package box.sand.spring5webapp.domain

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.ManyToMany

@Entity
class Author(
    val firstName: String,
    val secondName: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @ManyToMany(mappedBy = "authors", cascade = [CascadeType.ALL])
    var books: MutableSet<Book>? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Author

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "Author(id=$id, firstName='$firstName', secondName='$secondName')"
    }
}