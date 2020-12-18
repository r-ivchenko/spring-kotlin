package box.sand.spring5webapp.bootstrap

import box.sand.spring5webapp.domain.Author
import box.sand.spring5webapp.domain.Book
import box.sand.spring5webapp.repositories.AuthorRepository
import box.sand.spring5webapp.repositories.BookRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.util.*

@Component
class BootStrapData(
    private val authorRepository: AuthorRepository,
    private val bookRepository: BookRepository
): CommandLineRunner {

    override fun run(vararg args: String?) {
        val eric = Author("Eric", "Evans")
        val ddd = Book("Domain Driven Design", UUID.randomUUID().toString())
        eric.books = mutableSetOf(ddd)
        ddd.authors = mutableSetOf(eric)
        authorRepository.save(eric)
        bookRepository.save(ddd)

        val rod = Author("Rod", "Johnson")
        val noEJB = Book("J2EE Development without EJB", UUID.randomUUID().toString())
        rod.books = mutableSetOf(noEJB)
        noEJB.authors = mutableSetOf(rod)
        authorRepository.save(rod)
        bookRepository.save(noEJB)

        println("Started in Bootstrap")
        println("Number of Books: ${bookRepository.count()}")
    }
}