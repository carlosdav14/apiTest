package com.api.test.dto.itunes;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "resultCount",
    "results"
})
@Generated("jsonschema2pojo")
public class DataItunes {
	@JsonProperty("resultCount")
    private Long resultCount;
    @JsonProperty("results")
    private List<Result> results = null;

    @JsonProperty("resultCount")
    public Long getResultCount() {
        return resultCount;
    }

    @JsonProperty("resultCount")
    public void setResultCount(Long resultCount) {
        this.resultCount = resultCount;
    }

    @JsonProperty("results")
    public List<Result> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<Result> results) {
        this.results = results;
    }

}
