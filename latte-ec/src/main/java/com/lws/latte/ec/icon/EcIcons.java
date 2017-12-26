package com.lws.latte.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by Wenshan.Lu on 2017/12/26.
 */

public enum  EcIcons implements Icon {
    icon_scan('\ue66a'),
    icon_ali_pay('\ue616');

    private char character;

    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
