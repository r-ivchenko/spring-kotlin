package box.sand.spring5webapp.domain

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.CascadeType

@Entity
class Author(
    val firstName: String,
    val secondName: String,
) {
    @Id
    val id: UUID = UUID.randomUUID()

    @ManyToMany(mappedBy = "authors", cascade = [CascadeType.ALL])
    var books: MutableSet<Book> = mutableSetOf()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        return when(other) {
            is Publisher -> id == other.id
            else -> false
        }
    }

    override fun hashCode(): Int {
        return id?.hashCode()
    }

    override fun toString(): String {
        return "Author(id=$id, firstName='$firstName', secondName='$secondName')"
    }
}