package com.example.chatbot.demo.chatbot.model;




import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fulfillmentMessages"
})
public class Response {

  @JsonProperty("fulfillmentMessages")
  private List<FulfillmentMessage> fulfillmentMessages = null;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("fulfillmentMessages")
  public List<FulfillmentMessage> getFulfillmentMessages() {
    return fulfillmentMessages;
  }

  @JsonProperty("fulfillmentMessages")
  public void setFulfillmentMessages(List<FulfillmentMessage> fulfillmentMessages) {
    this.fulfillmentMessages = fulfillmentMessages;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }
}