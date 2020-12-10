package box.sand.spring5webapp.domain

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.ManyToMany

@Entity
data class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val firstName: String,
    val secondName: String,
    @ManyToMany(mappedBy = "authors")
    val books: Set<Book>
)