package com.inseoul.feature_flag

object ReleasePhaseConfig {
    fun get(): ReleasePhase = BuildConfig.RELEASE_PHASE
}
