import { useNavigate } from "react-router-dom"
import "./category-item.style.css"
import { useSound } from "../../../hook"

export function CategoryItem({name, symbol, campaignId, categoryId}) {
    const navigate = useNavigate()
    const { playClick, playHover } = useSound()

    function handleClick() {
        playClick()
        navigate(`/library/${campaignId}/category/${categoryId}`)
    }

    function renderExceedName() {
        if(name.length>18) {
            return `${name.substring(12,18)}[...]`
        }
        return `${name.substring(11)}`
    }

    function renderName() {
        if(name.length>11) {
            return (
                <>
                {`${name.substring(0,11)}-`}
                <br />
                {renderExceedName()}
                </>
            )
        }
        return name
    }

    return (
        <button
        onMouseEnter={playHover}
        onClick={handleClick}
        className="category-item">
            {renderName()}
        </button>
    )

}