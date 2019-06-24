package com.sureal.common;

/**
 * @author Wuxx
 * @date 2019/6/10 10:57
 * @PackageName com.sureal.pojo
 * @ClassName SubjectType
 */
public enum SubjectType {
    CHINESE("1", "语文"),

    MATH("2", "数学"),

    ENGLISH("3", "英语"),

    PHYSICS("4", "物理"),

    CHEMISTRY("5", "化学"),

    BIOLOGY("6", "生物"),

    HISTORY("7", "历史"),

    GEOGRAPHY("8", "地理"),

    POLITICS("9", "政治");

    private String code;
    private String view;

    private SubjectType(String code, String view) {
        this.code = code;
        this.view = view;
    }

    public String getCode() {
        return code;
    }

    public String getView() {
        return view;
    }

    public static SubjectType requestTypeByCode(String code) {
        if (null == code) {
            return null;
        }
        for (SubjectType sub : SubjectType.values()) {
            if (sub.getCode().equals(code)) {
                return sub;
            }
        }
        return null;
    }

    public static SubjectType requestTypeByName(String view) {
        if (null == view) {
            return null;
        }
        for (SubjectType sub : SubjectType.values()) {
            if (sub.getView().equals(view)) {
                return sub;
            }
        }
        return null;
    }
}
