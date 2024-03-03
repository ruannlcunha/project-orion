import { useNavigate } from "react-router-dom"
import "./category.style.css"
import { useSound } from "../../../hook"

export function CategoryItem({name, symbol, campaignId, categoryId}) {
    const navigate = useNavigate()
    const { playClick } = useSound()

    function handleClick() {
        playClick()
        navigate(`/library/${campaignId}/category/${categoryId}`)
    }

    return (
        <button onClick={handleClick} className="category-item">
            {name}
        </button>
    )

}