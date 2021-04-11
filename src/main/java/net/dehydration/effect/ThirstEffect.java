package net.dehydration.effect;

import net.dehydration.access.ThristManagerAccess;
import net.dehydration.thirst.ThirstManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.player.PlayerEntity;

public class ThirstEffect extends StatusEffect {

    public ThirstEffect(StatusEffectType type, int color) {
        super(type, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            ThirstManager thirstManager = ((ThristManagerAccess) (PlayerEntity) entity)
                    .getThirstManager((PlayerEntity) entity);
            thirstManager.addDehydration(0.005F * (float) (amplifier + 1));
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

}
