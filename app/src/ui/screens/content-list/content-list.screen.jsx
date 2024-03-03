import { useState } from "react"
import { ContainerScreen, BackButton, ButtonPrimary } from "../../components"
import imageAphelios from "../../../assets/image/content/aphelios.jpg"
import imageAlan from "../../../assets/image/content/alan.jpg"
import imageAndy from "../../../assets/image/content/andy.jpg"
import imageAyla from "../../../assets/image/content/ayla.png"
import imageMoxxie from "../../../assets/image/content/moxxie.png"
import imageNero from "../../../assets/image/content/nero.png"
import imageKaras from "../../../assets/image/content/karas.png"
import imageDominick from "../../../assets/image/content/dominick.png"
import imageEreena from "../../../assets/image/content/ereena.png"
import imageAspher from "../../../assets/image/content/aspher.png"
import imageCosmula from "../../../assets/image/content/cosmula.jpg"
import "./content-list.style.css"
import { useSound } from "../../../hook"
import { useNavigate } from "react-router-dom"

export function ContentListScreen() {
    const { playHover, playClick } = useSound()
    const navigate = useNavigate()
    const [actualImage, setActualImage] = useState(null)

    function handleHover(image) {
        setActualImage(image)
        playHover()
    }

    function handleClick(contentId) {
        playClick()
        navigate(`/library/content/${contentId}`)
    }

    return (
        <ContainerScreen>
            <div className="content-list-screen">
                <BackButton />
                <section className="content-list-left">
                    <header>
                        <h1>Personagens</h1>
                    </header>
                    <section>
                        <input type="text" placeholder="Pesquisar"/>
                        <ButtonPrimary onClick={()=>{handleClick(1)}}
                         onMouseEnter={()=>{handleHover(imageAlan)}}>Alan Ressfull</ButtonPrimary>
                        
                        <ButtonPrimary  onClick={()=>{handleClick(2)}}
                         onMouseEnter={()=>{handleHover(imageAndy)}}>Andy</ButtonPrimary>
                        
                        <ButtonPrimary  onClick={()=>{handleClick(3)}}
                         onMouseEnter={()=>{handleHover(imageAphelios)}}>Aphelios</ButtonPrimary>
                        
                        <ButtonPrimary  onClick={()=>{handleClick(4)}}
                         onMouseEnter={()=>{handleHover(imageAspher)}}>Aspher</ButtonPrimary>
                        
                        <ButtonPrimary  onClick={()=>{handleClick(5)}}
                         onMouseEnter={()=>{handleHover(imageAyla)}}>Ayla Greenwood</ButtonPrimary>
                        
                        <ButtonPrimary  onClick={()=>{handleClick(6)}}
                         onMouseEnter={()=>{handleHover(imageCosmula)}}>Cosmula</ButtonPrimary>
                        
                        <ButtonPrimary  onClick={()=>{handleClick(7)}}
                         onMouseEnter={()=>{handleHover(imageDominick)}}>Dominick</ButtonPrimary>
                        
                        <ButtonPrimary  onClick={()=>{handleClick(8)}}
                         onMouseEnter={()=>{handleHover(imageEreena)}}>Ereena</ButtonPrimary>
                        
                        <ButtonPrimary  onClick={()=>{handleClick(9)}}
                         onMouseEnter={()=>{handleHover(imageKaras)}}>Karas</ButtonPrimary>
                        
                        <ButtonPrimary  onClick={()=>{handleClick(10)}}
                         onMouseEnter={()=>{handleHover(imageMoxxie)}}>Moxxie</ButtonPrimary>
                        
                        <ButtonPrimary  onClick={()=>{handleClick(11)}}
                         onMouseEnter={()=>{handleHover(imageNero)}}>Nero</ButtonPrimary>

                    </section>
                </section>

                <section className="content-list-right" style={{backgroundImage:`url(${actualImage})`}}>
                    
                </section>
            </div>
        </ContainerScreen>
    )

}