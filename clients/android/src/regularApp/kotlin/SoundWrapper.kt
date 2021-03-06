/*
 * Copyright 2010-2019 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

internal actual fun printAppVariant() {
    println("Regular activated!")
}

internal actual class SoundWrapper {
    private var hasSound = true
    private var playSound = true

    private val soundPlayerInternal = SoundPlayerImpl("swish.wav")
    actual val soundPlayer: SoundPlayer
        get() = soundPlayerInternal

    actual fun playSoundIfAvailable() {
        if (hasSound) {
            soundPlayerInternal.initialize()
        }
        soundPlayerInternal.enable(playSound)
    }

    actual fun deinitSoundIfAvailable() {
        if (hasSound) {
            soundPlayerInternal.deinit()
        }
    }
}