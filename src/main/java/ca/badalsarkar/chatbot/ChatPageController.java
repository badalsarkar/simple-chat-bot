package ca.badalsarkar.chatbot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatPageController {

    @GetMapping("/chat")
    public String getChatPage() {
        // This will serve the chatbot.html from the templates directory
        return "chatbot";
    }
}
