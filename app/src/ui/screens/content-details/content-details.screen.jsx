import "./content-details.style.css"
import { ContainerScreen, BackButton, ContentSection } from "../../components"
import leftArrow from "../../../assets/image/left_arrow.png"
import rightArrow from "../../../assets/image/right_arrow.png"
import { useSound, useVisualizarConteudo } from "../../../hook"
import { useEffect, useState } from "react"
import { useParams } from "react-router-dom"

export function ContentDetailsScreen() {
    const { playChange } = useSound()
    const { contentId } = useParams()
    const [imagePage, setImagePage] = useState(0);
    const { conteudo, visualizarConteudo } = useVisualizarConteudo()

    useEffect(()=> {
        visualizarConteudo(contentId)
    },[])

    function handlePreviousImage() {
        playChange()
        setImagePage(oldPage=> oldPage-1)
    }

    function handleNextImage() {
        playChange()
        setImagePage(oldPage=> oldPage+1)
    }

    return (
        <ContainerScreen>
            <div className="content-details-screen">
                <BackButton />
                <section className="content-details-left">
                    <h1>{conteudo.titulo}</h1>
                    {conteudo.secoes?
                        conteudo.secoes.map(secao=> {
                            return <ContentSection title={secao.titulo} text={secao.descricao}/>
                        })
                    :null}
                </section>
                
                {conteudo.imagens?
                    <section className="content-details-right"
                    style={{backgroundImage: `url(${conteudo.imagens[imagePage].dataUri})`}}>
                    
                    {imagePage>0?
                        <div className="content-left-arrow" onClick={handlePreviousImage} >
                        <img src={leftArrow} alt="Seta para esquerda" />
                        </div>
                    :<div className="content-empty-arrow"></div>}

                    {(imagePage+1)!==conteudo.imagens.length?
                        <div className="content-right-arrow" onClick={handleNextImage} >
                        <img src={rightArrow} alt="Seta para direita" />
                        </div>
                    :<div className="content-empty-arrow"></div>}
                    </section>
                :null}
            </div>
        </ContainerScreen>
    )

}