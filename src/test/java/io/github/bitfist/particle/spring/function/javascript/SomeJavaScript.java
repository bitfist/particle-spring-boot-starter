package io.github.bitfist.particle.spring.function.javascript;

import io.github.bitfist.particle.function.javascript.JavaScriptCode;
import io.github.bitfist.particle.function.javascript.JavaScriptFile;

@JavaScriptFile
public interface SomeJavaScript {

    @JavaScriptCode(
            // language=JavaScript
            """
            document.body.style.backgroundColor = "red";
            """
    )
    void makeBodyRed();

}
