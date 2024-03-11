import { useParams } from "react-router-dom"
import { ContainerScreen, Header, CategoryItem, BackButton} from "../../components"
import "./category.style.css"
import { useListarCategorias, useSound } from "../../../hook"
import { useEffect } from "react"

export function CategoryScreen() {
    const { campaignId } = useParams()
    const { playHover } = useSound()
    const { categorias, listarCategorias } = useListarCategorias()

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
                    {categorias?
                        categorias.map(categoria=> {
                            return <CategoryItem
                            campaignId={campaignId}
                            categoryId={categoria.id}
                            name={categoria.nome}/>
                        })
                    :null}

                    {categorias.length<10?
                        <>
                        <button
                        onMouseEnter={playHover}
                        onClick={handleAddCategory}
                        className="category-add-button">
                            Adicionar Categoria
                        </button>
                        </>
                    :null}
                </section>
            </div>
        </ContainerScreen>
    )

}