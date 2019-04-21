package com.hans.belatrix.question.service;

import com.hans.belatrix.question.dao.ILogDAO;
import com.hans.belatrix.question.entity.Log;
import com.hans.belatrix.question.util.LogUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Hans H. Bravo
 */

@Transactional
@Service
public class LogService implements ILogService {

    @Autowired
    private ILogDAO dao;

    @Value("${config.logToDatabaseParam}")
    private Integer logToDatabase;

    @Value("${config.logMessageParam}")
    private Integer logMessage;

    @Value("${config.logWarningParam}")
    private Integer logWarning;

    @Value("${config.path-file}")
    private String pathLogFile;

    @Value("${config.logErrorParam}")
    private Integer logError;

    @Value("${config.logToFileParam}")
    private Integer logToFile;

    @Value("${config.logToConsoleParam}")
    private Integer logToConsole;

    private FileHandler fileHandler;
    ConsoleHandler consoleHandler = new ConsoleHandler();
    private Logger logger = Logger.getLogger("MyLog");

    @Override
    public void loadMessage(final String message, final Integer level) {
        //if it is empty or null it ends the program
        if (StringUtils.isEmpty(message)) {
            return;
        }
        //it is validated if the level exists
        if (!validateLevel(level)) {
            return;
        }

        try {
            Path path = Paths.get(pathLogFile).getParent();
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }

            fileHandler = new FileHandler(pathLogFile);
            if (1 == logToFile) {
                logger.addHandler(fileHandler);
            }

            if (1 == logToConsole) {
                logger.addHandler(consoleHandler);
            }

        } catch (IOException e) {
            new Throwable(e);
        }

        logFile(LogUtil.getMessageWithLevel(level).concat(" ")
                .concat(DateFormat.getDateInstance(DateFormat.LONG).format(new Date()))
                .concat(" ")
                .concat(message.trim()), level);

    }


    private boolean validateLevel(Integer level) {
        if (1 == logMessage && 1 == level) {
            return true;
        }
        if (1 == logWarning && 2 == level) {
            return true;
        }
        if (1 == logError && 3 == level) {
            return true;
        }
        return false;
    }

    private void logFile(final String messageBuilder, final Integer level) {
        logger.log(getLevel(level), messageBuilder);
        if (1 == logToDatabase) {
            dao.save(new Log(messageBuilder, level));
        }
    }

    private Level getLevel(final Integer level) {
        switch (level) {
            case 1:
                return Level.INFO;

            case 2:
                return Level.WARNING;

            default:
                return Level.SEVERE;

        }
    }
}
