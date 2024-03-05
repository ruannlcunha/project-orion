import "./back-button.style.css"
import { useSound } from "../../../hook";
import { useNavigate } from "react-router-dom";
import { THEME_TYPES } from "../../../constants";

export function BackButton({ theme }) {
    const navigate = useNavigate();
    const { playHover, playWrong } = useSound();

    function handleClick() {
        playWrong()
        navigate(-1)
    }

    function handleClassTheme() {
        if(theme===THEME_TYPES.DARK_THEME) return "back-button-white"
        if(theme===THEME_TYPES.LIGHT_THEME) return "back-button-black"
        return "back-button-black"
    }
 
    return (
        <button
        className={handleClassTheme()}
        onClick={handleClick}
        onMouseEnter={playHover}
        >
        Voltar
        </button>
    )

}