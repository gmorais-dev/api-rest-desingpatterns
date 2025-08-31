package com.formulario.form.patterns.validacao.logger;

public class LoggerSingleton {

    private static LoggerSingleton instance;

    private LoggerSingleton() {} // Construtor privado

    public static synchronized LoggerSingleton getInstance() {
        if(instance == null) {
            instance = new LoggerSingleton();
        }
        return instance;
    }

    public void log(String mensagem) {
        System.out.println("[LOG] " + mensagem);
    }
}
