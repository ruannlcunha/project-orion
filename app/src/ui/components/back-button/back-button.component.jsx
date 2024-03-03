import "./back-button.style.css"
import { useSound } from "../../../hook";
import { useNavigate } from "react-router-dom";

export function BackButton() {
    const navigate = useNavigate();
    const { playHover, playWrong } = useSound();

    function handleClick() {
        playWrong()
        navigate(-1)
    }
 
    return (
        <button
        className="back-button"
        onClick={handleClick}
        onMouseEnter={playHover}
        >
        Voltar
        </button>
    )

}