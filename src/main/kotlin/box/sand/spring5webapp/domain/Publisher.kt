package box.sand.spring5webapp.domain

import java.util.UUID
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Publisher(
    val name: String,
    val addressLine: String,
    val city: String,
    val state: String,
    val zip: String
) {
    val hash: UUID = UUID.randomUUID()
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    override fun hashCode(): Int {
        return hash.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Publisher

        if (name != other.name) return false
        if (addressLine != other.addressLine) return false
        if (city != other.city) return false
        if (state != other.state) return false
        if (zip != other.zip) return false
        if (id != other.id) return false

        return true
    }
}
