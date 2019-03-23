package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepostiory;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepostiory authorRepostiory;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepostiory authorRepostiory, BookRepository bookRepository) {
        this.authorRepostiory = authorRepostiory;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design","1234","Harper Collins");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepostiory.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noeEJB = new Book("J2EE Development without EJB","234444","Work");
        rod.getBooks().add(noeEJB);

        authorRepostiory.save(rod);
        bookRepository.save(noeEJB);
    }
}
