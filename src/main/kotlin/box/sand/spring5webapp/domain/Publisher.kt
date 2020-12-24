package box.sand.spring5webapp.domain

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany

@Entity
class Publisher(
    val name: String,
    val addressLine: String,
    val city: String,
    val state: String,
    val zip: String
) {
    @Id
    val id: UUID = UUID.randomUUID()

    @OneToMany
    @JoinColumn(name = "publisher_id")
    var books: MutableSet<Book> = HashSet()

    override fun hashCode(): Int {
        return id?.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        return when(other) {
            is Publisher -> id == other.id
            else -> false
        }
    }
}
