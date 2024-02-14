package com.software.elastic.search.persistence.repository;

import com.software.elastic.search.persistence.model.User;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/** Daniel Nacher 2024-02-10 */
public interface UserRepository extends ElasticsearchRepository<User, Integer> {

    Iterable<User> findByNameContains(String name);

    @Query("{\"bool\": " +
                "{\"should\": " +
                    "[" +
                        "{\"wildcard\": " +
                            "{\"name\": \"*?0*\"}" +
                        "}, " +
                        "{\"wildcard\": " +
                            "{\"userName\": \"*?0*\"}" +
                        "}, " +
                        "{\"wildcard\": " +
                            "{\"surname\": \"*?0*\"}" +
                        "}" +
                    "]" +
                "}" +
            "}")
    Iterable<User> findByvalue(String value);
}
