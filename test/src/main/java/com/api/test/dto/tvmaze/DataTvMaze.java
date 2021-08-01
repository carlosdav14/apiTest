package com.api.test.dto.tvmaze;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "score",
    "person"
})
@Generated("jsonschema2pojo")
public class DataTvMaze {
	
	 @JsonProperty("score")
	    private Double score;
	    @JsonProperty("person")
	    private Person person;

	    @JsonProperty("score")
	    public Double getScore() {
	        return score;
	    }

	    @JsonProperty("score")
	    public void setScore(Double score) {
	        this.score = score;
	    }

	    @JsonProperty("person")
	    public Person getPerson() {
	        return person;
	    }

	    @JsonProperty("person")
	    public void setPerson(Person person) {
	        this.person = person;
	    }

}
