package box.sand.spring5webapp.bootstrap

import box.sand.spring5webapp.domain.Author
import box.sand.spring5webapp.domain.Book
import box.sand.spring5webapp.domain.Publisher
import box.sand.spring5webapp.repositories.AuthorRepository
import box.sand.spring5webapp.repositories.BookRepository
import box.sand.spring5webapp.repositories.PublisherRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class BootStrapData(
    private val authorRepository: AuthorRepository,
    private val bookRepository: BookRepository,
    private val publisherRepository: PublisherRepository
): CommandLineRunner {

    override fun run(vararg args: String?) {
        val oreilly = Publisher("O'reilly",
            "1005 Gravenstein Highway North",
            "Sebastopol",
            "California",
            "95472")
        publisherRepository.save(oreilly)

        val eric = Author("Eric", "Evans")
        val ddd = Book("Domain Driven Design", UUID.randomUUID().toString())
        eric.books = mutableSetOf(ddd)
        ddd.authors = mutableSetOf(eric)
        authorRepository.save(eric)
        bookRepository.save(ddd)

        val rod = Author("Rod", "Johnson")
        val noEJB = Book("J2EE Development without EJB", UUID.randomUUID().toString())
        rod.books.add(noEJB)
        noEJB.authors.add(rod)

        ddd.publisher = oreilly
        oreilly.books.add(ddd)
        noEJB.publisher = oreilly
        oreilly.books.add(noEJB)

        authorRepository.save(rod)
        bookRepository.save(noEJB)
        publisherRepository.save(oreilly)


        println("Started in Bootstrap")

        println("Number of publisher: ${publisherRepository.count()}")
        println("Publisher number of books: ${oreilly.books.size}")

    }
}