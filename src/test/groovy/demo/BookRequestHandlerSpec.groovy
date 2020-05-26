package demo;
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification
import demo.MyService
import demo.MyServiceImpl
import javax.inject.Inject
import io.micronaut.test.annotation.MicronautTest

@MicronautTest
class BookRequestHandlerSpec extends Specification {

    @Inject MyService myService

    @AutoCleanup
    @Shared
    BookRequestHandler bookRequestHandler = new BookRequestHandler()


    void "test Handler"() {
        given:

        Book book = new Book()
        book.name = 'Building Microservices'

        when:
        BookSaved bookSaved = bookRequestHandler.execute(book)
        myService.doStuff()

        then: 'book name matches the one supplied'
        bookSaved.name == book.name

        and: 'isbn is populated'
        bookSaved.isbn
    }
}
