package ir.blog.mahdidavoodi;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SievereBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "sieverebot";
    }

    @Override
    public String getBotToken() {
        return "1470451909:AAEhqzBrclVRq4J8uLOJbDsKK1VWTzCDyzI";
    }

    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text.
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage();// Create a SendMessage object with mandatory fields.
            message.setChatId(String.valueOf(update.getMessage().getChatId()));
            message.setText(update.getMessage().getText());
            try {
                execute(message); // Call method to send the message.
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
