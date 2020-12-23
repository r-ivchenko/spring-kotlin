package box.sand.spring5webapp.domain

import java.util.UUID
import javax.persistence.*

@Entity
class Book(
    val name: String,
    val isbn: String,
) {
    @ManyToMany
    @JoinTable(
        name = "author_book",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "author_id")]
    )
    var authors: MutableSet<Author> = mutableSetOf()

    @ManyToOne
    lateinit var publisher: Publisher

    @Id
    val id: UUID = UUID.randomUUID()

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
        return "Book(id=$id, name='$name', isbn='$isbn')"
    }
}
