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

package com.sakuraryoko.streamer_mode.mixins;

import com.google.common.collect.ImmutableList;
import com.sakuraryoko.streamer_mode.StreamerMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import fi.dy.masa.malilib.MaLiLibConfigs;
import fi.dy.masa.malilib.config.IConfigValue;

@Mixin(value = MaLiLibConfigs.class, remap = false)
public class MixinMaLiLibConfigs
{
    @Redirect(method = "loadFromFile", at = @At(value = "FIELD", target = "Lfi/dy/masa/malilib/MaLiLibConfigs$Generic;OPTIONS:Lcom/google/common/collect/ImmutableList;"))
    private static ImmutableList<IConfigValue> addConfigs()
    {
        return StreamerMode.getConfigList();
    }

    @Redirect(method = "saveToFile", at = @At(value = "FIELD", target = "Lfi/dy/masa/malilib/MaLiLibConfigs$Generic;OPTIONS:Lcom/google/common/collect/ImmutableList;"))
    private static ImmutableList<IConfigValue> saveConfigs()
    {
        return StreamerMode.getConfigList();
    }
}
