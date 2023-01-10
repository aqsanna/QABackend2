package responses.pack;

import com.google.gson.annotations.SerializedName;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class PackLocation {
    @SerializedName("message")
    public String message;
    @SerializedName("code")
    public String code;
    @SerializedName("data")
    @Nullable
    public ArrayList<String> data;
}
