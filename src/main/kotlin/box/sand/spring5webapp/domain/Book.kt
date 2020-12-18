package box.sand.spring5webapp.domain

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.ManyToMany
import javax.persistence.JoinTable
import javax.persistence.JoinColumn

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (id != other.id) return false

        return true
    }

    //TODO: NOTE that current implementation is incorrect
    // due to Hibernate requirement that
    // hashcode should be the same during Entity instance lifecycle
    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Book(id=$id, name='$name', isbn='$isbn')"
    }
}
