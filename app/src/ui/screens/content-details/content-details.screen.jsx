import "./content-details.style.css"
import { ContainerScreen, BackButton, ContentSection } from "../../components"
import leftArrow from "../../../assets/image/left_arrow.png"
import rightArrow from "../../../assets/image/right_arrow.png"
import { useSound } from "../../../hook"

export function ContentDetailsScreen() {
    const { playClick } = useSound()

    function handleClickArrow() {
        playClick()
    }

    return (
        <ContainerScreen>
            <div className="content-details-screen">
                <BackButton />
                <section className="content-details-left">
                    <h1>Ayla Greenwood</h1>
                    <ContentSection title={"Aparência"} text={"Ayla é uma elfa negra, de olhos dourados, cabelo preto cacheado"}/>
                    <ContentSection title={"Personalidade"} text={"Calma, gentil, preocupada com os amigos."}/>
                </section>

                <section className="content-details-right">
                    <section><h1>Ayla com armadura</h1></section>

                    <div className="content-left-arrow" onClick={handleClickArrow} >
                        <img src={leftArrow} alt="Seta para esquerda" />
                    </div>
                    <div className="content-right-arrow" onClick={handleClickArrow} >
                        <img src={rightArrow} alt="Seta para direita" />
                    </div>
                </section>
            </div>
        </ContainerScreen>
    )

}