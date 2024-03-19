import { useParams } from "react-router-dom"
import { ContainerScreen, Header, CategoryItem, BackButton, Loading} from "../../components"
import "./category.style.css"
import { useListarCategorias, useSound } from "../../../hook"
import { useEffect } from "react"

export function CategoryScreen() {
    const { campaignId } = useParams()
    const isMaster = false
    const { playHover } = useSound()
    const { categorias, isLoading, listarCategorias } = useListarCategorias()

    useEffect(()=>{
        listarCategorias(campaignId)
    },[])

    function handleAddCategory() {

    }

    return (
        <ContainerScreen>
            <div className="category-screen">
                <Header title={"Categorias"} subtitle={"Escolha qual categoria deseja ver"}/>
                <BackButton/>
                <section>
                    <Loading isLoading={isLoading}/>
                    {categorias?
                        categorias.map(categoria=> {
                            return <CategoryItem
                            campaignId={campaignId}
                            categoryId={categoria.id}
                            name={categoria.nome}/>
                        })
                    :null}

                    {isMaster && categorias.length<10?
                        <>
                        <button
                        onMouseEnter={playHover}
                        onClick={handleAddCategory}
                        className="category-add-button">
                            Adicionar Categoria
                        </button>
                        </>
                    :null}

                    {!isMaster && categorias.length<1?
                        <h1>Não há categorias nesta campanha.</h1>
                    :null}
                    
                </section>
            </div>
        </ContainerScreen>
    )

}