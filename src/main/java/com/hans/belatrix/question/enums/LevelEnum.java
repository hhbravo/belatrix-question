package com.hans.belatrix.question.enums;

/**
 *
 * @author Hans H. Bravo
 */
public enum LevelEnum {

    MESSAGE(1), WARNING(2), ERROR(3);

    private Integer level;

    LevelEnum(Integer level) {
        this.level = level;
    }

    public Integer getLevel() {
        return level;
    }
}
