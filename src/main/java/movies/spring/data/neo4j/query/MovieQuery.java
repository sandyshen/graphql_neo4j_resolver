package movies.spring.data.neo4j.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import movies.spring.data.neo4j.domain.Movie;
import movies.spring.data.neo4j.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MovieQuery implements GraphQLQueryResolver {
    @Autowired
    private MovieService movieService;
    public Movie findByTitle(final String title) {
        return this.movieService.findByTitle(title);
    }
}
