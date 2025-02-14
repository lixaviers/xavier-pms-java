package com.xavier.pms.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Comments: 用户状态枚举
 */
@Getter
@AllArgsConstructor
public enum UserStatusEnum {
    PENDING_APPROVAL         ((byte) 0, "待审批"),
    NORMAL                   ((byte) 1, "正常"),
    HAVE_LEFT                ((byte) 2, "已离职"),
    ;

    private final byte value;
    private final String desc;

    public static boolean exists(Byte status) {
        if (status == null) {
            return false;
        }
        byte s = status.byteValue();
        return exists(s);
    }

    public static boolean exists(byte s) {
        for (UserStatusEnum element : UserStatusEnum.values()) {
            if (element.value == s) {
                return true;
            }
        }
        return false;
    }

    public boolean equal(Byte val) {
        return val == null ? false : val.byteValue() == this.value;
    }

    public static String getDescByValue(Byte value) {
        if (value == null) {
            return "";
        }
        for (UserStatusEnum element : UserStatusEnum.values()) {
            if (element.value == value.byteValue()) {
                return element.desc;
            }
        }
        return "";
    }
}
