package io.piano.test.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by ilya on 28.03.19.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Post {
    private PostOwner owner;
    @JsonProperty("is_answered")
    private boolean isAnswered;
    @JsonProperty("creation_date")
    private int creationDate;
    @JsonProperty("question_id")
    private int questionId;
    private String link;
    private String title;
}
