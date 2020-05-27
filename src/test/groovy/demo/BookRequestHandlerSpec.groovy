package demo

import io.micronaut.test.annotation.MicronautTest
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

//@MicronautTest
class BookRequestHandlerSpec extends Specification {

    @AutoCleanup
    @Shared
    BookRequestHandler bookRequestHandler = new BookRequestHandler()

    @Shared
    MyService myService = bookRequestHandler.applicationContext.getBean(MyService)

    void "test Handler"() {
        given:
        myService.doStuff()
        Book book = new Book()
        book.name = 'Building Microservices'

        when:
        BookSaved bookSaved = bookRequestHandler.execute(book)

        then: 'book name matches the one supplied'
        bookSaved.name == book.name

        and: 'isbn is populated'
        bookSaved.isbn
    }
}
