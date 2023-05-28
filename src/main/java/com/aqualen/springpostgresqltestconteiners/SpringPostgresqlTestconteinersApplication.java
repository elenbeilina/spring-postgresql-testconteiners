package com.aqualen.springpostgresqltestconteiners;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

interface QuotesRepository extends CrudRepository<YodaQuote, Long> {
    boolean existsByQuote(String quote);
}

@SpringBootApplication
public class SpringPostgresqlTestconteinersApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPostgresqlTestconteinersApplication.class, args);
    }

}

@RestController
@RequestMapping("quotes")
@RequiredArgsConstructor
class QuotesController {

    private final QuotesRepository quotesRepository;

    @GetMapping
    ResponseEntity<Iterable<YodaQuote>> getYodaQuotes() {
        return ResponseEntity.ok(quotesRepository.findAll());
    }

    @PostMapping
    void addYodaQuote() {
        String quote = new Faker().yoda().quote();
        if (!quotesRepository.existsByQuote(quote)) {
            quotesRepository.save(YodaQuote.builder().quote(quote).build());
        }
    }
}

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
class YodaQuote {
    @Id
    private Long id;
    private String quote;
}