import { useState } from "react"
import "./campaign-item.style.css"
import { useSound } from "../../../hook"
import { useNavigate } from "react-router-dom"

export function CampaignItem({campaignId, background, icon}) {
    const navigate = useNavigate()
    const { playClick } = useSound()

    function handleClick() {
        playClick()
        navigate(`/library/${campaignId}/category`)
    }

    return (
        <>
        <button
        onClick={handleClick}
        className="campaign-item"
        style={{backgroundImage: `url(${background})`}}
        >
            <img src={icon} alt="ícone da campanha" />
        </button>
        </>
        
    )

}