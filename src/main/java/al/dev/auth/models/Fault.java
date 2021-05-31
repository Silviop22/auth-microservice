package al.dev.auth.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Fault {
    @JsonProperty("timestamp")
    private String timestamp = null;
    @JsonProperty("errorCode")
    private String errorCode;
    @JsonProperty("name")
    private String name = null;
    @JsonProperty("reasonCode")
    private String reasonCode = null;
    @JsonProperty("message")
    private String message = null;

    public Fault() {
    }

    public Fault timestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    @ApiModelProperty(
            required = true,
            value = ""
    )
    @NotNull
    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }




    public Fault errorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }


    @ApiModelProperty("")
    @Valid
    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }


    @ApiModelProperty("A human readable short text name for the fault. Required if the Error Code >= 100, may be omitted or set to ")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Fault reasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
        return this;
    }

    @ApiModelProperty("An enumeration of the reasons why the fault has been generated by the provider. Currently this is not used.")
    public String getReasonCode() {
        return this.reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public Fault message(String message) {
        this.message = message;
        return this;
    }

    @ApiModelProperty("A human readable description of the fault as identified by the Error Code. Required if the Error Code >= 100, may be omitted or set to ")
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Fault fault = (Fault)o;
            return Objects.equals(this.timestamp, fault.timestamp)  && Objects.equals(this.errorCode, fault.errorCode) && Objects.equals(this.name, fault.name) && Objects.equals(this.reasonCode, fault.reasonCode) && Objects.equals(this.message, fault.message);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.timestamp, this.errorCode, this.name, this.reasonCode, this.message});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Fault {\n");
        sb.append("    timestamp: ").append(this.toIndentedString(this.timestamp)).append("\n");
        sb.append("    errorCode: ").append(this.toIndentedString(this.errorCode)).append("\n");
        sb.append("    name: ").append(this.toIndentedString(this.name)).append("\n");
        sb.append("    reasonCode: ").append(this.toIndentedString(this.reasonCode)).append("\n");
        sb.append("    message: ").append(this.toIndentedString(this.message)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }
}