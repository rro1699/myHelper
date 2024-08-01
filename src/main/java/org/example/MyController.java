package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private static final String HTML_BEGIN = "<html lang=\"ru\">\n" +
            "\t<head></head>\n" +
            "\t<body>\n" +
            "\t\t<iframe height=\"100%\" width=\"100%\"\n" +
            "src=\"";

    private static final String HTML_END = "\">\n" +
            "</iframe>\n" +
            "\t</body>\n" +
            "</html>";

    private static final String FIRST_PART_OF_YOUTUBE_LINK = "https://www.youtube.com/embed/";
    @GetMapping(value = "/")
    public ResponseEntity<?> openLink(@RequestParam String link){
        if(link != null && !link.isEmpty()) {
            String[] split = link.split("/");
            String linkS = split[split.length - 1].split("\\?")[0];
            StringBuilder sb = new StringBuilder();
            sb.append(HTML_BEGIN).append(FIRST_PART_OF_YOUTUBE_LINK)
                    .append(linkS).append(HTML_END);
            return ResponseEntity.ok(sb.toString());
        }else{
            return ResponseEntity.ok("Плохая ссылка. Введите другую!");
        }
    }
}
