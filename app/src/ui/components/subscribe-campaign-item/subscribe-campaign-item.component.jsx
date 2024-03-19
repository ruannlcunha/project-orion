import { useState } from "react"
import "./subscribe-campaign-item.style.css"
import { useInscreverCampanha, useSound } from "../../../hook"
import { useNavigate } from "react-router-dom"
import { Modal } from "../modal/modal.component"

export function SubscribeCampaignItem({title, campaignId, background, icon}) {
    const { inscreverCampanha } = useInscreverCampanha()
    const navigate = useNavigate()
    const { playClick, playWrong } = useSound()
    const [modalOpen, setModalOpen] = useState(false)

    function handleOpenConfirm() {
        playClick()
        setModalOpen(true)
    }

    function handleCancel() {
        playWrong()
        setModalOpen(false)
    }

    function handleSuccess() {
        setModalOpen(false)
        navigate(0)
    }

    function handleSubscribe() {
        playClick()
        inscreverCampanha(campaignId, handleSuccess)
    }

    return (
        <div className="subscribe-campaign-item">
            <h1>{title}</h1>
            <section
            style={{backgroundImage: `url(${background})`}}
            >
                <img src={icon} alt="ícone da campanha" />
                <button onClick={handleOpenConfirm}>Inscrever</button>
            </section>
            
            <Modal isOpen={modalOpen} setIsOpen={setModalOpen}>
                <div>
                    <header>
                        <h1>Deseja se inscrever em:</h1>
                        <h3>{title}</h3>
                    </header>
                    <section>
                        <button onClick={handleCancel}>Cancelar</button>
                        <button onClick={handleSubscribe}>Sim</button>
                    </section>
                </div>
            </Modal>
        </div>
    )

}