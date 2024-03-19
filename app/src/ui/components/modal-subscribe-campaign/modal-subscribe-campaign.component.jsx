import { useEffect } from "react"
import { useListarCampanhas } from "../../../hook"
import { Header, Loading, Modal, SubscribeCampaignItem } from ".."
import "./modal-subscribe-campaign.style.css"

export function ModalSubscribeCampaign({isOpen, setIsOpen}) {
    const { campanhas, isLoading, listarCampanhas } = useListarCampanhas()

    useEffect(()=> {
        isOpen? listarCampanhas() : null
    },[isOpen])

    return (
        <Modal isOpen={isOpen} setIsOpen={setIsOpen}>
        <Loading isLoading={isLoading}/>
            <div>
                <Header title={"Inscrever Campanha"} subtitle={"Qual campanha deseja se inscrever?"}/>
                <section>
                {campanhas.content?
                    campanhas.content.map(campanha=> {
                        return <SubscribeCampaignItem
                        title={campanha.titulo}
                        campaignId={campanha.id}
                        background={campanha.imagemFundo}
                        icon={campanha.imagemIcone}
                        />
                    })
                :null}
                </section>
            </div>
        </Modal>
    )

}