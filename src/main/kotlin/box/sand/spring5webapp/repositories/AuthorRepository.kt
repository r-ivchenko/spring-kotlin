package box.sand.spring5webapp.repositories

import box.sand.spring5webapp.domain.Author
import org.springframework.data.repository.CrudRepository

interface AuthorRepository: CrudRepository<Author, Long>