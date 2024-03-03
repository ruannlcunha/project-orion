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

export function CampaignScreen() {

    return (
        <ContainerScreen>
            <div className="campaign-screen">
            <BackButton />
                <Header title={"Campanhas"} subtitle={"Escolha qual campanha deseja ver"}/>
                <section>
                    <CampaignItem campaignId={1} image={allImage1} hoverImage={allImage2}/>
                    <CampaignItem campaignId={2} image={guildaImage1} hoverImage={guildaImage2}/>
                    <CampaignItem campaignId={3} image={khaasImage1} hoverImage={khaasImage2}/>
                    <CampaignItem campaignId={4} image={primaveraImage1} hoverImage={primaveraImage2}/>
                </section>
            </div>
        </ContainerScreen>
    )

}