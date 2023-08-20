package com.example.imagerandom_app.mvc

//이미지 숫자 카운트 할 수 있는 모델
class ImageCountModel {
    var count = 0

    fun increase() {
        count += 1
    }
}