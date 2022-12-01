package com.inseoul.feature_flag

// NOTE : 외부로 부터 주입 받을 예정
class FeatureFlagManager {
    fun isActivated(feature: Feature): Boolean = when (ReleasePhaseConfig.get()) {
        ReleasePhase.CANARY -> {
            true
        }
        ReleasePhase.STABLE -> {
            feature.stage == Feature.Stage.READY_FOR_RELEASE
        }
    }
}
