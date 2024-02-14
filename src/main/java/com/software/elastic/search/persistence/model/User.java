package com.software.elastic.search.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/** Daniel Nacher 2024-02-10 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "users")
public class User {

    @Id
    @Field(type = FieldType.Keyword, name = "id")
    private String id;

    @Field(type = FieldType.Text, name = "name")
    private String name;

    @Field(type = FieldType.Text, name = "surname")
    private String surname;

    @Field(type = FieldType.Text, name = "userName")
    private String userName;

    @Field(type = FieldType.Integer, name = "age")
    private Integer age;

    @Field(type = FieldType.Text, name = "birthDate")
    private Date birthDate;
}
