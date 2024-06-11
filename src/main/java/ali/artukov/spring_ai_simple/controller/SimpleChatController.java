package ali.artukov.spring_ai_simple.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/simple-chat")
@RequiredArgsConstructor
public class SimpleChatController {

    private final ChatClient chatClient;

    @GetMapping
    public String getDadJokeContent(@RequestParam(value = "message", defaultValue = "Tell me a dad joke about black cats") String message) {
        log.info("Customer: {}", message);
        String response = chatClient.prompt().user(message).call().content();
        log.info("AI: {}", response);
        return response;
    }

    @GetMapping("/with-chat-response")
    public ChatResponse getDadJokeChatResponse(@RequestParam(value = "message", defaultValue = "Tell me a dad joke about white cats") String message) {
        log.info("Customer: {}", message);
        ChatResponse response = chatClient.prompt().user(message).call().chatResponse();
        log.info("AI: {}", response);
        return response;
    }
}
