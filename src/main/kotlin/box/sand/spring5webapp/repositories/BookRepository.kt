package box.sand.spring5webapp.repositories

import box.sand.spring5webapp.domain.Book
import org.springframework.data.repository.CrudRepository

interface BookRepository: CrudRepository<Book, Long>