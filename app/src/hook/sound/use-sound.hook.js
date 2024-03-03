import START_SOUND from "../../assets/audio/onStart.wav"
import HOVER_SOUND from "../../assets/audio/onHover.wav"
import LOGIN_SOUND from "../../assets/audio/onLogin.wav"
import CLICK_SOUND from "../../assets/audio/onClick.wav"
import WRONG_SOUND from "../../assets/audio/onWrong.wav"
import {Howl} from 'howler';

export function useSound() {

    const hoverSound = new Howl({
        src: [HOVER_SOUND]
    });

    const startSound = new Howl({
          src: [START_SOUND]
    });

    const loginSound = new Howl({
          src: [LOGIN_SOUND]
    });

    const clickSound = new Howl({
          src: [CLICK_SOUND]
    });

    const wrongSound = new Howl({
          src: [WRONG_SOUND]
    });


    function playHover() {
        hoverSound.play()
    }

    function playStart() {
        startSound.play()
    }

    function playClick() {
        clickSound.play()
    }

    function playLogin() {
        loginSound.play()
    }

    function playWrong() {
        wrongSound.play()
    }

    return { playHover, playStart, playLogin, playClick, playWrong }

}