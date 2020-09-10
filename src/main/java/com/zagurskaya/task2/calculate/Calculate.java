package com.zagurskaya.task2.calculate;

import com.zagurskaya.task2.exception.ProjectException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculate {
    static final Logger logger = LogManager.getLogger(Calculate.class);

    public static String arithmeticExpression(String text, Long i, Long j) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine engine = scriptEngineManager.getEngineByName("JavaScript");

        engine.put("i", i);
        engine.put("j", j);
        Object eval;
        try {
            eval = engine.eval(text);
        } catch (ScriptException e) {
            logger.log(Level.ERROR, " incorrect script", e);
            throw new ProjectException(" incorrect script", e);
        }
        return eval.toString();
    }
}
