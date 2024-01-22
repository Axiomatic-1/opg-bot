package com.telegrambot.workqueue.telegram;

import com.telegrambot.workqueue.config.BotConfig;
import com.telegrambot.workqueue.constants.Constants;
import com.telegrambot.workqueue.service.PlayerCreationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@RequiredArgsConstructor
@Slf4j
public class TelegramBot extends TelegramLongPollingBot {
    private static String GREETING_START = "Приветствую ";
    private final BotConfig botConfig;
    private final PlayerCreationService playerCreationService;
    private final ReplyKeyboardMarkup replyKeyboardMarkupForName;
    private final ReplyKeyboardMarkup replyKeyboardMarkupForRole;
    private final ReplyKeyboardMarkup replyKeyboardMarkupForResult;

    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String msgTxt = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            String name = update.getMessage().getFrom().getFirstName();
            if (!isNameSelection(msgTxt)) {
                sendMessage(chatId, buildGreetingMessage(name), replyKeyboardMarkupForName);
            }
            if (isNameSelection(msgTxt)) {
                sendMessage(chatId, buildChooseRoleMsg(msgTxt), replyKeyboardMarkupForRole);
            }
            if (isRoleSelection(msgTxt)) {
                sendMessage(chatId, buildTeamSelection(msgTxt), replyKeyboardMarkupForResult);
            }

//            sendMessage(chatId, msgTxt);

        }
    }

    private String buildTeamSelection(String msgTxt) {
        return null;
    }

    private boolean isRoleSelection(String msgTxt) {
        return Constants.Role.contains(msgTxt);
    }

    private String buildChooseRoleMsg(String msgTxt) {
        return "Пожалуйста " + msgTxt + " выберите за какую роль вы играли";
    }

    private String buildGreetingMessage(String name) {
        return GREETING_START + name + " выберите ваш Ник в мафии!";
    }

    private boolean isNameSelection(String msgTxt) {
        return Constants.Names.contains(msgTxt);
    }


    private String prepareTask(String msgTxt) {
        return msgTxt.substring(4);
    }


    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }


    private void sendMessage(Long chatId, String textToSend, ReplyKeyboardMarkup replyKeyboardMarkup) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(textToSend);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }
    }

}
