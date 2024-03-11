import { useEffect, useState } from "react"
import { ContainerScreen, BackButton, ButtonPrimary } from "../../components"
import "./content-list.style.css"
import { useForm, useListarConteudos, useSound } from "../../../hook"
import { useNavigate, useParams } from "react-router-dom"

export function ContentListScreen() {
    const { playHover, playClick } = useSound()
    const { categoryId } = useParams()
    const navigate = useNavigate()
    const [actualImage, setActualImage] = useState(null)
    const { conteudos, listarConteudos } = useListarConteudos()
    const {formData, handleChange} = useForm({
        filter: ""});

    useEffect(()=> {
        listarConteudos(formData.filter, categoryId)
    },[formData.filter])

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
                        <input
                        name={"filter"}
                        value={formData.filter}
                        type="text" 
                        onChange={handleChange}
                        placeholder="Pesquisar"
                        />

                        {conteudos?
                        <>
                            {conteudos.map(conteudo=> {
                                return <ButtonPrimary  onClick={()=>{handleClick(conteudo.id)}}
                                onMouseEnter={()=>{handleHover(conteudo.imagem)}}>
                                    {conteudo.titulo}
                                </ButtonPrimary>
                            })}
                            {conteudos.length<1?
                            <h1>| Não há conteúdos nesta categoria. |</h1>
                            :null}
                        </>
                        :null}
                    </section>
                </section>

                <section className="content-list-right" style={{backgroundImage:`url(${actualImage})`}}>
                    
                </section>
            </div>
        </ContainerScreen>
    )

}