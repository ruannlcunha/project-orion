import { useState } from "react"
import "./campaign-item.style.css"
import { useSound } from "../../../hook"
import { useNavigate } from "react-router-dom"

export function CampaignItem({campaignId, image, hoverImage}) {
    const [activeImage, setActiveImage] = useState(image)
    const navigate = useNavigate()
    const { playClick } = useSound()

    function handleClick() {
        playClick()
        navigate(`/library/${campaignId}/category`)
    }

    function handleHover() {
        if(activeImage===image) setActiveImage(hoverImage)
        if(activeImage===hoverImage) setActiveImage(image)
    }

    return (
        <button
        onClick={handleClick}
        className="campaign-item"
        style={{backgroundImage: `url(${activeImage})`}}
        onMouseEnter={handleHover}
        onMouseLeave={handleHover}
        >

        </button>
    )

}