import { ContainerScreen, BackButton, CampaignItem, Header, Loading, ModalSubscribeCampaign } from "../../components"
import "./campaign.style.css"
import { useEffect, useState } from "react"
import { useListarCampanhasInscritas, useSound } from "../../../hook"

export function CampaignScreen() {
    const { campanhasInscritas, isLoading, listarCampanhasInscritas } = useListarCampanhasInscritas()
    const [ modalOpen, setModalOpen] = useState(false)
    const { playHover } = useSound()

    useEffect(()=> {
        listarCampanhasInscritas(0)
    },[])

    return (
        <ContainerScreen>
            <div className="campaign-screen">
            <BackButton />
                <Header title={"Campanhas"} subtitle={"Escolha qual campanha deseja ver"}/>
                <section>
                    <Loading isLoading={isLoading}/>
                    {campanhasInscritas.content?
                        campanhasInscritas.content.map(campanha=> {
                            return <CampaignItem
                            campaignId={campanha.id}
                            background={campanha.imagemFundo}
                            icon={campanha.imagemIcone}
                            />
                        })
                    :null}

                    <button
                    onMouseEnter={playHover}
                    onClick={()=>{setModalOpen(true)}}
                    className="campaign-subscribe">
                        Inscrever Campanha
                    </button>
                    
                    <ModalSubscribeCampaign isOpen={modalOpen} setIsOpen={setModalOpen}/>

                </section>
            </div>
        </ContainerScreen>
    )

}