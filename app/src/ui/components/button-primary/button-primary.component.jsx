import "./button-primary.style.css"
import { useSound } from "../../../hook";

export function ButtonPrimary({children, onClick, onMouseEnter}) {
    const { playHover } = useSound();

    return (
        <button
        className="button-primary"
        onClick={onClick}
        onMouseEnter={onMouseEnter? onMouseEnter: playHover}
        >
        {children}
        </button>
    )
}