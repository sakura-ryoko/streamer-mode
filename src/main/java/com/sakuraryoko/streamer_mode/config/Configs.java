/*
 * This file is part of the StreamerMode project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2024  Sakura-Ryoko and contributors
 *
 * StreamerMode is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * StreamerMode is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with StreamerMode.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.sakuraryoko.streamer_mode.config;

import java.util.List;
import com.google.common.collect.ImmutableList;

import fi.dy.masa.malilib.MaLiLibConfigs;
import fi.dy.masa.malilib.config.IConfigValue;
import fi.dy.masa.malilib.config.options.ConfigBooleanHotkeyed;
import fi.dy.masa.malilib.hotkeys.IHotkey;
import fi.dy.masa.malilib.hotkeys.KeybindSettings;
import com.sakuraryoko.streamer_mode.utils.StringUtils;

public class Configs
{
    //#if MC >= 12100
    //$$ private static final String GENERIC_KEY = "streamer-mode.configs.generic";
    //$$ public static final ConfigBooleanHotkeyed STREAMER_MODE = new ConfigBooleanHotkeyed("streamerMode", false, "", KeybindSettings.RELEASE_EXCLUSIVE)
    //$$ .apply(GENERIC_KEY);
    //$$ public static final ConfigBooleanHotkeyed STREAMER_MODE_DISABLE_ALL = new ConfigBooleanHotkeyed("streamerModeDisableAll", false, "", KeybindSettings.RELEASE_EXCLUSIVE)
    //$$ .apply(GENERIC_KEY);
    //#else
    public static final ConfigBooleanHotkeyed STREAMER_MODE = new ConfigBooleanHotkeyed("streamerMode", false, "", KeybindSettings.RELEASE_EXCLUSIVE,
                                            StringUtils.getTranslatedOrFallback("streamer-mode.configs.generic.comment.streamerMode",
                                                                                "Enable Streamer Mode to Disable the default\nBoolean Keybind Callback Action Bar messages."),
                                            StringUtils.getTranslatedOrFallback("streamer-mode.configs.generic.prettyName.streamerMode",
                                                                                "Streamer Mode"));
    public static final ConfigBooleanHotkeyed STREAMER_MODE_DISABLE_ALL = new ConfigBooleanHotkeyed("streamerModeDisableAll", false, "", KeybindSettings.RELEASE_EXCLUSIVE,
                                            StringUtils.getTranslatedOrFallback("streamer-mode.configs.generic.comment.streamerModeDisableAll",
                                                                                "Allow Streamer Mode to Disable all\nAction Bar messages."),
                                            StringUtils.getTranslatedOrFallback("streamer-mode.configs.generic.prettyName.streamerModeDisableAll",
                                                                                "Streamer Mode Disable All"));
    //#endif

    public static ImmutableList<IConfigValue> getConfigList()
    {
        List<IConfigValue> list = new java.util.ArrayList<>(MaLiLibConfigs.Generic.OPTIONS);
        list.add(STREAMER_MODE);
        list.add(STREAMER_MODE_DISABLE_ALL);

        return ImmutableList.copyOf(list);
    }

    public static final List<IHotkey> HOTKEY_LIST = ImmutableList.of(
            STREAMER_MODE,
            STREAMER_MODE_DISABLE_ALL
    );
}
