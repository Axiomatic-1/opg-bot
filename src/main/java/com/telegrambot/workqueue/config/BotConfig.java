package com.telegrambot.workqueue.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Data
public class BotConfig {
    @Value("${bot.name}")
    String botName;
    @Value("${bot.token}")
    String token;

    @Bean
    public ReplyKeyboardMarkup replyKeyboardMarkupForName() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        //следующие три строчки могут менять значение аргументов взависимости от ваших задач
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        //добавляем "клавиатуру"
        replyKeyboardMarkup.setKeyboard(nameKeyboardRows());

        return replyKeyboardMarkup;
    }

    @Bean
    public List<KeyboardRow> nameKeyboardRows() {
        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(new KeyboardRow(nameKeyboardButtons()));
        rows.add(new KeyboardRow(nameKeyboardButtons1()));
        rows.add(new KeyboardRow(nameKeyboardButtons2()));
        //создаем список рядов кнопок из списка кнопок

        return rows;
    }

    @Bean
    public List<KeyboardButton> nameKeyboardButtons() {
        List<KeyboardButton> buttons = new ArrayList<>();
        buttons.add(new KeyboardButton("NZX"));
        buttons.add(new KeyboardButton("Zlyuka"));
        buttons.add(new KeyboardButton("TIRAN"));
        buttons.add(new KeyboardButton("Учиха"));
        //создаем и заполняем список кнопок
        return buttons;
    }

    @Bean
    public List<KeyboardButton> nameKeyboardButtons1() {
        List<KeyboardButton> buttons = new ArrayList<>();
        buttons.add(new KeyboardButton("Дочь Карлеоне"));
        buttons.add(new KeyboardButton("Кузнечик"));
        buttons.add(new KeyboardButton("Jony"));
        buttons.add(new KeyboardButton("Borislav"));
        //создаем и заполняем список кнопок
        return buttons;
    }

    @Bean
    public List<KeyboardButton> nameKeyboardButtons2() {
        List<KeyboardButton> buttons = new ArrayList<>();
        buttons.add(new KeyboardButton("Peko"));
        buttons.add(new KeyboardButton("Svetlana"));
        buttons.add(new KeyboardButton("Vova"));
        buttons.add(new KeyboardButton("Alexey"));
        //создаем и заполняем список кнопок
        return buttons;
    }
}
