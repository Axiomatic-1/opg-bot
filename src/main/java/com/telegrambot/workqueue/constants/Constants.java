package com.telegrambot.workqueue.constants;


import java.util.HashSet;
import java.util.Set;


public class Constants {
    public static final Set<String> Names = new HashSet<>();
    public static final Set<String> teamMate = new HashSet<>();
    public static final Set<String> Role = new HashSet<>();


    static {
        Names.add("NZX");
        Names.add("Zlyuka");
        Names.add("TIRAN");
        Names.add("Учиха");
        Names.add("Дочь Карлеоне");
        Names.add("Кузнечик");
        Names.add("Borislav");
        Names.add("Peko");
        Names.add("Svetlana");
        Names.add("Vova");
        Names.add("Alexey");
    }

    static {
        teamMate.add("/NZX");
        teamMate.add("/Zlyuka");
        teamMate.add("/TIRAN");
        teamMate.add("/Учиха");
        teamMate.add("/Дочь Карлеоне");
        teamMate.add("/Кузнечик");
        teamMate.add("/Borislav");
        teamMate.add("/Peko");
        teamMate.add("/Svetlana");
        teamMate.add("/Vova");
        teamMate.add("/Alexey");
    }

    static {
        Role.add("Мирный");
        Role.add("Мафия");
        Role.add("Белый");
    }
}
