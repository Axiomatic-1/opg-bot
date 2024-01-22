package com.telegrambot.workqueue.config;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Data
public class RoleConfig {

    @Bean
    public ReplyKeyboardMarkup replyKeyboardMarkupForRole() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        //следующие три строчки могут менять значение аргументов взависимости от ваших задач
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        //добавляем "клавиатуру"
        replyKeyboardMarkup.setKeyboard(roleKeyboardRows());

        return replyKeyboardMarkup;
    }

    @Bean
    public List<KeyboardRow> roleKeyboardRows() {
        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(new KeyboardRow(roleKeyboardButtons()));
        //создаем список рядов кнопок из списка кнопок

        return rows;
    }

    @Bean
    public List<KeyboardButton> roleKeyboardButtons() {
        List<KeyboardButton> buttons = new ArrayList<>();
        buttons.add(new KeyboardButton("Мирные"));
        buttons.add(new KeyboardButton("Мафия"));
        buttons.add(new KeyboardButton("Белые"));
        //создаем и заполняем список кнопок
        return buttons;
    }
}


