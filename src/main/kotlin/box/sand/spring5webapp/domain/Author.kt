package box.sand.spring5webapp.domain

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.ManyToMany
import javax.persistence.CascadeType

@Entity
class Author(
    val firstName: String,
    val secondName: String,
) {
    val hash: UUID = UUID.randomUUID()
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

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
        return hash.hashCode()
    }

    override fun toString(): String {
        return "Author(id=$id, firstName='$firstName', secondName='$secondName')"
    }
}