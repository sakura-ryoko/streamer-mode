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
import fi.dy.masa.malilib.config.options.ConfigBoolean;

public class Configs
{
    //#if MC >= 12100
    //$$ public static final ConfigBoolean STREAMER_MODE = new ConfigBoolean("streamerMode", false,
            //$$ "streamer-mode.configs.generic.comment.streamerMode",
            //$$ "streamer-mode.configs.generic.prettyName.streamerMode").translatedName("streamer-mode.configs.generic.name.streamerMode");
    //#else
    public static final ConfigBoolean STREAMER_MODE = new ConfigBoolean("streamerMode", false,
            "Enable Streamer Mode to Disable the default\nBoolean Keybind Callback Action Bar messages.",
            "Streamer Mode");
    //#endif

    public static ImmutableList<IConfigValue> getConfigList()
    {
        List<IConfigValue> list = new java.util.ArrayList<>(MaLiLibConfigs.Generic.OPTIONS);
        list.add(STREAMER_MODE);

        return ImmutableList.copyOf(list);
    }
}
