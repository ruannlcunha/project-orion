import { ContainerScreen, BackButton, CampaignItem, Header } from "../../components"
import allImage1 from "../../../assets/image/campaign_itens/all_campaigns.png"
import allImage2 from "../../../assets/image/campaign_itens/all_campaigns_hover.png"
import guildaImage1 from "../../../assets/image/campaign_itens/guilda.png"
import guildaImage2 from "../../../assets/image/campaign_itens/guilda_hover.png"
import khaasImage1 from "../../../assets/image/campaign_itens/khaas.png"
import khaasImage2 from "../../../assets/image/campaign_itens/khaas_hover.png"
import primaveraImage1 from "../../../assets/image/campaign_itens/primavera.png"
import primaveraImage2 from "../../../assets/image/campaign_itens/primavera_hover.png"
import "./campaign.style.css"
import { useEffect } from "react"
import { useListarCampanhas } from "../../../hook"

export function CampaignScreen() {
    const { campanhas, listarCampanhas } = useListarCampanhas()

    useEffect(()=> {
        listarCampanhas(0)
    },[])

    return (
        <ContainerScreen>
            <div className="campaign-screen">
            <BackButton />
                <Header title={"Campanhas"} subtitle={"Escolha qual campanha deseja ver"}/>
                <section>
                    {campanhas.content?
                        campanhas.content.map(campanha=> {
                            return <CampaignItem
                            campaignId={campanha.id}
                            background={campanha.imagemFundo}
                            icon={campanha.imagemIcone}
                            />
                        })
                    :null}
                </section>
            </div>
        </ContainerScreen>
    )

}