package setup;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonParser {
    private String url = null;
    private String path = null;
    private String chromeParameter = null;
    private String browserName = null;
    private String baseBrowserName = null;
    private final String filePath;
    private ObjectMapper objectMapper = new ObjectMapper();

    @JsonCreator
    public JsonParser(@JsonProperty("filePath") String filePath) {
        this.filePath = filePath;
    }

    public JsonParser jsonParser() throws IOException {
        return objectMapper.readValue(new File(this.filePath), JsonParser.class);
    }

    public String getUrl() {
        return this.url;
    }

    public String getPath() {
        return this.path;
    }

    public String getBrowserName() {
        return this.browserName;
    }

    public String getBaseBrowserName() {
        return this.baseBrowserName;
    }

    public String getChromeParameter() {
        return this.chromeParameter;
    }

}