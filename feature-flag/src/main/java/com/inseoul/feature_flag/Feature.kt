package com.inseoul.feature_flag

enum class Feature(
    val key: String,
    val verbose: String,
    val stage: Stage
) {
    // NOTE : 테스트 용도로 작성
    MAIN_TEST("main_test", "메인 테스트", Stage.IN_DEVELOPMENT);

    enum class Stage {
        IN_DEVELOPMENT,
        READY_FOR_RELEASE
    }
}
