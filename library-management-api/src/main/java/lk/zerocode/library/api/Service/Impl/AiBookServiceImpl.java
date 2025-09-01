package lk.zerocode.library.api.Service.Impl;

import lk.zerocode.library.api.Service.AiBookService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AiBookServiceImpl implements AiBookService {

//    private final ChatClient chatClient;
//
//    public AiBookServiceImpl(ChatClient chatClient){
//        this.chatClient = chatClient;
//    }

    @Autowired
    private ChatClient.Builder builder;

    @Override
    public String getSuggestedBooks(String topic) {
        String prompt = "The user wants to learn about: " + topic +
                ". Suggest books with their authors and categories. " +
                "Speak naturally.";

        ChatClient chatClient = builder.clone()
                .build();

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }
}
