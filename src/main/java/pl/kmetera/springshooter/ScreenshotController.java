package pl.kmetera.springshooter;

import java.awt.AWTException;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ScreenshotController {
    public ScreenshotController() {
    }

    @GetMapping({"screenshot"})
    @ResponseBody
    public ResponseEntity<InputStreamResource> getImage() throws IOException, AWTException {
        MediaType contentType = MediaType.IMAGE_PNG;
        InputStream in = Screenshot.takeScreenshot();
        return ResponseEntity.ok().contentType(contentType).body(new InputStreamResource(in));
    }
}
