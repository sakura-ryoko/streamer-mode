package com.sakuraryoko.streamer_mode.mixins;

import com.sakuraryoko.streamer_mode.config.Configs;
import fi.dy.masa.malilib.util.InfoUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InfoUtils.class)
public class MixinInfoUtils
{
    @Inject(method = "Lfi/dy/masa/malilib/util/InfoUtils;printActionbarMessage(Ljava/lang/String;[Ljava/lang/Object;)V", at = @At("HEAD"), cancellable = true)
    private static void checkPrintActionBar(String key, Object[] args, CallbackInfo ci)
    {
        if (Configs.STREAMER_MODE_DISABLE_ALL.getBooleanValue())
        {
            ci.cancel();
        }
    }
}
